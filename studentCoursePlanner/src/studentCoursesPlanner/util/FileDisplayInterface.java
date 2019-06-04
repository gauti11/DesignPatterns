package studentCoursesPlanner.util;

import studentCoursesPlanner.state.semContextClass;

/**
 * It is implemented by the result and the files are written to 
 * the file when this method is called.
 * @author GautiSpurs
 *
 */
public interface FileDisplayInterface {

	void writeFile(String fw, semContextClass sc);
}
