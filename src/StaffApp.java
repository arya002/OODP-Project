import java.util.ArrayList;
import java.util.Random;
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
                    ("1. Create/Update/Remove Movie Listing " +
                            "\n2. Create/Update/Remove cinema Show times and the movies to be shown " +
                            "\n3. Configure System Settings" +
                            "\n4. Exit\n");


            sc_in = main.sc.nextInt();
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
        do {
            System.out.println("Welcome " + currentStaff.getFirstName());
            System.out.println
                    ("1. Movie Prices " +
                            "\n2. Holidays" +
                            "\n3. Exit\n");

            sc_in = main.sc.nextInt();
            switch (sc_in) {
                case 1:
                    System.out.println("Please enter the new price of an adult ticket.");
                    double price = main.sc.nextDouble();
                    changePriceOfTicket(price);
                    break;
                case 2:
                    System.out.println("When would you like to add a holiday");
                    addHoliday();
                    break;
                case 3:

                    break;
                case 4:
                    //    public Movie( name, Status status,  synopsis,  director,  cast, ArrayList<Review> , ArrayList<Cineplex> ) {

                    ArrayList<Review> reviews = new ArrayList<>();

                    //    public Review(String review, String movieName,double rating, Client reviewer) throws IllegalArgumentException




                    //Movie movie = new Movie("shrek", Movie.Status.Showing,"synopsis","beck",new String[] {"tom cruise","donkey"}, )
                    break;
                default:
                    System.out.println("Invalid input, please choose from the following:");
                    break;
            }

        } while (sc_in != 3);

    }

    private void addHoliday() {


    }

    private void changePriceOfTicket(double price) {

        boolean returnVal=false;

    }

    private void handleShowTimes() {


    }


    private void handleMovieListings() {

        int sc_in;
        do {
            System.out.println("Welcome " + currentStaff.getFirstName());
            System.out.println
                    ("1. View Movie Listings " +
                            "\n2. Edit Movie Lisings" +
                            "\n3. Exit\n");

            sc_in = main.sc.nextInt();
            switch (sc_in) {
                case 1:
                    do {
                        System.out.println
                                ("1. View Movie Listings " +
                                        "\n2. Edit Movie Lisings" +
                                        "\n3. Exit\n");

                        sc_in = main.sc.nextInt();
                        switch (sc_in) {
                            case 1:

                                break;
                            case 2:
                                System.out.println("When would you like to add a holiday");
                                addHoliday();
                                break;
                            case 3:

                                break;

                            default:
                                System.out.println("Invalid input, please choose from the following:");
                                break;
                        }

                    } while (sc_in != 3);


                case 2:
                    System.out.println("When would you like to add a holiday");
                    addHoliday();
                    break;
                case 3:

                    break;

                default:
                    System.out.println("Invalid input, please choose from the following:");
                    break;
            }

        } while (sc_in != 3);

    }


}
