/**
 * 
 * @author Uwais
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class tablemethods {

	public static void main(String[] args) {
		try {
			// Connect to the library_db database, via the jdbc:mysql: channel on localhost (this PC)
	        // Use username "otheruser", password "swordfish".
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisePms?useSSL=false","Uwais","swordfish");
	        
	        // Create a direct line to the database for running our queries
	        Statement statement = connection.createStatement();
	        ResultSet results;
	        int rowsAffected;
	
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
	}
	
	//Method to add Structural Engineer to StrEng table 
	public static void addStrEng(String pnumber,String Cname, String Ctel, String Cemail, String CPhyaddy, Statement statement) throws SQLException{
		// Putting ' ' around strings
		Cname = "'" + Cname + "'";
		Ctel = "'" + Ctel + "'";
		Cemail = "'" + Cemail + "'";
		CPhyaddy = "'" + CPhyaddy + "'";
		pnumber = "'" +pnumber+ "'";
		
		String newEntry = "INSERT INTO StrEng value" + " (" + pnumber + ", "+ Cname + ", " + Ctel + ", " + Cemail + ", " + CPhyaddy +")";
		int rowsAffected = statement.executeUpdate(newEntry);
	}
	

	//Method to add Architect to Architect table 
	public static void addArch(String pnumber, String Aname, String Atel, String Aemail, String APhyaddy, Statement statement) throws SQLException{
		// Putting ' ' around strings
		Aname = "'" + Aname + "'";
		Atel = "'" + Atel + "'";
		Aemail = "'" + Aemail + "'";
		APhyaddy = "'" + APhyaddy + "'";
		pnumber = "'" +pnumber+ "'";
		
		String newEntry = "INSERT INTO Architect value" + " (" + pnumber + ", " + Aname + ", " + Atel + ", " + Aemail + ", " + APhyaddy +")";
		int rowsAffected = statement.executeUpdate(newEntry);
	}	
	
	//Method to add Customer to Customer table 
	public static void addCust(String pnumber, String name, String tel, String email, String Phyaddy, Statement statement) throws SQLException{
		// Putting ' ' around strings
		name = "'" + name + "'";
		tel = "'" + tel + "'";
		email = "'" + email + "'";
		Phyaddy = "'" + Phyaddy + "'";
		pnumber = "'" +pnumber+ "'";
		String newEntry = "INSERT INTO Customer value" + " (" + pnumber + ", " + name + ", " + tel + ", " + email + ", " + Phyaddy +")";
		int rowsAffected = statement.executeUpdate(newEntry);
	}		
	
	//Method to add Customer to Customer table 
	public static void addPm(String pnumber, String Mname, String Mtel, String Memail, String MPhyaddy, Statement statement) throws SQLException{
		// Putting ' ' around strings
		Mname = "'" + Mname + "'";
		Mtel = "'" + Mtel + "'";
		Memail = "'" + Memail + "'";
		MPhyaddy = "'" + MPhyaddy + "'";
		pnumber = "'" +pnumber+ "'";
		String newEntry = "INSERT INTO Proj_Manager value" + " (" + pnumber + ", " + Mname + ", " + Mtel + ", " + Memail + ", " + MPhyaddy +")";
		int rowsAffected = statement.executeUpdate(newEntry);
	}			
	
	//Method to add Project info to Project table
	public static void addProj(String pname, String pnumber, String type, String address, String ERF, int total_fee, int paid, String ddate, String status, 
			Statement statement) throws SQLException{
		// Putting ' ' around strings
		pname = "'" + pname + "'";
		type = "'" + type + "'";
		address = "'" + address + "'";
		ERF = "'" + ERF + "'";
		ddate = "'" + ddate + "'";
		pnumber = "'" +pnumber+ "'";
		String newEntry = "INSERT INTO Project value" + " (" + pnumber + ", " + pname + ", " + type + ", " + address + ", " + ERF +
		"," +total_fee+ "," + paid + "," + ddate +"," + " 'Incomplete' "+")";
		int rowsAffected = statement.executeUpdate(newEntry);
	}
	
	//Method to update date 
	public static void newDue(String pnum, Statement statement, Scanner input) throws SQLException {
		System.out.println("Please enter a new due date (YYYY-MM-DD): ");
		String newDate = input.nextLine();
		
		//Finds project via and updates date
		String dUpdate = "UPDATE Project " + "SET due_date= " + newDate + " WHERE project_number = '" + pnum +"'";
		int rowsAffected =  statement.executeUpdate(dUpdate);
		System.out.println("Due date has been updated.\n");
	}
	//Method to update fees
	public static void newFees(String pnum, Statement statement, Scanner input) throws SQLException {
		System.out.println("Please enter a new fees paid amount: ");
		int newPaid = input.nextInt();
		
		//Finds project via and updates date
		String feeUpdate = "UPDATE Project " + "SET total_paid= " + newPaid + " WHERE project_number = '" + pnum +"'";
		int rowsAffected =  statement.executeUpdate(feeUpdate);
		System.out.println("Fees has been updated.\n");
	}
	
	//Method to get total_fees and store as integer variable
	public static void fFees(String pnum,Statement statement, Scanner input) throws SQLException{
		String tFees = "SELECT total_fees FROM Project WHERE project_number= '" + pnum +"'"; 
		ResultSet result = statement.executeQuery(tFees);
		result.next();
		int tFees2 = result.getInt("total_fees");

		
	}
	//Method to get total_fees and store as integer variable
	public static void fPaid(String pnum,Statement statement, Scanner input) throws SQLException{ 
		String tPaid = "SELECT total_paid FROM Project WHERE project_number= '" + pnum +"'"; 
		ResultSet result = statement.executeQuery(tPaid);
		result.next();
		int tPaid2 = result.getInt("total_paid");
		
	}
	// Method to finalize project, used values from fpaid() and fFees()
	public static void fin(String pnum, int tFees2, int tPaid2, Statement statement, Scanner input) throws SQLException{
		if(tFees2 == tPaid2) {
			System.out.println("The project has been paid in full. No invoice generated.");
			// ask for completion date , update status = finalized + compdate
			System.out.println("Please add a completion date for this project: ");
			Scanner CompDate = new Scanner(System.in);
			String compDate = CompDate.nextLine();
			//Updated table to reflect new status with completion date
			String finUpdate = "UPDATE Project " + "SET status= " + "Finalized " + compDate + " WHERE project_number = '" + pnum +"'";
			int rowsAffected =  statement.executeUpdate(finUpdate);
			System.out.print(rowsAffected);
			
			
		}
		else if (tFees2 != tPaid2) {
			System.out.println("The project has funds outstanding. See invoice below: ");
			int outstanding = tFees2 - tPaid2;
			System.out.println("Your Invoice"+
					"\nAmount still owing: R" + outstanding);
			
		}
	}
	//Method to view incomplete
	public static void viewIncomp(Statement statement) throws SQLException {
		// Filters to search for rows where "Incomplete" is present
		String incomp = "SELECT status FROM Project WHERE status = Incomplete";
		ResultSet result = statement.executeQuery(incomp);
		result.next();
		//logic to show entire set
		String projname = result.getString("project_name");
		String projnumber = result.getString("project_number");
		String projtype = result.getString("type");
		String projaddy = result.getString("address");
		String projerf = result.getString("erf");
		String projdate = result.getString("due_date");
		String projstat = result.getString("status");
		int projfees = result.getInt("total_fees");
		int projpaid = result.getInt("total_paid");
		System.out.println("Incomplete Projects: ");
		System.out.println("Project name " + projname + '\n' + "Project number: " + projnumber + "\n" +
		"Type: " + projtype + "\n" + "Address: " + projaddy + '\n' + "ERF: " + projerf + "\n" +
		 "Total Fees: " + projfees + "\n" + "Total Paid: " + projpaid + '\n' + "Due date: " + projdate 
		 + '\n' + "Project Status: " + projstat + "\n");
				
		
	}
	
	public static void overdue(Statement statement) throws SQLException{
		
		String date1 ="Select * from Project where due_date < curdate()"; 
		ResultSet result = statement.executeQuery(date1);
		result.next();
		//logic to show entire set
				String projname = result.getString("project_name");
				String projnumber = result.getString("project_number");
				String projtype = result.getString("type");
				String projaddy = result.getString("address");
				String projerf = result.getString("erf");
				String projdate = result.getString("due_date");
				String projstat = result.getString("status");
				int projfees = result.getInt("total_fees");
				int projpaid = result.getInt("total_paid");
				System.out.println("Overdue Projects: ");
				System.out.println("Project name " + projname + '\n' + "Project number: " + projnumber + "\n" +
				"Type: " + projtype + "\n" + "Address: " + projaddy + '\n' + "ERF: " + projerf + "\n" +
				 "Total Fees: " + projfees + "\n" + "Total Paid: " + projpaid + '\n' + "Due date: " + projdate 
				 + '\n' + "Project Status: " + projstat + "\n");
		
		
	}
	
	// ask for project name in menu
	//Method to search project by name
	public static void searchName(Statement statement, Scanner input) throws SQLException {
		//Asked user for project name
		System.out.println("Please enter a Project Name: ");
		String proname = input.nextLine();
		
		//Searched db for name
		String sName = "Select * from Project where project_name =" + "'" + proname + "'";
		ResultSet result = statement.executeQuery(sName);
		result.next();
		
		//logic to show entire set
		String projname = result.getString("project_name");
		String projnumber = result.getString("project_number");
		String projtype = result.getString("type");
		String projaddy = result.getString("address");
		String projerf = result.getString("erf");
		String projdate = result.getString("due_date");
		String projstat = result.getString("status");
		int projfees = result.getInt("total_fees");
		int projpaid = result.getInt("total_paid");

		System.out.println("Project name " + projname + '\n' + "Project number: " + projnumber + "\n" +
		"Type: " + projtype + "\n" + "Address: " + projaddy + '\n' + "ERF: " + projerf + "\n" +
		 "Total Fees: " + projfees + "\n" + "Total Paid: " + projpaid + '\n' + "Due date: " + projdate 
		 + '\n' + "Project Status: " + projstat + "\n");

		
	}
	
	public static void searchNum(Statement statement, Scanner input) throws SQLException {
		//Asked user for project name
		System.out.println("Please enter a Project Number: ");
		String proname = input.nextLine();
		
		//Searched db for name
		String sName = "Select * from Project where project_number =" + "'" + proname + "'";
		ResultSet result = statement.executeQuery(sName);
		result.next();
		
		//logic to show entire set
		String projname = result.getString("project_name");
		String projnumber = result.getString("project_number");
		String projtype = result.getString("type");
		String projaddy = result.getString("address");
		String projerf = result.getString("erf");
		String projdate = result.getString("due_date");
		String projstat = result.getString("status");
		int projfees = result.getInt("total_fees");
		int projpaid = result.getInt("total_paid");

		System.out.println("Project name " + projname + '\n' + "Project number: " + projnumber + "\n" +
		"Type: " + projtype + "\n" + "Address: " + projaddy + '\n' + "ERF: " + projerf + "\n" +
		 "Total Fees: " + projfees + "\n" + "Total Paid: " + projpaid + '\n' + "Due date: " + projdate 
		 + '\n' + "Project Status: " + projstat + "\n");
	
	}
	
}
