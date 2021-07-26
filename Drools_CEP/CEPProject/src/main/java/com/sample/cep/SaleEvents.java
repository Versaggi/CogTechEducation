package com.sample.cep;

import org.kie.api.runtime.rule.EntryPoint;
import com.sample.cep.Sale;


public class SaleEvents {

	public SaleEvents() {
		// *** Do Nothing ***
	}// End Constructor
	
	
	/*
	 *   These are the actual Event POJO's
	*/
	
	public static void insertStoreOneEvents(EntryPoint entryPoint) {
		// Insert EventData into WM for StoreOne
		entryPoint.insert(new Sale("meat", 40, 5) );
		entryPoint.insert(new Sale("bananna", 5, 10) );
		entryPoint.insert(new Sale("pear", 5, 10) );
		entryPoint.insert(new Sale("yogurt", 5, 50) );
		entryPoint.insert(new Sale("led TV", 10000, 1) );
	}
	
	
	public static void insertStoreTwoEvents(EntryPoint entryPoint) {
		// Insert EventData into WM for StoreTwo
		entryPoint.insert(new Sale("meat", 40, 5) );
		entryPoint.insert(new Sale("bananna", 5, 10) );
		entryPoint.insert(new Sale("pear", 5, 10) );
		entryPoint.insert(new Sale("yogurt", 5, 50) );
		entryPoint.insert(new Sale("led TV", 12000, 1) );
	}	
	

}// End Class SaleEvents
