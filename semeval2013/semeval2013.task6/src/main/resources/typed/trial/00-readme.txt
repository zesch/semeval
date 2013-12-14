
			*SEM 2013 SHARED TASK

				 STS
		     Semantic Textual Similarity:
 
		     A Unified Framework for the
	      Evaluation of Modular Semantic Components

		    TYPED-SIMILARITY PILOT DATASET
				   


This set of files describes the TYPED-SIMILARITY PILOT DATASET for the
pilot track of the *SEM 2013 SHARED TASK on Semantic Textual
Similarity.

The trial dataset for the TYPED-SIMILARITY PILOT contains the following:

  00-README.txt 		  this file
  correlation.pl		  evaluation script
  correct-output.pl               data integrity script

  STS.input.europeana.txt         tab separated urls of item pairs
  STS.gs.europeana.txt            tab separated sample gold standard
  STS.output.europeana.txt        tab separated sample output
  
  pull-records.pl		  perl script to extract the information 
                                  for each item using Europeana's API V2.0.
  api-key.txt                     file with a dummy API key (see below)

The script will produce the following directories and files (already
provided for this trial dataset):

  text/*.txt                      textual record of each item
  json/*.json                     full json information of each item
  images/*                        image of each item

  The name of the files are composed by the pair number and the item
  code. For instance, the following file

    text/100a_09405u_759A01602A1F2685A8C428448B9572892E53128E.txt

  refers to the leftmost item in the pair at line 100 from
  STS.input.europeana.txt, which has the following url :

     http://www.europeana.eu/portal/record/09405u/759A01602A1F2685A8C428448B9572892E53128E.html



Introduction
------------

The items in this task are taken from Europeana
(http://www.europeana.eu/), a single access point to millions of
books, paintings, films, museum objects and archival records that have
been digitised throughout Europe. It is an authoritative source of
information coming from European cultural and scientific institutions.
Typically, the items comprise meta-data describing a cultural heritage
item and, sometimes, a thumbnail of the item itself.

The items cannot be redistributed, so we provide the urls and a script
to extract the corresponding metadata (see below for details).

Systems participating in this task should compute the similarity
betwee, which contain several fields with textual values. Systems
should return a general similarity score, plus an additional score for
each type of similarity considered:

- similar author
- similar people involved
- similar time period
- similar location
- similar event or action involved
- similar subject
- similar description

The trial dataset comprises sample data for the typed-similarity
dataset.


Recovering the meta-data and text
---------------------------------

The trial dataset already provides the meta-data and text corresponding
to the target pairs of items. But please follow these instructions if
you want to make sure you will be able to retrieve the data for the
train and test datasets.

First you need to register in Europeana, and get the API key:

  http://preview.europeana.eu/portal/api/registration.html

Then substitute the key in api-key.txt and run the following:

  $ perl pull-records.pl STS.input.europeana.txt

You should then see the following directories and files (already
provided in this trial dataset):

  text/*.txt                      textual record of each item
  json/*.json                     full json information of each item
  images/*                        image of each item


Input format
------------

The input files with the item pairs consist of two fields separated by
a tab:

- url of first item
- url of second item 

Please check STS.input.europeana.txt

The information corresponding to each item can be recovered from the
text directory as explained in top of this mail. 

For completeness, we provide the full json code for each item as
returned by the API and the image, in case some participants want to
use them.


Textual record format
---------------------

The text directory contains one file per item mentioned in
STS.input.europeana.txt. The files have one line per field, where the
field can be any of the following:

 dcTitle: title of the item
 dcSubject: list of subject terms (from some vocabulary)
 dcDescription:	textual description of the item
 dcCreator: creator of the item
 dcDate: date of the item
 dcSource: source of the item

The name of the field is followed by a tab and one (or several)
textual description. In case there is more than one value, they are
separated by tabs. Some of the fields occur very rarely, some others
often. The values in these fields are not normalised or
pre-processed. They are derived from a heterogeneous set of resources
and there is no guarantee about their consistency. They are provided
"as is", in case participants find them useful.

For instance, this is an imaginary record:

dcTitle:	Royal visit to Leeds of Queen Elizabeth II.
dcSubject:	Queen	Jubilee	Royal	Calverley Street	Town Hall
dcDescription:	11th July 2002. Image shows Queen Elizabeth II as she arrives in Leeds for the royal visit to mark her Golden Jubilee year of 2002. She is seated in the rear passenger seat and is wearing a peach coat and matching hat. She waves a white gloved hand to onlookers as the car passes the Town Hall on its way along Calverley Street. The royal visit to Leeds was part of a programme of visits throughout the United Kingdom which took place between May and August.
dcCreator:	SMITH; John (1968 - )
dcDate:	[2002, 2002]
dcSource:	A dummy collection


Gold Standard
-------------

The gold standard file contains, in each line, a set of 8 scores
between 0 and 5 (separated by tabs) for each pair of records, where
each score corresponds to the following similarity (in this order):

- general similarity
- author
- people involved
- time
- location
- event or action involved
- subject
- description

The interpretation of the score is the following:

- 0 means there is no similarity between the records for the given type
- 5 means the records are identical for the given type

Numbers in between correspond to intermediate values.

The gold standard in the test data will be assembled using
crowdsourcing, gathering several scores per sentence pair. The gold standard
scores will be the average of those scores. In this trial dataset,
this is just a dummy number which you can ignore.

Please check any of STS.gs.europeana.txt



Answer format
--------------

The answer format is similar to the gold standard format. Each line
has 8 fields separated by tabs, where each field contains a number
between 0 and 5 for each of the similarity types. 

Please check STS.output.europeana.txt which always returns 2.5 for all
pairs of records and types.

The output file needs to conform to the above specifications. Files
which do not follow those will be automatically removed from
evaluation. Please check that your answer files are in the correct
format using the following script:
 
  $ ./correct-output-typed.pl STS.output.europeana.txt
  Output file is OK!

In addition to printing errors and a final message on standard error,
the script returns 0 if correct, and another value if incorrect. 


Scoring
-------

The official score is based on mean Pearson correlation across all 8
type similarities. We will also report correlation for each of the
individual similarity types.

For instance:

  $ ./correlation-typed.pl STS.gs.europeana.txt  STS.output.europeana.txt
  Pearson (General): -0.17476
  Pearson (Author): 0.42117
  Pearson (People involved): -0.89737
  Pearson (Time): -0.69707
  Pearson (Location): 0.72183
  Pearson (Event): -0.12310
  Pearson (Subject): -0.46833
  Pearson (Description): -0.58569
  Pearson mean: -0.22542

Please check correlation-typed.pl


Participation in the task
-------------------------

Participant teams will be allowed to submit at most three runs.



Other
-----

Please check http://ixa2.si.ehu.es/sts for more details.

We recommend that potential participants join the task mailing list:

 http://groups.google.com/group/STS-semeval



Authors
-------

Eneko Agirre
Nikolaos Aletras
Aitor Gonzalez-Agirre
German Rigau
Mark Stevenson


Acknowledgments
----------------

The development of this dataset was supported by the PATHS project
(http://paths-project.eu) funded by the European Community's Seventh
Framework Programme (FP7/2007-2013) under grant agreement
no. 270082.

We thank Europeana and all contributors to Europeana for sharing their
content through the API.
