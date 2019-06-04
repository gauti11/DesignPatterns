## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=firstarg -Darg1=SECOND -Darg2=THIRD

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

[Date: 2/13/2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

I Have implemented the Binary Search Tree in this Observer Pattern. It is 
easy to traverse and implement As balancing of tree was not an issue as 
node was never getting deleted. The worst cases of the Binary Search Tree 
is O(n).BSTs help to keep the keys in the sorted order and hence which makes the
lookup, Insertion and deletion process easy to traverse.
Insertion: O(n)
Deletion: O(n)
Search: O(n)
Access: O(n)
Space Complexity of the BST is O(n).
I have also used Array List and Hash Sets with time complexities similar to the BSTs.

Observer Pattern:

Observer Pattern is implemented in a way that i have created one Tree and two Backups
where the original Tree is being the Subject while the other 2 Backup trees are being the
Observers. In my implementation every node will act as a observer as well as the Subject.
I haved added and registered the Observers in the Node.java file and also taken 3 nodes for 
all three different trees in node.java.
All the methods of an Observer and Subject are defined in the Node class including update and 
notifyAll.EveryTime a node is traveresed a new HashSet is formed corrosponding to it for the
Course Number. In the TreeBuilder, whenever the Add or Delete of courses function is called , the 
existing node will notifyAll the observers and update the operation and if its a new node in original
tree then it will create a new nodes for the number of backup trees i have and will register that node 
with the observer and will insert the first node with the course.
In the Driver File i have created 3 instances of Tree for all separate trees so direct copy shouldnot be 
there of the trees. 
For the observer pattern, the nodes are getting copied from original tree
rather than travelling in the whole Tree in BackUps.

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).
http://www.sanfoundry.com/java-program-implement-binary-search-tree/
I have used this as a reference. All the modification and changes are 
done are my own.

https://stackoverflow.com/
For Enums, toStrings and few basic help taken from it.
Implementation of it is solely mine.
