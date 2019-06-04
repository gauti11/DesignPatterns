
package genericCheckpointing.driver;

import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import genericCheckpointing.fileProcessor.FileDisplayInterface;
import genericCheckpointing.fileProcessor.FileProcessor;
import genericCheckpointing.fileProcessor.Results;
import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;

// import the other types used in this file

public class Driver {
	static int notSame = 0;
	public static void main(String[] args) {

		// FIXME: read the value of checkpointFile from the command line
		if (args.length != 3 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {
			System.out.println("Enter the Mode[arg0] , N[arg1] and Filename[args2]");
			System.exit(1);
		}
		String mode = args[0];
		ProxyCreator pc = new ProxyCreator();
		int NUM_OF_OBJECTS = 0;
		NUM_OF_OBJECTS = Integer.parseInt(args[1]);

		Vector<SerializableObject> deSeralize = new Vector<>();
		Vector<SerializableObject> seralize = new Vector<>();
		Random rand = new Random();
		StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
				new Class[] {
						StoreI.class, RestoreI.class
				}, 
				new StoreRestoreHandler()
				);
		MyAllTypesFirst myFirst;
		MyAllTypesSecond  mySecond;
		switch(mode)
		{
		case "serdeser":
			Results resultIn = new Results(args[2]);
			for (int i=0; i<NUM_OF_OBJECTS; i++) {
				myFirst = new MyAllTypesFirst(rand.nextInt(314) + i ,rand.nextLong() + i, "DesignPatterns", false, rand.nextInt(213) , rand.nextLong());
				mySecond = new MyAllTypesSecond((double)rand.nextDouble() + (i) ,(float)rand.nextFloat() +(i), (short)0, 'w', 76);
				seralize.add(myFirst);
				seralize.add(mySecond);
				((StoreI) cpointRef).writeObj(myFirst, 13,  "XML", resultIn);
				((StoreI) cpointRef).writeObj(mySecond, 17, "XML", resultIn);

			}
			resultIn.writeFile(args[2]);
			SerializableObject myRecordRet;
			FileProcessor fpIn = new FileProcessor(args[2]);
			for (int j=0; j<2*NUM_OF_OBJECTS; j++) {

				myRecordRet = ((RestoreI) cpointRef).readObj("XML", fpIn);
				deSeralize.add(myRecordRet);
			}
			System.out.println("Deserialisation " + deSeralize);

			notSame = checkVectors(seralize, deSeralize);
			if(notSame==0)
			{
				System.out.println("Serialized and Deseralized values are same");
			}
			else
			{
				System.out.println("Serialized and Deseralized values are not same");
			}
			break;
		case "deser":
			SerializableObject myRecordRet1;
			FileProcessor fpIn1 = new FileProcessor(args[2]);
			for (int j=0; j<NUM_OF_OBJECTS; j++) {
				myRecordRet1 = ((RestoreI) cpointRef).readObj("XML", fpIn1);
				deSeralize.add(myRecordRet1);
			}
			System.out.println(deSeralize);
			break;
		default:
			System.out.println("Wrong mode entered");
		}
	}		    
	private static int checkVectors(Vector<SerializableObject> seralize, Vector<SerializableObject> deSeralize) {
		for( int i = 0; i< seralize.size() && i < deSeralize.size() ; i++){
			if(!seralize.get(i).equals(deSeralize.get(i))){
				//            	System.out.println(seralize.get(i));
				//            	System.out.println(deSeralize.get(i));
				notSame++;
			}
		}
		return notSame;
	}

}
