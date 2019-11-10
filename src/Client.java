
public class Client extends User {
	
	String phoneNum;
	String email;

	public Client(String username, String password) {
		super(username, password);
		this.phoneNum = "";
		this.email = "";
		this.type = "Client";
	}
	
	public Client(String username, String password	,String phoneNum,String email) {
		super(username, password);
		this.phoneNum = phoneNum;
		this.email = email;		
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

}
