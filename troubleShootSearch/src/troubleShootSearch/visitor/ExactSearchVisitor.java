package troubleShootSearch.visitor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import troubleShootSearch.product.DSeaGateI;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.Results;
import troubleShootSearch.util.MyLogger.DebugLevel;

public class ExactSearchVisitor implements SearchVisitorI {

	public ExactSearchVisitor() {
	}

	@Override
	public void visit(DSeaGateI productIn, Results resultIn, String searchStringIn) {

		MyLogger.writeMessage("Exact Search", DebugLevel.ExactSearch);
		resultIn.getResultList().add("\nExact Search");
		for (String string : productIn.getProductDetails()) {
			if (isContain(string, searchStringIn)) {
				MyLogger.writeMessage("\t" + string, DebugLevel.ExactSearch);
				resultIn.getResultList().add("\t" + string + "\n");
			}
		}
	}

	/**
	 * It compares the source and subItem to state if subItem is present as an exact word in source string
	 * @param sourceIn
	 * @param subItemIn
	 * @return
	 */
	private static boolean isContain(String sourceIn, String subItemIn) {
		String pattern = "\\b" + subItemIn + "\\b";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(sourceIn);
		return m.find();
	}

}
