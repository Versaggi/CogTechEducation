package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    
	public static final void main(String[] args) {
		
		
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	        	
        	// Listeners
        	// kSession.addEventListener( new DebugAgendaEventListener() );
        	// kSession.addEventListener( new DebugRuleRuntimeEventListener() );

        	


            /*
             * 1. If the Audit View is not visible, click on "Window" and then select "Show View", 
             *    then "Other..." and "Drools" and finally "Audit View".
             * 2. In the "Audit View" click the "Open Log" button and select the file:
             *    "<drools-examples-dir>/log/state.log".
             */

        	
            // To setup a file based audit logger, uncomment the next line 
            // KieRuntimeLogger loggerKie = ks.getLoggers().newFileLogger( kSession, "./logger" );
            // KieRuntimeLogger consoleLogger = ks.getLoggers().newConsoleLogger(kSession); 
            
        	Logger logger = LoggerFactory.getLogger(DroolsTest.class);
        	logger.info("\n*********************************>>>> DroolsTest");	

        	
            // Process KB Inserts
            
            // Message
            Message message = new Message();
            message.setMessage("Hello World");
            message.setStatus(Message.HELLO);
            kSession.insert(message);
            
            // Contact
            Contact contact = new Contact();
            contact.setName("Matthew Versaggi");
            contact.setEmailAddr("matt@versaggi.com");
            contact.setPhoneNum("555-1212");
            
            // Insert the Object(s) into working Memory 
            kSession.insert(message);
            kSession.insert(contact);
            kSession.insert("foo");
            
            // Boolean
            Boolean b = false;
            kSession.insert(b);
            
            
            // ArrayLists
            List<String> stringList = new ArrayList<String>();
            stringList.add("footwodude");       
            stringList.add("foothreedude");
            stringList.add("foofourdude");
            stringList.add("foofivedude");
            stringList.add("foosixdude");
            
            kSession.setGlobal("myStringList", stringList);
            
            
            // CHEESE Object:
            // Note: List<String> myCheeses = Arrays.asList("Brie", "Stilton", "Asigio");
            Cheese cheese = new Cheese(Arrays.asList("Brie", "Stilton", "Asigio"), Arrays.asList("Stilton", "Parmigiana Reggiano", "Old Amsterdam"), "Italy", "Rounds");
            cheese.setName("Stilton");
            kSession.insert(cheese);
            
            
            // BUS Object: - insert AlarmsList as the last parameter
            Bus bus_452 = new Bus("Big Red", 452, "red", "english", 10000);
            Bus bus_442 = new Bus("Little Red", 442, "red", "english", 15000);
            Bus bus_432 = new Bus("Tiny Red", 432, "red", "english", 20000);
            Bus bus_422 = new Bus("Just Red", 422, "red", "english", 25000);
            Bus bus_412 = new Bus("jumbo Red", 412, "red", "english", 30000);
            //Bus bus_402 = new Bus("Not Red", 402, "blue", "english", 35000);
            
            
            // Experiment - set Ksession to bus_#'s.
            bus_452.setkSession(kSession);
            bus_442.setkSession(kSession);
            bus_432.setkSession(kSession);
            bus_422.setkSession(kSession);
            bus_412.setkSession(kSession);
            
            // ALARM Object:

            Alarm alarm1 = new Alarm("battery", "active", "serious", bus_452);
            Alarm alarm2 = new Alarm("engine", "active", "maintenance", bus_452);
            Alarm alarm3 = new Alarm("breaks", "active", "serious", bus_452);
            Alarm alarm4 = new Alarm("gears", "active", "serious", bus_422);
            Alarm alarm5 = new Alarm("exhaust", "active", "maintenance", bus_422);
            
            kSession.insert(alarm1);
            kSession.insert(alarm2);
            kSession.insert(alarm3);
            kSession.insert(alarm4);
            kSession.insert(alarm5);
            
            
            
            // Alarms List
            ArrayList<Alarm> alarmsList = new ArrayList<Alarm>();
            ArrayList<Alarm> alarmsList1 = new ArrayList<Alarm>();
            
            alarmsList.add(alarm1);
            alarmsList.add(alarm2);
            alarmsList.add(alarm3);
            
            alarmsList1.add(alarm4);
            alarmsList1.add(alarm5);
            
            // ALARMSLIST Object
            kSession.setGlobal("myAlarmsList", alarmsList);
            
            
            
            // ALARM RESULT SET
            AlarmsResultSet alarmResultSet = new AlarmsResultSet();
            AlarmsResultSet alarmResultSet1 = new AlarmsResultSet();
            
            alarmResultSet.setAlarms(alarmsList);
            alarmResultSet1.setAlarms(alarmsList1);
            
            kSession.insert(alarmResultSet);
            kSession.insert(alarmResultSet1);
            
            
            kSession.insert(bus_452);
            kSession.insert(bus_442);
            kSession.insert(bus_432);
            kSession.insert(bus_422);
            kSession.insert(bus_412);
            //ksession.insert(bus_402);

            
            // Fire All Rules
            kSession.fireAllRules();
            kSession.insert(cheese);
            
            // Fire all Rules
            kSession.fireAllRules();
            
            
            // Retrieving data from the execution results
            List<String> returnStringList = (List<String>) kSession.getGlobal("myStringList");
            System.out.println("*** Return Object: " + returnStringList.toString());
            logger.info("\n*** Return Object: " + returnStringList.toString());
            
            StringBuilder sb = new StringBuilder();
            for (Object fact : kSession.getObjects()) {
                sb.append("\n\nFact: " + fact);
                // fact.getClass(). 
                System.out.println("FactName: " + fact.getClass().getSimpleName());
            }
            logger.info(sb.toString());
            
            // Close Logger
            //logger.close();
            
            // Close the session
            kSession.destroy();
            
        } catch (Throwable t) {
            t.printStackTrace();
        } 
        
    }// End Main Method



    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;
        private int status;

        // Getters and Setters
        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

    }// End Class Message

    
    
 public static class Contact {
     
     private String name;
     private String emailAddr;
     private String phoneNum;
     
     public void setName(String name) {
         this.name = name;
     }
     
     public String getName() {
         return name;
     }
     
     public void setEmailAddr(String emailAddr) {
         this.emailAddr = emailAddr;
     }
     
     public String getEmailAddr() {
         return emailAddr;
     }
     
     public void setPhoneNum(String phoneNum) {
         this.phoneNum = phoneNum;
     }
     
     public String getPhoneNum() {
         return phoneNum;
     }
     
 } // End Class Contact

 
 // Helper Method
 public static String myGreetings(String name) {
     return "Hello Sir: " + name + "!";
 }    
 
 
    
} // End Class DroolsTest



   

