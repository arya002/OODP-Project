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
        System.out.println(client.getEmail());
        tickets = new ArrayList<>();
        this.client = client;
        this.showing = showing;
   } 

   public void addTicket(String age, int row, int column)
   {
        Seat seat = showing.getSeatingPlan().getSeat(row, column);
        int price = calculatePrice(age);
        if (client == null)
            System.out.println("client is null");
        if (seat == null)
            System.out.println("seat is null");
        if (showing == null)
            System.out.println("showing is null");
        
        System.out.println(price);
        tickets.add(new Ticket(client, seat, showing, price, age));
        seat.assignSeat(client.getUsername());
   }

   private int calculatePrice(String age)
   {
       int price = 0;
       if (age.equals("adult"))
            price += BASE_ADULT;
       else
            price += BASE_CHILD;

        if (showing.is3D())
            price += PREMIUM_MOVIE_MARKUP;
        if (showing.getMovie().isBlockbuster())
            price += PREMIUM_MOVIE_MARKUP;
        if (showing.getCinema().isPremium())
            price += PREMIUM_CINEMA_MARKUP;

        System.out.println("Your ticket costs " + price);
        return price;
   }

   public void completeBooking()
   {
       Booking booking = new Booking(tickets, client, showing);
       System.out.println("Your booking ID is " + booking.getBookingID());
       System.out.println("Your total amount owed is S$" + booking.getTotalPrice());

       ArrayList<Booking> bookings;
       if((bookings = (ArrayList<Booking>) Data.getInstance().getObjectFromPath(SaveLoadPath.BOOKING_PATH,
                Booking.class)) == null)
            bookings = new ArrayList<>();
       bookings.add(booking);
       Data.getInstance().saveObjectToPath(SaveLoadPath.BOOKING_PATH, bookings);
   }

   public static ArrayList<Booking> getBookings(){
       ArrayList<Booking> bookings = (ArrayList<Booking>) Data.getInstance().getObjectFromPath(SaveLoadPath.BOOKING_PATH, Booking.class);

       return bookings;
   }

   public ArrayList<Movie> getMoviesByTicketSales(){

       for(Ticket ticket:tickets){

           

       }

       return null;
   }
}