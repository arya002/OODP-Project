import java.util.*;

public class LoginScreen {

	private Scanner sc = new Scanner(System.in);

	private String password = "";
	private String userName;
	private int tries;

	public LoginScreen(){
		this.password = "guest";
		this.userName = "guest";
		this.tries = 3;
	}




	public void enterUserName(){

		System.out.print("Enter username : ");
		this.userName = sc.next();
	}

	public void enterPassword(){

		if(tries > 0) {
			System.out.print("Enter password ( " + tries + " left ) : ");
			this.password = sc.next();
			tries -= 1;
		}
		else{
			System.out.println("Tries exceeded");
		}
	}

	public String getUserName() {

		return this.userName;
	}

	public String getPassword() {

		return this.password;
	}

	public String getType(){

		// check if userName is in the list of staff usernames
		if(true){
			return "staff";
		}
		// check if userName is in the list of customer usernames
		else if(true){
			return "staff";
		}
		//guest login if any other username
		else{
			return "guest";
		}
	}
}