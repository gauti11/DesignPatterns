package studentCoursesPlanner.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * This class will take in input file as a string and will read the line and will
 * close the file
 * 
 * @author GautiSpurs
 *
 */
public class FileProcessor 
{
	int bno;
	int course;
	BufferedReader br;
	/**
	 * Constructor
	 * File is being read.
	 * @param fileIn
	 */
	public FileProcessor(String fileIn)
	{
  
		try {	
			  File file = new File(fileIn);
			  if(!file.isDirectory() && file.exists())
			  {
				 // BufferedReader br = null;
				 br = new BufferedReader(new FileReader(file)); 
			  }
			  else
			  {
					System.err.println("File Not found");
					throw new FileNotFoundException();
			  }
			} 
				catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
	/**
	 * File being read line by line
	 * @return
	 */
	public String readLine()
	{
		String sread = null;
		 try {
			if ((sread = br.readLine()) != null) {
					//return sread;			
			  }			
			/*else if(sread == null && br!=null)
				br.close();*/
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return sread;
	}
}
