import java.io.Serializable;

public abstract class User implements Serializable {

	protected String username;
	protected String password;
	protected boolean loggedIn;
	protected String type;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		loggedIn = false;
	}

	public String getUsername() {return username;}

	public void setUsername(String username) {this.username = username;}

	public boolean checkPassword(String test) {return password.equals(test);}
	
	public void setPassword(String password) {}
	
	public boolean isLoggedIn() {return loggedIn;}

	public void LogIn() {loggedIn = true;}

	public void LogOut() {loggedIn = false;}
	
	
}
