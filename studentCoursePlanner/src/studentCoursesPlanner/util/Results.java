package studentCoursesPlanner.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import studentCoursesPlanner.state.semContextClass;


/**
 * This class implements from FileDisplayInterface and stdoutDisplay which have methods 
 * to print in the console and or append in the file.
 * This class will print the Bno as well as the student is graduated or not.
 * @author GautiSpurs
 *
 */

public class Results implements FileDisplayInterface, StdoutDisplayInterface
{
	ArrayList<String> concatData = new ArrayList<String>();

	@Override
	public void writeConsole(semContextClass sc, int bNo) {
		// TODO Auto-generated method stub
		if (sc.isGraduated() != true || sc.isIsnotGraduated() == true) {
			System.out.println("Not Graduated ");
			if(sc.getTotalCoursesCounter()!=0)
			{
				System.out.println("TotalSemester " + (sc.getSemCounter()+1));
			}
			else 
				System.out.println("TotalSemester " + sc.getSemCounter());
		}
		if (sc.isGraduated() == true) {
			System.out.println("Graduated ");
			System.out.println("TotalSemester " + sc.getSemCounter());

		}
		System.out.print(bNo +" : "+ sc.getCoursesIn());

	}

	@Override
	public void writeFile(String fw, semContextClass sc) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(fw));
			//System.out.println(string);
			if (sc.isGraduated() != true || sc.isIsnotGraduated() == true) {
				//System.out.println("Not Graduated ");
				writer.append("Not Graduated ");
				if(sc.getTotalCoursesCounter()!=0)
				{
					writer.append("In TotalSemester =  " + (sc.getSemCounter()+1));
				}
				else 
				{
					writer.append("TotalSemester " + sc.getSemCounter());
				}

			}


			if (sc.isGraduated() == true) {
				writer.append("Graduated ");
				writer.append("In TotalSemester = " + sc.getSemCounter());

			}
			writer.newLine();
			writer.append(sc.getCoursesIn()+"\n");
			writer.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// TODO Auto-generated method stub

}


