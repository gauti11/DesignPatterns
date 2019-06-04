package studentCoursesPlanner.state;

import java.util.ArrayList;

/**
 * In the Elective Courses , this is the state which has implemented methods from the
 * CoursePlanner interface.
 * @author GautiSpurs
 *
 */
public class electiveCourses implements CoursePlannerStateI {

	private final semContextClass contextChange;

	/**
	 * This constructor contains the current state which happens to be changed from the 
	 * context class.
	 * @param contextChange
	 */
	public electiveCourses(semContextClass contextChange)
	{
		this.contextChange = contextChange;
	}

	
	@Override
	public CoursePlannerStateI courseCheck(String course) {
		return null;
		// TODO Auto-generated method stub
		
	}

	/**
	 *Elective Course State uses the add course action to add the elective courses.
	 *From this state it goes to the graduation state while adding the courses
	 * to the courseIn array.
	 */
	@Override
	public CoursePlannerStateI addCourse(String course) {
		ArrayList<String> temp = contextChange.getCoursesIn();
		temp.add(course);
		ArrayList<String> tempOnGoing = contextChange.getonGoingSem();
		tempOnGoing.add(course);
		contextChange.setCoursesIn(temp);
		contextChange.setonGoingSem(tempOnGoing);
		//contextChange.setElecCounter(contextChange.getElecCounter()+1);
		//System.out.println("Successfully Course Added in the ArrayList");
		contextChange.setTotalCoursesCounter(contextChange.getTotalCoursesCounter()+1);
		return new Graduated(contextChange);
		// TODO Auto-generated method stub
	}

	public CoursePlannerStateI degreeConfirmation(ArrayList<String> courseAdded, String course) {
		return null;
		// TODO Auto-generated method stub
		
	}
	public String toString() {
		return "Total Elective Courses taken till now: " + contextChange.getElecCounter();
	}

}
