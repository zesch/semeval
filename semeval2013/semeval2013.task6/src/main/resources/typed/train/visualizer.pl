#!/usr/bin/perl

#binmode(STDOUT, ":utf8");

use strict;

my $origin_folder = "pairs/text";
my $target_folder = "visualizer";
system("mkdir -p $target_folder");


my %sim;
my $pair = 1;
open(GS, "<STS.gs.europeana.txt") or die "Cannot open < STS.gs.europeana.txt: $!";
while (my $line = <GS>) {
    chomp($line);
    my ($general, $author, $people, $time, $location, $event, $subject, $description) = split(/\t+/, $line);

    $sim{$pair}->{general} = $general;
    $sim{$pair}->{author} = $author;
    $sim{$pair}->{people} = $people;
    $sim{$pair}->{time} = $time;
    $sim{$pair}->{location} = $location;
    $sim{$pair}->{event} = $event;
    $sim{$pair}->{subject} = $subject;
    $sim{$pair}->{description} = $description;

    $pair++;	    
}
close(GS);


$pair = 1;
my %item;
my $item_code1;
my $item_code2;
open(PAIRSFILE, "<STS.input.europeana.txt") or die "Cannot open < STS.input.europeana.txt: $!";
while (my $line = <PAIRSFILE>) {
    chomp($line);
    $line =~ s/.+record\/(.+).html\t.+record\/(.+).html//;
    $item_code1 = $1;
    $item_code2 = $2;
    $item_code1 =~ s/\//_/;
    $item_code1 = $pair ."a_". $item_code1;
    $item_code2 =~ s/\//_/;
    $item_code2 = $pair ."b_". $item_code2;

    get_item("a",$item_code1);
    get_item("b",$item_code2);

    print_html();
    undef %item;
    $pair++;
}
close(PAIRSFILE);

print "Done!\n";

sub get_item {
    my ($ab, $item_code) = @_;
    open(ITEMFILE, "<$origin_folder/$item_code.txt") or die "Cannot open < $origin_folder/$item_code.txt: $!";

    while (my $line = <ITEMFILE>) {
	chomp($line);
	$line =~ s/(.+):\t(.+)//gi;
	my $feature = $1;
	my $values = $2;
	$item{$ab}->{$feature} = $values;
    }
    if (!defined ($item{$ab}->{dcTitle})) { $item{$ab}->{dcTitle} = "" };
    if (!defined ($item{$ab}->{dcCreator})) { $item{$ab}->{dcCreator} = "" };
    if (!defined ($item{$ab}->{dcSubject})) { $item{$ab}->{dcSubjet} = "" };
    if (!defined ($item{$ab}->{dcDescription})) { $item{$ab}->{dcDescription} = "" };
    if (!defined ($item{$ab}->{dcSource})) { $item{$ab}->{dcSource} = "" };
    close(ITEMFILE);
}

