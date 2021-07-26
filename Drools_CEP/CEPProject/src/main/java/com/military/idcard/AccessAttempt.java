package com.military.idcard;

public class AccessAttempt {

	private String employeeId;
	private String location;
	private String computerId;
	private String action;
	private String result;
	
	
	
	public AccessAttempt(String employeeId, String location, String computerId, String action, String result) {
		this.employeeId = employeeId;
		this.location = location;
		this.computerId = computerId;
		this.action = action;
		this.result = result;
	} // End Constructor
	

	public AccessAttempt() {
		
	}// End No Arg Constructor
	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getComputerId() {
		return computerId;
	}

	public void setComputerId(String computerId) {
		this.computerId = computerId;
	}
	
	
	@Override
	public String toString() {
		return "AccessAttempt [employeeId=" + employeeId + ", location="
				+ location + ", computerId="
				+ computerId + ", action=" + action + ", result=" + result
				+ "]";
	}
	

} // End Class LoginAttempt
