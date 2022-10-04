/**
 * 
 * @author Uwais
 *
 */

// Class removes finalized project from Incompleted.txt
// This is so when user finalizes a project and
// selects to view incomplete projects, the finalized
//project is not present as incomplete

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class dltCompleted {
	//created a method that removes finalized project from list of incomplete projects
	static void dlt() throws IOException {
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

		//Code to capture user input of Project name
		Scanner input = new Scanner(System.in);
		System.out.println("\nPlease enter the project name so it may be removed from the Incomplete list: ");
		String name = input.nextLine();
		// Gives user context for needing name
		System.out.println("\n" + name + " has been removed from the incomplete list and finalized.");

		// Used name to obtain project index
		int getIndex = Arrays.asList(linesArray).indexOf("Project Name: " + name);
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
				BufferedWriter writer = new BufferedWriter(new FileWriter("Incomplete.txt"))) {
			writer.write(etlines);

		}
	}


}
