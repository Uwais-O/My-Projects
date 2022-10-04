/**
 * 
 * @author Uwais
 *
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
public class Program {

	public static void main(String[] args) throws IOException, ParseException {
		
		try {
			// Connect to the library_db database, via the jdbc:mysql: channel on localhost (this PC)
	        // Use username "otheruser", password "swordfish".
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisePms?useSSL=false","Uwais","swordfish");
	        
	        // Create a direct line to the database for running our queries
	        Statement statement = connection.createStatement();
	        ResultSet results;
	        int rowsAffected;
	
		
		
		
		
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		//Project input
		System.out.println("What is the name of the project? ");
		String pname = input.nextLine();
		
		System.out.println("What is the Project Number? ");
		String pnumber = input.nextLine();
		
		System.out.println("What is the project type? ");
		String type = input.nextLine();
		
		System.out.println("What is the project address?");
		String address = input.nextLine();
		
		System.out.println("What is the ERF number? ");
		String ERF = input.nextLine();
		
		System.out.println("What is the total fees? ");
		int total_fee = input.nextInt();
		input.nextLine();
		
		System.out.println("What is the total amount paid? ");
		int paid = input.nextInt();
		input.nextLine();
		
		System.out.println("What is the due date/deadline?('yyyy-MM-dd')");
		String ddate = input.nextLine();
		
		
		
		// Architect input 
		System.out.println("What is the name of the Architect? ");
		String Aname = input.nextLine();
		System.out.println("What is the telephone number of the Architect? ");
		String Atel = input.nextLine();
		System.out.println("What is the Architect's email address? ");
		String Aemail = input.nextLine();
		System.out.println("What is the Architect's physical address?");
		String APhyaddy = input.nextLine();
		
		// Structural Engineer input
		System.out.println("What is the name of the Structural Engineer? ");
		String Cname = input.nextLine();
		System.out.println("What is the telephone number of the Structural Engineer? ");
		String Ctel = input.nextLine();
		System.out.println("What is the Structural Engineer's email address? ");
		String Cemail = input.nextLine();
		System.out.println("What is the Structural Engineer's physical address?");
		String CPhyaddy = input.nextLine();
		
		// Customer input
		System.out.println("What is the name of the Customer? ");
		String name = input.nextLine();
		System.out.println("What is the telephone number of the Customer? ");
		String tel = input.nextLine();
		System.out.println("What is the Customer's email address? ");
		String email = input.nextLine();
		System.out.println("What is the Customer's physical address?");
		String Phyaddy = input.nextLine();
		
		// If name is blank, merges Type with Surname
		if (pname == "") {
			String surname = name.split(" ")[1];
			pname = type + " " + surname;}
		
		// Project Manager input
		System.out.println("What is the name of the Project Manager? ");
		String Mname = input.nextLine();
		System.out.println("What is the telephone number of the Project Manager? ");
		String Mtel = input.nextLine();
		System.out.println("What is the Manager's email address? ");
		String Memail = input.nextLine();
		System.out.println("What is the Manager's physical address?");
		String MPhyaddy = input.nextLine();
	
		// Calling methods from tablemethod class to add to poisepms tables
		tablemethods.addArch(pnumber, Aname, Atel, Aemail, APhyaddy, statement);
		tablemethods.addCust(pnumber, name, tel, email, Phyaddy, statement);
		tablemethods.addPm(pnumber, Mname, Mtel, Memail, MPhyaddy, statement);
		String status = null;
		tablemethods.addProj(pname, pnumber, type, address, ERF, total_fee, paid, ddate, status, statement);
		tablemethods.addStrEng(pnumber, Cname, Ctel, Cemail, CPhyaddy, statement);
		
		
		
		// Objects
		Architect Arch1 = new Architect(name, tel, email, Phyaddy);
		
		StrEng Con1 = new StrEng(name, tel, email, Phyaddy);
		
		customer Cust1 = new customer(name, tel, email, Phyaddy);
		
		ProjManager Man1= new ProjManager(name, tel, email, Phyaddy);
		
		Project Proj1 = new Project(pname, pnumber, type, address, ERF, total_fee, paid, ddate, 
						Arch1, Con1, Cust1, Man1);
		
		//Prints preview of object entered 
	      System.out.println(Proj1);
	      


		
///////////////////////////////////  MENU  ////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("Menu  \n1 - Change due date of a project "
				+ "\n2 - Change the total amount of the fee paid to date for a project "
				 + "\n3 - Finalize Project" +
				   "\n4 - View incompleted projects"
				+ "\n5 - Search for Project By Name" 
				   + "\n6 -  Search for Project By Number"
				+ "\n7 - View Overdue Projects"
				); 
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		try (/// Obtaining User input ///
		Scanner input1 = new Scanner(System.in)) {
			int choice = input1.nextInt();
			
				// Section calling setters
//////////////////////////////// Updating amount paid to date/////////////////////////////////////////////////////////////////////////////////
					if (choice == 2) {
						System.out.println("Please enter the Project Number to update it's Fees Paid: ");
						String pnum = input.nextLine();
						tablemethods.newFees(pnum, statement, input);
					}
					

//////////////////////////////////Updating due date of project ///////////////////////////////////////////////////////////////////////////	
					else if (choice == 1) {
						System.out.println("Please enter the Project Number to update it's Due Date: ");
						String pnum = input.nextLine();
						tablemethods.newDue(pnum, statement, input);
					}
						

							
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////						
							
			
					// Viewing incomplete files //
					else if (choice == 4) {
					tablemethods.viewIncomp(statement);
						}
						
						
					//Finalizing a project
					else if (choice == 3) {
						System.out.println("Please enter the Project Number to Finalize it:  ");
						String pnum = input.nextLine();
						int tFees2 = 0;
						int tPaid2 = 0;
						tablemethods.fFees(pnum, statement, input);
						tablemethods.fPaid(pnum, statement, input);
						if(tFees2 == tPaid2) {
							System.out.println("The project has been paid in full. No invoice generated.");
							// ask for completion date , update status = finalized + compdate
							System.out.println("Please add a completion date for this project: ");
							try (Scanner CompDate = new Scanner(System.in)) {
								String compDate = CompDate.nextLine();
								//Updated table to reflect new status with completion date
								String finUpdate = "UPDATE Project " + "SET status= " + "Finalized " + compDate + " WHERE project_number = '" + pnum +"'";
								int rowsAffected1 =  statement.executeUpdate(finUpdate);
								System.out.print(rowsAffected1);
							}
							
							
						}
						else if (tFees2 != tPaid2) {
							System.out.println("The project has funds outstanding. See invoice below: ");
							int outstanding = tFees2 - tPaid2;
							System.out.println("Your Invoice"+
									"\nAmount still owing: R" + outstanding);
							
						}
						
						
					}
////////////////////////////// Search options /////////////////////////////////////////////////////////////////////////////////////////////////////
					else if (choice == 5) {
						//If user selects 5, name method runs
						tablemethods.searchName(statement, input);
						}
					else if (choice == 6) {
						// if user selects 6, number method runs
						tablemethods.searchNum(statement, input);
					}
					
					else if (choice ==7) {
						// If user selects 7, Overdue projects are shown
						// displayed
						tablemethods.overdue(statement);
						}
		}
					
				
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
}


