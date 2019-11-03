
public abstract class User {

	protected String username; 
	protected String password;
	protected boolean loggedIn;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		loggedIn = false;
	}

	public abstract String getUsername();

	public abstract void setUsername(String username);

	public abstract String getPassword();
	
	public abstract void setPassword(String password);
	
	public abstract boolean isLoggedIn();
	
	
}
