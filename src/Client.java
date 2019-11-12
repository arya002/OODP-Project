
public class Client extends User {
	private String name;
	private String phoneNum;
	private String email;
	int age;
	static private boolean loggedIn = false;

	public Client(String username, String password) {
		super(username, password, username);
		this.phoneNum = "";
		this.email = "";
		this.type = "Client";
		this.loggedIn = true;
	}
	
	public Client(String username, String password	,String phoneNum, String email, String name, int age) throws IllegalArgumentException {
		super(username, password, name);
		this.setPhoneNum(phoneNum);
		this.setEmail(email);
		this.setAge(age);
		this.setName(name);
		this.loggedIn = true;
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

	public Boolean getLoggedIn() {
		return this.loggedIn;
	}
	//</editor-fold>

	//<editor-fold desc="Setters">
	public void setPhoneNum(String phoneNum) {
		if (phoneNum.isEmpty())
			throw new IllegalArgumentException("Phonenumber cannot be empty");
		else
			this.phoneNum = phoneNum;
	}

	public void setEmail(String email) {
		if (email.isEmpty())
			throw new IllegalArgumentException("Email cannot be empty");
		else
			this.email = email;
	}

	public void setAge(int age) {
		if (age < 0)
			throw new IllegalArgumentException("Age cannot be negative");
		else
			this.age = age;
	}

	public void setName(String name) {
		if (name.isEmpty())
			throw new IllegalArgumentException("Name cannot be empty");
		this.name = name;
	}
	//</editor-fold>
}
