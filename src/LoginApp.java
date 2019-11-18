import java.util.*;

/**
 * Prints the login screen. Logic for login contained here as well
 */

public class LoginApp {

    Scanner sc = new Scanner(System.in);

/**
 * Offer user a choice to login, register or go back
 */
    public User run() {
        int sc_in;
		User currentUser= null;
        do {
            System.out.println("1. Login \n2. Register new user");
            sc_in = sc.nextInt();
            switch (sc_in) {
                case 1:
                    currentUser = enterUserPass();
                    return currentUser;
                case 2:
                	registerUser();
                    break;
                default:
                    System.out.println("Please choose from the following:");
                    break;
            }

        } while (currentUser == null);

        return currentUser;

    }
/**
 * Checks username and password to login
 */
    public User enterUserPass() {

        System.out.println();
        System.out.print("Enter username : ");
        String user = sc.next();
		System.out.print("Enter password : ");
		String pass = sc.next();
	ArrayList<User> allUsers = (ArrayList<User>) Data.getInstance().getObjectFromPath(SaveLoadPath.USER_PATH,User.class);

        for(User userEntry:allUsers)
        {
			if(userEntry.getUsername().equals(user))
				if(userEntry.getPassword().equals(pass)) {
                    System.out.println("You have successfully logged in!");
                    return userEntry;
				}
        }
        System.out.println("Something went wrong, please enter correct login details");
		return null;
    }


/**
 * Registers a new user. Will check if username has been taken
 */
    public void registerUser() {
	    ArrayList<User> allUsers = (ArrayList<User>) Data.getInstance().getObjectFromPath(SaveLoadPath.USER_PATH,User.class);
	    boolean taken = true;
	    
	    while(taken){
		taken = false;
        	System.out.println("Enter a username:");
        	String userName = sc.next();
		for(User userEntry:allUsers)
        		{
			if(userEntry.getUsername().equals(userName)){
				System.out.println("Username taken. Please try again");
				taken = true;
				break;}
		}
	      }
		System.out.println("Enter a password:");
		String password = sc.next();

		System.out.println("Enter a phone number:");
		String phone = sc.next();

		System.out.println("Enter an email:");
		String email = sc.next();

		System.out.println("Enter an age:");
		int age = sc.nextInt();


	}

}
