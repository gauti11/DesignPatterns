package studentCoursesBackup.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import studentCoursesBackup.myTree.Node;

/**
 * This class implements from FileDisplayInterface and stdoutDisplay which have methods 
 * to print in the console and or append in the file.
 * This class will print the inorder of the tree only.
 * @author GautiSpurs
 *
 */

public class Results implements FileDisplayInterface, StdoutDisplayInterface
{
	ArrayList<String> concatData = new ArrayList<String>();
	/*public void inorder()
	{
		inorder(node.getRoot());
	}*/
/**
 * This will print the inorder of the tree	
 * 
 * @param r
 */
	
	private void inorder(Node r)
	{
		if (r != null)
		{
			inorder(r.getLeft());
			concatData.add(r.getBno() +":"+ r.getAvailCourse());
			//concatData.addAll(r.getAvailCourse());
			//System.out.println(r.getAvailCourse());
			inorder(r.getRight());
		}
	}

	@Override
	/**
	 * It will append the Root node with the courses and write in the console.
	 * 
	 */
	public void writeConsole(TreeBuilder treeIn) {
		inorder(treeIn.getRoot());
		for (String string : concatData) {
			System.out.println(string);
		}
		concatData.clear();
		//System.out.println(concatData);
		// TODO Auto-generated method stub

	}	

	/**
	 * It will append the Root node with the courses and write in the New File.
	 * 
	 */
	public void writeFile(String fw, TreeBuilder treeIn) {
		BufferedWriter writer;
		
		try {
			writer = new BufferedWriter(new FileWriter(fw));
			inorder(treeIn.getRoot());
			//System.out.println(string);
			for (String string : concatData) 
		//	{
				writer.append(string+"\n");
				writer.newLine();
			//}
		writer.close();
		concatData.clear();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
