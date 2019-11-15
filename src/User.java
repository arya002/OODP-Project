import java.io.Serializable;

public abstract class User implements Serializable {

	protected String firstName;
	protected String username;
	protected String password;

	protected String type;

	public User(String username, String password, String firstName) {
		this.firstName = firstName;
		this.username = username;
		this.password = password;
	}

	public String getUsername() {return username;}
	
	public String getFirstName() {
		return firstName;
	}

	public void setUsername(String username) {this.username = username;}
	
	public void setPassword(String password) {}

	public boolean checkPassword(String test) {return password.equals(test);}
	
}
