package studentCoursesBackup.myTree;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Node class implements subject and observer of a tree. The class contains the left, right
 * backup nodes respectively. Every time a node is created , it will register an hashset 
 * against it to store the courses.
 * HashSet has been used for the courses as it comes with in built sort and is comparatively
 * efficient and fast and handles the duplicates itself.
 * Arraylist has been taken for to add only number of observers.
 * @author GautiSpurs
 *
 */


public class Node implements SubjectI, ObserverI {
	Node left, right, bckup1, bckup2;
	//int data;
	public ArrayList<Object> observers = new ArrayList<>();
	
	public void registerObserver(ObserverI o)
	{
		observers.add(o);
	}
	
	/**
	 * It gives the backup node of the first backup tree node.
	 * @return
	 */
	public Node getBckup1() {
		return bckup1;
	}
	/**
	 * It sets the backup node of the first backup tree node.
	 * @return
	 */
	
	public void setBckup1(Node root) {
		this.bckup1 = root;
	}
	
	/**
	 * It gives the backup node of the second backup tree node.
	 * @return
	 */
	public Node getBckup2() {
		return bckup2;
	}
	
	/**
	 * It sets the backup node of the second backup tree node.
	 * @return
	 */
	
	public void setBckup2(Node root) {
		this.bckup2 = root;
	}
	int Bno;
	//int courseIn;
	HashSet<String> availCourse;

	/**
	 * Constructor assigning the value of the 
	 * left right and new arraylist to the observers  
	 */
	
	public Node()
	{
		left = null;
		right = null;
		observers = new ArrayList<>();
		//this.registerObserver(o);
	}

	/* Constructor */
	/**
	 * Constructor of node with parameters
	 * whenever Its called , backup node will register new hash set.
	 * @param n
	 * @param courseIn
	 */
	public Node(int n, String courseIn)
	{
		left = null;
		right = null;
		Bno = n;
		this.setCourse(courseIn);
		bckup1 = register();
		bckup2 = register();
	}
	
	/**
	 * Sets the Bnumber and add the courses with the hashset to the respective 
	 * Bnumber node.
	 * @return node n
	 */

	public Node register() {
		HashSet<String> h = new HashSet<>();
		for (String string : this.getAvailCourse()) {
			h.add(string);
		}
		//h = this.getAvailCourse();
		Node n = new Node();
		n.setBno(this.getBno());
		n.availCourse = h;
		/*for (String string : this.getAvailCourse()) {
			n.availCourse.add(string);
		}*/
		//n.setAvailCourse(this.getAvailCourse());
		return n;
	}
	/**
	 *  Function to set left node 
	 */
	public void setLeft(Node n)
	{
		left = n;
	}
	/**
	 * Function to set right node 
	 */ 
	public void setRight(Node n)
	{
		right = n;
	}
	/**
	 *  Function to get left node */
	public Node getLeft()
	{
		return left;
	}
	/**
	 *  Function to get right node */
	public Node getRight()
	{
		return right;
	}
	/**
	 *  Function to get Bnumber */

	public int getBno() {
		return Bno;
	}
	
	/**
	 * Set the Bnumber
	 * @param bno
	 */
	public void setBno(int bno) {
		this.Bno = bno;
	}
	/**
	 * Set the courses with the validation not more than K alphabetically.
	 * @param courseIn
	 */
	public void setCourse(String courseIn) {
		if(null == availCourse)
			availCourse = new HashSet<>();
		if(courseIn.charAt(0) > 'K'){
		}
		else{
			availCourse.add(courseIn);

		}


	}

	/**
	 * it get the available courses.
	 * @return
	 */
	
	public HashSet<String> getAvailCourse() {
		return availCourse;
	}
	/**
	 * it sets the available courses
	 * @param availCourse
	 */
	
	public void setAvailCourse(HashSet<String> availCourse) {
		this.availCourse = availCourse;
	}
	/**
	 * Delete the Course given through a parameter.
	 * @param courseIn
	 */
	public void delCourse(String courseIn)
	{
		if(null!=availCourse && availCourse.contains(courseIn))
		{
			availCourse.remove(courseIn);
		}
	}
	/**
	 * This update function will be called from the Notify to either insert 
	 * or delete the course
	 */
	@Override
	public void update(Operation op, String course) {
		switch(op) {
		case INSERT:
			setCourse(course);
			break;
		case REMOVE:
			delCourse(course);
			break;
		}
	}
	@Override
	public void removeObserver(ObserverI observerI) {
		// TODO Auto-generated method stub
		observers.remove(observerI);

	}
	@Override
	/**
	 * It will notify the available observers and the update method is called for the
	 * respective node.
	 */
	public void notifyAllObservers(Operation op,String course) {
		for(int i=0; i<observers.size(); i++)
		{
			ObserverI ob = (ObserverI) observers.get(i);
			ob.update(op, course);
		}

	}

	//register
	/*public void registerObserver(Node node) 
	{
		observersList.add(node);
	}
	 */
	/**
	 * This method returns the node and the courses of the particular node.
	 */
public String toString()
	{
		//return "Bnumber of root node s: " +bckup1.getBno();
		return "Bno and Courses assigned to node is:"+getBno()+ " " +getAvailCourse();
	}

}
