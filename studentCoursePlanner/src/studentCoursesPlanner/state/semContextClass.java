package studentCoursesPlanner.state;

import java.util.ArrayList;

/**
 * This is my context class where all the switching take place of one state to another
 * and all the arrays as well as the counters of the respective courses and all the variables
 * used are accessed from the context class.
 * current state is initialize to notGraduated so whenever the new course comes its initial state
 * happens to be the the notGraduated state.
 * @author GautiSpurs
 *
 */

public class semContextClass implements CoursePlannerStateI {
	
	CoursePlannerStateI currentState;
	private ArrayList<String> coursesIn = new ArrayList<>();
	private ArrayList<String> waitlist = new ArrayList<>();
	private ArrayList<String> onGoingSem = new ArrayList<>();
	private int elecCounter = 0;
	private int semCounter = 0;
	private int longPCounter = 0;
	private int dataStCounter = 0;
	private int hardwareCounter = 0;
	private int datanaCounter = 0;
	private int totalCoursesCounter = 0;
	private boolean isGraduated = false;
	private boolean isnotGraduated = false;
	
	@Override
	public CoursePlannerStateI courseCheck(String course) {
		// TODO Auto-generated method stub
		currentState = currentState.courseCheck(course);
		if (currentState == null)
		{
			return null;
		}
		return addCourse(course);
	}

	@Override
	public CoursePlannerStateI addCourse(String course) {
		currentState = currentState.addCourse(course);
		//coursesIn.add(course);
		if (currentState == null)
		{
			return null;
		}
		currentState = currentState.degreeConfirmation(coursesIn, course);
		return currentState;
	}

	public CoursePlannerStateI degreeConfirmation(ArrayList<String> courseAdded, String course) {
		return null;
	}
	
	public int getSemCounter() {
		return semCounter;
	}

	public void setSemCounter(int semCounter) {
		this.semCounter = semCounter;
	}

	public int getLongPCounter() {
		return longPCounter;
	}

	public void setLongPCounter(int longPCounter) {
		this.longPCounter = longPCounter;
	}

	public int getDataStCounter() {
		return dataStCounter;
	}

	public void setDataStCounter(int dataStCounter) {
		this.dataStCounter = dataStCounter;
	}

	public int getHardwareCounter() {
		return hardwareCounter;
	}

	public void setHardwareCounter(int hardwareCounter) {
		this.hardwareCounter = hardwareCounter;
	}

	public int getDatanaCounter() {
		return datanaCounter;
	}

	public void setDatanaCounter(int datanaCounter) {
		this.datanaCounter = datanaCounter;
	}

	
	
	public int getElecCounter() {
		return elecCounter;
	}

	public void setElecCounter(int elecCounter) {
		this.elecCounter = elecCounter;
	}

	public CoursePlannerStateI getCurrentState() {
		return currentState;
	}

	public void setCurrentState(CoursePlannerStateI currentState) {
		this.currentState = currentState;	
	}

	public ArrayList<String> getCoursesIn() {
		return coursesIn;
	}

	public void setCoursesIn(ArrayList<String> coursesIn) {
		this.coursesIn = coursesIn;
	}

	public semContextClass() {
		//electiveCourses = new CoursePlannerStateI(this);
		currentState = new notGraduated(this);
		
	   // CoursePlannerStateI currentState = new NewCoursePlannerStateI(this);
		//this.CoursePlannerStateI = CoursePlannerStateI;
	}
	
	
		public String toString()
		{
			return "Courses taken till now: "+getCoursesIn();
		}
		


	/**
	 * @return the totalCoursesCounter
	 */
	public int getTotalCoursesCounter() {
		return totalCoursesCounter;
	}

	/**
	 * @param totalCoursesCounter the totalCoursesCounter to set
	 */
	public void setTotalCoursesCounter(int totalCoursesCounter) {
		this.totalCoursesCounter = totalCoursesCounter;
	}

	/**
	 * @return the isGraduated
	 */
	public boolean isGraduated() {
		return isGraduated;
	}

	/**
	 * @param isGraduated the isGraduated to set
	 */
	public void setGraduated(boolean isGraduated) {
		this.isGraduated = isGraduated;
	}

	/**
	 * @return the waitlist
	 */
	public ArrayList<String> getWaitlist() {
		return waitlist;
	}

	/**
	 * @param waitlist the waitlist to set
	 */
	public void setWaitlist(ArrayList<String> waitlist) {
		this.waitlist = waitlist;
	}


	public ArrayList<String> getonGoingSem() {
		return onGoingSem;
	}

	public void setonGoingSem(ArrayList<String> onGoingSem) {
		this.onGoingSem = onGoingSem;
	}

	/**
	 * @return the isnotGraduated
	 */
	public boolean isIsnotGraduated() {
		return isnotGraduated;
	}

	/**
	 * @param isnotGraduated the isnotGraduated to set
	 */
	public void setIsnotGraduated(boolean isnotGraduated) {
		this.isnotGraduated = isnotGraduated;
	}

}
