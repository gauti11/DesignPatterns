package studentOrientation.activity;

import studentOrientation.activity.AttendLecture.LecturePreference;

public interface AttendLectureI {
	/**
	 * This method will calculate all the effort required to perform the current Activity.
	 * @param LecIn the enum of LecturePreference
	 */
	void getEffortAttendLecture(LecturePreference LecIn);
}
