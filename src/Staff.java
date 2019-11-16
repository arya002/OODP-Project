
public class Staff extends User {

	public Staff(String username, String password,String firstName) {
		super(username, password, firstName);
		this.type = "Staff";
	}

	//dont need right now, may later need to override
	
	@Override
	public String getUsername() {
		return "Admin" + username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean checkPassword(String test) {
		return password.equals(test);
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	
}
