import java.io.Serializable;

/**
* Represents a staff member in the system
*/
public class Staff extends User implements Serializable {

	/**
	* Creates a new staff member with given parameters
	* @param username Staff member's username
	* @param password Staff member's password
	* @param firstName Staff member's first name
	*/
	public Staff(String username, String password,String firstName) {
		super(username, password, firstName);
		super.setType("staff");
	}

	//dont need right now, may later need to override


	
}
