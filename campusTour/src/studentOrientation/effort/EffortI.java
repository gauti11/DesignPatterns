package studentOrientation.effort;

import studentOrientation.activity.AttendLecture.LecturePreference;
import studentOrientation.activity.HaveLunch.LunchPlaces;
import studentOrientation.activity.PickGift.PickGiftPlaces;
import studentOrientation.activity.VisitBuilding.CollegeBuilding;

public interface EffortI {

	double getEffortBuilding(CollegeBuilding cb);
	double getEffortAttendLecture(LecturePreference lecIn);
	double getEffortHaveLunch(LunchPlaces lunchIn);
	double getEffortPickGift(PickGiftPlaces gp);
	
	
}