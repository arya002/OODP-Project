import java.util.ArrayList;
import java.util.Scanner;
/**
Booking Application which would display the booking screen
 */
public class BookingApp
{
    private Client client;
    private Showing showing;
/**
Takes the client and particular showing and run main method which would display the screen
 */
    public BookingApp(Client client, Showing showing)
    {
        this.client = client;
        this.showing = showing;
        main();
    }
/**
Runs the interface to process a booking. E.g. asking for a user's age class, choose seats etc.
Note: NOT the main method of this project
 */
    public void main()
    {
        Scanner sc = new Scanner(System.in);
        if (!showing.getMovie().getStatus().equals(Movie.Status.notShowing))
        {
        System.out.println("Would you like to purchase a ticket? (Yes/No)");
        String anotherTicket = sc.nextLine();
        BookingControl bookingControl = new BookingControl(client, showing);

        while (anotherTicket.equalsIgnoreCase("yes"))
        { 
            System.out.println("Is this an adult or a child ticket?");
            String age = sc.nextLine();

            System.out.println("Legend : U for unavailable, P for premuim, N for normal");
            ShowingControl.printSeats(showing);

            System.out.println("\n\n");
            System.out.println("Please enter the row of your chosen seat (letter):");
            int column = (int)(sc.nextLine().toUpperCase().charAt(0)) - 65;
            System.out.println("Please enter the column of your chosen seat (number):");
            int row = Integer.parseInt(sc.nextLine()) - 1;

            if (confirmSeat(row, column))
            {
                bookingControl.addTicket(age, row, column);
                System.out.println("Your ticket has been added to the booking");
            }
            else
            {
                System.out.println("This seat is unavailable");
            }

            System.out.println("Would you like to add another ticket? (Yes/No)");
            anotherTicket = sc.nextLine();
        }
        
        bookingControl.completeBooking();
    }
    else
    {
        System.out.print("Movie not currently showing");
    }
    }
/**
Checks if seat allocation is successful
@return a boolean on the success(or failure) of allocation
 */
    public boolean confirmSeat(int row, int column)
    {
        if (!ShowingControl.isAllocated(showing, row, column))
            return true;
        else
            return false;
    }
}
