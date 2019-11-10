
public class Client extends User {
	private String name;
	private String phoneNum;
	private String email;
	int age;

	public Client(String username, String password) {
		super(username, password);
		this.phoneNum = "";
		this.email = "";
		this.type = "Client";
	}
	
	public Client(String username, String password	,String phoneNum, String email, String name) {
		super(username, password);
		this.phoneNum = phoneNum;
		this.email = email;
		this.name = name;
	}

	//<editor-fold desc="Getters">
	public String getPhoneNum() {
		return phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}
	//</editor-fold>

	//<editor-fold desc="Mutators">
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}
	//</editor-fold>
}
