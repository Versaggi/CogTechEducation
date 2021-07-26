package com.military.idcard;

import java.util.concurrent.TimeUnit;
import org.drools.core.time.SessionPseudoClock;
import org.kie.api.runtime.rule.EntryPoint;

public class EventStreamBig {

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
	

	public EventStreamBig() {
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
		
		// NORMAL ACTIVITY - 1000
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1000", OFFICE,  "office1000", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1000", "1000") );	

		// NORMAL ACTIVITY - 1001
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1001", OFFICE,  "office1001", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1001", "1001") );	
		
		// NORMAL ACTIVITY - 1002
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1002", OFFICE,  "office1002", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1002", "1002") );	
		
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

		// NORMAL ACTIVITY - 1003
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1003", OFFICE,  "office1003", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1003", "1003") );	

		// NORMAL ACTIVITY - 1004
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1004", OFFICE,  "office1004", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1004", "1004") );	

		// NORMAL ACTIVITY - 1005
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1005", OFFICE,  "office1005", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1005", "1005") );	

		// NORMAL ACTIVITY - 1006
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1006", OFFICE,  "office1006", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1006", "1006") );	

		// NORMAL ACTIVITY - 1007
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1007", OFFICE,  "office1007", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1007", "1007") );	

		// NORMAL ACTIVITY - 1008
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1008", OFFICE,  "office1008", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1008", "1008") );	
		
		// NORMAL ACTIVITY - 1009
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1009", OFFICE,  "office1009", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1009", "1009") );	
		
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
		// Lunch
		clock.advanceTime( 0, TimeUnit.HOURS );
		entryPoint.insert(new AccessAttempt("4023", OFFICE,  "office4023", LOGOUT, SUCCESSFUL) );
		// Lunch
		clock.advanceTime( 0, TimeUnit.HOURS );
		entryPoint.insert(new AccessAttempt("1123", OFFICE,  "office1123", LOGOUT, SUCCESSFUL) );		
				
		// Lunch
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1000", OFFICE,  "office1000", LOGOUT, SUCCESSFUL) );		
		// Lunch
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1001", OFFICE,  "office1001", LOGOUT, SUCCESSFUL) );		
		// Lunch
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1002", OFFICE,  "office1002", LOGOUT, SUCCESSFUL) );			
		// Lunch
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1003", OFFICE,  "office1003", LOGOUT, SUCCESSFUL) );		
		// Lunch
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1004", OFFICE,  "office1004", LOGOUT, SUCCESSFUL) );			
		// Lunch
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1005", OFFICE,  "office1005", LOGOUT, SUCCESSFUL) );
		// Lunch
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1006", OFFICE,  "office1006", LOGOUT, SUCCESSFUL) );		
		//Lunch
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1007", OFFICE,  "office1007", LOGOUT, SUCCESSFUL) );
		// Lunch
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1008", OFFICE,  "office1008", LOGOUT, SUCCESSFUL) );		
		// Lunch
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1009", OFFICE,  "office1009", LOGOUT, SUCCESSFUL) );
				
				
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
		// Post Lunch
		clock.advanceTime( 0, TimeUnit.HOURS );
		entryPoint.insert(new AccessAttempt("4023", OFFICE,  "office4023", LOGIN, SUCCESSFUL) );
		// Post Lunch
		clock.advanceTime( 0, TimeUnit.HOURS );
		entryPoint.insert(new AccessAttempt("1123", OFFICE,  "office1123", LOGIN, SUCCESSFUL) );
		
		// Post Lunch
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1000", OFFICE,  "office1000", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1000", "1000") );	
		// Post Lunch
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1001", OFFICE,  "office1001", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1001", "1001") );
		// Post Lunch
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1002", OFFICE,  "office1002", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1002", "1002") );
		// Post Lunch
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1003", OFFICE,  "office1003", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1003", "1003") );	
		// Post Lunch
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1004", OFFICE,  "office1004", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1004", "1004") );	
		// Post Lunch
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1005", OFFICE,  "office1005", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1005", "1005") );	
		// Post Lunch
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1006", OFFICE,  "office1006", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1006", "1006") );	
		// Post Lunch
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1007", OFFICE,  "office1007", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1007", "1007") );	
		// Post Lunch
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1008", OFFICE,  "office1008", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1008", "1008") );	
		// Post Lunch
		clock.advanceTime( 0, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1009", OFFICE,  "office1009", LOGIN, SUCCESSFUL) );
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office1009", "1009") );
		
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
		
		// Post Lunch - Proper Restricted Data Access
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(CLASSIFIED, "office1000", "1000") );	
		// Post Lunch - Proper Restricted Data Access
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(SECRET, "office1001", "1001") );
		// Post Lunch - Proper Restricted Data Access
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(TOPSECRET, "office1002", "1002") );
		// Post Lunch - Proper Restricted Data Access
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(CLASSIFIED, "office1003", "1003") );	
		// Post Lunch - Proper Restricted Data Access
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(SECRET, "office1004", "1004") );	
		// Post Lunch - Proper Restricted Data Access
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(TOPSECRET, "office1005", "1005") );	
		// Post Lunch - Proper Restricted Data Access
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(CLASSIFIED, "office1006", "1006") );	
		// Post Lunch - Proper Restricted Data Access
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(SECRET, "office1007", "1007") );	
		// Post Lunch - Proper Restricted Data Access
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(TOPSECRET, "office1008", "1008") );	
		// Post Lunch - Proper Restricted Data Access
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(CLASSIFIED, "office1009", "1009") );		
		
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
		// EOD
		clock.advanceTime( 0, TimeUnit.HOURS );
		entryPoint.insert(new AccessAttempt("4023", OFFICE,  "office4023", LOGOUT, SUCCESSFUL) );
		// EOD
		clock.advanceTime( 0, TimeUnit.HOURS );
		entryPoint.insert(new AccessAttempt("1123", OFFICE,  "office1123", LOGOUT, SUCCESSFUL) );	
		
		// EOD
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1000", OFFICE,  "office1000", LOGOUT, SUCCESSFUL) );
		// EOD
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1001", OFFICE,  "office1001", LOGOUT, SUCCESSFUL) );		
		// EOD
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1002", OFFICE,  "office1002", LOGOUT, SUCCESSFUL) );		
		// EOD
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1003", OFFICE,  "office1003", LOGOUT, SUCCESSFUL) );
		// EOD
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1004", OFFICE,  "office1004", LOGOUT, SUCCESSFUL) );
		// EOD
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1005", OFFICE,  "office1005", LOGOUT, SUCCESSFUL) );
		// EOD
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1006", OFFICE,  "office1006", LOGOUT, SUCCESSFUL) );	
		// EOD
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1007", OFFICE,  "office1007", LOGOUT, SUCCESSFUL) );
		// EOD
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1008", OFFICE,  "office1008", LOGOUT, SUCCESSFUL) );
		// EOD
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("1009", OFFICE,  "office1009", LOGOUT, SUCCESSFUL) );		
		
		
		
		clock.advanceTime( 1, TimeUnit.HOURS );	
		
