package troubleShootSearch.product;

import java.util.ArrayList;

import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;
import troubleShootSearch.util.Results;
import troubleShootSearch.visitor.SearchVisitorI;

public class Product1 implements DSeaGateI {

	private ArrayList<String> productDetails = new ArrayList<>();
	
	public Product1() {
		FileProcessor fp = new FileProcessor(System.getProperty("user.dir")+"/src/troubleShootSearch/product/technicalDetails1.txt");
		productDetails = fp.readLine();
		MyLogger.writeMessage("Product 1 constructor file was read", DebugLevel.CONSTRUCTOR);
	}

	public ArrayList<String> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ArrayList<String> productDetailsIn) {
		this.productDetails = productDetailsIn;
	}

	@Override
	public void accept(SearchVisitorI visitorIn, Results resultIn, String searchInputIn) {
		visitorIn.visit(this, resultIn, searchInputIn);
	}



}
