package genericCheckpointing.strategyHandler;

import genericCheckpointing.util.SerializableObject;

public interface SerStrategy {
	void processInput(SerializableObject sObject);
}