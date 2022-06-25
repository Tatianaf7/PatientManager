//Tatiana Fucsik 
package edu.seminolestate.patients;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class InPatient extends Patient {
	private LocalDate dateAdmitted;
	private LocalDate dateReleased;
	private int roomNumber;
	protected static final LocalDate DEFAULT_DATE_ADMITTED = LocalDate.now();
	protected static final LocalDate DEFAULT_DATE_RELEASED = null;
	protected static final int DEFAULT_ROOM_NUMBER = Integer.MAX_VALUE;
	
	public InPatient (String newFirstName, String newLastName, int newPatientID, LocalDate newDateAdmitted, LocalDate newDateReleased, int newRoomNumber) {
	 super(newFirstName, newLastName, newPatientID);
		this.setDateAdmitted(newDateAdmitted);
		this.setDateReleased(newDateReleased);
		this.setRoomNumber(newRoomNumber);
	}
	
	
	public InPatient (String newFirstName, String newLastName, int newPatientID) {
		this(newFirstName, newLastName, newPatientID, DEFAULT_DATE_ADMITTED, DEFAULT_DATE_RELEASED, DEFAULT_ROOM_NUMBER);
	}
	
	@Override
	public int lengthOfStay() {
		int daybetween = (int) ChronoUnit.DAYS.between(dateAdmitted, dateReleased);
		int days = (int) ChronoUnit.DAYS.between(dateAdmitted, LocalDate.now());	
	if (dateReleased == null)
		return days;
	else 
		return daybetween;
}
	public LocalDate getDateAdmitted() {
		return dateAdmitted;
		
	}
	public void setDateAdmitted(LocalDate newDateAdmitted) {
		if (newDateAdmitted != null)
			this.dateAdmitted = newDateAdmitted;
		
	}
	
	public LocalDate getDateReleased() {
		return dateAdmitted;
		
	}
	
	public void setDateReleased(LocalDate newDateReleased) {
		this.dateReleased = newDateReleased;
	}
	
	public int getRoomNumber() {
		return roomNumber;
		
	}
	
	public void setRoomNumber(int newRoomNumber) {
		if (newRoomNumber > 0)
			this.roomNumber = newRoomNumber;
	}
	
	public String toString() {
		return super.toString() + "InPatient [Date Admitted=" + dateAdmitted + ", Date Released=" + dateReleased + ", Room Number=" + roomNumber + "]";
	}

}
