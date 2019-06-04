package troubleShootSearch.visitor;

import troubleShootSearch.product.DSeaGateI;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;
import troubleShootSearch.util.Results;

public class NaiveSearchVisitor implements SearchVisitorI {

	public NaiveSearchVisitor() {
	}

	@Override
	public void visit(DSeaGateI productIn, Results resultIn, String searchStringIn) {
		resultIn.getResultList().add("\nNaive Search");
		MyLogger.writeMessage("Naive Search", DebugLevel.NaiveSearch);
		String[] input = searchStringIn.split(" ");
		for (String string : productIn.getProductDetails()) {
			if (string.contains(input[0])) {
				MyLogger.writeMessage("\t" + string, DebugLevel.NaiveSearch);
				resultIn.getResultList().add("\t" + string);
			}
		}
	}

}
