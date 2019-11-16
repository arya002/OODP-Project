import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to MOBLIMA, the best way book your movie tickets.");
		System.out.println("What would you like to do?");
		menu();
	}

	private static void menu() {

		int sc_in;

		do {
			System.out.println("1. Login/Register \n2. Continue as guest \n3. Exit");
			sc_in = sc.nextInt();
			switch (sc_in) {
				case 1:
					User lis = new LoginScreen().run();

					if(lis.getType().equals("client")){

						new ClientApp((Client) lis);

					}else if(lis.getType().equals("staff")){

						new StaffApp((Staff) lis);

					}else {
                        System.out.println("error in determining class");
					}

					break;

				case 2:

					new ClientApp(null);
					break;

				case 3:

					System.exit(1);
					break;

				case 10:

					instantiateTestData();
					break;

				case 22:
					ArrayList<Staff> staff = new ArrayList<>();
					staff.add(new Staff("admin","admin","admin"));
					Data.getInstance().saveObjectToPath(SaveLoadPath.USER_PATH,staff);
					break;

				default:

					System.out.println("Invalid input, please choose from the following:");
					break;

			}

		} while (sc_in != 3);
	}

	private static void instantiateTestData() {

		String[] castArray = new String[2];
		castArray[0] = "tom cruise";
		castArray[1] = "also tom cruise";

        CineplexControl.addCineplex(new Cineplex("Jurong"));
        CineplexControl.addCineplex(new Cineplex("Orchard"));
        CineplexControl.addCineplex(new Cineplex("Central"));

        //Data.getInstance().saveObjectToPath(SaveLoadPath.MOVIE_PATH,MovieControl.getAllMoviesNames());



//        ReviewControl.addReview(new Review(" good i like","shrek",4,new Client("helol")));
//        ReviewControl.addReview(new Review("pretty good","ferb",2,new Client("helol")));
//        ReviewControl.addReview(new Review(" like ","phineas",1,new Client("helol")));
//        ReviewControl.addReview(new Review("pretty good i like","shrek",2,new Client("helol")));


        ShowingControl.addShowing(new Showing((CineplexControl.getCineplex("Jurong")).getCinemas().get(0),
				(CineplexControl.getCineplex("Jurong")),
				MovieControl.getAllMovies().get(0),
				"20191120" + Cinema.DaysOfWeek.valueOf("Wed") + Cinema.TimeSlots.valueOf("tenAm"),
				"type"
				));

        System.out.println(ShowingControl.getAllShowings().get(0).getCineplex().getName());


		Data.getInstance().saveObjectToPath(SaveLoadPath.CINEPLEX_PATH,CineplexControl.getCineplexes());


	}


}
