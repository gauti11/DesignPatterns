package studentOrientation.activity;

import studentOrientation.activity.HaveLunch.LunchPlaces;

public interface HaveLunchI {
	/**
	 * This method will calculate all the effort required to perform the current Activity.
	 * @param placeIn the enum of LunchPlaces
	 */
	void getEffortHaveLunch(LunchPlaces placeIn);
}
