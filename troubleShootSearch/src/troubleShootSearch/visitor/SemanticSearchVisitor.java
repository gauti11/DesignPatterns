package troubleShootSearch.visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import troubleShootSearch.product.DSeaGateI;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.Results;
import troubleShootSearch.util.MyLogger.DebugLevel;

public class SemanticSearchVisitor implements SearchVisitorI {

	public SemanticSearchVisitor() {
	}

	@Override
	public void visit(DSeaGateI productIn, Results resultIn, String searchStringIn) {

		MyLogger.writeMessage("Semantic Search", DebugLevel.SemanticSearch);
		resultIn.getResultList().add("\nSemantic Search");
		HashMap<String, ArrayList<String>> synonymMap = getSynonymMatch();

		String[] input = searchStringIn.split(" ");
		ArrayList<String> dbSynonyms = synonymMap.get(input[input.length - 1]);
		if (dbSynonyms != null) {
			searchStringIn = searchStringIn.replace(input[input.length - 1], "");
			for (String string : dbSynonyms) {
				searchStringIn = searchStringIn.concat(" " + string);
				for (String string1 : productIn.getProductDetails()) {
					if (isContain(string1, searchStringIn)) {
						MyLogger.writeMessage("\t" + string1, DebugLevel.SemanticSearch);
						resultIn.getResultList().add("\t" + string1);
					}
				}
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

	/**
	 * @return Hashmap of the word and list of it's synonyms
	 */
	private HashMap<String, ArrayList<String>> getSynonymMatch() {
		HashMap<String, ArrayList<String>> synonymMap = new HashMap<String, ArrayList<String>>();
		FileProcessor fp = new FileProcessor(
				System.getProperty("user.dir") + "/src/troubleShootSearch/visitor/synonyms.txt");

		for (String line : fp.readLine()) {
			String[] words = line.split(":");

			if (synonymMap.containsKey(words[0])) {
				synonymMap.get(words[0]).add(words[1]);
			} else {
				ArrayList<String> synonymsOfWord = new ArrayList<>();
				synonymsOfWord.add(words[1]);
				synonymMap.put(words[0], synonymsOfWord);
			}

		}

		return synonymMap;
	}
}
