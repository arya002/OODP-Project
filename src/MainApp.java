import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

	User currentUser;
	static Scanner sc = new Scanner(System.in);
	static ReviewControl movieReview = ReviewControl.getInstance();
	static ArrayList<Cineplex> cineplexes = new ArrayList<>();
	static ArrayList<Movie> movieListings = new ArrayList<>();

	public static void main(String[] args) {

		System.out.println("Welcome to MOBLIMA, the best way book your movie tickets.");
		System.out.println("What would you like to do?");
		menu();
	}

	private static void menu() {
		int sc_in;
		boolean loggedin = false;

		do {
			System.out.println("1. Login/Register \n2. Continue as guest \n3. Exit");
			sc_in = sc.nextInt();
			switch (sc_in) {
				case 1:
					//TODO go to LogInScreen
					//TODO go to ClientApp
					break;
				case 2:
					//TODO go to ClientApp with no user
					break;
				case 3:
					break;

                case 6:
					movieReview.addReview(new Review("pretty good i like","shrek",2,new Client("helol")));
					movieReview.addReview(new Review(" good i like","shrek",4,new Client("helol")));
					movieReview.addReview(new Review(" i like","shrek",5,new Client("helol")));
					movieReview.addReview(new Review(" like ","phineas",1,new Client("helol")));
					movieReview.addReview(new Review("pretty good","ferb",2,new Client("helol")));


					MovieControl.printAllMoviesByRating();
					break;

				case 7:
					CineplexControl cp = new CineplexControl();

					break;
				default:
					System.out.println("Invalid input, please choose from the following:");
					break;
			}

		} while (sc_in != 3 && !loggedin);
	}

	private static boolean Login() {
//		Maybe move this inside LogIn and pass allong the scanner or something?
		System.out.println("Please enter username or type 'back' to return");
		String user = sc.next();
		if (!user.equalsIgnoreCase("back") && !user.isEmpty()) {
			System.out.println("Please enter password or type 'back' to return");
			String pass = sc.next();
			if (!pass.equalsIgnoreCase("back") && !pass.isEmpty()) {
				String response = LogIn.checkLogin(user, pass);
				if(!response.isEmpty()) {
					LogIn.loadUser(response);
					return true;
				} else {
					System.out.println("User not found");
				}
			}
		}
		return false;
	}

}
