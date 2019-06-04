package studentOrientation.activity;

import studentOrientation.effort.CarbonFootprint;
import studentOrientation.effort.CostOfActivity;
import studentOrientation.effort.Duration;
import studentOrientation.effort.EffortI;
import studentOrientation.effort.NoOfCalories;

/**
 * This class implements from the AttendLecture which takes up an object of Effort to calculate all the effort required to
 * do the current activity.
 * This class contains ENUMs for the activities which is specified by user in the Driver Class.
 * 
 */

public class AttendLecture implements AttendLectureI {
	EffortI eI;

	public enum LecturePreference {
		CS240, CS350;

		double carbonFootprint, cost, duration, calories;

		public double getCarbonFootprint() {
			return carbonFootprint;
		}

		public double getCost() {
			return cost;
		}

		public double getDuration() {
			return duration;
		}

		public double getCalories() {
			return calories;
		}

		public void setCarbonFootprint(double carbonFootprint) {
			this.carbonFootprint = carbonFootprint;
		}

		public void setCost(double cost) {
			this.cost = cost;
		}

		public void setDuration(double duration) {
			this.duration = duration;
		}

		public void setCalories(double calories) {
			this.calories = calories;
		}
	}

	@Override
	public void getEffortAttendLecture(LecturePreference lecIn) {
		eI = new CarbonFootprint();
		lecIn.setCarbonFootprint(eI.getEffortAttendLecture(lecIn));
		//System.out.println(lecIn.getCarbonFootprint() + " CF: " + stud.getTotalCarbonFootprint());

		eI = new CostOfActivity();
		lecIn.setCost(eI.getEffortAttendLecture(lecIn));
		//System.out.println(lecIn.getCost() + " Cost: " + stud.getTotalCost());

		eI = new Duration();
		lecIn.setDuration(eI.getEffortAttendLecture(lecIn));
		//System.out.println(lecIn.getDuration() + " duration: " + stud.getTotalDuration());

		eI = new NoOfCalories();
		lecIn.setCalories(eI.getEffortAttendLecture(lecIn));
		//System.out.println(lecIn.getCalories() + " calories: " + stud.getTotalCalories());
	}
}
