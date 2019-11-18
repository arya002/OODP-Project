import java.io.Serializable;

/**
Represents a user of the App, be it Staff or Client
*/

public abstract class User implements Serializable {

	/**
	* The first name of the user
	*/
	private String firstName;
	
	/**
	* The Username name of the user
	*/
	private String username;
	
	/**
	* The password set by the user
	*/
	private String password;
	
	/**
	* The type of the user i.e. Staff or Client
	*/
	private String type;
	
	/**
	* Creates a new user with the given parameters
	* @param username This user's username
	* @param password This user's passoword
	* @param firstName This user's first name
	*/
	public User(String username, String password, String firstName) {
		this.firstName = firstName;
		this.username = username;
		this.password = password;
	}
	
	/**
	* Gets the username of the User
	* @return This user's username
	*/
	public String getUsername() {return username;}

	/**
	* Gets the first name of the User
	* @return This user's first name
	*/
	public String getFirstName() {return firstName;}

	/**
	* Gets the password of the User
	* @return This user's password
	*/
	public String getPassword(){return password;}

	/**
	* Gets the type of the User
	* @return This user's type
	*/
	public String getType() {
		return type;
	}

	/**
	* changesSets the type of the User
	* @param type This user's type
	*/
	public void setType(String type) {
		this.type = type;
	}
}
