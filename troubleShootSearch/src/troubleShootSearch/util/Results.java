package troubleShootSearch.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import troubleShootSearch.util.MyLogger.DebugLevel;

/**
 * Result class to store the total efforts as result of orientation selected
 * 
 * @author pragyavishalakshi
 *
 */
public class Results implements FileDisplayInterface {

	/**
	 * arrayList to store the course alloted and graduation status of each student
	 */
	private ArrayList<String> resultList = null;

	/**
	 * Constructor of Results
	 */
	public Results() {
		resultList = new ArrayList<>();
	}
	
	@Override
	public void writeToFile(String fileIn) {
		BufferedWriter br = null;
		try {
			br = new BufferedWriter(new FileWriter(fileIn));
			for (String data : resultList) {
				br.write(data+"\n");
			}
			resultList.clear();
		} catch (IOException e) {
			MyLogger.writeMessage("IOException", DebugLevel.NONE);
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				MyLogger.writeMessage("IOException while closing BufferedWriter", DebugLevel.NONE);
				e.printStackTrace();
			}
		}
	}

	public ArrayList<String> getResultList() {
		return resultList;
	}

	public void setResultList(ArrayList<String> resultList) {
		this.resultList = resultList;
	}

}