//  6 PM
		
		// Normal Coffee - 2001
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2001", CAFE, "cafe2001", LOGIN, SUCCESSFUL) );			
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office2001", "2001") );	
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2001", CAFE, "cafe2001", LOGOUT, SUCCESSFUL) );
		
		// Normal Coffee - 2002
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2002", CAFE, "cafe2002", LOGIN, SUCCESSFUL) );			
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office2002", "2002") );	
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2002", CAFE, "cafe2002", LOGOUT, SUCCESSFUL) );

		// Normal Coffee - 2003
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2003", CAFE, "cafe2003", LOGIN, SUCCESSFUL) );			
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office2003", "2003") );	
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2003", CAFE, "cafe2003", LOGOUT, SUCCESSFUL) );
		
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
		
		// Normal Coffee - 2004
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2004", CAFE, "cafe2004", LOGIN, SUCCESSFUL) );			
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office2004", "2004") );	
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2004", CAFE, "cafe2004", LOGOUT, SUCCESSFUL) );
		
		// Normal Coffee - 2005
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2005", CAFE, "cafe2005", LOGIN, SUCCESSFUL) );			
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office2005", "2005") );	
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2005", CAFE, "cafe2005", LOGOUT, SUCCESSFUL) );
		
		
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
				
		
		// Normal Barracks - 2006
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2006", BARRACKS, "cafe2006", LOGIN, SUCCESSFUL) );			
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office2006", "2006") );	
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2006", BARRACKS, "cafe2006", LOGOUT, SUCCESSFUL) );
		
		// Normal Barracks - 2007
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2007", BARRACKS, "cafe2007", LOGIN, SUCCESSFUL) );			
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office2007", "2007") );	
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2007", BARRACKS, "cafe2007", LOGOUT, SUCCESSFUL) );		
		
		// Normal Barracks - 2008
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2008", BARRACKS, "cafe2008", LOGIN, SUCCESSFUL) );			
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office2008", "2008") );	
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2008", BARRACKS, "cafe2008", LOGOUT, SUCCESSFUL) );
		
		// [ ** EVENT ** ] : (Multiple Logins Barracks -> Cafe) 
		// BARRACKS - 2023
		clock.advanceTime( 15, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2023", BARRACKS, "barracks2023", LOGIN, SUCCESSFUL) );		
		// CAFE - 2023
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2023", CAFE, "cafe2023", LOGIN, SUCCESSFUL) );			
		
		// Normal Barracks - 2009
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2009", BARRACKS, "cafe2009", LOGIN, SUCCESSFUL) );			
		clock.advanceTime( 5, TimeUnit.MINUTES );
		entryPoint.insert(new DataAccessAttempt(UNCLASSIFIED, "office2009", "2009") );	
		clock.advanceTime( 10, TimeUnit.MINUTES );
		entryPoint.insert(new AccessAttempt("2009", BARRACKS, "cafe2009", LOGOUT, SUCCESSFUL) );		
		
		
		clock.advanceTime( 1, TimeUnit.HOURS );	
				
// 11 PM		
		
		clock.advanceTime( 1, TimeUnit.HOURS );	
		
// 12 Midnight		
		
		clock.advanceTime( 1, TimeUnit.HOURS );			
			
			
		
		
		
		
		/*****  END DATA STREAM SEQUENCE USING PSEUDO CLOCK: TIME STOPPS HERE ******/
		
	} // End Method insertIdSystemEvents	
	
	
	
	
}// End Class EventStreamBig
