/**
 * 
 * @author Uwais
 *
 */

public class Architect {
	///Attributes 
	private String Aname;
	private String Atel;
	private String Aemail;
	private String APhyaddy;
	
	//Constructor
	public Architect(String name, String tel, String email, String Phyaddy) {
		this.Aname = name;
		this.Atel = tel;
		this.Aemail = email;
		this.APhyaddy = Phyaddy;}
	
	// Method 
	public String toString() {
		String objectString = "\nArchitect Information: " +
				"\nName: " + Aname + 
				"\nTelephone Number: " + Atel + 
				"\nEmail Address: " + Aemail + 
				"\nPhysical Address: " + APhyaddy  ;
				return objectString;
				
	}
	
}

