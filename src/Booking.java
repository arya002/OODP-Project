import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Booking {

    private ArrayList<Ticket> tickets;
    private Client client;
    private int totalPrice = 0;
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
        this.bookingID = client.getName() + format1.format(calendar.getTime());
    }
}