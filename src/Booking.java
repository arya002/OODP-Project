import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Booking {

    private ArrayList<Ticket> tickets;
    private Client client;
    private double totalPrice = 0;
    private Showing showing;
    private String bookingID;

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
        this.bookingID = showing.getCineplex().getName() + format1.format(calendar.getTime());
    }

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

    public String bookingPrint(){
        String retString="";
        retString+= "Booking ID" + bookingID + "\n";
        retString+= "Customer " + client.getName() + "\n";
        retString+= "Movie " + showing.getMovie().getName() + "\n";
        retString+= "For " + tickets.size() + " Tickets " + "\n";
        return retString;
    }
}