import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Booking implements Serializable{

    private ArrayList<Ticket> tickets;
    private Client client;
    private double totalPrice = 0;
    private Showing showing;
    private String bookingID;

    public Booking(ArrayList<Ticket> tickets, Client client, Showing showing) {
/**
 * Create a new booking
 *@param tickets list of tickets selected
  *@param client identity of client
   *@param showing particular timeslot of showing
   *It then timestamps and get the total price of the tickets for the customer.
 */
        this.tickets = tickets;
        this.client = client;
        this.showing = showing;

        for (Ticket ticket : tickets)
        {
            this.totalPrice += ticket.getPrice();
        }

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddhhmm");
        this.bookingID = showing.getCineplex().getName().substring(0, 3).toUpperCase() + format1.format(calendar.getTime());
    }
/**
 * Get Methods
 */
    public double getTotalPrice()
    {
        return totalPrice;
    }

    public String getBookingID()
    {
        return bookingID;
    }

    public Client getClient() {
        return client;
    }

    public ArrayList<Ticket> getTickets()
    {
        return tickets;
    }

    public String bookingPrint(){
        /**
 * Print the booking details in to format:
 * Booking ID
 *Client Name
 *Movie
 *Number of Tickets
 */
        String retString="";
        retString+= "Booking ID" + bookingID + "\n";
        retString+= "Customer " + client.getFirstName() + "\n";
        retString+= "Movie " + showing.getMovie().getName() + "\n";
        retString+= "For " + tickets.size() + " Tickets " + "\n";
        return retString;
    }
}
