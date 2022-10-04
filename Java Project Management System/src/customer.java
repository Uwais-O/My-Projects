/**
 * 
 * @author Uwais
 *
 */


public class customer {
	///Attributes 
	private String name;
	private String tel;
	private String email;
	private String Phyaddy;
	
	// Constructor
	public customer(String name, String tel, String email, String Phyaddy) {
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.Phyaddy = Phyaddy;
	}
	// Method 
	public String toString() {
		String objectString = "\nCustomer information:" +
				"\nName: " + name + 
				"\nTelephone Number: " + tel + 
				"\nEmail Address: " + email + 
				"\nPhysical Address: " + Phyaddy ;
				return objectString;}
				
}
