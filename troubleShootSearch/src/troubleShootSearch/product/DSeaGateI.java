package troubleShootSearch.product;

import java.util.ArrayList;

import troubleShootSearch.util.Results;
import troubleShootSearch.visitor.SearchVisitorI;

public interface DSeaGateI {
	/**
	 * Accepts the visitor (in our case search type) which needs to be visited for
	 * the query given
	 * @param visitor
	 * @param result
	 * @param searchInputIn
	 */
	public void accept(SearchVisitorI visitorIn, Results result, String searchInputIn);

	/**
	 * @return ArrayList of the technical details of the product selected
	 */
	public ArrayList<String> getProductDetails();
}
