import java.util.Scanner;

public class main {

	User currentUser;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String sc_in;

		System.out.println("1. Client Login \n2. Staff Login \n3. Continue as Guest \n4. Client Register");

		sc_in = sc.next();
		while (true) {
			switch (sc_in) {
			case "1":

				System.out.println("Please enter username or type 'back' to return");
				sc_in = sc.next();
				if (!sc_in.equalsIgnoreCase("back")) {
					String user = sc_in;
					System.out.println("Please enter password or type 'back' to return");
					sc_in = sc.next();
					if (!sc_in.equalsIgnoreCase("back")) {
						String pass = sc_in;
						String response = LogIn.checkLogin(user, pass);
						if(!response.equals(""))
							LogIn.loadUser(response);
					} else {
						break;
					}
				} else {
					break;
				}

			}

		}
	}

}
