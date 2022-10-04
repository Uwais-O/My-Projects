/**
 * 
 * @author Uwais
 *
 */


public class StrEng {
	///Attributes 
	private String Cname;
	private String Ctel;
	private String Cemail;
	private String CPhyaddy;
	
	//Constructor
	public StrEng(String name, String tel, String email, String Phyaddy) {
		this.Cname = name;
		this.Ctel = tel;
		this.Cemail = email;
		this.CPhyaddy = Phyaddy;
	}
	
	// Method 
	public String toString() {
		String objectString = "\nStructural Engineer Information: " 
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


