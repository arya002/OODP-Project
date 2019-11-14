import java.util.*;

public class LoginScreen {

	Scanner sc = new Scanner(System.in);

	private String password = "";
	private String userName;
	private String type;
	private int tries;
	private boolean loggedIn;

	public LoginScreen(){
		this.password = "guest";
		this.userName = "guest";
		this.type = "";
		this.tries = 3;
		this.loggedIn = false;
		run();
	}

	public void run() {
        int sc_in;

        do {
            System.out.println("1. Login \n2. Continue as Guest \n3. Client Register\n4. Exit");
            sc_in = sc.nextInt();
            switch (sc_in) {
                case 1:
                    enterUserName();
                    enterPassword();
                    break;
                case 2:
//					TODO make guest
                    break;
                case 3:
                    registerUser();
                    loggedIn = true;
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid input, please choose from the following:");
                    break;
            }

        } while (sc_in != 4 && sc_in != 2 && !loggedIn);

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
                loggedIn = true;
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
