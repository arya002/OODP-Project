import java.util.Random;
import java.util.Scanner;

/**
 * Handles all the Staff capabilities
 *
 * @author Beck
 * @version 1
 * @since 11/11/2019
 *
 */
public class StaffApp {

    private Staff currentStaff;

    public StaffApp(Staff _currentStaff){
        currentStaff=_currentStaff;
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
                    break;
                case 2:
                    handleShowTimes();
                    break;
                case 3:
                    handleSystemSettings();
                    break;
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
                            "\n3. Configure System Settings" +
                            "\n4. Exit\n");

            sc_in = main.sc.nextInt();
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
                    break;
                default:
                    System.out.println("Invalid input, please choose from the following:");
                    break;
            }

        } while (sc_in != 4);

    }

    private void handleShowTimes() {



    }


    private void handleMovieListings() {



    }


}
