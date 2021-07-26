package com.sample;

public class Alarm {

	private String name;
	private String status;
	private String type;
	private Bus bus;
	
	
	public Alarm(String name, String status, String type, Bus bus) {
		this.name = name;
		this.status = status;
		this.type = type;
		this.bus = bus;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	

	
	
}// End Class Alarm
