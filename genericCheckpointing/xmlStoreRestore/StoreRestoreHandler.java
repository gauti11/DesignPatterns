package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import genericCheckpointing.fileProcessor.FileProcessor;
import genericCheckpointing.fileProcessor.Results;
import genericCheckpointing.strategyHandler.DeserStrategy;
import genericCheckpointing.strategyHandler.SerStrategy;
import genericCheckpointing.strategyHandler.XMLDeserialization;
import genericCheckpointing.strategyHandler.XMLSerialization;
import genericCheckpointing.util.SerializableObject;

public class StoreRestoreHandler implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		String methodName = method.getName();

		if (methodName.equals("writeObj")) {
			if (args[2].equals("XML")) {
				SerStrategy serialStrat = new XMLSerialization((Results)args[3]);
				serialStrat.processInput((SerializableObject)args[0]);
				//serialStrat.processInput((SerializableObject)args[0]);
			}
		}	
		if (methodName.equals("readObj")) {
			if (args[0].equals("XML")) {
				DeserStrategy dserialStrat = new XMLDeserialization((FileProcessor)args[1]);
				return dserialStrat.processInput();
				//serialStrat.processInput((SerializableObject)args[0]);
			}
		}	
		return null;
	}
	public void serializeData(SerializableObject sObject, SerStrategy sStrategy) {
		sStrategy.processInput(sObject);
	}
}

