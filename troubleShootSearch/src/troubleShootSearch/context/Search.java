package troubleShootSearch.context;

import java.util.ArrayList;
import troubleShootSearch.product.*;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.Results;
import troubleShootSearch.util.MyLogger.DebugLevel;
import troubleShootSearch.visitor.*;

public class Search {

	Results result;
	SearchVisitorI exactSearch, naiveSearch, semanticSearch;
	ArrayList<String> searchInputs;
	DSeaGateI product1, product2, product3, product4;

	public Search(Results resultIn, ArrayList<String> inputIn) {
		result = resultIn;
		exactSearch = new ExactSearchVisitor();
		naiveSearch = new NaiveSearchVisitor();
		semanticSearch = new SemanticSearchVisitor();
		searchInputs = inputIn;
		product1 = new Product1();
		product2 = new Product2();
		product3 = new Product3();
		product4 = new Product4();
	}

	/**
	 * Execute the search query for all the products and all three type of Searches
	 */
	public void doSearch() {
		for (String searchString : searchInputs) {
			MyLogger.writeMessage("Search query: " + searchString + "\nDSEaGate Product1", DebugLevel.ExactSearch);
			MyLogger.writeMessage("Search query: " + searchString + "\nDSEaGate Product1", DebugLevel.NaiveSearch);
			MyLogger.writeMessage("Search query: " + searchString + "\nDSEaGate Product1", DebugLevel.SemanticSearch);
			result.getResultList().add("Search query: " + searchString + "\nDSEaGate Product1");
			product1.accept(exactSearch, result, searchString);
			product1.accept(naiveSearch, result, searchString);
			product1.accept(semanticSearch, result, searchString);

			MyLogger.writeMessage("Search query: " + searchString + "\nDSEaGate Product2", DebugLevel.ExactSearch);
			MyLogger.writeMessage("Search query: " + searchString + "\nDSEaGate Product2", DebugLevel.NaiveSearch);
			MyLogger.writeMessage("Search query: " + searchString + "\nDSEaGate Product2", DebugLevel.SemanticSearch);
			result.getResultList().add("\nDSEaGate Product2");
			product2.accept(exactSearch, result, searchString);
			product2.accept(naiveSearch, result, searchString);
			product2.accept(semanticSearch, result, searchString);

			MyLogger.writeMessage("Search query: " + searchString + "\nDSEaGate Product3", DebugLevel.ExactSearch);
			MyLogger.writeMessage("Search query: " + searchString + "\nDSEaGate Product3", DebugLevel.NaiveSearch);
			MyLogger.writeMessage("Search query: " + searchString + "\nDSEaGate Product3", DebugLevel.SemanticSearch);
			result.getResultList().add("\nDSEaGate Product3");
			product3.accept(exactSearch, result, searchString);
			product3.accept(naiveSearch, result, searchString);
			product3.accept(semanticSearch, result, searchString);

			MyLogger.writeMessage("Search query: " + searchString + "\nDSEaGate Product4", DebugLevel.ExactSearch);
			MyLogger.writeMessage("Search query: " + searchString + "\nDSEaGate Product4", DebugLevel.NaiveSearch);
			MyLogger.writeMessage("Search query: " + searchString + "\nDSEaGate Product4", DebugLevel.SemanticSearch);
			result.getResultList().add("\nDSEaGate Product4");
			product4.accept(exactSearch, result, searchString);
			product4.accept(naiveSearch, result, searchString);
			product4.accept(semanticSearch, result, searchString);
			System.out.println();
		}
	}
}
