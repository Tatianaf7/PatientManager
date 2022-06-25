//Tatiana Fucsik 
package edu.seminolestate.patients;

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class Outpatient extends Patient {
private int visitNumber;
private int clinicNumber;
private LocalDate procedureDate;
protected static final LocalDate DEFAULT_PROCEDURE_DATE = LocalDate.now();
protected static final int DEFAULT_VISIT_NUMBER = Integer.MAX_VALUE;
protected static final int DEFAULT_CLINIC_NUMBER = Integer.MAX_VALUE;

public Outpatient (String newFirstName, String newLastName, int newPatientID, int newVisitNumber, int newClinicNumber, LocalDate newProcedureDate) {
	super(newFirstName, newLastName,newPatientID);
	this.setClinicNumber(newClinicNumber);
	this.setVisitNumber(newVisitNumber);
	this.setProcedureDate(newProcedureDate);
}

public Outpatient (String newFirstName, String newLastName, int newPatientID) {
	this(newFirstName, newLastName, newPatientID, DEFAULT_CLINIC_NUMBER, DEFAULT_VISIT_NUMBER, DEFAULT_PROCEDURE_DATE);
}

@Override
public int lengthOfStay() {
	int daysbetween = (int) ChronoUnit.DAYS.between(procedureDate, LocalDate.now());
	return daysbetween;
}

public int getVisitNumber() {
	return clinicNumber;
	
}

public void setVisitNumber( int newVisitNumber) {
	if (newVisitNumber > 0)
		this.visitNumber = newVisitNumber;
}

public int getClinicNumber() {
	return clinicNumber;

}

public void setClinicNumber( int newClinicNumber){
	if (newClinicNumber > 0)
		this.clinicNumber = newClinicNumber;
}

public LocalDate getProcedureDate() {
	return procedureDate;
	
}

public void setProcedureDate(LocalDate newProcedureDate) {
	if (newProcedureDate != null)
		this.procedureDate = newProcedureDate;
	
}

public String toString() {
	return super.toString() + "Outpatient [Procedure date= " + procedureDate + ", Clinic Number= " + clinicNumber + ", Visit Number= " + visitNumber + "]";
}
}

