import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles all the Staff capabilities
 *
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
        int sc_in;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Welcome " + currentStaff.getFirstName());
            System.out.println
                    ("1. Add new movie showing " +
                            "\n2. Update movie showing" +
                            "\n3. Delete movie showing" +
                            "\n4. Back");
            sc_in = sc.nextInt();
            switch (sc_in) {

                case 1:
                    addShowing();
                    break;
                case 2:
                    updateShowing();
                    break;
                case 3:
                    deleteShowing();
                    break;
                case 4:

                    break;
                default:
                    System.out.println("Invalid input. Enter again!");
            } while (sc_in != 4) ;


            //TODO delete showing
        } while (sc_in != 4);
    }

    private void deleteShowing() {

        System.out.println("Select a showing number to delete: ");
        ArrayList<Showing> allShowings = ShowingControl.getAllShowings();

        for(int i=0; i<allShowings.size(); ++i){
            System.out.println( (i+1) + ". " + allShowings.get(i).getMovie().getName() + " is playing at " +
                    allShowings.get(i).getCineplex().getName() + " on " + allShowings.get(i).getDayOfWeek() +
                    " at " + allShowings.get(i).getTimeSlotString(allShowings.get(i).getTimeSlot()));
        }
        Scanner sc = new Scanner(System.in);
        int sc_in = sc.nextInt();
        allShowings.remove(sc_in-1);
        Data.getInstance().saveObjectToPath(SaveLoadPath.SHOWING_PATH,allShowings);
    }

    private void updateShowing() {

        System.out.println("Select a showing number to edit: ");
        ArrayList<Showing> allShowings = ShowingControl.getAllShowings();

        for(int i=0; i<allShowings.size(); ++i){
            System.out.println(allShowings.get(i).printShowing());
        }

        int sc_in = MainApp.sc.nextInt();
        System.out.println(allShowings.get(sc_in).printShowing());
        System.out.println("Which part do you want to edit: ");
        System.out.println("1. Movie + " +
                            "\n2. Date");
        int sc_in2 = MainApp.sc.nextInt();

        switch (sc_in2) {

            case 1:
                System.out.println("Enter new movie: ");
                String mov = MainApp.sc.next();
                allShowings.get(sc_in-1).getMovie().setName(mov);
                break;
            case 2:
                System.out.println("Enter new date: ");
                String date = MainApp.sc.next();
                allShowings.get(sc_in-1).setDate(date);
                break;
        }
        Data.getInstance().saveObjectToPath(SaveLoadPath.SHOWING_PATH,allShowings);

    }

    private void printMovies(ArrayList<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie.getName());

        }
    }

    private void printCineplexs(ArrayList<Cineplex> cineplexs) {
        for (Cineplex cineplex : cineplexs) {
            System.out.println(cineplex.getName());

        }
    }

    private void addShowing() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a cineplex: ");
        printCineplexs(CineplexControl.getCineplexes());
        String cineplex = sc.next();

        System.out.println("Choose a movie: ");
        printMovies(MovieControl.getAllMovies());
        String movie = sc.next();

        System.out.println("is it 3d? :");
        String type = sc.next();
        boolean threedee=  false;
        if (type.equalsIgnoreCase("yes"))


        System.out.println("Enter date: ");
        String date = sc.next();

        ShowingControl.addShowing(new Showing(CineplexControl.getCineplex(cineplex).getCinemas().get(0), CineplexControl.getCineplex(cineplex),
                MovieControl.getMovie(movie), date, type));
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
                    i++;
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
