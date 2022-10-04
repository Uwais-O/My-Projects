// This class consists of 2 methods
// Method one searches through incomplete.txt for project via name
// Method two searches through incomplete.txt for project via number


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class search {
	//Method to obtain project with name
	static void name() throws IOException {
		//Used bufferedreader to read from file
				BufferedReader in = new BufferedReader(new FileReader("Incompleted.txt"));
				
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
				
				//Code to capture user input of Project name
				Scanner input = new Scanner(System.in);
				System.out.println("\nPlease enter the name of the project that you are looking for: ");
				String name = input.nextLine();
				// Gives user context for needing names
				
				// Used name to obtain project index
				int getIndex = Arrays.asList(linesArray).indexOf("Project Name: " + name);
				// Added 27 to obtain exact lines 
				int indexSum = getIndex + 27;
				
				// Obtained specific range of ArrayList
				// Stored as List
				List<String> projByName = lines.subList(getIndex, indexSum);
				
				//Converted to List to Array
				String[] cpl = projByName.toArray(new String[lines.size()]);
				// Converted Array to String
				String cpl2 = Arrays.deepToString(cpl);
				// Fixed formatting
				//Allowed to display on new line
				String cpl3 = cpl2.replace(",","\n");
				String cpl4 = cpl3.replace("null","");
				String cpl5 = cpl4.replace("[","");
				String cpl6 = cpl5.replace("]", "");
				System.out.println(cpl6);
				
				
	}
	//Method to obtain project with Number
	static void number() throws IOException {
		//Used bufferedreader to read from file
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
				String forIndex = Arrays.deepToString(linesArray);
				
				//Code to capture user input of Project name
				Scanner input = new Scanner(System.in);
				System.out.println("\nPlease enter the Project Number to view the project you are looking for: ");
				String numP = input.nextLine();
				// Gives user context for needing names
				
				// Used name to obtain project index
				int getIndex = Arrays.asList(linesArray).indexOf("Project Number: " + numP);
				//subtracted 1 to begin at the first element - Project Name
				int projIndex = getIndex -1;
				// Added 27 to obtain exact lines
				int indexSum = projIndex + 27;
				
				// Obtained specific range of ArrayList
				// Stored as List
			List<String> projByName = lines.subList(projIndex, indexSum);
				
				//Converted to List to Array
				String[] cpl = projByName.toArray(new String[lines.size()]);
				// Converted Array to String
				String cpl2 = Arrays.deepToString(cpl);
				// Fixed formatting
				//Allowed to display on new line
				String cpl3 = cpl2.replace(",","\n");
				String cpl4 = cpl3.replace("null","");
				String cpl5 = cpl4.replace("[","");
				String cpl6 = cpl5.replace("]", "");
				System.out.println(cpl6);
				
				
				
				}
		
	}
		
	



