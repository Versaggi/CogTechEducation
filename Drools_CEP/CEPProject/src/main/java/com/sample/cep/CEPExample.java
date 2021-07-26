package com.sample.cep;

import java.util.concurrent.TimeUnit;

import org.drools.core.time.SessionPseudoClock;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.ClockTypeOption;
import org.kie.api.runtime.rule.EntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CEPExample {

	public static void main(String[] args) {

		
        try {
            // load up the knowledge base & get the kSession
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	        	
        	// CEP - get the KIE related configuration container and set the EventProcessing (from default cloud) to Stream
        	KieBaseConfiguration config = ks.newKieBaseConfiguration();
        	config.setOption( EventProcessingOption.STREAM );       	
        	
        	
        	// Listeners
        	kSession.addEventListener( new DebugAgendaEventListener() );
        	kSession.addEventListener( new DebugRuleRuntimeEventListener() );

            // To setup a file based audit logger, uncomment the next line 
            // KieRuntimeLogger loggerKie = ks.getLoggers().newFileLogger( kSession, "./logger" );
            // KieRuntimeLogger consoleLogger = ks.getLoggers().newConsoleLogger(kSession); 
            
        	Logger logger = LoggerFactory.getLogger(CEPExample.class);
        	logger.info("\n*********************************>>>> Drools CEP Example \n");	
        
        	// Each Event is Inserted into WorkingMemory through an *EntryPoint*
        	EntryPoint entryPointStoreOne = kSession.getEntryPoint( "StoreOne" );
        	EntryPoint entryPointStoreTwo = kSession.getEntryPoint( "StoreTwo" );
        	
        	
        	// Create a SaleEvent Object 
        	SaleEvents saleEvent = new SaleEvents();
        	
        	// Call it's methods to populate WM with Sales Events Streams
        	saleEvent.insertStoreOneEvents(entryPointStoreOne);
        	saleEvent.insertStoreTwoEvents(entryPointStoreTwo);
        	       	
            
            // Fire all Rules
            kSession.fireAllRules();

            
            // Close Logger
            //logger.close();
            
            // Close the session
            kSession.destroy();
            
            System.out.println("*** DONE *** ");
            
        } catch (Throwable t) {
            t.printStackTrace();
        } 
		
	} // End Method - MAIN

	
	
	
//	// Helper Class to INSERTEVENT
//	private static void insertEvent(EntryPoint entryPoint, Sale sale, String article, long amount, int quantity) {
//	
//		sale.setArticle(article);
//		sale.setAmount(amount);
//		sale.setQuantity(quantity);
//		entryPoint.insert(sale);
//		
//	} // End Class insertEvent	
	
		
	
}// End Class CEPExample










