import java.util.ArrayList;
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
        Scanner sc = MainApp.sc;
        do {
            System.out.println("Welcome " + currentStaff.getFirstName());
            System.out.println
                    ("1. Create/Update/Remove Movie" +
                            "\n2. Create/Update/Remove cinema Show times" +
                            "\n3. Configure System Settings" +
                            "\n4. Get All Movies by Ticket Sales" +
                            "\n5. Get All Movies by Ratings" +
                            "\n6. Log out\n");

            sc.nextLine();
            sc_in = sc.nextInt();
            switch (sc_in) {
                case 1:
                    handleMovieListings();
                    break;
                case 2:
                    handleShowTimes();
                    break;
                case 3:
                    handleSystemSettings();
                    break;
                case 4:
                    MovieControl.getMoviesByTicketSales();
                    break;
                case 5:
                    MovieControl.getAllMoviesByRating();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid input, please choose from the following:");
                    break;
            }

        } while (sc_in != 6);
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
                    ("1. Edit Movie Prices " +
                            "\n2. Edit Holidays" +
                            "\n3. Add New Staff Member" +
                            "\n4. Edit Cinema Layout" +
                            "\n5. Exit");

            sc_in = sc.nextInt();
            switch (sc_in) {
                case 1:
                    editMoviePrices();
                    break;
                case 2:
                    editHolidays();
                    break;
                case 3:
                    addNewStaff();
                    break;
                case 4:
                    editCinemaLayouts();
                    break;
                case 5:
                default:
                    System.out.println("Invalid input, please choose from the following:");
                    break;
            }

        } while (sc_in != 5);

    }

    private void addNewStaff() {
        Scanner sc = MainApp.sc;
        String user, pass, first;
        System.out.println("Please Enter the staff Username");
        user = sc.next();
        System.out.println("Please Enter the staff Password");
        pass = sc.next();
        System.out.println("Please Enter the staff FirstName");
        first = sc.next();
        StaffControl.addNewStaff(user, pass, first);
        System.out.println("New staff profile added\n");
    }

    private void editCinemaLayouts() {
        Scanner sc = MainApp.sc;
        int row;
        int column;
        System.out.println("How many rows would you like this new cinema layout to have?");
        row = sc.nextInt();
        System.out.println("how many seats in a row would you like this cinema layout to have?");
        column = sc.nextInt();
        ArrayList<Cineplex> cineplex = (ArrayList<Cineplex>) Data.getObjectFromPath(SaveLoadPath.CINEPLEX_PATH, Cineplex.class);
        int selectedCineplex = 1;
        int selectedCinema = 1;
        System.out.println("Choose the cineplex: ");
        for (Cineplex cp : cineplex) {
            System.out.println(selectedCineplex + ". " + cp.getName());
            selectedCineplex++;
        }
        selectedCineplex = sc.nextInt() - 1;
        for (Cinema cinema : cineplex.get(selectedCineplex).getCinemas()) {
            System.out.println(selectedCinema + ". " + cinema.getCinemaID());
            selectedCinema++;
        }
        selectedCinema = sc.nextInt() - 1;
        cineplex.get(selectedCineplex).getCinemas().get(selectedCinema).buildRoomLayout(StaffControl.newLayout(row, column));
        Data.saveObjectToPath(SaveLoadPath.CINEPLEX_PATH, cineplex);
        System.out.println("Cinema layout changed");
    }

    private void editHolidays() {
        Scanner sc = MainApp.sc;
        StaffControl.printHolidays();
        System.out.println("What would you like to do?\n1. Add holiday \n2. Remove holiday");
        int sc_in = sc.nextInt();
        String holiday;
        switch (sc_in) {
            case 1:
                System.out.println("Please enter the new holiday (YYYYMMDD):");
                sc.nextLine();
                holiday = sc.nextLine();
                StaffControl.addHoliday(holiday);
                break;

            case 2:
                System.out.println("Please enter the holiday to remove (YYYYMMDD):");
                sc.nextLine();
                holiday = sc.nextLine();
                StaffControl.removeHoliday(holiday);
                break;
        }
    }

    private void editMoviePrices() {
        Scanner sc = MainApp.sc;
        StaffControl.printPrices();
        System.out.println("Would you like to edit the prices?");
        if (sc.next().equalsIgnoreCase("yes")) {
            StaffControl.changePrices();
            System.out.println("Prices have been edited\n");
        }
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
            }
        } while (sc_in != 4);
    }

    private void deleteShowing() {

        System.out.println("Select a showing number to delete: ");
        ArrayList<Showing> allShowings = ShowingControl.getAllShowings();

        for (int i = 0; i < allShowings.size(); ++i) {
            System.out.println((i + 1) + ". " + allShowings.get(i).printShowing());
        }
        Scanner sc = MainApp.sc;
        int sc_in = sc.nextInt();
        allShowings.remove(sc_in - 1);
        Data.getInstance().saveObjectToPath(SaveLoadPath.SHOWING_PATH, allShowings);
        System.out.println("Showing deleted\n");
    }

    private void updateShowing() {
        Scanner sc = MainApp.sc;
        System.out.println("Select a showing number to edit: ");
        ArrayList<Showing> allShowings = ShowingControl.getAllShowings();

        for (int i = 0; i < allShowings.size(); ++i) {
            System.out.println(i + ". " + allShowings.get(i).printShowing());
        }

        int sc_in = sc.nextInt();
        Showing showingToEdit = allShowings.get(sc_in);

        System.out.println(allShowings.get(sc_in).printShowing());
        System.out.println("Which part do you want to edit: ");
        System.out.println("1. Movie " +
                "\n2. Date" +
                "\n3. Exit");
        int sc_in2 = sc.nextInt();
        switch (sc_in2) {

            case 1:
                int count = 0;
                System.out.println("Enter new movie: ");
                ArrayList<Movie> allmovies = MovieControl.getAllMovies();
                for (Movie all : allmovies) {
                    System.out.println(count + ". " + all.getName());
                    count++;
                }
                int mov = sc.nextInt();
                showingToEdit.setMovie(allmovies.get(mov));

                break;
            case 2:
                String date = StaffControl.getDateInput(sc);
                showingToEdit.setDate(date);
                break;
            case 3:
                break;
        }
        Data.getInstance().saveObjectToPath(SaveLoadPath.SHOWING_PATH, allShowings);
        System.out.println("Showing has been updated\n");
    }

    /**
     * Adds a new showing
     */
    private void addShowing() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a cineplex: ");
        int count = 1;
        int cineplexIndex = 1;
        int cinemaIndex = 1;
        for (Cineplex cineplex : CineplexControl.getCineplexes()) {
            System.out.println(count + "." + cineplex.getName());
            count++;
        }
        cineplexIndex = sc.nextInt() - 1;
        Cineplex cineplex = CineplexControl.getCineplexes().get(cineplexIndex);
        count = 1;
        System.out.println("Choose a cinema: ");
        for (Cinema cinema : cineplex.getCinemas()) {
            System.out.println(count + "." + cinema.getCinemaID());
            count++;
        }

        cinemaIndex = sc.nextInt() - 1;
        Cinema cinema = cineplex.getCinemas().get(cinemaIndex);

        System.out.println("Choose a movie: ");
        count = 1;
        for (Movie movie : MovieControl.getAllMovies()) {
            System.out.println(count + ". " + movie.getName());
            count++;
        }
        int movieIndex = sc.nextInt() - 1;
        Movie movie = MovieControl.getAllMovies().get(movieIndex);

        System.out.println("is it 3d? :");
        String type = sc.next();
        boolean threedee = false;
        if (type.equalsIgnoreCase("yes")) {
            threedee = true;
        }

        String date = StaffControl.getDateInput(sc);

