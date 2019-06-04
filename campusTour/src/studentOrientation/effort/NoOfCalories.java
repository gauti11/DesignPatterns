package studentOrientation.effort;

import studentOrientation.activity.AttendLecture.LecturePreference;
import studentOrientation.activity.HaveLunch.LunchPlaces;
import studentOrientation.activity.PickGift.PickGiftPlaces;
import studentOrientation.activity.VisitBuilding.CollegeBuilding;

/**
 * 
 * @author GautiSpurs
 *This NoOfCalories class implements from Effort Interface and contains methods which actually contains the
 *NoOfCalories of each activities.
 *
 */

public class NoOfCalories implements EffortI {

	@Override
	public double getEffortBuilding(CollegeBuilding cb) {
		if(cb.equals(CollegeBuilding.BusRide)) {
			return 80;
		} else if(cb.equals(CollegeBuilding.ByFoot)) {
			return 500;
		}
		return 0;
	}

	@Override
	public double getEffortAttendLecture(LecturePreference lecIn) {
		if(lecIn.equals(LecturePreference.CS240)) {
			return 150;
		} else if(lecIn.equals(LecturePreference.CS350)) {
			return 120;
		}
		return 0;
	}

	@Override
	public double getEffortHaveLunch(LunchPlaces lunchIn) {
		if(lunchIn.equals(LunchPlaces.MountainViewOnline)) {
			return 60.00;
		} else if(lunchIn.equals(LunchPlaces.AtCIW)) {
			return 250.00;
		}
		return 0;
	}

	@Override
	public double getEffortPickGift(PickGiftPlaces gp) {
		if(gp.equals(PickGiftPlaces.EventCenter)) {
			return 300;
		} else if(gp.equals(PickGiftPlaces.UniversityUnion)) {
			return 200;
		}
		return 0;
	}
}
