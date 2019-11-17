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

					break;

				case 22:
					try {
						instantiateTestData();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;

				default:

					System.out.println("Invalid input, please choose from the following:");
					break;

			}

		} while (sc_in != 3);
	}

	private static void instantiateTestData() throws InterruptedException {

		CineplexControl cc = new CineplexControl();
		CineplexControl.Initialize();
		MovieControl mc = new MovieControl();

		CineplexControl.addCineplex(new Cineplex("Jurong"));
        CineplexControl.addCineplex(new Cineplex("Orchard"));
        CineplexControl.addCineplex(new Cineplex("Central"));
		Data.getInstance().saveObjectToPath(SaveLoadPath.CINEPLEX_PATH,CineplexControl.getCineplexes());

		String[] castArray = new String[2];
		ArrayList<Cineplex> cpes = (ArrayList<Cineplex>) Data.getInstance().getObjectFromPath(SaveLoadPath.CINEPLEX_PATH,Cineplex.class);

		castArray[0] = "Zhou Dongyu";
		castArray[1] = "Jackson Yee";
		MovieControl.addMovieListing(new Movie(
				"Better Days",
				Movie.Status.Showing,
				"Seventeen-year-old Nian is the subject of cruel bullying at high school when she meets Bei, a tough street kid. The two teenagers find a kindred spirit in each other that gradually rises above love, forming a world of their own. But the cocoon is crushed when they are being dragged into a teenage girl murder case as prime suspects. An emotional roller coaster that is heartwarming and heartbreaking at the same time, the China coming-of-age movie offers thought-provoking insights into the intense competition faced by nearly 10 million teenagers every year who sit for the National College Entrance Examination and national issues of school bullying. If you are one amongst 10 million to secure a promising future with a topnotch college passport, would you kill to do it?",
				"Derek Tsang",
				castArray));

		castArray[0] ="Chloe Benne";
		castArray[1] ="TenzNorgay Trainor";
		MovieControl.addMovieListing(new Movie("Abominable (PG)", Movie.Status.Showing,"Abominable” takes audiences on an epic 2,000-mile adventure from the streets of a Chinese city to the breathtaking Himalayan snowscapes. When teenage Yi (Chloe Bennet) encounters a young Yeti on the roof of her apartment building, she and her friends, Jin (Tenzing Norgay Trainor) and Peng (Albert Tsai), name him “Everest” and embark on an epic quest to reunite the magical creature with his family at the highest point on Earth.\n",
				"Jill Culton",castArray));

		castArray[0] ="Woody Harrelson";
		castArray[1] ="Jesse Eisenberg";
		MovieControl.addMovieListing(new Movie("Zombieland: Double Tap",
				Movie.Status.Showing,
				"A decade after Zombieland became a hit film and a cult classic, the lead cast (Woody Harrelson, Jesse Eisenberg, Abigail Breslin, and Emma Stone) have reunited with director Ruben Fleischer (Venom) and writers Rhett Reese & Paul Wernick (Deadpool) for Zombieland 2. In the sequel, through comic mayhem that stretches from the White House and through the heartland, these four slayers must face off against the many new kinds of zombies that have evolved since the first movie, as well as some new human survivors. But most of all, they have to face the growing pains of their own snarky, makeshift family.",
				"Ruben Fleischer",
				castArray));

		castArray[0] ="Joaquin Phoenix";
		castArray[1] ="Robert De Niro";
		MovieControl.addMovieListing(new Movie("Joker",
				Movie.Status.Showing,
				"A failed stand-up comedian is driven insane and becomes a psychopathic murderer.",
				"Todd Phillips",
				castArray));

		int cineplex =0;
		int cinema =0;
		int day =20;
		int dotw =1;

		ShowingControl.addShowing(new Showing(
				new Cinema("normal"),
				cpes.get(cineplex),
				new Movie(
						"Better Days",
						Movie.Status.Showing,
						"Seventeen-year-old Nian is the subject of cruel bullying at high school when she meets Bei, a tough street kid. The two teenagers find a kindred spirit in each other that gradually rises above love, forming a world of their own. But the cocoon is crushed when they are being dragged into a teenage girl murder case as prime suspects. An emotional roller coaster that is heartwarming and heartbreaking at the same time, the China coming-of-age movie offers thought-provoking insights into the intense competition faced by nearly 10 million teenagers every year who sit for the National College Entrance Examination and national issues of school bullying. If you are one amongst 10 million to secure a promising future with a topnotch college passport, would you kill to do it?",
						"Derek Tsang",
						castArray),
				"201911"+day+dotw+1,
				"normal"
		));



//		while (day < 30) {
//			int movie = 0;
//			int timeslot=1;
//
//			timeslot++;//2
//			movie++;
//			ShowingControl.addShowing(new Showing(
//					cpes.get(cinema).getCinemas().get(cinema),
//					cpes.get(cineplex),
//					MovieControl.getAllMovies().get(movie),
//					"201911"+day+dotw+timeslot,
//					MovieControl.getAllMovies().get(movie).getType()
//			));
//			timeslot++;//3
//			movie++;
//			ShowingControl.addShowing(new Showing(
//					cpes.get(cinema).getCinemas().get(cinema),
//					cpes.get(cineplex),
//					MovieControl.getAllMovies().get(movie),
//					"201911"+day+dotw+timeslot,
//					MovieControl.getAllMovies().get(movie).getType()
//			));
//			timeslot++;//4
//			movie++;
//			ShowingControl.addShowing(new Showing(
//					cpes.get(cinema).getCinemas().get(cinema),
//					cpes.get(cineplex),
//					MovieControl.getAllMovies().get(movie),
//					"201911"+day+dotw+timeslot,
//					MovieControl.getAllMovies().get(movie).getType()
//			));
//			movie = 1;
//			timeslot++;//5
//			ShowingControl.addShowing(new Showing(
//					cpes.get(cinema).getCinemas().get(cinema),
//					cpes.get(cineplex),
//					MovieControl.getAllMovies().get(movie),
//					"201911"+day+dotw+timeslot,
//					MovieControl.getAllMovies().get(movie).getType()
//			));
//
//			cinema++;
//			day++;
//
//		}
//
//
//
	}


}
