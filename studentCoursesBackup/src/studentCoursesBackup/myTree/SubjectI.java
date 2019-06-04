package studentCoursesBackup.myTree;

import studentCoursesBackup.myTree.ObserverI.Operation;

/**
 * Subject is an interface and is implemented by the node.
 * Subject will register the number of observers and when done will be able to remove the 
 * observers.
 * NotifyAll is implemented in node class where subject notify the observers of the changes.
 * 
 * 
 * @author GautiSpurs
 *
 */

public interface SubjectI {

    void registerObserver(ObserverI observerI);
    void removeObserver(ObserverI observerI);
    void notifyAllObservers(Operation op,String course);
}
