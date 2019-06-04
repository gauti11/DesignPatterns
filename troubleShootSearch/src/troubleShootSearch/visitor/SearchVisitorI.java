package troubleShootSearch.visitor;

import troubleShootSearch.product.*;
import troubleShootSearch.util.Results;

public interface SearchVisitorI {
	/**
	 * Execute the algorithms visited by the class which is calls this function
	 * based on the product which is calling it
	 * 
	 * @param productIn
	 * @param resultIn
	 * @param searchStringIn
	 */
	void visit(DSeaGateI productIn, Results resultIn, String searchStringIn);
}
