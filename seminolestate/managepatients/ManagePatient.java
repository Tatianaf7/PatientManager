//Tatiana Fucsik 
package edu.seminolestate.managepatients;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import edu.seminolestate.patients.Patient;
import edu.seminolestate.patients.InPatient;
import edu.seminolestate.patients.Outpatient;

public class ManagePatient {

	public static void main(String[] args) {
		// Create one ArrayList that can store InPatient and Outpatient objects.
		ArrayList<Patient> patientArrayList = new ArrayList<>();
		//Below are local variables to get data from user. These are used for 
		//both InPatient and Outpatient objects.
		int tempPatientID = 0;
		String tempFirstName = null;
		String tempLastName = null;
		String tempAdmitDate = null;
		String tempReleaseDate = null;
		String tempProcedureDate = null;
		LocalDate ProcedureDate = null;
		LocalDate AdmitDate = null;
		LocalDate ReleaseDate = null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
		Scanner scanner = new Scanner(System.in);
		String strUserInput = null;
		int intUserInput = 0;
		
		// Display a menu when the application starts.
		// Redisplay the menu if an invalid value
		do {
			System.out.println("Enter your choice: ");
			System.out.println("1. Add InPatient");
			System.out.println("2. Add OutPatient");
			System.out.println("3. List All Patients");
			System.out.println("4. Exit");
			strUserInput = scanner.nextLine();
			intUserInput = Integer.parseInt(strUserInput);
			switch (intUserInput) {
			case 1:
				// Create a InPatient object if the user selects option 1.
				// Get the appropriate data from the user.
				System.out.print("Enter Patient ID: ");
				tempPatientID = scanner.nextInt();
				scanner.nextLine(); //remove left over enter key
				System.out.print("Enter Patient first name: ");
				tempFirstName = scanner.nextLine();
				System.out.print("Enter Patient last name: ");
				tempLastName = scanner.nextLine();
				System.out.print("Enter Date Admitted: ");
				tempAdmitDate = scanner.nextLine();
				AdmitDate = LocalDate.parse(tempAdmitDate, dtf);
				System.out.print("Has the patient been released? (y/n): ");
				String Answer = scanner.nextLine();
				 if(Answer.equals("y")){
					 System.out.print("Enter Date Released: ");
						tempReleaseDate = scanner.nextLine();
						ReleaseDate = LocalDate.parse(tempReleaseDate, dtf);
				 }
					System.out.print("Enter Room Number: ");
					int rmNumber = scanner.nextInt();
				InPatient inpt1 =
					new InPatient(tempFirstName, tempLastName, tempPatientID, AdmitDate, ReleaseDate, rmNumber);
				patientArrayList.add(inpt1);
				break;
			case 2:
				System.out.print("Enter Patient ID: ");
				tempPatientID = scanner.nextInt();
				scanner.nextLine(); 
				System.out.print("Enter Patient first name: ");
				tempFirstName = scanner.nextLine();
				System.out.print("Enter Patient last name: ");
				tempLastName = scanner.nextLine();
				System.out.print("Enter Visit Number: ");
				int visNumber = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Clinic Number: ");
				int clinNumber = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Procedure Date: ");
				tempProcedureDate = scanner.nextLine();
				ProcedureDate = LocalDate.parse(tempProcedureDate, dtf);
				// Create the Outpatient object
				Outpatient out1 = 
					new Outpatient(tempFirstName, tempLastName, tempPatientID, visNumber, clinNumber, ProcedureDate);
				// Store the Manager object in the ArrayList.
				patientArrayList.add(out1);
				break;
			case 3:

				if (patientArrayList.size() == 0) {
					System.out.println("No Patients to list!");
				} else
				for (int ctr = 0; ctr < patientArrayList.size(); ctr++) {
					System.out.println(patientArrayList.get(ctr).toString());
					System.out.println("Length of Stay (" + patientArrayList.get(ctr).lengthOfStay() + ")");
				}
				break;
			case 4:
				System.out.println("Thank you for using the Patient management system.");
				scanner.close();
				break;
			default:
				System.out.println("Invalid menu option entered. Try again.");
			}
		} while (intUserInput != 4);
	}

}
