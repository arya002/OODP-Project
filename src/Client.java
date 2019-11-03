
public class Client extends User {
	
	String phoneNum;
	String email;


	public Client(String username, String password) {
		super(username, password);
		this.phoneNum = "";
		this.email = "";
	}
	
	public Client(String username, String password	,String phoneNum,String email) {
		super(username, password);
		this.phoneNum = phoneNum;
		this.email = email;		
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		 this.username = username;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
