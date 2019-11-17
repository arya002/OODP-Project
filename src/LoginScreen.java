import java.util.*;

public class LoginScreen {

    Scanner sc = new Scanner(System.in);


    public LoginScreen() {
    }

    public User run() {
        int sc_in;
		User currentUser= null;
        System.out.println("RUN");
        do {
            System.out.println("1. Login \n2. Register new user \n3. Back");
            sc_in = sc.nextInt();
            switch (sc_in) {
                case 1:
<<<<<<< HEAD
                    currentUser = enterUserPass();
                    return currentUser;
=======
                    return (currentUser = enterUserPass());
>>>>>>> 0f4b0763f46af422e2a2a70f7890be3391ead580
                case 2:
                	registerUser();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid input, please choose from the following:");
                    break;
            }

<<<<<<< HEAD
        } while (sc_in != 3 && currentUser == null);
=======
        } while (sc_in != 3&& currentUser!=null);
>>>>>>> 0f4b0763f46af422e2a2a70f7890be3391ead580

        return currentUser;

    }

    public User enterUserPass() {

        System.out.print("Enter username : ");
        String user = sc.next();
		System.out.print("Enter password : ");
		String pass = sc.next();

		ArrayList<User> allUsers = (ArrayList<User>) Data.getInstance().getObjectFromPath(SaveLoadPath.USER_PATH,User.class);

		for(User userEntry:allUsers)
			if(userEntry.getUsername().equals(user))
				if(userEntry.getPassword().equals(pass)) {
                    System.out.println("success");
                    return userEntry;
				}


		return null;
    }



    public void registerUser() {
        System.out.println("Enter a username:");
        String userName = sc.next();
        //check if username already exists and throw error
		System.out.println("Enter a password:");
		String password = sc.next();

		System.out.println("Enter a phone number:");
		String phone = sc.next();

		System.out.println("Enter a email:");
		String email = sc.next();

		System.out.println("Enter a age:");
		int age = sc.nextInt();


	}

}
