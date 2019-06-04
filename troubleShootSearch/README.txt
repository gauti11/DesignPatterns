Run following command when inside Gautam_Beri folder:

ant -buildfile troubleShootSearch/src/build.xml clean
ant -buildfile troubleShootSearch/src/build.xml all
ant -buildfile troubleShootSearch/src/build.xml run -Darg0=0 (Debug level at which we need the debug printing)

command to generate javadoc:
ant -buildfile troubleShootSearch/src/build.xml javadoc

The javadoc generated is stored in "doc" folder at src level. The "index.html" is the file which takes from first page of Javadoc.

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: 04/24/2018

-----------------------------------------------------------------------

Debug Levels:
0 : NONE : It prints the error or messages in catch blocks
1 : FILE_PROCESSOR : It prints messages at fileProcessor java file
2 : CONSTRUCTOR : It prints message under all the constructors when called
3 : ExactSearch : It prints all the Exact matched results for the given query for all the products
4 : NaiveSearch : It prints all the Naive matched results for the given query for all the products
5 : SemanticSearch : It prints all the Semantic matched results for the given query for all the products


Algorithm:
technicalDetails1.txt contains the technical detail statements of Product1 and same things for all 4 products.

Driver reads the input file and contains the main method.
Each product works as a Vistorable and The Search classes are the visitors which visits the visit function of the search provided. 