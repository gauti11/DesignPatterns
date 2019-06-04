package studentOrientation.activity;

import studentOrientation.activity.VisitBuilding.CollegeBuilding;

public interface VisitBuildingI {
	/**
	 * This method will calculate all the effort required to perform the current Activity.
	 * @param buildingIn the enum of CollegeBuilding
	 */
	void getTotalEffortForVisitingBuilding(CollegeBuilding buildingIn);
}
