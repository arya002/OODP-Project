import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Handles all the Staff capabilities
 *
 * @version 1
 * @since 11/11/2019
 */
public class StaffApp {

    /**
    * The current staff member logged in
    */
    private Staff currentStaff;

    /**
    * Initializes the StaffApp application for the current staff member
    */
    public StaffApp(Staff _currentStaff) {
        currentStaff = _currentStaff;
        run();
    }

    /**
    * Runs the StaffApp
    */
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

    /**
    * Handles the system settings
    */
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

    /**
    * Adds a new staff member
    * @param user Staff member's username
    * @param pass Staff member's password
    * @param first Staff member's first name
    */
    private void addNewStaff(String user, String pass, String first) {

        ArrayList<User> allusers = (ArrayList<User>) Data.getInstance().getObjectFromPath(SaveLoadPath.USER_PATH, User.class);
        allusers.add(new Staff(user, pass, first));
        Data.getInstance().saveObjectToPath(SaveLoadPath.USER_PATH, allusers);

    }

    /**
    * Adds a new holiday
    */
    private void addHoliday() {


    }

    /**
    * Changes the price of a ticket
    * @param price New price of the ticket
    */
    private void changePriceOfTicket(double price) {

        boolean returnVal = false;

    }

    /**
    * Handles the show times
    */
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

