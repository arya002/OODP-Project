import java.io.Serializable;

public abstract class User implements Serializable {

	private String firstName;
	private String username;
	private String password;
	private String type;

	public User(String username, String password, String firstName) {
		this.firstName = firstName;
		this.username = username;
		this.password = password;
	}

	public String getUsername() {return username;}

	public String getFirstName() {return firstName;}

	public String getPassword(){return password;}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