sub print_html {
    my $next_pair = $pair + 1;
    my $previous_pair = $pair - 1;

    if ($next_pair > 750) { $next_pair = 1 };
    if ($previous_pair < 1) { $previous_pair = 750 };

    my $html =  '<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd"><html><head><meta content="text/html; charset=utf-8" http-equiv="content-type"><title>Typed-similarity pairs visualizer: pair $pair.</title></head><body><table style="text-align: left; width: 85%; height: 1040px; margin-left: auto; margin-right: auto;" border="0" cellpadding="2" cellspacing="2">  <tbody><tr><td style="vertical-align: top; text-align: center; width: 45%;">Item A<br></td><td style="vertical-align: top; text-align: center; width: 10%;"><br></td><td style="vertical-align: top; text-align: center; width: 45%;">Item B<br></td></tr><tr><td style="vertical-align: top; text-align: center;"><img style="width: 200px;" alt="" src="../pairs/images/' .$item_code1. '.jpg"><br></td><td style="vertical-align: top; text-align: center;"><br></td><td style="vertical-align: top; text-align: center;"><img style="width: 200px;" alt="" src="../pairs/images/' .$item_code2. '.jpg"><br></td></tr><tr><td style="vertical-align: top;"><br></td><td style="vertical-align: top; text-align: center;"><span style="text-decoration: underline; font-weight: bold;">Similarity type</span><br></td><td style="vertical-align: top;"><br></td></tr><tr><td style="vertical-align: top; font-weight: bold; text-align: center;">Title<br></td><td style="vertical-align: top; font-weight: bold; text-align: center;">General:<br></td><td style="vertical-align: top; font-weight: bold; text-align: center;">Title<br></td></tr><tr><td style="vertical-align: top; text-align: center;">' .($item{a}->{dcTitle}). '<br></td><td style="vertical-align: top; text-align: center;">' .($sim{$pair}->{general}). '<br></td><td style="vertical-align: top; text-align: center;">' .($item{b}->{dcTitle}). '</td></tr><tr><td style="vertical-align: top; font-weight: bold; text-align: center;">Creator<br></td><td style="vertical-align: top; font-weight: bold; text-align: center;">Author:<br></td><td style="vertical-align: top; font-weight: bold; text-align: center;">Creator<br></td></tr><tr><td style="vertical-align: top; text-align: center;">' .($item{a}->{dcCreator}). '</td><td style="vertical-align: top; text-align: center;">' .($sim{$pair}->{author}). '<br></td><td style="vertical-align: top; text-align: center;">' .($item{b}->{dcCreator}). '</td></tr><tr><td style="vertical-align: top; font-weight: bold; text-align: center;">Subject<br></td><td style="vertical-align: top; font-weight: bold; text-align: center;">Subject:<br></td><td style="vertical-align: top; font-weight: bold; text-align: center;">Subject<br></td></tr><tr><td style="vertical-align: top; text-align: center;">' .($item{a}->{dcSubject}). '</td><td style="vertical-align: top; text-align: center;">' .($sim{$pair}->{subject}). '<br></td><td style="vertical-align: top; text-align: center;">' .($item{b}->{dcSubject}). '</td></tr><tr><td style="vertical-align: top; font-weight: bold; text-align: center;">Description<br></td><td style="vertical-align: top; font-weight: bold; text-align: center;">Description:<br></td><td style="vertical-align: top; font-weight: bold; text-align: center;">Description<br></td></tr><tr><td style="vertical-align: top; text-align: center;">' .($item{a}->{dcDescription}). '<br></td><td style="vertical-align: top; text-align: center;">' .($sim{$pair}->{description}). '<br></td><td style="vertical-align: top; text-align: center;">' .($item{b}->{dcDescription}). '<br></td></tr><tr><td style="vertical-align: top; font-weight: bold; text-align: center;">Date<br></td><td style="vertical-align: top; font-weight: bold; text-align: center;">Time period:<br></td><td style="vertical-align: top; font-weight: bold; text-align: center;">Date<br></td></tr><tr><td style="vertical-align: top; text-align: center;">' .($item{a}->{dcDate}). '</td><td style="vertical-align: top; text-align: center;">' .($sim{$pair}->{time}). '<br></td><td style="vertical-align: top; text-align: center;">' .($item{b}->{dcDate}). '</td></tr><tr><td style="vertical-align: top; font-weight: bold; text-align: center;">Source<br></td><td style="vertical-align: top; font-weight: bold; text-align: center;">Location:<br></td><td style="vertical-align: top; font-weight: bold; text-align: center;">Source<br></td></tr><tr><td style="vertical-align: top; text-align: center;">' .($item{a}->{dcSource}). '</td><td style="vertical-align: top; text-align: center;">' .($sim{$pair}->{location}). '<br></td><td style="vertical-align: top; text-align: center;">' .($item{a}->{dcSource}). '</td></tr><tr><td style="vertical-align: top; font-weight: bold; text-align: center;"><br></td><td style="vertical-align: top; font-weight: bold; text-align: center;">Event or action:<br></td><td style="vertical-align: top; font-weight: bold; text-align: center;"><br></td></tr><tr><td style="vertical-align: top; text-align: center;"><br></td><td style="vertical-align: top; text-align: center;">' .($sim{$pair}->{event}). '<br></td><td style="vertical-align: top; text-align: center;"><br></td></tr><tr><td style="vertical-align: top; font-weight: bold; text-align: center;"><br></td><td style="vertical-align: top; font-weight: bold; text-align: center;">People involved:<br></td><td style="vertical-align: top; font-weight: bold; text-align: center;"><br></td></tr><tr><td style="vertical-align: top; text-align: center;"><br></td><td style="vertical-align: top; text-align: center;">' .($sim{$pair}->{people}). '<br></td><td style="vertical-align: top; text-align: center;"><br></td></tr>  </tbody></table>  <br><table style="text-align: left; width: 50%; margin-left: auto; margin-right: auto;" border="0" cellpadding="2" cellspacing="2">  <tbody><tr><td style="vertical-align: top; width: 50%;"><a href="' .$previous_pair. '.html">&lt;&lt;&nbsp; Go to&nbsp; pair ' .$previous_pair. '</a><br></td><td style="vertical-align: top; text-align: right;"><a href="' .$next_pair. '.html">Go to pair ' .$next_pair. ' &gt;&gt;</a><br></td></tr>  </tbody></table><br></body></html> ';

    open(HTMLFILE, ">$target_folder/$pair.html") or die "Cannot open > $target_folder/$pair.html: $!";
    print HTMLFILE $html;
    close(HTMLFILE);

}
