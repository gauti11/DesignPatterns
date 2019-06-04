## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=firstarg -Darg1=SECOND
-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 3/13/2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

I have Implemented the State Pattern for the StudentCoursePlanner.
It has waitlist which is being handled by an ArrayList which contains all the 
high priority subjects while we have an onGoingSem Array List which handles the 
subject involved in the present sem to check the co-req while a 3rd ArrayList which 
take in account the Courses taken throught the degree.
The Array List used are all running with time complexities of the O(n).

State Pattern:

The State Pattern implementation Contains 4 States and a Context Class. The 4 States 
which i have implemented are 1.Graduated 2.NotGraduated 3.ElectiveCourses 4.Pre-Requisite Course.
Apart from that I have a context Class which helps in determining the present state and then changes 
the state to the respective state when asked.
The Initial State or the Start State where it always goes in is the NoGraduate State.It verifies which
States it has to go in next whether preReq or the Elective Courses.
PreReq State: In this State it verifies the Co-req as well as the prerequisite of the courses already taken
or going to take and after successful add it will move on the Next STATE which is Graduation State.
Elective State: In this State it adds the elective course and after successful add it will move
on the Next STATE which is Graduation State.
Graduation State: In this State it checks with the OngoingSem Array List with the WaitList to check if any coreq
conditions exist and after that it checks on whether the student would graduate or not and after successful checks 
it will then move on the Next course to the noGraduate Current State.

Waitlist & onGoingSem:

My Waitlist take on the Highest Courses. While the onGoingSem takes in the courses of the courses present in the 
on going semester. If a course of highest order comes with the course of lower order but in the same semester than 
it is considered as a coreq and can be accepted.
For Example:
If Input: C E A D S T B L
Output: C E A D S T L

In this Course A got added because it works as a coreq with C in the same semester. While B cannot be added as 
in the Previous Semester Course greater then B has already been taken. Only Course D can be taken as it is higher than
the Previous Sem course.
So for Input: E F D B C T S L K M N
Output: E F D.

This student Wont ever graduate because he has already taken the highest possible Course in the A-D section so the requirement
of getting a degree is 2 Courses of that section that it fails and without going through the list student can be told that
he wont Graduate because he doesnt fill the current Criteria.

These 2 list , 1 ContextClass and 4 states plays a major role in this implementation of registering the course. The 2 lists
takes care of pre-req as well as the Co-req of the subjects.

Student Can Graduate in as many Semester as he Can whenever he fulfill the Graduation Criteria of min 2 courses from 
each of the Section.

Duplicate Check is not an action in the Diagram it just verifies in the courseCheck action.
-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

https://stackoverflow.com/
Implementation of it is solely mine.
