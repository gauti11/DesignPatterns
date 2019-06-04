package studentCoursesPlanner.driver;

import studentCoursesPlanner.util.FileDisplayInterface;
import studentCoursesPlanner.util.Results;
import studentCoursesPlanner.util.StdoutDisplayInterface;
import studentCoursesPlanner.state.notGraduated;
import studentCoursesPlanner.state.semContextClass;
import studentCoursesPlanner.util.FileProcessor;

/**
 * Driver class will run the code. It will . It will take the command line
 * arguments for input output files.
 * 
 * @author GautamBeri
 */
public class Driver {

	/**
	 * It checks and validates the arguments of the filenames
	 * 
	 * @param args
	 *            command line arguments
	 */

	public static void main(String[] args) {

		
/*		 * As the build.xml specifies the arguments as argX, in case the argument value
		 * is not given java takes the default value specified in build.xml. To avoid
		 * that, below condition is used
		 
*/
		
		  if (args.length != 2 || args[0].equals("${arg0}") ||
		  args[1].equals("${arg1}")) {
		  
		  System.err.
		  println("Error: Incorrect number of arguments. Program accepts 2 argumnets."
		  ); System.exit(0); }
		 
		//FileProcessor inputFile = new FileProcessor("C:\\Users\\GautiSpurs\\Desktop\\statePatternInput.txt");
		FileProcessor inputFile;
		//FileProcessor deleteFile;
		inputFile = new FileProcessor(args[0]);
		String s = null;
		while ((s = inputFile.readLine()) != null) {
			String[] readLine = s.split(":");
			semContextClass sc = new semContextClass();
			int bNo = Integer.parseInt(readLine[0]);
			// System.out.println(bNo);
			String courses = readLine[1];
			courses.replace("//s+", "");
			courses = courses.trim();
			String[] courseName = courses.split(" ");
			courses = courses.replaceAll("\\s+", "");
			for (String part : courseName) {
				if (sc.isGraduated() == true) {
					// System.out.println("Graduated");
					break;
				}
				if (sc.isIsnotGraduated() == true) {
					//System.out.println("Cannot Graduate");
					break;
				}
				sc.setCurrentState(new notGraduated(sc));
				sc.courseCheck(part);
			}
			Results finalResult = new Results();
			FileDisplayInterface fDin = finalResult;
			StdoutDisplayInterface sDis = finalResult;
			
			sDis.writeConsole(sc, bNo);
			String outputFile1 = args[1];
			fDin.writeFile(outputFile1, sc);
		}
	}
}
