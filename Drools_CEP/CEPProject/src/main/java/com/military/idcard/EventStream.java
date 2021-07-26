package com.military.idcard;

import java.util.concurrent.TimeUnit;
import org.drools.core.time.SessionPseudoClock;
import org.kie.api.runtime.rule.EntryPoint;


public class EventStream {

	private static final String LOGIN = "login";
	private static final String LOGOUT = "logout";
	private static final String SUCCESSFUL = "successful";
	private static final String FAILURE = "failure";
	private static final String TOPSECRET = "topsecret";
	private static final String SECRET = "secret";
	private static final String CLASSIFIED = "classified";
	private static final String UNCLASSIFIED = "unclassified";
	private static final String OFFICE = "office";
	private static final String CAFE = "cafe";
	private static final String BARRACKS = "barracks";
	private static final String UNKNOWN = "unknown";
	

	public EventStream() {
		// *** Do Nothing ***
	}// End Constructor
	
	
	/*
	 *   These are the actual Event POJO's for the event stream creation
	*/
		
	public void insertIdSystemEvents(EntryPoint entryPoint, SessionPseudoClock clock) {
		
		// Insert EventData into WM ==> employeeId | location | timeOfDay | computerId | action | result : (AccessAttempt)
		// Insert EventData into WM ==> dataClassification | computerId | employeeId 					 : (DataAccessAttempt)
		
		/*****  BEGIN DATA STREAM SEQUENCE USING PSEUDO CLOCK: TIME MOVED FORWARD LINEARLY ******/
		
//  1 AM
		clock.advanceTime( 1, TimeUnit.HOURS );
		
//  2 AM
		clock.advanceTime( 1, TimeUnit.HOURS );
		
//  3 AM
		clock.advanceTime( 1, TimeUnit.HOURS );
		
//  4 AM
		clock.advanceTime( 1, TimeUnit.HOURS );
		
//  5 AM
		clock.advanceTime( 1, TimeUnit.HOURS );
		
//  6 AM
		clock.advanceTime( 1, TimeUnit.HOURS );
		
//  7 AM
		clock.advanceTime( 1, TimeUnit.HOURS );
		
//  8 AM
		clock.advanceTime( 1, TimeUnit.HOURS );	
		
		
//  9 AM
		
		// ** START OF WORK DAY *** 
		
		// [ ** EVENT ** ] : ( Access Restricted Data *NORMAL* ) : OFFICE - 4023
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4023", OFFICE,  "office4023", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(TOPSECRET, "office4023", "4023") );						// TOP SECRET

		
		// [ ** EVENT ** ] : ( Access Restricted Data *NORMAL* ) : OFFICE - 1123
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1123", OFFICE,  "office1123", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 3, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1123", "1123") );					// UNCLASSIFIED
		clock.advanceTime( 3, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(CLASSIFIED, "office1123", "1123") );					// CLASSIFIED
		clock.advanceTime( 3, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(SECRET, "office1123", "1123") );						// SECRET

		clock.advanceTime( 1, TimeUnit.HOURS );	
		
		
