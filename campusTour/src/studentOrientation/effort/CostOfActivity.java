package studentOrientation.effort;

import studentOrientation.activity.AttendLecture.LecturePreference;
import studentOrientation.activity.HaveLunch.LunchPlaces;
import studentOrientation.activity.PickGift.PickGiftPlaces;
import studentOrientation.activity.VisitBuilding.CollegeBuilding;
/**
 * 
 * @author GautiSpurs
 *This CostofActivity class implements from Effort Interface and contains methods which actually contains the
 *CostofActivity of each activities.
 *
 */

public class CostOfActivity implements EffortI {

	@Override
	public double getEffortBuilding(CollegeBuilding cb) {
		if(cb.equals(CollegeBuilding.BusRide)) {
			return 1.00;
		} else if(cb.equals(CollegeBuilding.ByFoot)) {
			return 0.50;
		}
		return 0;
	}

	@Override
	public double getEffortAttendLecture(LecturePreference lecIn) {
		if(lecIn.equals(LecturePreference.CS240)) {
			return 22.00;
		} else if(lecIn.equals(LecturePreference.CS350)) {
			return 20.00;
		}
		return 0;
	}

	@Override
	public double getEffortHaveLunch(LunchPlaces lunchIn) {
		if(lunchIn.equals(LunchPlaces.MountainViewOnline)) {
			return 52.00;
		} else if(lunchIn.equals(LunchPlaces.AtCIW)) {
			return 50.00;
		}
		return 0;
	}

	@Override
	public double getEffortPickGift(PickGiftPlaces gp) {
		return 0;
	}
}
