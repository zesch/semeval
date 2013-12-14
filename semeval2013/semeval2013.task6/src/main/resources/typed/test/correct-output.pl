#!/usr/bin/perl
#
# Usage: 
# 
#   correct-output.pl file
#
# 

=head1 $0

=head1 SYNOPSIS

 correct-output.pl file

 Examples:

   $ ./correct-output.pl file 

 Author: Aitor Gonzalez-Agirre

 Dec. 27, 2012

=cut
 
use warnings;
use strict;
use Scalar::Util qw(looks_like_number);

my $errors = 0;

open(I,$ARGV[0]) or die "Cannot open $ARGV[0]: $!";
while (<I>) {
    chomp ;
    if (/^\s*$/) { 
	warn "$ARGV[0]: empty line";
	$errors++;
    }
    else {
	my @sysvalues = split(/\t/,$_) ;

	if (scalar(@sysvalues) != 8 ) {
	    warn "$ARGV[0]: number of values is not 8";
	    $errors++;
	}

	foreach my $sysvalue (@sysvalues) {
	    if ((!looks_like_number($sysvalue)) or ($sysvalue eq "NaN")) {
		warn "$ARGV[0]: score is not a number";
		$errors++;
	    }
	    elsif (($sysvalue<0) or ($sysvalue>5)) {
		warn "$ARGV[0]: score is not between 0 and 5";
		$errors++;
	    }
	}
    }
} 
close(I) ;

if ($errors == 0){
    print STDERR "Output file is OK!\n";
    exit(0);
}
else {
    print STDERR "Output file has $errors errors. Please correct them before sending.\n";
    exit(1);
}


