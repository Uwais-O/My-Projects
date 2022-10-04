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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
public class Program {

	public static void main(String[] args) throws IOException, ParseException {
		
		String status = "Finalized";
		String status2 = "Incompleted";
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
		float total_fee = input.nextFloat();
		input.nextLine();
		
		System.out.println("What is the total amount paid? ");
		Double paid = input.nextDouble();
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
		
		// Contractor input
		System.out.println("What is the name of the Contractor? ");
		String Cname = input.nextLine();
		System.out.println("What is the telephone number of the Contractor? ");
		String Ctel = input.nextLine();
		System.out.println("What is the Contractors's email address? ");
		String Cemail = input.nextLine();
		System.out.println("What is the Contractor's physical address?");
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
		
		
		// Objects
		Architect Arch1 = new Architect(name, tel, email, Phyaddy);
		
		Contractor Con1 = new Contractor(name, tel, email, Phyaddy);
		
		customer Cust1 = new customer(name, tel, email, Phyaddy);
		
		Project Proj1 = new Project(pname, pnumber, type, address, ERF, total_fee, paid, ddate, 
						Arch1, Con1, Cust1);
		
/////////////////// LOGIC FOR OVERDUE PROJECTS ///////////////////////////////////////////////////////////////////////////
		
		 //Obtaining todays date
		 LocalDate Today =	java.time.LocalDate.now();
		 //Converted to string
		 String toDate = Today.toString();
		 
		 //Used SimpleDateFormat to compare dates
	      SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
	      //Parsed into format yyyy-MM-dd
	      Date d1 = sdformat.parse(ddate);
	      Date d2 = sdformat.parse(toDate);
	     //Compared two dates and wrote to file
	      if(d1.compareTo(d2) > 0) {
	         System.out.println("Project is not overdue");
	      } else if(d1.compareTo(d2) < 0) {
	         System.out.println("Project is overdue");
	       try{
	 			//If due date has passed, writes object to overdue
	 			  FileWriter fstream = new FileWriter("Overdue.txt",true);
	 			  BufferedWriter out = new BufferedWriter(fstream);
	 			  
	 			  out.write("\n" + Proj1);
	 			  out.close();
	 		  }catch (Exception e){
	 			 System.err.println("Error while writing to file: " +
	 		          e.getMessage());
	 				}
	      }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
	      //Prints preview of object entered 
	      System.out.println(Proj1);
	      
//////////// Writes to new file called Incomplete.txt //////////////////////////////////////////
		try{
			  FileWriter fstream = new FileWriter("Incomplete.txt",true);
			  BufferedWriter out = new BufferedWriter(fstream);
			  
			  out.write("\n"+Proj1 + "\nProject Status: " + status2 + "\n");
			  out.close();
		  }catch (Exception e){
			 System.err.println("Error while writing to file: " +
		          e.getMessage());
				}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
///////////////////////////////////  MENU  ////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("Menu  \n1 - Change due date of project "
				+ "\n2 - Change the total amount of the fee paid to date "
				+ "\n3 - Update a contractor’s contact details." + 
				   "\n4 - Finalize Project" +
				   "\n5 - View incompleted projects"
				+ "\n6 - Search for Project By Name" 
				   + "\n7 -  Search for Project By Number"
				+ "\n8 - View Overdue Projects"
				); 
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		/// Obtaining User input ///
		Scanner input1 = new Scanner(System.in);
		int choice = input1.nextInt();
		
