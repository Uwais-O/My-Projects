/**
 * 
 * @author Uwais
 *
 */
public class ProjManager {
	///Attributes 
	private String Mname;
	private String Mtel;
	private String Memail;
	private String MPhyaddy;
	
	//Constructor
	public ProjManager(String name, String tel, String email, String Phyaddy) {
		this.Mname = name;
		this.Mtel = tel;
		this.Memail = email;
		this.MPhyaddy = Phyaddy;}
	
	// Method 
	public String toString() {
		String objectString = "\nProject Manager Information: " +
				"\nName: " + Mname + 
				"\nTelephone Number: " + Mtel + 
				"\nEmail Address: " + Memail + 
				"\nPhysical Address: " + MPhyaddy  ;
				return objectString;
				
	}
	
}




