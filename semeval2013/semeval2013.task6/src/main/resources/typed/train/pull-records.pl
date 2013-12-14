#!/usr/bin/perl

binmode(STDOUT, ":utf8");

use strict;
use WWW::Mechanize;
use JSON -support_by_pp;

my @features_to_extract = ("dcTitle","dcCreator","dcSubject","dcDescription","dcDate","dcSource");
my $folder = "pairs";
system("mkdir -p $folder/images/");
system("mkdir -p $folder/json/");
system("mkdir -p $folder/text/");


open(KEYFILE, "<api-key.txt") or die "Cannot open < api_key.txt: $!";
my $line = <KEYFILE>;
chomp($line);
my $key = $line;
close(KEYFILE);

my $pair = 1;
my $success = 0;
my $failed = 0;
my $crashed = 0;
open(PAIRSFILE, "<STS.input.europeana.txt") or die "Cannot open < STS.input.europeana.txt: $!";
open(ERRORFILE, ">pull-record-errors.txt") or die "Cannot open > pull-record-errors.txt: $!";
while (my $line = <PAIRSFILE>) {
    chomp($line);
    $line =~ s/.+record\/(.+).html\t.+record\/(.+).html//;
    my $item1 = $1;
    my $item2 = $2;

    print "Getting pair $pair items.\n";
    fetch_json_page("http://preview.europeana.eu/api/v2/record/$item1.json?wskey=$key&profile=full",$pair."a",$item1);
    fetch_json_page("http://preview.europeana.eu/api/v2/record/$item2.json?wskey=$key&profile=full",$pair."b",$item2);
    print "\n";
    
    $pair++;
}
close(PAIRSFILE);
close(ERRORFILE);


print "Succesfully extracted: $success. Failed: $failed. Crashed: $crashed.\n";

while (($failed > 0) or ($crashed > 0)) {
    my $answer;
    until (defined $answer) 
    {
	print "\nSome items failed or crashed. Would you like to retry downloading them? (Y/N) ";
	$answer = <>;
	$answer =~ s/^Y/1/i;
	$answer =~ s/^N/0/i;
	print "\n";
    }

    if ($answer == 1) {
	$failed = 0;
	$crashed = 0;
	system("cp -f pull-record-errors.txt temp.txt");
	open(ERRORFILE, ">pull-record-errors.txt") or die "Cannot open > pull-record-errors.txt: $!";
	open(TMP, "<temp.txt") or die "Cannot open < temp.txt: $!";
	while (my $line = <TMP>) {
	    chomp($line);
	    $line =~ s/(\d+a|b)_(.+)_(.+):.+//;
	    my $item_num = $1;
	    my $item_code1 = $2;
	    my $item_code2 = $3;

	    print "Getting $item_num item.\n";
	    fetch_json_page("http://preview.europeana.eu/api/v2/record/$item_code1/$item_code2.json?wskey=$key&profile=full",$item_num,$item_code1."_".$item_code2);
	    print "\n";
	}
	close(TMP);
	system("rm -f temp.txt");
	close(ERRORFILE);
    }
    else {
	last;
    }
    print "Succesfully extracted: $success. Failed: $failed. Crashed: $crashed.\n";
}

sub fetch_json_page {
    my ($json_url,$num,$item_code) = @_;
    $item_code =~ s/\//_/;
    $item_code = $num ."_". $item_code;

    my $browser = WWW::Mechanize->new();
    eval{
        # download the json page:
	print "Getting json for item $num and processing...  ";
        $browser->get( $json_url );
	my $content = $browser->content();
	my $json = new JSON;
	    
	# these are some json options to relax restrictions a bit:
        my $json_text = $json->allow_nonref->utf8->relaxed->escape_slash->loose->allow_singlequote->allow_barekey->decode($content);

	if ($json_text->{success}) {
	    # save json text to file
	    open(JSONFILE, ">$folder/json/$item_code.json") or die "Cannot open > $item_code.json: $!";
	    print JSONFILE $content;
	    close(JSONFILE);

	    # iterate in the JSON structure to extract features to file
	    open(FEATURESFILE, ">$folder/text/$item_code.txt") or die "Cannot open > $item_code.txt: $!";
	    binmode(FEATURESFILE, ":utf8");
	    foreach my $proxie (@{$json_text->{object}->{proxies}}){
		# here we have the proxies
		foreach my $feature (@features_to_extract){
		    if (defined($proxie->{$feature}->{def})){
			print FEATURESFILE "$feature:";
			
			foreach my $element_list ($proxie->{$feature}->{def}){
			    foreach my $element (@{$element_list}) {
				$element =~  s/\r\n|\n/ /g;
				print FEATURESFILE "\t$element";
			    }
			    print FEATURESFILE "\n";
			}
		    }
		}
		
	    }
	    close(FEATURESFILE);

	    # extract thumbnail
	    foreach my $aggregation (@{$json_text->{object}->{aggregations}}){
		my $image_url = $aggregation->{edmObject};
		my $image_extension = substr($image_url, -3);
		if ($image_extension ne 'gif') { $image_extension = 'jpg' };
		system("wget --quiet --tries=5 --timeout=10 -O $folder/images/$item_code.$image_extension \"$image_url\"");
	    }
	    $success++;
	    print "OK!\n";
	}
	else {
	    $failed++;
	    print "Failed!\n";
	    print ERRORFILE " $item_code: Error extracting $num item.\n";
	}	    
    };
    # catch crashes:
    if($@){
	$crashed++;
	print "[[JSON ERROR]] JSON parser crashed! $@\n";
	print ERRORFILE " $item_code: [[JSON ERROR]] JSON parser crashed in $num item: $@\n";
    }
}

