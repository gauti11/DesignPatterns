package genericCheckpointing.server;

import genericCheckpointing.fileProcessor.Results;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;

/**
 * Created by Gautam on 5/5/14.
 */
public interface StoreI extends StoreRestoreI{
    void writeObj( MyAllTypesFirst aRecord,int authID, String wireFormat, Results resultIn);
    void writeObj( MyAllTypesSecond aRecords,int authID, String wireFormat, Results resultIn);
}