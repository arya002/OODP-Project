import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

	User currentUser;
	static Scanner sc = new Scanner(System.in);
	//static ReviewControl movieReview = ReviewControl.getInstance();
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
					LoginScreen lg = new LoginScreen();
					loggedin = lg.loggedIn;
					currentUser.setUsername(lg.getUserName());
					currentUser.setPassword(lg.getPassword());
					break;
				case 2:
					loggedin = false;
					currentUser.setUsername(lg.getUserName("guest"));
					currentUser.setPassword(lg.getPassword("guest"));
					break;
				case 3:
					//TODO go to CLientApp with null as user
					break;

				case 7:

					String[] castArray = new String[2];
					castArray[0] = "tom cruise";
					castArray[1] = "also tom cruise";

					Movie movie = new Movie("shrek", Movie.Status.Showing,"synopsis",
				"Al Green", castArray);
					ArrayList<Movie> movies = new ArrayList<>();
					movies.add(movie);

					Data.getInstance().saveObjectToPath(SaveLoadNames.MOVIE_PATH,movies);
//					ReviewControl.addReview(new Review(" good i like","shrek",4,new Client("helol")));
//					ReviewControl.addReview(new Review("pretty good","ferb",2,new Client("helol")));
//					ReviewControl.addReview(new Review(" like ","phineas",1,new Client("helol")));
//					ReviewControl.addReview(new Review("pretty good i like","shrek",2,new Client("helol")));
//					CineplexControl.addCineplex(new Cineplex("Jurong"));
//					CineplexControl.addCineplex(new Cineplex("Orchard"));
//					CineplexControl.addCineplex(new Cineplex("Central"));

					//hello

//					mc.addMovieListing(new Movie("shrek", Movie.Status.Showing,"synopsis","Al Green", castArray));

					//Showing showing = new Showing(cp.getCineplex("Jurong"),);

					break;
				default:
					System.out.println("Invalid input, please choose from the following:");
					break;
			}

		} while (sc_in != 3 && !loggedin);
	}
