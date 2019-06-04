package studentOrientation.driver;

import studentOrientation.activity.AttendLecture.LecturePreference;
import studentOrientation.activity.HaveLunch.LunchPlaces;
import studentOrientation.activity.PickGift.PickGiftPlaces;
import studentOrientation.activity.VisitBuilding.CollegeBuilding;
import studentOrientation.context.ActivityBuilder;
import studentOrientation.context.Student;
import studentOrientation.util.Results;

/**
 *We pass the student object stud to the builder(activity.buildtour) to construct the object and then
 *finally print statement show the constructed plan. 
 * @author GautiSpurs
 *
 */

public class Driver {

	public static void main(String[] args) {
		Student stud = new Student(PickGiftPlaces.UniversityUnion, LunchPlaces.AtCIW, LecturePreference.CS350,
				CollegeBuilding.BusRide);
		ActivityBuilder activity = new ActivityBuilder();
		activity.buildTour(stud);
		Results result = new Results();
		result.printConsole(stud);
	}

}
