package genericCheckpointing.server;

import genericCheckpointing.fileProcessor.FileProcessor;
import genericCheckpointing.util.SerializableObject;

/**
 * Created by Gautam on 5/5/18.
 */
public interface RestoreI extends StoreRestoreI{
    SerializableObject readObj(String wireFormat, FileProcessor fpIn);
}
