package studentCoursesBackup.myTree;

/**
 * Its an observer implemented as an interface which will be implemented to update the
 * backup trees.
 * @author GautiSpurs
 *
 */

public interface ObserverI {
	enum Operation {INSERT,REMOVE}
	void update(Operation op,String course);
	
}
