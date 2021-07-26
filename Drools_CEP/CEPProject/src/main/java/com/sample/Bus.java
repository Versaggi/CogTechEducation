package com.sample;

import java.util.ArrayList;
import org.kie.api.logger.KieRuntimeLogger;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Bus {

	
	private String name;
	private int busNumber;
	private String color;
	private String type;
	private int miles;
	private ArrayList<Alarm> alarms;
	private KieSession kSession;
	

	public Bus(String name, int busNumber, String color, String type, int miles) {
		this.name = name;
		this.busNumber = busNumber;
		this.color = color;
		this.type = type;
		this.miles = miles;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getBusNumber() {
		return busNumber;
	}



	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}



	public ArrayList<Alarm> getAlarms() {
		return alarms;
	}



	public void setAlarms(ArrayList<Alarm> alarms) {
		this.alarms = alarms;
	}



	@Override
	public String toString() {
		return "Bus [name=" + name + ", busNumber=" + busNumber + ", color="
				+ color + ", type=" + type + "]";
	}



	public int getMiles() {
		return miles;
	}



	public void setMiles(int miles) {
		this.miles = miles;
	}
	
	

	public KieSession getkSession() {
		return kSession;
	}


	public void setkSession(KieSession kSession) {
		this.kSession = kSession;
	}	
	
	/*
	 * This esample takes a KSESSION handle as an attribute and injectes it BACK into a the WM of an open, stateful KSESSION.
	 * There is a rule that upon detection of this string will fire off a notice. 
	*/
	public void printBusGreetings() {
		System.out.println("\n*** THIS IS A BUS - it sends it's greetings! ***** \n");
		kSession.insert("FOOBAR");
	}	
	

}// End Class Bus
