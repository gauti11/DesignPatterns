package troubleShootSearch.driver;

import java.util.ArrayList;

import troubleShootSearch.context.Search;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.Results;

/**
 *We pass the student object stud to the builder(activity.buildtour) to construct the object and then
 *finally print statement show the constructed plan. 
 * @author GautiSpurs
 *
 */

public class Driver {

	public static void main(String[] args) {
		if (args.length != 1 || args[0].equals("${arg0}")) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 1 argumnets.");
			System.exit(0);
		}
		MyLogger.setDebugValue(Integer.parseInt(args[0]));
		FileProcessor fp = new FileProcessor(System.getProperty("user.dir")+"/src/userInput.txt");
		ArrayList<String> input = fp.readLine();
		Results result = new Results();
		Search search = new Search(result, input);
		search.doSearch();
		String outputFile1 = (System.getProperty("user.dir")+"/src/userOutput.txt");
		result.writeToFile(outputFile1);
		
	}

}
