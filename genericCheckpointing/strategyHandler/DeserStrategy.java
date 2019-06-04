package genericCheckpointing.strategyHandler;

import genericCheckpointing.util.SerializableObject;

public interface DeserStrategy {
SerializableObject processInput();
}
