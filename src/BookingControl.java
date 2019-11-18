import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BookingControl {

    private Client client;
    private Showing showing;
    private static ArrayList<Ticket> tickets;
    public static ArrayList<String> holidays;
    private static Prices prices = null;


   public BookingControl(Client client, Showing showing)
   {
        //System.out.println(client.getEmail());

        tickets = new ArrayList<>();
        this.client = client;
        this.showing = showing;
        Initialize();
   } 

   public static void Initialize(){
       
            ArrayList<Prices> inte;
            if((inte = (ArrayList<Prices>) Data.getObjectFromPath(SaveLoadPath.PRICE_PATH, Prices.class)) == null){
                inte = new ArrayList<>();
            }
            else
            {
                prices = inte.get(0);
            }
   }

   public void addTicket(String age, int row, int column)
   {
        Seat seat = showing.getSeatingPlan().getSeat(row, column);
        int price = calculatePrice(age);

        if (client == null)
            System.out.println("client is null");
            while (client == null){
                User lis = new LoginScreen().run();
                client = (Client) lis;
            }
        if (seat == null)
            System.out.println("seat is null");
        if (showing == null)
            System.out.println("showing is null");
        
        tickets.add(new Ticket(client, seat, showing, price, age));
        seat.assignSeat(client.getUsername());

   }

   private int calculatePrice(String age)
   {
       int price = 0;
       if (age.equals("adult"))
            price += prices.getBASE_ADULT();
       else
            price += prices.getBASE_CHILD();

        if (showing.is3D())
            price += prices.getPREMIUM_MOVIE_MARKUP();
        if (showing.getMovie().isBlockbuster())
            price += prices.getPREMIUM_MOVIE_MARKUP();
        if (showing.getCinema().isPremium())
            price += prices.getPREMIUM_CINEMA_MARKUP();
        if (showing.getDayOfWeek() == 5 || showing.getDayOfWeek() == 6 || prices.getHOLIDAYS().contains(showing.getYYYYMMDD()));
            price += prices.getHOLIDAY_MARKUP();

        System.out.println("Your ticket costs S$" + price);
        return price;
   }

   public void completeBooking()
   {
       Booking booking = new Booking(tickets, client, showing);
       System.out.println();
       System.out.println("Thank you for booking with us! To view your bookings please look at your booking history.");
       System.out.println("Your booking ID is " + booking.getBookingID());
       System.out.println("Your total amount owed is S$" + booking.getTotalPrice());
       System.out.println();

       ArrayList<Booking> bookings;
       if((bookings = (ArrayList<Booking>) Data.getInstance().getObjectFromPath(SaveLoadPath.BOOKING_PATH,
                Booking.class)) == null)
            bookings = new ArrayList<>();
       bookings.add(booking);
       Data.getInstance().saveObjectToPath(SaveLoadPath.BOOKING_PATH, bookings);
   }

   public static ArrayList<Booking> getBookings(){
       return (ArrayList<Booking>) Data.getObjectFromPath(SaveLoadPath.BOOKING_PATH, Booking.class);

   }

}