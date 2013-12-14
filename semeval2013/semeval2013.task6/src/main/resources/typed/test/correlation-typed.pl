#!/usr/bin/perl


=head1 $0

=head1 SYNOPSIS

 correlation.pl gs system [options] 

 Options:
  --help
  --debug

 Outputs the Pearson correlation for each of the 8 similarity types 
 in the gold standard and system output.

 Note: the gold standard file needs to have all pairs, otherwise dies

 Examples:

   $ ./correlation.pl gs sys 

 Author: Eneko Agirre, Aitor Gonzalez-Agirre

 Dec. 31, 2012

=cut

use Getopt::Long qw(:config auto_help); 
use Pod::Usage; 
use warnings;
use strict;
use Statistics::Basic qw(correlation) ;


my @gs ;
my @sys ;
my @simtype = ("General","Author","People involved","Time","Location","Event","Subject","Description");
my $DEBUG = '' ;

GetOptions("debug" => \$DEBUG) 
    or
    pod2usage() ;

pod2usage if $#ARGV != 1 ;

# load GS results
open(I,$ARGV[0]) or die "$ARGV[0] $!" ;
while (<I>) {
    chomp ;
    my @gsvalues = split(/\s+/,$_) ;

    my $i = 0;
    foreach my $gsvalue (@gsvalues) {
	push @{$gs[$i]}, $gsvalue ;
	$i++;
    }
} 
close(I) ;

# load SYS results
open(I,$ARGV[1]) or die $! ;
while (<I>) {
    chomp ;
    if (/^\s*$/) {
	warn "$ARGV[1]: empty line" if $DEBUG ;
	next ;
    }
    
    my @sysvalues = split(/\s+/,$_) ;

    my $i = 0;
    foreach my $sysvalue (@sysvalues) {
	push @{$sys[$i]}, $sysvalue ;
	$i++;
    }
} 
close(I) ;

#Compute Pearson, and mean
my $mean = 0 ;
for(my $i = 0; $i < scalar(@simtype); $i++) {
    my $pearson = correlation($gs[$i],$sys[$i]) ;
    $mean += $pearson ;
    printf "Pearson ($simtype[$i]): %.5f\n", $pearson;
}
printf "Pearson mean: %.5f\n", $mean/scalar(@simtype);


