package studentCoursesBackup.driver;

import studentCoursesBackup.util.FileDisplayInterface;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.StdoutDisplayInterface;
import studentCoursesBackup.util.TreeBuilder;

/**
 * Driver class will run the code.
 * It will create 3 objects of the TreeBUilder class, 2 objects of the FileProcessor.
 * It will take the command line arguments for input delete and output files.	
 * @author GautamBeri
 */
public class Driver {
	
	/**
	 * It checks and validates the arguments of the filenames
	 * @param args command line arguments
	 */
	
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		
		if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
				|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		}
		FileProcessor inputFile;
		FileProcessor deleteFile;
		inputFile = new FileProcessor(args[0]);
	    deleteFile = new FileProcessor(args[1]);
		
		TreeBuilder BST = new TreeBuilder();
		TreeBuilder Backup1 = new TreeBuilder();
		TreeBuilder Backup2 = new TreeBuilder();
		String s = null;
		while ((s = inputFile.readLine()) != null) {
			String[] readLine = s.split(":");
			int bNo = Integer.parseInt(readLine[0]);
			String courseName = readLine[1];
			BST.courseInsert(bNo, courseName, Backup1, Backup2, BST);
		}
		
		
		Results finalResult = new Results();
		FileDisplayInterface fDin = finalResult;
		StdoutDisplayInterface sDis = finalResult;
		
		System.out.println("Print");
		sDis.writeConsole(BST);
		System.out.println("Print Backup1");
		sDis.writeConsole(Backup1);
		System.out.println("Print Backup2");
		sDis.writeConsole(Backup2);
		
		while ((s = deleteFile.readLine()) != null) {
			String[] readLine = s.split(":");
			int bNo = Integer.parseInt(readLine[0]);
			String courseName = readLine[1];
			BST.courseDel(bNo, courseName);
			//BST.inorder();
		}

	   	String outputFile1 = args[2];
		String outputFile2 = args[3];
		String outputFile3 = args[4];
		
		System.out.println("After Delete Print BST");
		sDis.writeConsole(BST);
		System.out.println("After Delete Print Backup1");
		sDis.writeConsole(Backup1);
		System.out.println("After Delete Print Backup2");
		sDis.writeConsole(Backup2);
		
		fDin.writeFile(outputFile1, BST);
		fDin.writeFile(outputFile2, Backup1);
		fDin.writeFile(outputFile3, Backup2);
	
	}
}
