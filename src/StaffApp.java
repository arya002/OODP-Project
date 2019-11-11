import java.util.Random;
import java.util.Scanner;

public class StaffApp {

    Staff currentStaff;

    public StaffApp(Staff _currentStaff){
        currentStaff=_currentStaff;
    }

    private void run() {
        int sc_in;
        boolean loggedin = false;

        do {
            System.out.println("Welcome " + currentStaff.getFirstName());
            Scanner sc = new Scanner(System.in);
            sc_in = sc.nextInt();
            switch (sc_in) {
                case 1:
                    break;
                case 2:
//					TODO make guest
                    loggedin = true;
                    break;
                case 3:
                    loggedin = true;
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid input, please choose from the following:");
                    break;
            }

        } while (sc_in != 4 && !loggedin);
    }


}
