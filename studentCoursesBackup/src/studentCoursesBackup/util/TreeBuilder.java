package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.myTree.ObserverI.Operation;

/**
 * TreeBuilder Contains the methods of the tree of Removing, adding in the nodes.
 * Observer Subject methods are called here to get implemented.
 * @author GautiSpurs
 *
 */
public class TreeBuilder 
{
	private Node root;
	/*private Node rootBk1;
	private Node rootBk2;
	private TreeBuilder backup1;
	private TreeBuilder backup2;*/
	/**
	 * Will Get Root of the node
	 * @return
	 */
	public Node getRoot() {
		return root;
	}
/**
 * Will set the root
 * @param root
 */
	public void setRoot(Node root) {
		this.root = root;
	}

	/** Constructor */
	public TreeBuilder()
	{
		root = null;		
	}

	/**
	 * @return the backup1
	 */
	/*public TreeBuilder getBackup1() {
		return backup1;
	}
	*//**
	 * @param backup1 the backup1 to set
	 *//*
	public void setBackup1(TreeBuilder backup1) {
		this.backup1 = backup1;
	}     

	*//**
	 * @return the backup2
	 *//*
	public TreeBuilder getBackup2() {
		return backup2;
	}

	*//**
	 * @param backup2 the backup2 to set
	 *//*
	public void setBackup2(TreeBuilder backup2) {
		this.backup2 = backup2;
	}*/

	
	
	/**
	 *  Function to check if tree is empty */
	public boolean isEmpty()
	{
		return root == null;
	}
	/** Functions to insert data 
	*/
	public void insert(int BnoIn, String courseIn, Node obsNode)
	{
		//Node n = new Node(BnoIn);
		root = insert(root, BnoIn, courseIn, obsNode);
		//return node;
	}
	/**
	 *  Function to insert data recursively 
	 *  */
	private Node insert(Node node, int BnoIn, String courseIn, Node obsNode)
	{
		//Node tempSearch = search(node,BnoIn);
		//if(tempSearch == null)
		{
			if (node == null) {
				if(obsNode == null) {
					node = new Node(BnoIn, courseIn);
//				} else if(isPrimary == 2) {
//					node = node.getBckup1();
				} else {
					node = obsNode;
				}
				
			}
			else
			{
				if (BnoIn <= node.getBno())
					node.setLeft(insert(node.getLeft(), BnoIn, courseIn, obsNode));
				else
					node.setRight(insert(node.getRight(), BnoIn, courseIn, obsNode));
			}
			return node;
		}
		/*	else
		{
			tempSearch.setCourse(courseIn);
		}*/
	}
	/**
	 *  Functions to insert course and will notify the observers */
	public String courseInsert(int buNo, String courseIn, TreeBuilder b1, TreeBuilder b2, TreeBuilder orig)
	{
		
		//System.out.println("hello");
		if(courseIn!=null)
		{
			
			Node node = new Node(buNo,courseIn); 
			Node existingNode = search(buNo);
			if(existingNode != null)
			{
				existingNode.setCourse(courseIn);
				existingNode.notifyAllObservers(Operation.INSERT, courseIn);
			}
			else
			{
				Node rootBk1 = new Node(buNo,courseIn);
				Node rootBk2 = new Node(buNo,courseIn);
				node.registerObserver(rootBk1);
				node.registerObserver(rootBk2);				
				orig.insert(buNo, courseIn, node);
				b1.insert(buNo, courseIn, rootBk1);
				b2.insert(buNo, courseIn, rootBk2);
			}
		}
		return "Done";
	}

	/**
	 *  Functions to Delete course and will notify the observers */
	public String courseDel(int buNo, String courseIn)
	{
		Node existingNode = search(buNo);
		if(existingNode != null)
		{
			existingNode.delCourse(courseIn);
			existingNode.notifyAllObservers(Operation.REMOVE, courseIn);
		}
	return "Success";
}
		
	/** Functions to search for an element */
	public Node search(int Bno)
	{
		return search(root, Bno);
	}
	/** Function to search for an element recursively */
	private Node search(Node r, int BnoIn)
	{
		Node found = null;
		while ((r != null))// && r.getBno() == BnoIn)
		{
			int rval = r.getBno();
			if (BnoIn < rval)
				r = r.getLeft();
			else if (BnoIn > rval)
				r = r.getRight();
			else
			{
				found = r;
				break;
			}
			found = search(r, BnoIn);
		}
		return found;
	}
	
	public String toString()
	{
		return "Bnumber of root node is: "+root.getBno();
	}
}


