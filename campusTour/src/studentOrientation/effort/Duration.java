package studentOrientation.effort;

import studentOrientation.activity.AttendLecture.LecturePreference;
import studentOrientation.activity.HaveLunch.LunchPlaces;
import studentOrientation.activity.PickGift.PickGiftPlaces;
import studentOrientation.activity.VisitBuilding.CollegeBuilding;

/**
 * 
 * @author GautiSpurs
 *This Duration class implements from Effort Interface and contains methods which actually contains the
 *Duration of each activities.
 *
 */
public class Duration implements EffortI {

	@Override
	public double getEffortBuilding(CollegeBuilding cb) {
		if(cb.equals(CollegeBuilding.BusRide)) {
			return 5;
		} else if(cb.equals(CollegeBuilding.ByFoot)) {
			return 15;
		}
		return 0;
	}

	@Override
	public double getEffortAttendLecture(LecturePreference lecIn) {
		if(lecIn.equals(LecturePreference.CS240)) {
			return 45;
		} else if(lecIn.equals(LecturePreference.CS350)) {
			return 30;
		}
		return 0;
	}

	@Override
	public double getEffortHaveLunch(LunchPlaces lunchIn) {
		if(lunchIn.equals(LunchPlaces.MountainViewOnline)) {
			return 15.00;
		} else if(lunchIn.equals(LunchPlaces.AtCIW)) {
			return 35.00;
		}
		return 0;
	}

	@Override
	public double getEffortPickGift(PickGiftPlaces gp) {
		if(gp.equals(PickGiftPlaces.EventCenter)) {
			return 20;
		} else if(gp.equals(PickGiftPlaces.UniversityUnion)) {
			return 10;
		}
		return 0;
	}
}
