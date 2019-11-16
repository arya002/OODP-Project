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
                    Staff(user, pass, first);
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

    private void addHoliday() {


    }

    private void changePriceOfTicket(double price) {

        boolean returnVal=false;

    }

    private void handleShowTimes() {
        //TODO ask staff if they want to add new, update or delete showing
        //TODO add new showing
        //TODO update showing
        //TODO delete showing
    }


    private void handleMovieListings() {

        int sc_in;
        do {
            System.out.println("Welcome " + currentStaff.getFirstName());
            System.out.println
                    ("1. View Movie Listings " +
                            "\n2. Edit Movie Lisings" +
                            "\n3. Exit\n");

            sc_in = MainApp.sc.nextInt();
            switch (sc_in) {
                case 1:
                    do {
                        System.out.println
                                ("1. View Movie Listings " +
                                        "\n2. Edit Movie Lisings" +
                                        "\n3. Exit\n");

                        sc_in = MainApp.sc.nextInt();
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
