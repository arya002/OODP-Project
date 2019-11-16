import java.io.Serializable;

public class Staff extends User implements Serializable {

	public Staff(String username, String password,String firstName) {
		super(username, password, firstName);
		super.setType("staff");
	}

	//dont need right now, may later need to override


	
}
