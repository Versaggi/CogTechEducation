package com.military.idcard;

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

import com.military.idcard.AccessAttempt;
import com.military.idcard.DataAccessAttempt;

public class IDCardEventExample {

	public static void main(String[] args) {

		
        try {
            // Create a KIE Container from the classpath
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
    	    
//    	    KieSessionConfiguration config = KieServices.Factory.get().newKieSessionConfiguration();
//    	    conf.setOption( ClockTypeOption.get( "pseudo" ) );
    	    
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	        	
        	// CEP - get the KIE related configuration container and set the EventProcessing (from default "cloud") to Stream
        	//KieBaseConfiguration config = ks.newKieBaseConfiguration();
        	//config.setOption( EventProcessingOption.STREAM );       	
        	
        	
        	// Listeners
        	// kSession.addEventListener( new DebugAgendaEventListener() );
        	// kSession.addEventListener( new DebugRuleRuntimeEventListener() );

            // To setup a file based audit logger, uncomment the next line 
            // KieRuntimeLogger loggerKie = ks.getLoggers().newFileLogger( kSession, "./logger" );
            // KieRuntimeLogger consoleLogger = ks.getLoggers().newConsoleLogger(kSession); 
            
        	Logger logger = LoggerFactory.getLogger(IDCardEventExample.class);
        	logger.info("  *********************************>>>> Drools CEP ID Card Example \n");	
        	
        		
        	
        	// Each Event is Inserted into WorkingMemory through an *EntryPoint* which represents a location
        	EntryPoint entryPointIdSystem = kSession.getEntryPoint( "idsystem" );


        	// Create a new EventStream Object
        	//EventStream eventStream = new EventStream();
        	EventStreamBig eventStream = new EventStreamBig();
        	
        	
        	// Get a clock 
        	SessionPseudoClock clock = kSession.getSessionClock();
        	
        	
        	// Insert a DEBUG Flag into WM
        	// kSession.insert("DEBUG");
        	
        	// Call the EventStream method to insert events into WM
        	// Note: The order in which these events are inserted into WM is important relative to the clock movement.
        	// Each eventstream is a QUEUE for which the LAST entry happend before the FIRST entry of the NEXT QUEUE.
        	
        	eventStream.insertIdSystemEvents(entryPointIdSystem, clock); 	// idsystem
        	       	
        	
        	
            
            // Fire all Rules
            kSession.fireAllRules();
                    
            
            // Close Logger
            //logger.close();
            
            // Close the session
            kSession.destroy();
            
            System.out.println("\n*** DONE *** ");
            
        } catch (Throwable t) {
            t.printStackTrace();
        } 
		
		
		
	}// End Main Method 
	
	

}// End Class IDCardEventExample
