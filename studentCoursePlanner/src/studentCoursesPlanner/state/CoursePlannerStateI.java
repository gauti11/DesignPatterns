package studentCoursesPlanner.state;

import java.util.ArrayList;

/**
 * Contains all the Actions of a state in this interface which are 
 * defined and used respectively in the state.
 * @author GautiSpurs
 *
 */
public interface CoursePlannerStateI {
	//check the prerquisites and add the course
	public CoursePlannerStateI courseCheck(String course);
	//check the semester of the course
	public CoursePlannerStateI addCourse(String course);
	//check whether graduated or not
	public CoursePlannerStateI degreeConfirmation(ArrayList<String> coursesIn, String course);
}
