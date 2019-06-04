package studentOrientation.activity;

import studentOrientation.effort.CarbonFootprint;
import studentOrientation.effort.CostOfActivity;
import studentOrientation.effort.Duration;
import studentOrientation.effort.EffortI;
import studentOrientation.effort.NoOfCalories;

/**
 * This class implements from the HaveLunch which takes up an object of Effort to calculate all the effort required to
 * do the current activity.
 * This class contains ENUMs for the activities which is specified by user in the Driver Class.
 * 
 */
public class HaveLunch implements HaveLunchI {
	EffortI eI;

	public enum LunchPlaces {
		MountainViewOnline, AtCIW;

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
	public void getEffortHaveLunch(LunchPlaces placeIn) {
		eI = new CarbonFootprint();
		placeIn.setCarbonFootprint(eI.getEffortHaveLunch(placeIn));
		//System.out.println(placeIn.getCarbonFootprint() + " CF: " + stud.getTotalCarbonFootprint());

		eI = new CostOfActivity();
		placeIn.setCost(eI.getEffortHaveLunch(placeIn));
		//System.out.println(placeIn.getCost() + " Cost: " + stud.getTotalCost());

		eI = new Duration();
		placeIn.setDuration(eI.getEffortHaveLunch(placeIn));
		//System.out.println(placeIn.getDuration() + " duration: " + stud.getTotalDuration());

		eI = new NoOfCalories();
		placeIn.setCalories(eI.getEffortHaveLunch(placeIn));
		//System.out.println(placeIn.getCalories() + " calories: " + stud.getTotalCalories());
	}

}
