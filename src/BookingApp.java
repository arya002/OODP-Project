import java.util.ArrayList;
import java.util.Scanner;

public class BookingApp
{
    private Client client;
    private Showing showing;

    public BookingApp(Client client, Showing showing)
    {
        this.client = client;
        this.showing = showing;
        main();
    }

    public void main()
    {
        Scanner sc = new Scanner(System.in);
        int totalPrice = 0;

        System.out.println("Would you like to purchase a ticket? (Yes/No)");
        String anotherTicket = sc.nextLine();
        BookingControl bookingControl = new BookingControl(client, showing);

        while (anotherTicket.equalsIgnoreCase("yes"))
        {
            //TODO check that there are spaces available 
            System.out.println("Is this an adult or a child ticket?");
            String age = sc.nextLine();

            System.out.println("U vor unavailable, P for premuim, N for normal");
            ShowingControl.printSeats(showing);

            System.out.println("Please enter the row of your chosen seat:");
            int row = Integer.parseInt(sc.nextLine());
            System.out.println("Please enter the column of your chosen seat:");
            int column = Integer.parseInt(sc.nextLine());

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

    public boolean confirmSeat(int row, int column)
    {
        if (!ShowingControl.isAllocated(showing, row, column))
            return true;
        else
            return false;
    }
}