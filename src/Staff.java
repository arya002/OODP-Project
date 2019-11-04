
public class Staff extends User {

	public Staff(String username, String password) {
		super(username, password);
		this.type = "Staff";
	}

	//dont need right now, may later need to override
	
	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean isLoggedIn() {
		return loggedIn;
	}

	
}