//        if (cinema.getTimeSlotsArray()[Integer.parseInt(date.substring(8, 9))][Integer.parseInt(date.substring(9))] == 1) {
        Showing showing = new Showing(cinema, cineplex, movie, date, type);
        showing.setIs3D(threedee);
        ShowingControl.addShowing(showing);
//        } else {
//        System.out.println("error -");
//        }
        return;
    }


    /**
     * handles Movie Listing changes
     */
    private void handleMovieListings() {
        Scanner sc = MainApp.sc;
        int sc_in;
        do {
            System.out.println("Welcome " + currentStaff.getFirstName());
            System.out.println("1. View Movie Listings " +
                    "\n2. Edit Movie Listings" +
                    "\n3. Add New Movie" +
                    "\n4. Delete movie listing" +
                    "\n5. Exit\n");

            sc_in = sc.nextInt();
            switch (sc_in) {
                case 1:
                    viewListings();
                    break;
                case 2:
                    editListings();
                    break;
                case 3:
                    addListing();
                    break;
                case 4:
                    deleteListings();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid input, please choose from the following:");
                    break;
            }

        } while (sc_in != 5);

    }

    private void deleteListings() {

        ArrayList<Movie> movies = MovieControl.getAllMovies();
        System.out.println("Which movie would you like to delete?");
        int indexToEdit = StaffControl.printWhichMovieToEdit(movies);
        movies.remove(indexToEdit);
        Data.saveObjectToPath(SaveLoadPath.MOVIE_PATH, movies);
        System.out.println("Movie listing deleted");
    }

    private void editListings() {
        Scanner sc = MainApp.sc;
        ArrayList<Movie> movies = MovieControl.getAllMovies();
        System.out.println("Which movie would you like to edit?");
        int indexToEdit = StaffControl.printWhichMovieToEdit(movies);
        System.out.println("1. Status" +
                "\n2. Rating " +
                "\n3. Exit");
        int sc_in = sc.nextInt();
        System.out.println("Edit - ");
        switch (sc_in) {
            case 1: {
                do {
                    System.out.println("1. Showing " +
                            "\n2. Coming Soon" +
                            "\n3. Not Showing" +
                            "\n4. Exit.");
                    sc_in = sc.nextInt();
                    switch (sc_in) {
                        case 1:
                            movies.get(indexToEdit).setStatus(Movie.Status.Showing);
                            break;
                        case 2:
                            movies.get(indexToEdit).setStatus(Movie.Status.comingSoon);
                            break;
                        case 3:
                            movies.get(indexToEdit).setStatus(Movie.Status.notShowing);
                            ShowingControl.notShowing(movies.get(indexToEdit).getName());
                            System.out.println("Removing all showings of " + movies.get(indexToEdit).getName());
                            sc_in = 4;
                            break;
                        case 4:
                            break;

                        default:
                            System.out.println("Please enter a valid integer");
                            break;
                    }

                    Data.saveObjectToPath(SaveLoadPath.MOVIE_PATH, movies);

                } while (sc_in < 1 || sc_in > 3);
                break;
            }
            case 2: {

                do {
                    movies.get(indexToEdit).setRating(getRatingInput());
                    Data.saveObjectToPath(SaveLoadPath.MOVIE_PATH, movies);
                } while (sc_in != 8);

            }
            case 3:
                break;
        }
        System.out.println("Movie listing updated\n");
    }

    private String getRatingInput() {
        Scanner sc = MainApp.sc;
        System.out.println("1. NR " +
                "\n2. PG" +
                "\n3. G" +
                "\n4. M" +
                "\n5. MA" +
                "\n6. R" +
                "\n7. X" +
                "\n8. Exit.");
        int sc_in;
        do {
            sc_in = sc.nextInt();
            switch (sc_in) {
                case 1:
                    return "NR";
                case 2:
                    return "G";
                case 3:
                    return "PG";
                case 4:
                    return "M";
                case 5:
                    return "MA";
                case 6:
                    return "R";
                case 7:
                    return "X";
                case 8:
                    break;
                default:
                    System.out.println("Please enter a valid integer");
                    break;
            }
        } while (sc_in < 8 && sc_in >= 0);
        return "";
    }

    private void addListing() {
        Scanner sc = MainApp.sc;
        String name;
        Movie.Status status;
        String synopsis;
        String type = "";
        String actor = "";
        String rating = "";
        ArrayList<String> cast = new ArrayList<>();
        String director;
        boolean blockbuster = false;
        System.out.println("Please enter the movies name");
        sc.nextLine();
        name = sc.nextLine();
        System.out.println("Please enter which Status");
        Movie.Status[] moviestatus = Movie.Status.values();
        for (int index = 0; index < Movie.Status.size; index++) {
            System.out.println(index + ". " + moviestatus[index].toString());
        }
        int sc_in = sc.nextInt();
        status = moviestatus[sc_in];
        System.out.println("Please enter the movie synopsis");
        sc.nextLine();
        synopsis = sc.nextLine();
        System.out.println("Is this a BlockBuster");
        type = sc.nextLine();
        rating = getRatingInput();
        if (type.equalsIgnoreCase("yes")) {
            blockbuster = true;
        }
        System.out.println("Enter the directors name");
        sc.nextLine();
        director = sc.nextLine();

        while (!actor.equalsIgnoreCase("exit")) {
            System.out.println("Enter the cast members name or type exit to exit");
            actor = sc.nextLine();
            cast.add(actor);
        }

        String[] castArray = new String[cast.size()];
        for (int index = 0; index < cast.size(); index++) {
            castArray[index] = cast.get(index);
        }

        Movie newMovie = new Movie(name, status, synopsis, director, rating, castArray);
        newMovie.setBlockbuster(blockbuster);
        MovieControl.addMovieListing(newMovie);
        System.out.println("new movie " + newMovie.getName() + " added");
    }

    public void viewListings() {
        int i = 0;
        for (Movie movie : MovieControl.getAllMovies()) {
            System.out.println(i + " - " + movie.getName() + "(" + movie.getRating() + ")" + " is currently " + movie.getStatus() + " \n" + movie.getSynopsis() + "\n");
            i++;
        }

    }
}


