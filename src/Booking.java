import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
/**
Is a booking object which holds the tickets, client, price, showing slot and identifying ID of a booking.
 */
public class Booking implements Serializable{

    private ArrayList<Ticket> tickets;
    private Client client;
    private double totalPrice = 0;
    private Showing showing;
    private String bookingID;

    /**
 * Create a new booking object
 *@param tickets list of tickets selected
  *@param client identity of client
   *@param showing particular timeslot of showing
   *It then timestamps and get the total price of the tickets for the customer.
 */
    public Booking(ArrayList<Ticket> tickets, Client client, Showing showing) {
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
 * Gets the total price of the tickets
 @return the price (double)
 */
    public double getTotalPrice()
    {
        return totalPrice;
    }
/**
 * Gets the id of booking
 @return the id as a string
 */
    public String getBookingID()
    {
        return bookingID;
    }
/**
 * Gets the client who made the booking
 @return client object
 */
    public Client getClient() {
        return client;
    }
/**
 * Gets the arraylist of tickets booked
 @return the tickets as an array list
 */
    public ArrayList<Ticket> getTickets()
    {
        return tickets;
    }
        /**
 * Print the booking details in to format:
 * Booking ID
 *Client Name
 *Movie
 *Number of Tickets
 */
    public String bookingPrint(){
        String retString="";
        retString+= "Booking ID " + bookingID + "\n";
        retString+= "Customer " + client.getFirstName() + "\n";
        retString+= "Movie " + showing.getMovie().getName() + "\n";
        retString+= "For " + tickets.size() /*+ " Tickets on the " + tickets.get(0).getDate()*/ +"\n";
        for(int i =0; i<tickets.size();i++) {
            retString += "\t"+tickets.get(i).getSeat().getSeatID()+" for " + tickets.get(i).getType() +" \n";
        }
        return retString;
    }
}