// 10 AM
		
		// [ ** EVENT ** ] : (Access Restricted Data *Improperly* )  : BARRACKS - 4023
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("3333", BARRACKS, "barracks3333", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 1, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(SECRET, "barracks3333", "3333") );						// SECRET
		clock.advanceTime( 2, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("3333", BARRACKS, "barracks3333", LOGOUT, SUCCESSFUL) );
								
		
		// [ ** EVENT ** ] : (Multiple Logins) : [Office -> Cafe]
		clock.advanceTime( 1, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4023", CAFE,  "cafe4023", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 1, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1123", CAFE,  "cafe1123", LOGIN, SUCCESSFUL));
		// LOGOUT - Corresponding 
		clock.advanceTime( 1, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4023", CAFE,  "cafe4023", LOGOUT, SUCCESSFUL) );
		clock.advanceTime( 1, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1123", CAFE,  "cafe1123", LOGOUT, SUCCESSFUL));
			
		
		clock.advanceTime( 1, TimeUnit.HOURS );	

// 11 AM
		
		// [ ** EVENT ** ] : (Access Restricted Data *Improperly* ) : CAFE - 2222	
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2222", CAFE, "cafe2222", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 1, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(CLASSIFIED, "cafe2222", "2222") );						// CLASSIFIED
		clock.advanceTime( 2, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2222", CAFE, "cafe2222", LOGOUT, SUCCESSFUL) );				
		
		clock.advanceTime( 1, TimeUnit.HOURS );	
		
// 12 AM
		
		// ** START OF LUNCH *** 
		clock.advanceTime( 0, TimeUnit.HOURS );
		entryPoint.insert(new AccessAttempt("4023", OFFICE,  "office4023", LOGOUT, SUCCESSFUL) );	
		clock.advanceTime( 0, TimeUnit.HOURS );
		entryPoint.insert(new AccessAttempt("1123", OFFICE,  "office1123", LOGOUT, SUCCESSFUL) );		
							
				
				
		// [ ** EVENT ** ] : ( Multiple Login Failures ) : CAFE - ID: 4023		
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4023", CAFE, "cafe234", LOGIN, FAILURE) );
		clock.advanceTime( 1, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4023", CAFE, "cafe234", LOGIN, FAILURE) );		
		clock.advanceTime( 1, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4023", CAFE, "cafe234", LOGIN, FAILURE) );
		clock.advanceTime( 1, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4023", CAFE, "cafe234", LOGIN, FAILURE) );
		clock.advanceTime( 1, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4023", CAFE, "cafe234", LOGIN, FAILURE) );		
		clock.advanceTime( 1, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4023", CAFE, "cafe234", LOGIN, FAILURE) );	
		
		clock.advanceTime( 1, TimeUnit.HOURS );	
	
//  1 PM
		
		// ** END OF LUNCH *** 
		clock.advanceTime( 0, TimeUnit.HOURS );
		entryPoint.insert(new AccessAttempt("4023", OFFICE,  "office4023", LOGIN, SUCCESSFUL) );	
		clock.advanceTime( 0, TimeUnit.HOURS );
		entryPoint.insert(new AccessAttempt("1123", OFFICE,  "office1123", LOGIN, SUCCESSFUL) );		
		
		clock.advanceTime( 1, TimeUnit.HOURS );	
		
//  2 PM
			
		// [ ** EVENT ** ]: Multiple Login Failures			
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4023", BARRACKS, "barracks4023", LOGIN, FAILURE) );		
		clock.advanceTime( 1, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4023", BARRACKS, "barracks4023", LOGIN, FAILURE) );		
		clock.advanceTime( 1, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4023", BARRACKS, "barracks4023", LOGIN, FAILURE) );	
		clock.advanceTime( 1, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4023", BARRACKS, "barracks4023", LOGIN, FAILURE) );	
		clock.advanceTime( 1, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4023", BARRACKS, "barracks4023", LOGIN, FAILURE) );				
			
		clock.advanceTime( 1, TimeUnit.HOURS );		
			
		
//  3 PM
		clock.advanceTime( 1, TimeUnit.HOURS );	
		
		
//  4 PM
			
		// [ ** EVENT ** ] : ( Multiple Login Failures ) : UNKNOWN - ID: 4444
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4444", UNKNOWN, "unknown", LOGIN, FAILURE) );
		clock.advanceTime( 1, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4444", UNKNOWN, "unknown", LOGIN, FAILURE) );		
		clock.advanceTime( 1, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4444", UNKNOWN, "unknown", LOGIN, FAILURE) );
		clock.advanceTime( 1, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4444", UNKNOWN, "unknown", LOGIN, FAILURE) );
		clock.advanceTime( 1, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4444", UNKNOWN, "unknown", LOGIN, FAILURE) );
			
		// [ ** EVENT ** ] : ( Data Breach ) : Location UNKNOWN - ID: 4444
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4444", UNKNOWN, "unknown", LOGIN, SUCCESSFUL) );		
		clock.advanceTime( 1, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(TOPSECRET, "unknown", "4444") );
		clock.advanceTime( 50, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("4444", UNKNOWN,  "unknown", LOGOUT, SUCCESSFUL) );				
		
		
		clock.advanceTime( 1, TimeUnit.HOURS );	
		
		
//  5 PM
		
		// ** END OF WORK DAY *** 
		clock.advanceTime( 0, TimeUnit.HOURS );
		entryPoint.insert(new AccessAttempt("4023", OFFICE,  "office4023", LOGOUT, SUCCESSFUL) );	
		clock.advanceTime( 0, TimeUnit.HOURS );
		entryPoint.insert(new AccessAttempt("1123", OFFICE,  "office1123", LOGOUT, SUCCESSFUL) );		
		
		clock.advanceTime( 1, TimeUnit.HOURS );	
		
//  6 PM
		
		// [ ** EVENT ** ] : (Multiple Logins Cafe -> Barracks) 
		// CAFE - 1023
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1023", CAFE, "cafe1023", LOGIN, SUCCESSFUL) );		
		// BARRACKS - 1023
		clock.advanceTime( 15, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1023", BARRACKS, "barracks1023", LOGIN, SUCCESSFUL) );	
		
		// LOGOUT - corresponding
		// CAFE - 1023
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1023", CAFE, "cafe1023", LOGOUT, SUCCESSFUL) );		
		// BARRACKS - 1023
		clock.advanceTime( 15, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1023", BARRACKS, "barracks1023", LOGOUT, SUCCESSFUL) );	
		
		
		clock.advanceTime( 1, TimeUnit.HOURS );	
		
//  7 PM
		
		// START OF DINNER
		clock.advanceTime( 1, TimeUnit.HOURS );	
			
//  8 PM
			
		// END OF DINNER	
		clock.advanceTime( 1, TimeUnit.HOURS );	
		
		
//  9 PM
		clock.advanceTime( 1, TimeUnit.HOURS );	
		
// 10 PM
				
		// [ ** EVENT ** ] : (Multiple Logins Barracks -> Cafe) 
		// BARRACKS - 2023
		clock.advanceTime( 15, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2023", BARRACKS, "barracks2023", LOGIN, SUCCESSFUL) );		
		// CAFE - 2023
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2023", CAFE, "cafe2023", LOGIN, SUCCESSFUL) );	
			
		clock.advanceTime( 1, TimeUnit.HOURS );	
				
// 11 PM		
		
		clock.advanceTime( 1, TimeUnit.HOURS );	
		
// 12 Midnight		
		
		clock.advanceTime( 1, TimeUnit.HOURS );			
			
			
		
		
		/*****  END DATA STREAM SEQUENCE USING PSEUDO CLOCK: TIME STOPPS HERE ******/
		
	} // End Method insertIdSystemEvents
	
	

	
} // End Class EventStream.java
