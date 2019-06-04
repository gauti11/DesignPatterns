package studentCoursesPlanner.state;

import java.util.ArrayList;

public class Graduated implements CoursePlannerStateI {

	private final semContextClass contextChange;

	public Graduated(semContextClass contextChange) {
		this.contextChange = contextChange;
	}

	@Override
	public CoursePlannerStateI courseCheck(String course) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public CoursePlannerStateI addCourse(String course) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public CoursePlannerStateI degreeConfirmation(ArrayList<String> array, String course) {
		boolean toAdd = false;
		String regexCheck = "";
		int countSimilar = 0;
		if(course.matches(".*[A-D].*")) {
			regexCheck = ".*[A-D].*";
		} else if(course.matches(".*[E-H].*")) {
			regexCheck = ".*[E-H].*";
		} else if(course.matches(".*[I-L].*")) {
			regexCheck = ".*[I-L].*";
		} else if(course.matches(".*[M-P].*")) {
			regexCheck = ".*[M-P].*";
		}
		
		for (String string : contextChange.getWaitlist()) {
			if(string.matches(regexCheck) && !string.equals(course)) {
				toAdd = true;
				break;
			}
		}
		
		if (((contextChange.getTotalCoursesCounter() + contextChange.getWaitlist().size() == 3)
				&& contextChange.getWaitlist().size() != 0) || toAdd) {

			
			ArrayList<String> temp = contextChange.getCoursesIn();
			ArrayList<String> tempOnGoing = contextChange.getonGoingSem();
			for (String string : contextChange.getWaitlist()) {
				temp.add(string);
				if(string.matches("D"))
				{
					contextChange.setLongPCounter(contextChange.getLongPCounter() + 1);
				}
				if(string.matches("H"))
				{
					contextChange.setDataStCounter(contextChange.getDataStCounter() + 1);
				}
				if(string.matches("L"))
				{
					contextChange.setHardwareCounter(contextChange.getHardwareCounter() + 1);
				}
				if (course.matches("P")) {
					contextChange.setDatanaCounter(contextChange.getDatanaCounter() + 1);
				}
				
				contextChange.setTotalCoursesCounter(contextChange.getTotalCoursesCounter()+1);
				tempOnGoing.add(string);
				// temp.remove(string);
			}
			if(contextChange.getWaitlist().size() > 1) {
				contextChange.setIsnotGraduated(true);
			}
			ArrayList<String> temp1 = contextChange.getWaitlist();
			for (String string : temp) {
				temp1.remove(string);
			}
			contextChange.setWaitlist(temp1);
			contextChange.setCoursesIn(temp);
			contextChange.setonGoingSem(tempOnGoing);
			for (String onGoingsem : contextChange.getonGoingSem())
			{
				if(onGoingsem.matches(regexCheck)) {
					countSimilar++;
				}
						
			}
			if(countSimilar <= 1) {
				contextChange.setIsnotGraduated(true);
//			} else {
//				ArrayList<String> onGoingTemp = contextChange.getonGoingSem();
//				onGoingTemp.clear();
//				contextChange.setonGoingSem(onGoingTemp);
				
			}
			//change to common method n call
			if (contextChange.getTotalCoursesCounter() == 3) {
				// if (contextChange.getTotalCoursesCounter() == 3 &&
				// contextChange.getSemCounter() <= 3) {
				contextChange.setSemCounter(contextChange.getSemCounter() + 1);
				ArrayList<String> onGoingTemp = contextChange.getonGoingSem();
				onGoingTemp.clear();
				contextChange.setonGoingSem(onGoingTemp);
				contextChange.setTotalCoursesCounter(0);
			} else if (contextChange.getSemCounter() == 3 && contextChange.getTotalCoursesCounter() < 3) {
				contextChange.setSemCounter(contextChange.getSemCounter() + 1);
				ArrayList<String> onGoingTemp = contextChange.getonGoingSem();
				onGoingTemp.clear();
				contextChange.setonGoingSem(onGoingTemp);
			}
			return null;
		}

		if (contextChange.getTotalCoursesCounter() == 3) {
			// if (contextChange.getTotalCoursesCounter() == 3 &&
			// contextChange.getSemCounter() <= 3) {
			contextChange.setSemCounter(contextChange.getSemCounter() + 1);
			ArrayList<String> onGoingTemp = contextChange.getonGoingSem();
			onGoingTemp.clear();
			contextChange.setonGoingSem(onGoingTemp);
			contextChange.setTotalCoursesCounter(0);
		/*} else if (contextChange.getSemCounter() == 3 && contextChange.getTotalCoursesCounter() < 3) {
			contextChange.setSemCounter(contextChange.getSemCounter() + 1);
			ArrayList<String> onGoingTemp = contextChange.getonGoingSem();
			onGoingTemp.clear();
			contextChange.setonGoingSem(onGoingTemp);*/
		}
		if (contextChange.getLongPCounter() >= 2 && contextChange.getDataStCounter() >= 2
				&& contextChange.getElecCounter() >= 2 && contextChange.getHardwareCounter() >= 2
				&& contextChange.getDatanaCounter() >= 2) {   // && contextChange.getSemCounter() >= 4
			//System.out.println("Graduated");
			contextChange.setGraduated(true);
			if(contextChange.getTotalCoursesCounter() > 0) {
				contextChange.setSemCounter(contextChange.getSemCounter() + 1);
				ArrayList<String> onGoingTemp = contextChange.getonGoingSem();
				onGoingTemp.clear();
				contextChange.setonGoingSem(onGoingTemp);
			}
			return null;
		}
		return new notGraduated(contextChange);
		// TODO Auto-generated method stub

	}

}
