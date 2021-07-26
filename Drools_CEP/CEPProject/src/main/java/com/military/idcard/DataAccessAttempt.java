package com.military.idcard;

public class DataAccessAttempt {

	private String dataClassification;
	private String computerId;
	private String employeeId;

	
	public DataAccessAttempt(String dataClassification, String computerId, String employeeId) {
		this.dataClassification = dataClassification; 
		this.computerId = computerId;
		this.employeeId = employeeId;
	}
	
    public String getComputerId() {
		return computerId;
	}

	public void setComputerId(String computerId) {
		this.computerId = computerId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getDataClassification() {
		return dataClassification;
	}

	public void setDataClassification(String dataClassification) {
		this.dataClassification = dataClassification;
	}

	public DataAccessAttempt() {
    	
    }

	
	
	@Override
	public String toString() {
		return "DataAccessAttempt [dataClassification=" + dataClassification
				+ ", computerId=" + computerId + ", employeeId=" + employeeId
				+ "]";
	}

	
	
} // End Class DataAccessAttempt
