package studentOrientation.util;

import java.util.HashMap;
import java.util.Set;

import studentOrientation.context.Student;

/**
 * Result class to store the total efforts as result of orientation selected
 * 
 * @author pragyavishalakshi
 *
 */
public class Results implements StdoutDisplayInterface {

	/**
	 * arrayList to store the course alloted and graduation status of each student
	 */
	private HashMap<String, String> resultMap = null;

	/**
	 * default Constructor of Results
	 */
	public Results() {
		resultMap = new HashMap<>();
	}

	/**
	 * add the key and value in the resultList
	 * @param studentIn the Student object
	 */
	public void addResult(Student studentIn) {
		resultMap.put("CarbonFootprint", Double.toString(studentIn.getTotalCarbonFootprint())+"kg of CO2");
		resultMap.put("Duration", Double.toString(studentIn.getTotalDuration())+"min");
		resultMap.put("Cost", "$"+Double.toString(studentIn.getTotalCost()));
		resultMap.put("Calories", Double.toString(studentIn.getTotalCalories())+"cal");
	}

	@Override
	public void printConsole(Student studentIn) {
		addResult(studentIn);
		Set<String> keys = resultMap.keySet();
		System.out.println("Total efforts for the given orientation schedule:");
		for (String string : keys) {
			System.out.println(string +" : "+resultMap.get(string));
		}
	}

}