			// Section calling setters
//////////////////////////////// Updating amount paid to date/////////////////////////////////////////////////////////////////////////////////
				if (choice == 2) 
				{
					System.out.println("Enter new amount paid to date: "); // Asked for user input
					Scanner paid1 = new Scanner(System.in);
						Double newpaid = paid1.nextDouble();
						System.out.println(Proj1.setPaid(newpaid));	//Used setter to change edited amount
						System.out.print(Proj1); // printed entire object with alterations
						
//////////////////////Removing portion with old amount paid to date from text file and replacing with new ////////////////////////////////////////////						
						BufferedReader in = new BufferedReader(new FileReader("Incomplete.txt"));

						//Used ArrayList and an empty string
						//to store contents in variable "str"
						String str=null;
						ArrayList<String> lines = new ArrayList<String>();
						//Read each line and stored as array list
						while((str = in.readLine()) != null){
							lines.add(str);
						}
						// Converted ArrayList to Array
						String[] linesArray = lines.toArray(new String[lines.size()]);

						// Used name to obtain project index
						int getIndex = Arrays.asList(linesArray).indexOf("Project Name: " + pname);
						// Added 27 to obtain exact lines 
						int indexSum = getIndex + 27;

						//Used subList method to remove a range of indices
						lines.subList(getIndex, indexSum).clear();
						//Converted Array list to Array
						String[] Array = lines.toArray(new String[lines.size()]);
						//Converted Array to String
						String Filelines = Arrays.deepToString(Array);

						// Fixed formatting issues in string 
						String fourlines = Filelines.replace("[", "");
						String fivelines = fourlines.replace("]", "");
						String sixlines = fivelines.replaceFirst(" ,","");
						String sevlines = sixlines.replaceFirst("  ","");
						String etlines = sevlines.replace(", ","\n");

						try (
								//Overwrote file and excluded finalized project
								// Removed project
								BufferedWriter writer = new BufferedWriter(new FileWriter("Incomplete.txt"))) {
							writer.write(etlines);

							
						}
						
						// Wrote project back with updated Contractor details
						try{
							  FileWriter fstream = new FileWriter("Incomplete.txt",true);
							  BufferedWriter out = new BufferedWriter(fstream);
							  
							  out.write("\n" + Proj1);
							  out.close();
						  }catch (Exception e){
							 System.err.println("Error while writing to file: " +
						          e.getMessage());
								}
				}
				
				
				
//////////////////////////////////Updating due date of project ///////////////////////////////////////////////////////////////////////////	
				else if (choice == 1) {
					System.out.println("Enter new due date (e.g. 2022-08-16): "); // Asked for user input
					Scanner date1 = new Scanner(System.in); 
					String newdate = date1.nextLine();		
					System.out.println(Proj1.setDDate(newdate));  // Used setter to change edited due date
					System.out.print(Proj1); // Printed entire project with new date
					
//////////////////////////Removing portion with old due date from text and replacing with new ////////////////////////////////////////////			
					BufferedReader in = new BufferedReader(new FileReader("Incomplete.txt"));

					//Used ArrayList and an empty string
					//to store contents in variable "str"
					String str=null;
					ArrayList<String> lines = new ArrayList<String>();
					//Read each line and stored as array list
					while((str = in.readLine()) != null){
						lines.add(str);
					}
					// Converted ArrayList to Array
					String[] linesArray = lines.toArray(new String[lines.size()]);

					// Used name to obtain project index
					int getIndex = Arrays.asList(linesArray).indexOf("Project Name: " + pname);
					// Added 27 to obtain exact lines 
					int indexSum = getIndex + 27;

					//Used subList method to remove a range of indices
					lines.subList(getIndex, indexSum).clear();
					//Converted Array list to Array
					String[] Array = lines.toArray(new String[lines.size()]);
					//Converted Array to String
					String Filelines = Arrays.deepToString(Array);

					// Fixed formatting issues in string 
					String fourlines = Filelines.replace("[", "");
					String fivelines = fourlines.replace("]", "");
					String sixlines = fivelines.replaceFirst(" ,","");
					String sevlines = sixlines.replaceFirst("  ","");
					String etlines = sevlines.replace(", ","\n");

					try (
							//Overwrote file and excluded finalized project
							// Removed project
							BufferedWriter writer = new BufferedWriter(new FileWriter("Incomplete.txt"))) {
						writer.write(etlines);

						
					}
					
					// Wrote project back with updated Contractor details
					try{
						  FileWriter fstream = new FileWriter("Incomplete.txt",true);
						  BufferedWriter out = new BufferedWriter(fstream);
						  
						  out.write("\n" + Proj1);
						  out.close();
					  }catch (Exception e){
						 System.err.println("Error while writing to file: " +
					          e.getMessage());
							}
					
					
				}
					
								
				
/////////////////////////////  Updating Contractor contact details ///////////////////////////////////////////////////////////////////
				else if (choice == 3) {
					//Obtained user input of telephone and email - contractor
					// Used setters to change info to user input 
					
					System.out.println("Enter Contractor new telephone number: "); 
					Scanner tel1 = new Scanner(System.in);
						String newtel = tel1.nextLine();		
						System.out.println(Con1.setCtel(newtel));
						
					System.out.println("Enter Contractor new email: ");
					Scanner email1 = new Scanner(System.in);
						String newemail = email1.nextLine();		
						System.out.println(Con1.setCemail(newemail));
						
						
////////////////////////// Removing portion with old contact details from text file and replacing with new ////////////////////////////////// 
						
						BufferedReader in = new BufferedReader(new FileReader("Incomplete.txt"));

						//Used ArrayList and an empty string
						//to store contents in variable "str"
						String str=null;
						ArrayList<String> lines = new ArrayList<String>();
						//Read each line and stored as array list
						while((str = in.readLine()) != null){
							lines.add(str);
						}
						// Converted ArrayList to Array
						String[] linesArray = lines.toArray(new String[lines.size()]);

						// Used name to obtain project index
						int getIndex = Arrays.asList(linesArray).indexOf("Project Name: " + pname);
						// Added 27 to obtain exact lines 
						int indexSum = getIndex + 27;

						//Used subList method to remove a range of indices
						lines.subList(getIndex, indexSum).clear();
						//Converted Array list to Array
						String[] Array = lines.toArray(new String[lines.size()]);
						//Converted Array to String
						String Filelines = Arrays.deepToString(Array);

						// Fixed formatting issues in string 
						String fourlines = Filelines.replace("[", "");
						String fivelines = fourlines.replace("]", "");
						String sixlines = fivelines.replaceFirst(" ,","");
						String sevlines = sixlines.replaceFirst("  ","");
						String etlines = sevlines.replace(", ","\n");

						try (
								//Overwrote file and excluded finalized project
								// Removed project
								BufferedWriter writer = new BufferedWriter(new FileWriter("Incomplete.txt"))) {
							writer.write(etlines);

							
						}
						
						// Wrote project back with updated Contractor details
						try{
							  FileWriter fstream = new FileWriter("Incomplete.txt",true);
							  BufferedWriter out = new BufferedWriter(fstream);
							  
							  out.write("\n" + Proj1);
							  out.close();
						  }catch (Exception e){
							 System.err.println("Error while writing to file: " +
						          e.getMessage());
								}
						
						
					}
						
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////						
						
		
				//Viewing incomplete files
				//Reads from a separate file containing incomplete projects
				else if (choice == 5) {
					System.out.println("List of Incomplete Projects:");
					BufferedReader reader = new BufferedReader(new FileReader("Incomplete.txt"));
					String strlines;
					while((strlines = reader.readLine()) != null) {
						System.out.println(strlines);
					}
					
					
				}
				//If user choice is 4
				else if (choice == 4) {
					// If fees are paid no invoice is generated
					// Obtains completion date and writes to text file
					if (total_fee == paid) {
						System.out.println("The project has been paid in full. No invoice generated.");
						System.out.println("Please add a completion date for this project: ");
						
						Scanner CompDate = new Scanner(System.in);
						String compDate = CompDate.nextLine();
						System.out.print("\n" + Proj1 + "\nCompletion Date: " + compDate + "\nProject Status: " + status);
						//Writing to file
						//Writing Completed Tasks to file
						try{
							  FileWriter fstream = new FileWriter("Completed.txt",true);
							  BufferedWriter out = new BufferedWriter(fstream);
							  // divided sum by length of array to obtain average
							  out.write("\n" + Proj1 + "\nCompletion Date: " + compDate + "\nProject Status: " + status);
							  out.close();
						  }catch (Exception e){
							 System.err.println("Error while writing to file: " +
						          e.getMessage());
								}	
						dltCompleted.dlt();
					
					}
					// If fees are not paid in full invoice is generated
					// Project information + date is displayed and written to text file
					else if (total_fee != paid) {
						System.out.println("The project has funds outstanding. See invoice below: ");
						double outstanding = total_fee - paid;
						System.out.println("Invoice"+
								"\nAmount still owing: R" + outstanding);
						
						System.out.println("Please add a completion date for this project: ");
						Scanner CompDate = new Scanner(System.in);
						String compDate = CompDate.nextLine();
						System.out.print("\n" + Proj1 + "\nCompletion Date: " + compDate + "\nProject Status: " + status);
						dltCompleted.dlt();
						//Writing to file
						//Writing Completed Tasks to file
						try{
							  FileWriter fstream = new FileWriter("Completed.txt",true);
							  BufferedWriter out = new BufferedWriter(fstream);
							  // divided sum by length of array to obtain average
							  out.write("\n" + Proj1 + "\nCompletion Date: " + compDate + "\nProject Status: " + status+"\n");
							  out.close();
						  }catch (Exception e){
							 System.err.println("Error while writing to file: " +
						          e.getMessage());
								}
						dltCompleted.dlt();
						
					
					}
				}
////////////////////////////// Search options /////////////////////////////////////////////////////////////////////////////////////////////////////
				else if (choice == 6) {
					//If user selects 6, name method runs
					search.name();
					}
				else if (choice == 7) {
					// if user selects 7, number method runs
					search.number();
				}
				// Date option
				else if (choice ==8) {
					// If user selects 8, Overdue.txt is read and
					// displayed
					System.out.println("List of Overdue Projects:");
					BufferedReader reader = new BufferedReader(new FileReader("Overdue.txt"));
					String strlines;
					while((strlines = reader.readLine()) != null) {
						System.out.println(strlines);
					}
					
				}
		
		}
	}