    /** 
    * Deletes a movie showing
    */
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
        return;
    }

    /**
    * Updates the details of a showing
    */
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
                System.out.println("\t X = Day of the week 0-6 - Y = Time Slot" );
                System.out.println("Enter new date in format YYYYMMDDXY: ");
                String date = MainApp.sc.next();
                allShowings.get(sc_in-1).setDate(date);
                break;
        }
        Data.getInstance().saveObjectToPath(SaveLoadPath.SHOWING_PATH,allShowings);

    }

    /**
    * Prints all the movie names
    * @param movies Array list of all the movie objects
    */
    private void printMovies(ArrayList<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie.getName());

        }
    }

    /**
    * Prints all the cineplexes
    * @param cineplexs Array list of all the cineplex objects
    */
    private void printCineplexs(ArrayList<Cineplex> cineplexs) {
        for (Cineplex cineplex : cineplexs) {
            System.out.println(cineplex.getName());

        }
    }

    /**
    * Adds a new showing
    */
    private void addShowing() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a cineplex: ");
        int count=0;
        int cineplexIndex=0;
        int cinemaIndex=0;
        for(Cineplex cineplex:CineplexControl.getCineplexes()) {
            System.out.println(count + "." + cineplex.getName());
            count++;
        }
        cineplexIndex= sc.nextInt();
        Cineplex cineplex = CineplexControl.getCineplexes().get(cineplexIndex);
        count =0;
        System.out.println("Choose a cinema: ");
        for(Cinema cinema:cineplex.getCinemas()){
            System.out.println(count + "." + cinema.getCinemaID());
            count++;
        }

        cinemaIndex= sc.nextInt();
        Cinema cinema = cineplex.getCinemas().get(cinemaIndex);

        System.out.println("Choose a movie: ");
        count =0;
        for(Movie movie:MovieControl.getAllMovies()){
            System.out.println(count + ". " + movie.getName());
            count++;
        }
        int movieIndex = sc.nextInt();
        Movie movie = MovieControl.getAllMovies().get(movieIndex);

        System.out.println("is it 3d? :");
        String type = sc.next();
        boolean threedee=  false;
        if (type.equalsIgnoreCase("yes")){
            threedee = true;
        }

        String date =getDateInput(sc);

        if(cinema.getTimeSlotsArray()[Integer.parseInt(date.substring(8,9))][Integer.parseInt(date.substring(9))] == 1) {
            ShowingControl.addShowing(new Showing(cinema, cineplex, movie, date, type));
        }else{
            System.out.println("error -");
        }
        return;

    }

    private String getDateInput(Scanner sc) {
        System.out.println("Enter date in format YYYYMMDD: ");
        String date;
        date = sc.next();

        Cinema.DaysOfWeek[] dotwvals= Cinema.DaysOfWeek.values();
        System.out.println("Enter which Day of the week: ");
        for(int choice = 0;choice<dotwvals.length;choice++){
            System.out.println(choice+". "+dotwvals[choice].toString());
        }
        int dotwIndex= sc.nextInt();
        date+=(dotwIndex);

        System.out.println("Enter Time Slot: ");
        Cinema.TimeSlots[] timeSlots= Cinema.TimeSlots.values();

        for(int choice = 0;choice<timeSlots.length;choice++){
            System.out.println(choice+". "+timeSlots[choice].toString());
        }
        int timeSlotIndex = sc.nextInt();
        date+=(timeSlotIndex);
        return date;
    }

    /**
    * handles Movie Listing changes
    */
    private void handleMovieListings() {

        int sc_in;
        int i = 0;
        do {
            System.out.println("Welcome " + currentStaff.getFirstName());
            System.out.println("1. View Movie Listings " +
                            "\n2. Edit Movie Listings" +
                            "\n3. Add New Movie" +
                            "\n4. Exit\n");

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
                    ArrayList<Movie> movies=MovieControl.getAllMovies();
                    for (Movie movie : movies) {

                        System.out.println(i + ". " + movie.getName() + " is currently " + movie.getStatus());
                        i++;
                    }

                    sc_in = MainApp.sc.nextInt();
                    int indexToEdit = sc_in;

                    do {
                        System.out.println("1. Status " +
                                "\n2. Exit");
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
                                            movies.get(indexToEdit).setStatus(Movie.Status.Showing);
                                            break;
                                        case 2:
                                            movies.get(indexToEdit).setStatus(Movie.Status.comingSoon);
                                            break;
                                        case 3:
                                            movies.get(indexToEdit).setStatus(Movie.Status.notShowing);
                                            break;
                                        case 4:
                                            break;

                                        default:
                                            System.out.println("Please enter a valid integer");
                                            break;
                                    }

                                    Data.saveObjectToPath(SaveLoadPath.MOVIE_PATH,movies);

                                } while (sc_in != 4);

                            case 3:
                                String name;
                                Movie.Status status;
                                String synopsis;
                                String type="";
                                String actor="";
                                ArrayList<String> cast= new ArrayList<>();
                                String director;
                                boolean blockbuster = false;
                                System.out.println("Please enter the movies name");
                                name = MainApp.sc.nextLine();
                                System.out.println("Please enter which Status");
                                Movie.Status[] moviestatus = Movie.Status.values();
                                for(int index=0; i <Movie.Status.size;i++){
                                    System.out.println(i + ". " +moviestatus.toString());
                                }
                                sc_in = MainApp.sc.nextInt();
                                status = moviestatus[sc_in];
                                System.out.println("Please enter the movie synopsis");
                                synopsis = MainApp.sc.nextLine();
                                System.out.println("Is this a BlockBuster");
                                type =MainApp.sc.nextLine();
                                if(type.equalsIgnoreCase("yes")){
                                    blockbuster = true;
                                }
                                System.out.println("Enter the directors name");
                                director =MainApp.sc.nextLine();


                                while(!actor.equalsIgnoreCase("exit")){
                                    System.out.println("Enter the cast members name or type exit to exit");
                                    actor =MainApp.sc.nextLine();
                                    cast.add(actor);
                                }

                                String[] castArray = new String[cast.size()];
                                castArray = (String[]) cast.toArray();
                                Movie newMovie = new Movie(name,status,synopsis,director,castArray);
                                MovieControl.addMovieListing(newMovie);

                                System.out.println("new movie "+newMovie.getName() +" added");

                            default:
                                System.out.println("Invalid input, please choose from the following:");
                                break;
                        }

                    } while (sc_in != 2);

            }


        } while (sc_in != 3);
    }
}
