package studentOrientation.context;

import studentOrientation.activity.AttendLecture.LecturePreference;
import studentOrientation.activity.HaveLunch.LunchPlaces;
import studentOrientation.activity.PickGift.PickGiftPlaces;
import studentOrientation.activity.VisitBuilding.CollegeBuilding;

/**
 * 
 * @author GautiSpurs
 *
 */
public class Student {
	LecturePreference lecturePref;
	CollegeBuilding collegeBuildingToVisit;
	LunchPlaces lunchPref;
	PickGiftPlaces giftPickupLocationPref;

	double totalCarbonFootprint, totalCost, totalDuration, totalCalories;

	/**
	 * constructor - which takes all the references.
	 * 
	 * @param giftPrefIn
	 *            the enum of PickGiftPlaces
	 * @param lunchPrefIn
	 *            the enum of LunchPlaces
	 * @param lectPrefIn
	 *            the enum of LecturePreference
	 * @param walkPrefIn
	 *            the enum of CollegeBuilding
	 */
	public Student(PickGiftPlaces giftPrefIn, LunchPlaces lunchPrefIn, LecturePreference lectPrefIn,
			CollegeBuilding walkPrefIn) {
		collegeBuildingToVisit = walkPrefIn;
		lecturePref = lectPrefIn;
		lunchPref = lunchPrefIn;
		giftPickupLocationPref = giftPrefIn;
		totalCarbonFootprint = 0;
		totalCost = 0;
		totalDuration = 0;
		totalCalories = 0;
	}

	/**
	 * This method contains all the calculations of the carbonFootprints, duration ,
	 * cost as well as calories required for completing the activities.
	 * 
	 */
	public void effortOfTour() {
		totalCarbonFootprint = lecturePref.getCarbonFootprint() + collegeBuildingToVisit.getCarbonFootprint()
				+ lunchPref.getCarbonFootprint() + giftPickupLocationPref.getCarbonFootprint();

		totalDuration = lecturePref.getDuration() + collegeBuildingToVisit.getDuration() + lunchPref.getDuration()
				+ giftPickupLocationPref.getDuration();

		totalCost = lecturePref.getCost() + collegeBuildingToVisit.getCost() + lunchPref.getCost()
				+ giftPickupLocationPref.getCost();

		totalCalories = lecturePref.getCalories() + collegeBuildingToVisit.getCalories() + lunchPref.getCalories()
				+ giftPickupLocationPref.getCalories();

	}

	/**
	 * All the Getter Setters are defined below for all the efforts.
	 * 
	 * @return double value of total cost/calories/carbonfootprint/duration for the
	 *         events
	 */
	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(double totalDuration) {
		this.totalDuration = totalDuration;
	}

	public double getTotalCalories() {
		return totalCalories;
	}

	public void setTotalCalories(double totalCalories) {
		this.totalCalories = totalCalories;
	}

	public double getTotalCarbonFootprint() {
		return totalCarbonFootprint;
	}

	public void setTotalCarbonFootprint(double totalCarbonFootprint) {
		this.totalCarbonFootprint = totalCarbonFootprint;
	}

	public LecturePreference getLecturePref() {
		return lecturePref;
	}

	public void setLecturePref(LecturePreference lecturePref) {
		this.lecturePref = lecturePref;
	}

	public CollegeBuilding getCollegeBuildingToVisit() {
		return collegeBuildingToVisit;
	}

	public void setCollegeBuildingToVisit(CollegeBuilding collegeBuildingToVisit) {
		this.collegeBuildingToVisit = collegeBuildingToVisit;
	}

	public LunchPlaces getLunchPref() {
		return lunchPref;
	}

	public void setLunchPref(LunchPlaces lunchPref) {
		this.lunchPref = lunchPref;
	}

	public PickGiftPlaces getGiftPickupLocationPref() {
		return giftPickupLocationPref;
	}

	public void setGiftPickupLocationPref(PickGiftPlaces giftPickupLocationPref) {
		this.giftPickupLocationPref = giftPickupLocationPref;
	}

	public String toString() {
		String print = "LecturePreference : " + lecturePref + "\nCollegeBuilding : "
				+ collegeBuildingToVisit + "\nLunchPlaces : " + lunchPref + "\nPickGiftPlaces : "
				+ giftPickupLocationPref;
		return print;

	}

}
