import java.io.Serializable;

public class Client extends User implements Serializable {
	private String name;
	private String phoneNum;
	private String email;
	private int age;

	public Client(String username, String password) {
		super(username, password, username);
		this.phoneNum = "";
		this.email = "";
		super.setType("client");
	}

	
	public Client(String username, String password, String phoneNum, String email, String name, int age) throws IllegalArgumentException {
		super(username, password, name);
		this.setPhoneNum(phoneNum);
		this.setEmail(email);
		this.setAge(age);
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

	public void setPhoneNum(String phoneNum) {
		if (phoneNum.isEmpty())
			throw new IllegalArgumentException("Phonenumber cannot be empty");

        this.phoneNum = phoneNum;
	}

	public void setEmail(String email) {
		if (email.isEmpty())
			throw new IllegalArgumentException("Email cannot be empty");

        this.email = email;
	}

	public void setAge(int age) {
		if (age < 0)
			throw new IllegalArgumentException("Age cannot be negative");

        this.age = age;
	}

	public void setName(String name) {
		if (name.isEmpty())
			throw new IllegalArgumentException("Name cannot be empty");

		this.name = name;
	}

}
