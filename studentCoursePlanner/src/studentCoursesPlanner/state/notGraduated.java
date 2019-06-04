package studentCoursesPlanner.state;

import java.util.ArrayList;
/**
 * This happens to be the first state that every course has to go through which contains the 
 * checks as the subject belongs to which category either its in Pre-req courses or its in 
 * the elective courses.
 * @author GautiSpurs
 *
 */

public class notGraduated implements CoursePlannerStateI {
	/**
	 * This constructor contains the current state which happens to be changed from the 
	 * context class.
	 * @param contextChange
	 */
	private final semContextClass contextChange;

	public notGraduated(semContextClass contextChange) {
		this.contextChange = contextChange;
	}

	/**
	 * This is the action which is being used by the notGraduated State, which will verify on
	 * which course it belongs to and also handle the duplicate courses.
	 */
	@Override
	public CoursePlannerStateI courseCheck(String course) {
		for (String cT : contextChange.getCoursesIn()) {
			if(cT.equals(course)) {
				return null;
			}
		}
		// TODO Auto-generated method stub
		if (course.matches(".*[A-P].*")) {
			if (course.matches(".*[A-D].*")) {
				// if(contextChange.getLongPCounter() < 2)
				// {
					contextChange.setLongPCounter(contextChange.getLongPCounter() + 1);
					//System.out.println("Its in Long Programming");
				// }
			}

			// String Ds = "EFGH";
			if (course.matches(".*[E-H].*")) {
				//System.out.println("Its in DataStructure");
				contextChange.setDataStCounter(contextChange.getDataStCounter() + 1);
			}

			if (course.matches(".*[I-L].*")) {
				//System.out.println("Its in Hardware Sequence");
				contextChange.setHardwareCounter(contextChange.getHardwareCounter() + 1);

			}

			if (course.matches(".*[M-P].*")) {
				//System.out.println("Its in DataAnalytics");
				contextChange.setDatanaCounter(contextChange.getDatanaCounter() + 1);
			}
		} else {
			if (course.matches(".*[Q-Z].*")) {
				//System.out.println("Its in Electives");
				contextChange.setElecCounter(contextChange.getElecCounter() + 1);
				return new electiveCourses(contextChange);

			}
		}
		return new preReqCourses(contextChange);
	}

	@Override
	public CoursePlannerStateI addCourse(String course) {
		return contextChange;
		// TODO Auto-generated method stub

	}

	@Override
	public CoursePlannerStateI degreeConfirmation(ArrayList<String> courseAdded, String course) {
		return contextChange;
		// TODO Auto-generated method stub

	}

}
