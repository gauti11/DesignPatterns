package studentOrientation.activity;

import studentOrientation.effort.CarbonFootprint;
import studentOrientation.effort.CostOfActivity;
import studentOrientation.effort.Duration;
import studentOrientation.effort.EffortI;
import studentOrientation.effort.NoOfCalories;

/**
 * This class implements from the VisitBuilding which takes up an object of Effort to calculate all the effort required to
 * do the current activity.
 * This class contains ENUMs for the activities which is specified by user in the Driver Class.
 * 
 */
public class VisitBuilding implements VisitBuildingI {
	EffortI eI;

	public enum CollegeBuilding {
		BusRide, ByFoot;

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
	public void getTotalEffortForVisitingBuilding(CollegeBuilding buildingIn) {
		//System.out.println("Visiting building");
		eI = new CarbonFootprint();
		buildingIn.setCarbonFootprint(eI.getEffortBuilding(buildingIn));
		//System.out.println(buildingIn.getCarbonFootprint() + " CF: " + stud.getTotalCarbonFootprint());

		eI = new CostOfActivity();
		buildingIn.setCost(eI.getEffortBuilding(buildingIn));
		//System.out.println(buildingIn.getCost() + " Cost: " + stud.getTotalCost());

		eI = new Duration();
		buildingIn.setDuration(eI.getEffortBuilding(buildingIn));
		//System.out.println(buildingIn.getDuration() + " duration: " + stud.getTotalDuration());

		eI = new NoOfCalories();
		buildingIn.setCalories(eI.getEffortBuilding(buildingIn));
		//System.out.println(buildingIn.getCalories() + " calories: " + stud.getTotalCalories());
	}
}
