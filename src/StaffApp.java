import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles all the Staff capabilities
 *
 * @author Beck
 * @version 1
 * @since 11/11/2019
 */
public class StaffApp {

    private Staff currentStaff;

    public StaffApp(Staff _currentStaff) {
        currentStaff = _currentStaff;
        run();
    }

    private void run() {
        int sc_in;

        do {
            System.out.println("Welcome " + currentStaff.getFirstName());
            System.out.println
                    ("1. Create/Update/Remove Movie" +
                            "\n2. Create/Update/Remove cinema Show times" +
                            "\n3. Configure System Settings" +
                            "\n4. Exit\n");


            sc_in = MainApp.sc.nextInt();
            switch (sc_in) {
                case 1:
                    handleMovieListings();
                case 2:
                    handleShowTimes();
                case 3:
                    handleSystemSettings();
                case 4:
                    break;
                default:
                    System.out.println("Invalid input, please choose from the following:");
                    break;
            }

        } while (sc_in != 4);
    }

    private void handleSystemSettings() {
        int sc_in;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Welcome " + currentStaff.getFirstName());
            System.out.println
                    ("1. Edit movie Prices " +
                            "\n2. Edit holidays" +
                            "\n3. Add new staff member" +
                            "\n4. Exit\n");

            sc_in = sc.nextInt();
            switch (sc_in) {
                case 1:
                    //TODO Allow staff to edit ticket prices
                    System.out.println("Please enter the new price of an adult ticket.");
                    double price = MainApp.sc.nextDouble();
                    changePriceOfTicket(price);
                    break;
                case 2:
                    System.out.println("When would you like to add a holiday");
                    addHoliday();
                    break;
                case 3:
                    //Add new staff
                    String user, pass, first;
                    System.out.println("Please Enter the staff Username");
                    user = sc.next();
                    System.out.println("Please Enter the staff Password");
                    pass = sc.next();
                    System.out.println("Please Enter the staff FirstName");
                    first = sc.next();
                    addNewStaff(user, pass, first);
                    break;
                case 4:
                    //    public Movie( name, Status status,  synopsis,  director,  cast, ArrayList<Review> , ArrayList<Cineplex> ) {

                    //ArrayList<Review> reviews = new ArrayList<>();

                    //    public Review(String review, String movieName,double rating, Client reviewer) throws IllegalArgumentException


                    //Movie movie = new Movie("shrek", Movie.Status.Showing,"synopsis","beck",new String[] {"tom cruise","donkey"}, )
                    break;
                default:
                    System.out.println("Invalid input, please choose from the following:");
                    break;
            }

        } while (sc_in != 3);
        sc.close();

    }

    private void addNewStaff(String user, String pass, String first) {

        ArrayList<User> allusers = (ArrayList<User>) Data.getInstance().getObjectFromPath(SaveLoadPath.USER_PATH, User.class);
        allusers.add(new Staff(user, pass, first));
        Data.getInstance().saveObjectToPath(SaveLoadPath.USER_PATH, allusers);

    }

    private void addHoliday() {


    }

    private void changePriceOfTicket(double price) {

        boolean returnVal = false;

    }

    private void handleShowTimes() {
        int sc_in =0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Welcome " + currentStaff.getFirstName());
            System.out.println
                    ("1. Add new movie showing " +
                            "\n2. Update movie showing" +
                            "\n3. Delete movie showing" +
                            "\n4. Back");

            switch (sc_in) {

                case 1:
                    int whichMovie = 0;
                    int whichCineplex =0;
                    int whichDay =0;
                    int whichTimeSlot =0;
                    int whichCinema =0;
                    for(Movie movie:MovieControl.getAllMovies()){
                        System.out.println(whichMovie + ". " +movie.getName());
                    }
                    whichMovie = sc.nextInt();

//                    for (Cineplex cinplex);



                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:
                    System.out.println("Invalid input. Enter again!");
            } while (sc_in != 4);

            //TODO add new showing
            //TODO update showing
            //TODO delete showing
        }while (sc_in != 4);
    }

    private void handleMovieListings() {

        int sc_in;
        int i = 0;
        do {
            System.out.println("Welcome " + currentStaff.getFirstName());
            System.out.println
                    ("1. View Movie Listings " +
                            "\n2. Edit Movie Listings" +
                            "\n3. Exit\n");

            sc_in = MainApp.sc.nextInt();
            switch (sc_in) {
                case 1:
                    i = 0;
                    for (Movie movie : MovieControl.getAllMovies()) {
                        System.out.println(i + " - " + movie.getName() + " is currently " + movie.getStatus() + " \n" + movie.getSynopsis() + "\n\n");
                    }
                case 2:

                    System.out.println("Which movie would you like to edit");

                    i = 0;
                    for (Movie movie : MovieControl.getAllMovies()) {

                        System.out.println(i + ". " + movie.getName() + " is currently " + movie.getStatus());

                    }

                    sc_in = MainApp.sc.nextInt();
                    int indexToEdit = sc_in;
                    ArrayList<Movie> editedMovieList = MovieControl.getAllMovies();

                    do {
                        System.out.println("1. Status " +
                                "\n2. Location" +
                                "\n3. Exit");
                        sc_in = MainApp.sc.nextInt();
                        System.out.println("Edit - ");
                        switch (sc_in) {
                            case 1:
                                do {
                                    System.out.println("1. Showing " +
                                            "\n2. Preview" +
                                            "\n3. Not Showing" +
                                            "\n4. Exit.");
                                    sc_in = MainApp.sc.nextInt();
                                    switch (sc_in) {
                                        case 1:
                                            editedMovieList.get(indexToEdit).setStatus(Movie.Status.Showing);
                                            break;
                                        case 2:
                                            editedMovieList.get(indexToEdit).setStatus(Movie.Status.comingSoon);
                                            break;
                                        case 3:
                                            editedMovieList.get(indexToEdit).setStatus(Movie.Status.notShowing);
                                            break;
                                        case 4:

                                            break;

                                        default:
                                            System.out.println("Please enter a valid integer");
                                            break;
                                    }

                                } while (sc_in != 4);

                            case 2:

//                                do {
//                                    System.out.println("1. Add location" +
//                                            "\n2. Remove location" +
//                                            "\n3. Exit.");
//                                    sc_in = MainApp.sc.nextInt();
//                                    switch (sc_in) {
//                                        case 1:
//                                            System.out.println("1. Locations to add\n");
//                                            ArrayList<Cineplex> cineplexes = CineplexControl.getCineplexes();
//                                            for (int index = 0; index < cineplexes.size(); index++) {
//                                                System.out.println(index + ". " + cineplexes.get(index));
//                                            }
//                                            break;
//
//                                        case 2:
//                                            //TODO add option to delete
//                                            for (Cineplex cineplex :CineplexControl.getCineplexes()){
//                                                for (Cinema cinema:cineplex.getCinemas()){
//                                                    System.out.println("cineplex " + cineplex + " has showings of ");
//                                                    for(Showing showing:cinema.getShowings()){
//                                                        System.out.println(showing.getMovie() + " ");
//
//                                                    }
//                                                }
//
//                                            }
////
//                                            break;
//
//                                        case 3:
//
//                                            break;
//
//                                        default:
//                                            System.out.println("Please enter a valid integer");
//                                            break;
//                                    }
//                                    while (sc_in != 3) ;
//                                    break;

//                                } while (sc_in != 3);

                                break;
                            case 3:

                                break;

                            default:
                                System.out.println("Invalid input, please choose from the following:");
                                break;
                        }

                    } while (sc_in != 3);

            }


        } while (sc_in != 3);
    }

}
