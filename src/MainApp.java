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
		LoginScreen lg = new LoginScreen();

	}
