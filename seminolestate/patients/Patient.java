//Tatiana Fucsik 
package edu.seminolestate.patients;

public class Patient {
	private String firstName;
	private String lastName;
	private int patientID;
	protected static final String DEFAULT_FIRST_NAME = "No first name assigned";
	protected static final String DEFAULT_LAST_NAME = "No last name assigned";
	protected static final int DEFAULT_PATIENT_ID = Integer.MAX_VALUE;
	
	
	public Patient(String newFirstName, String newLastName, int newPatientID) {
		this.setFirstName(newFirstName);
		this.setLastName(newLastName);
		this.setPatientID(newPatientID);
	}
	
	public Patient() {
		this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_PATIENT_ID);
		}
	
	public int lengthOfStay() {
		return 0;
	}
	
	public String getFirstName() {
		return firstName;		
	}

	public void setFirstName(String newFirstName) {
		if (newFirstName != null && newFirstName.length() > 0)
			this.firstName = newFirstName;
	}
	
	public String getLastName() {
		return firstName;
		
	}
	
	public void setLastName(String newLastName) {
		if (newLastName != null && newLastName.length() > 0)
			this.lastName = newLastName;
	}
	public int getPatientID() {
		return patientID;
		
	}
	public void setPatientID(int newPatientID) {
		if (newPatientID > 0)
			this.patientID = newPatientID;
		
	}
	@Override
	public String toString() {
		return "Patient [First Name=" + firstName + ", Last Name=" + lastName + ", Patient ID=" + patientID + "]";
		
	}
}

