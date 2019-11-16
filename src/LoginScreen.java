import java.util.*;

public class LoginScreen {

	Scanner sc = new Scanner(System.in);

	private String password = "";
	private String userName;
	private int tries;
	public boolean loggedIn;

	public LoginScreen(){
		this.password = "guest";
		this.userName = "guest";
		this.tries = 3;
		this.loggedIn = false;
		run();
	}

	public void run() {
        int sc_in;

        do {
            System.out.println("1. Login \n2. Register new user \n3. Back");
            sc_in = sc.nextInt();
            switch (sc_in) {
                case 1:
                    enterUserName();
                    enterPassword();
                    break;
                case 2:
//		    registerUser();
		    this.loggedIn = true;
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid input, please choose from the following:");
                    break;
            }

        } while (sc_in != 3 || !loggedIn);

    }

	public void enterUserName(){

		System.out.print("Enter username : ");
		this.userName = sc.next();
		//check if invalid username and throw error
        	//also get type of user
	}

	public void enterPassword(){

		if(tries > 0) {
			System.out.print("Enter password ( " + tries + " left ) : ");
			this.password = sc.next();
			    //check value of password from file
			if(password.equals()) {
				this.loggedIn = true;
				System.out.println("Successfully logged in!");
				return;
            		}
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

	public void registerUser() {
		System.out.println("Enter a username:");
		userName = sc.next();
	        //check if username already exists and throw error
        	password = sc.next();

    }

}
