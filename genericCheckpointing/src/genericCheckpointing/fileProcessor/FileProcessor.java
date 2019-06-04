package genericCheckpointing.fileProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor 
{
	//Node node1 = new Node();
	BufferedReader br;
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
		
	public String readLine()
	{
		String sread = null;
		 try {
			if ((sread = br.readLine()) != null) {
					//System.out.println(sread);
				  	//String[] sl = st.split(":");	
					//bno = Integer.parseInt(sl[0].trim());
					//course = Integer.parseInt(sl[1].trim()); 				
			  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return sread;
	}
}
