/**
 * 
 * @author Uwais
 *
 */


public class Contractor {
	///Attributes 
	private String Cname;
	private String Ctel;
	private String Cemail;
	private String CPhyaddy;
	
	//Constructor
	public Contractor(String name, String tel, String email, String Phyaddy) {
		this.Cname = name;
		this.Ctel = tel;
		this.Cemail = email;
		this.CPhyaddy = Phyaddy;
	}
	
	// Method 
	public String toString() {
		String objectString = "\nContractor Information: " 
				+"\nName: " + Cname + 
				"\nTelephone Number: " + Ctel + 
				"\nEmail Address: " + Cemail +  
				"\nPhysical Address: " + CPhyaddy ;
				return objectString;}
	
	// Setters 
	public String setCtel(String newTel) {
		Ctel = newTel;
		return "New Contractor tel num: " + Ctel;
	}
	public String setCemail(String newEmail) {
		Cemail = newEmail;
		return "New Contractor email: " + Cemail;
	}
}


