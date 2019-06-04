package studentCoursesPlanner.state;

import java.util.ArrayList;

/**
 * In the PreReq Courses , this is the state which has implemented methods from the
 * CoursePlanner interface.
 * @author GautiSpurs
 */
public class preReqCourses implements CoursePlannerStateI {

	private final semContextClass contextChange;
	private static boolean flag = false;

	public preReqCourses(semContextClass contextChange) {
		this.contextChange = contextChange;
	}

	@Override
	public CoursePlannerStateI courseCheck(String courseIn) {
		return null;

		// TODO Auto-generated method stub

	}
	/**
	 * In this it  method it will add the course to the existing course list
	 * and increment the total courses taken.
	 * @param course
	 */
	
	
	public void verificationAdd(String course) {
		ArrayList<String> temp = contextChange.getCoursesIn();
		temp.add(course);
		ArrayList<String> tempOnGoing = contextChange.getonGoingSem();
		tempOnGoing.add(course);
		contextChange.setCoursesIn(temp);
		contextChange.setonGoingSem(tempOnGoing);
		contextChange.setTotalCoursesCounter(contextChange.getTotalCoursesCounter() + 1);
		// System.out.println("Successfully Pre-ReqCourse Added in the ArrayList");
	}

/**
 * This is where all the conditions get satisfied of the pre-requisite courses.
 * In this it will check for the co-req conditions as well as manage the 
 * ongoingSem arraylist to check the possibility of existing of a co-req.	
 * 
 * @param regex
 * @param course
 * @return
 */
	public CoursePlannerStateI checkCoreq(String regex, String course) {
		// System.out.println("Courses available " + course);
		boolean addCourse = false;
		for (String course1 : contextChange.getCoursesIn()) {
			if (contextChange.getTotalCoursesCounter() < 3) {
				if (course.compareTo(course1) > 0 && course.matches(regex) && course1.matches(regex)) {
					// System.out.println("valid");
					addCourse = true;

					// verificationAdd(course);
					// return new Graduated(contextChange);
				} else if (course.compareTo(course1) < 0 && course.matches(regex) && course1.matches(regex)) {
					// if (contextChange.getonGoingSem().size() > 0) {
					ArrayList<String> temp2 = contextChange.getonGoingSem();
					if (contextChange.getTotalCoursesCounter() < 3) {
						for (String course2 : temp2) {
							if (course1.compareTo(course2) < 0) {
								return new Graduated(contextChange);
							} else if (course.compareTo(course2) < 0 && contextChange.getTotalCoursesCounter() < 3
									&& course2.matches(regex)) {
								// addCourse = true;
								verificationAdd(course);
								// contextChange.setTotalCoursesCounter(contextChange.getTotalCoursesCounter() +
								// 1);
								return new Graduated(contextChange);
							}
						}
						if (course1.matches(regex)) {
							if (course.matches(".*[A-D].*")) {
								contextChange.setLongPCounter(contextChange.getLongPCounter() - 1);
							}
							if (course.matches(".*[E-H].*")) {
								// System.out.println("Its in DataStructure");
								contextChange.setDataStCounter(contextChange.getDataStCounter() - 1);
							}

							if (course.matches(".*[I-L].*")) {
								// System.out.println("Its in Hardware Sequence");
								contextChange.setHardwareCounter(contextChange.getHardwareCounter() - 1);

							}

							if (course.matches(".*[M-P].*")) {
								// System.out.println("Its in DataAnalytics");
								contextChange.setDatanaCounter(contextChange.getDatanaCounter() - 1);
							}

							return new Graduated(contextChange);
						}
					}
					/*
					 * } else { verificationAdd(course); return new Graduated(contextChange); }
					 */
				}
			}
		}
		if (addCourse) {
			verificationAdd(course);
			// contextChange.setTotalCoursesCounter(contextChange.getTotalCoursesCounter() +
			// 1);
			return new Graduated(contextChange);
		}
		// return new Graduated(contextChange);
		return null;
	}

	/**
	 * This is the action which is being used by the Pre-Requisite state.
	 * In this It will add the courses checking both the co-req as well as 
	 * the pre-req conditions and also waitlist gets implemented to the 
	 * highest order courses.
	 */
	
	@Override
	public CoursePlannerStateI addCourse(String course) {
		ArrayList<String> temp1 = contextChange.getWaitlist();
		if (contextChange.getTotalCoursesCounter() < 3) {
			if (contextChange.getLongPCounter() == 1 && course.contains("D")) {
				temp1.add(course);
				contextChange.setWaitlist(temp1);
				contextChange.setLongPCounter(contextChange.getLongPCounter() - 1);
				return new Graduated(contextChange);
			}
			if (contextChange.getDataStCounter() == 1 && course.contains("H")) {
				temp1.add(course);
				contextChange.setWaitlist(temp1);
				contextChange.setDataStCounter(contextChange.getDataStCounter() - 1);
				return new Graduated(contextChange);
			}
			if (contextChange.getHardwareCounter() == 1 && course.contains("L")) {
				temp1.add(course);
				contextChange.setWaitlist(temp1);
				contextChange.setHardwareCounter(contextChange.getHardwareCounter() - 1);
				return new Graduated(contextChange);
			}

			if (contextChange.getDatanaCounter() == 1 && course.contains("P")) {
				temp1.add(course);
				contextChange.setWaitlist(temp1);
				contextChange.setDatanaCounter(contextChange.getDatanaCounter() - 1);
				return new Graduated(contextChange);
			}
		}

		// for handling co-req

		/*
		 * if(contextChange.getTotalCoursesCounter() == 0) { verificationAdd(course);
		 * return new Graduated(contextChange); }
		 */
		CoursePlannerStateI cp1 = checkCoreq(".*[A-D].*", course);
		CoursePlannerStateI cp2 = checkCoreq(".*[E-H].*", course);
		CoursePlannerStateI cp3 = checkCoreq(".*[I-L].*", course);
		CoursePlannerStateI cp4 = checkCoreq(".*[M-P].*", course);

		if (cp1 != null) {
			return cp1;
		}
		if (cp2 != null) {
			return cp2;
		}
		if (cp3 != null) {
			return cp3;
		}
		if (cp4 != null) {
			return cp4;
		}
		
		verificationAdd(course);

		return new Graduated(contextChange);
	}

	@Override
	public CoursePlannerStateI degreeConfirmation(ArrayList<String> courseAdded, String course) {
		return null;
		// TODO Auto-generated method stub

	}

	public String toString() {
		return "Total Pre-reqCourses taken till now: " + (contextChange.getDatanaCounter() + contextChange.getLongPCounter()
				+ contextChange.getHardwareCounter() + contextChange.getDataStCounter());
	}

	/**
	 * @return the flag
	 */
	public static boolean isFlag() {
		return flag;
	}

	/**
	 * @param flag
	 *            the flag to set
	 */
	public static void setFlag(boolean flag) {
		preReqCourses.flag = flag;
	}

}
