package studentOrientation.effort;

import studentOrientation.activity.AttendLecture.LecturePreference;
import studentOrientation.activity.HaveLunch.LunchPlaces;
import studentOrientation.activity.PickGift.PickGiftPlaces;
import studentOrientation.activity.VisitBuilding.CollegeBuilding;

/**
 * 
 * @author GautiSpurs
 *This carbonFootprint class implements from Effort Interface and contains methods which actually contains the
 *carbonfootprint of each activities.
 *
 */
public class CarbonFootprint implements EffortI {

	@Override
	public double getEffortBuilding(CollegeBuilding cb) {
		if(cb.equals(CollegeBuilding.BusRide)) {
			return 50;
		} else if(cb.equals(CollegeBuilding.ByFoot)) {
			return 100;
		}
		return 0;
	}

	@Override
	public double getEffortAttendLecture(LecturePreference lecIn) {
		if(lecIn.equals(LecturePreference.CS240)) {
			return 75;
		} else if(lecIn.equals(LecturePreference.CS350)) {
			return 60;
		}
		return 0;
	}

	@Override
	public double getEffortHaveLunch(LunchPlaces lunchIn) {
		if(lunchIn.equals(LunchPlaces.AtCIW)) {
			return 180;
		} else if(lunchIn.equals(LunchPlaces.MountainViewOnline)) {
			return 30;
		}
		return 0;
	}

	@Override
	public double getEffortPickGift(PickGiftPlaces gp) {
		if(gp.equals(PickGiftPlaces.EventCenter)) {
			return 150;
		} else if(gp.equals(PickGiftPlaces.UniversityUnion)) {
			return 80;
		}
		return 0;
	}

}
