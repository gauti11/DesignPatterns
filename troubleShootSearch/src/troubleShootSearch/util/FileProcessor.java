package troubleShootSearch.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import troubleShootSearch.util.MyLogger.DebugLevel;

/**
 * Class to process the file given and read all the data from it
 * 
 * @author pragyavishalakshi
 *
 */
public class FileProcessor {
	private BufferedReader br = null;

	/**
	 * get the BufferedReader object of class
	 * 
	 * @return BufferedReader object
	 */
	public BufferedReader getBr() {
		return br;
	}

	/**
	 * set the BufferedReader object of class to given value
	 * 
	 * @param BufferedReader
	 *            object to be set
	 */
	public void setBr(BufferedReader brIn) {
		this.br = brIn;
	}

	/**
	 * parameterized constructor. Reads the file provided in BufferedReader
	 * 
	 * @param absolute
	 *            path of file
	 */
	public FileProcessor(String inputIn) {
		super();
		try {
			br = new BufferedReader(new FileReader(inputIn));
		} catch (FileNotFoundException e) {
			MyLogger.writeMessage("FileNotFoundException while reading file: "+inputIn, DebugLevel.NONE);
			e.printStackTrace();
		}
	}

	/**
	 * returns the list of all the lines read by buffered reader from file
	 * 
	 * @return list of all the lines read from file
	 */
	public ArrayList<String> readLine() {
		ArrayList<String> textLines = new ArrayList<>();
		try {
			String line = br.readLine();
			while (line != null) {
				textLines.add(line);
				line = br.readLine();
				MyLogger.writeMessage(line, DebugLevel.FILE_PROCESSOR);
			}
		} catch (IOException e) {
			MyLogger.writeMessage("Input Output Exception", DebugLevel.NONE);
			e.printStackTrace();
		} finally {
			close();
		}
		return textLines;
	}
	
	/**
	 * Close the buffer reader object
	 */
	public void close() {
		try {
			br.close();
		} catch (IOException e) {
			MyLogger.writeMessage("Input Output Exception while closing Buffere Reader", DebugLevel.NONE);
			e.printStackTrace();
		}
	}

}
