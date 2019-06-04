package studentOrientation.activity;

import studentOrientation.effort.CarbonFootprint;
import studentOrientation.effort.CostOfActivity;
import studentOrientation.effort.Duration;
import studentOrientation.effort.EffortI;
import studentOrientation.effort.NoOfCalories;
/**
 * This class implements from the pickGift which takes up an object of Effort to calculate all the effort required to
 * do the current activity.
 * This class contains ENUMs for the activities which is specified by user in the Driver Class.
 * 
 */

public class PickGift implements PickGiftI {
	EffortI eI;

	public enum PickGiftPlaces {
		EventCenter, UniversityUnion;

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
	public void getTotalEffortForPickingGift(PickGiftPlaces giftIn) {
		eI = new CarbonFootprint();
		giftIn.setCarbonFootprint(eI.getEffortPickGift(giftIn));
		//System.out.println(giftIn.getCarbonFootprint() + " CF: " + stud.getTotalCarbonFootprint());

		eI = new CostOfActivity();
		giftIn.setCost(eI.getEffortPickGift(giftIn));
		//System.out.println(giftIn.getCost() + " Cost: " + stud.getTotalCost());

		eI = new Duration();
		giftIn.setDuration(eI.getEffortPickGift(giftIn));
		//System.out.println(giftIn.getDuration() + " duration: " + stud.getTotalDuration());

		eI = new NoOfCalories();
		giftIn.setCalories(eI.getEffortPickGift(giftIn));
		//System.out.println(giftIn.getCalories() + " calories: " + stud.getTotalCalories());
	}

}
