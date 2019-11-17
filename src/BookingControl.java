import java.util.ArrayList;

public class BookingControl {

    private static int BASE_ADULT = 10;
    private static int BASE_CHILD = 7;
    private static int HOLIDAY_MARKUP = 2;
    private static int PREMIUM_MOVIE_MARKUP = 1;
    private static int PREMIUM_CINEMA_MARKUP = 3;

    private Client client;
    private Showing showing;
    private ArrayList<Ticket> tickets;

   public BookingControl(Client client, Showing showing)
   {
        tickets = new ArrayList<>();
        this.client = client;
        this.showing = showing;
   } 

   public void addTicket(String age, int row, int column)
   {
       Seat seat = showing.getSeatingPlan().getSeat(row, column);
       int price = calculatePrice(age);
        tickets.add(new Ticket(client, seat, showing, price));
   }

   private int calculatePrice(String age)
   {
       //TODO calculate price
        return 5;
   }

   public void completeBooking()
   {
       Booking booking = new Booking(tickets, client, showing);
       System.out.println("Your booking ID is " + booking.getBookingID());
       System.out.println("Your total amount owed is S$" + booking.getTotalPrice());

       Data data = Data.getInstance();
       ArrayList<Booking> bookings = (ArrayList<Booking>) data.getObjectFromPath(SaveLoadPath.BOOKING_PATH, Booking.class);
       bookings.add(booking);
       Data.getInstance().saveObjectToPath(SaveLoadPath.BOOKING_PATH, bookings);
   }
}