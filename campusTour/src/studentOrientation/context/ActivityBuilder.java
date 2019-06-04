package studentOrientation.context;

import studentOrientation.activity.AttendLecture;
import studentOrientation.activity.AttendLectureI;
import studentOrientation.activity.HaveLunch;
import studentOrientation.activity.HaveLunchI;
import studentOrientation.activity.PickGift;
import studentOrientation.activity.PickGiftI;
import studentOrientation.activity.VisitBuilding;
import studentOrientation.activity.VisitBuildingI;
/**
 *  
 * @author GautiSpurs
 *This activity BUilder class constructor is setting the value for every orientation
 *activitiy we desired.
 *
 */

public class ActivityBuilder {
	VisitBuildingI building;
	AttendLectureI lec;
	HaveLunchI lunch;
	PickGiftI gift;

	public ActivityBuilder() {
		building = new VisitBuilding();
		lec = new AttendLecture();
		lunch = new HaveLunch();
		gift = new PickGift();
	}

	/**
	 * This Method builds each activity to make a one complete tour what is expected.
	 * @param stud the object of Student class
	 */
	public void buildTour(Student stud) {
		building.getTotalEffortForVisitingBuilding(stud.getCollegeBuildingToVisit());
		lec.getEffortAttendLecture(stud.getLecturePref());
		lunch.getEffortHaveLunch(stud.getLunchPref());
		gift.getTotalEffortForPickingGift(stud.getGiftPickupLocationPref());
		stud.effortOfTour();
	}

}
