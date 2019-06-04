package genericCheckpointing.fileProcessor;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Results implements FileDisplayInterface
{
	BufferedWriter writer;	
public Results(String string) {
		// TODO Auto-generated constructor stub
	try {
		writer = new BufferedWriter(new FileWriter(string));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

private ArrayList<String> concatData = new ArrayList<String>();
	
	public ArrayList<String> getConcatData() {
	return concatData;
}

public void setConcatData(ArrayList<String> concatData) {
	this.concatData = concatData;
}

	public void writeFile(String fw) {
		try {
			//System.out.println(string);
			for (String string : concatData) 
		//	{
				writer.append(string+"\n");
				writer.newLine();
			//}
		writer.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeFile(String fw) {
		BufferedWriter writer;	
		try {
			writer = new BufferedWriter(new FileWriter(fw));
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

