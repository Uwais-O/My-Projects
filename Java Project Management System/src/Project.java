/**
 * 
 * @author Uwais
 *
 */

public class Project {
	//Attributes
	private String pname;
	private String pnumber;
	private String type;
	private String address;
	private String ERF;
	private float total_fee;
	private Double paid;
	private String ddate;
	//Attributes from customer, architect and contractor classes
	private Architect Arch1;
	private customer Cust1;
	private Contractor Con1;

	//Constructor
	public Project(String pname, String pnumber, String type, String address, String ERF, 
					float total_fee, Double paid, String ddate, Architect Arch1, Contractor Con1, customer Cust1) {
		this.pname = pname;
		this.pnumber = pnumber;
		this.type = type;
		this.address = address;
		this.ERF = ERF;
		this.total_fee = total_fee;
		this.paid = paid;
		this.ddate = ddate;
		this.Arch1 = Arch1;
		this.Con1 = Con1;
		this.Cust1 = Cust1;
		
		
		
	}
	//Methods
	public String toString() {
		String objectString = "Project Name: " + pname +
				"\nProject Number: " + pnumber + 
				"\nProject Type: " + type +
				"\nAddress: " + address + 
				"\nERF number: " + ERF + 
				"\nTotal fees: " + total_fee + 
				"\nTotal amount Paid: " + paid + 
				"\nDue Date: " + ddate + 
				"\n" + Arch1 + 
				"\n" + Con1 + 
				"\n" + Cust1;
				
				return objectString;
				
	}
	
	// Setters
	public String setDDate(String newDate) {
		ddate = newDate;
		return "New due date: " + ddate;
	}
	
	public String setPaid(Double newpaid) {
		paid = newpaid;
		return "New total amount paid to date: " + paid;
	}
}

