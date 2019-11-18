import java.io.Serializable;
/**
 * Individual clients as an object
 */

public class Client extends User implements Serializable {
	private String phoneNum;
	private String email;

	/**
 * Create a new client with the username, password, phoneNumber, email and Name.
 */
	public Client(String username, String password, String phoneNum, String email, String name){
		super(username, password, name);
		this.setPhoneNum(phoneNum);
		this.setEmail(email);
		this.setType("client");
	}
/**
 * Returns the ohone number of the client
 @return phoneNum
 */
	public String getPhoneNum() {
		return phoneNum;
	}
/**
 * Create a new client with the username, password, phoneNumber, email and Name.
 @return the email as string
 */
	public String getEmail() {
		return email;
	}

	/**
 * Sets new phone number, with error checking to disallow missing phone No.
 @param phoneNum is a string in case we need country codes +65 etc.
 */
	public void setPhoneNum(String phoneNum) {
		if (phoneNum.isEmpty())
			throw new IllegalArgumentException("Phonenumber cannot be empty");

        this.phoneNum = phoneNum;
	}
/**
 * Sets a new email. Again, email cannot be empty
 @param email takes a string email
 */
	public void setEmail(String email) {
		if (email.isEmpty())
			throw new IllegalArgumentException("Email cannot be empty");

        this.email = email;
	}
}
