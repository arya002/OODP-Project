import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Controls the booking of a user
 */
public class BookingControl {

    private Client client;
    private Showing showing;
    private static ArrayList<Ticket> tickets;
    public static ArrayList<String> holidays;
    private static Prices prices = null;

    /**
     * Initialises the class. Creates arrays of empty tickets for holding on later, set the client and particular showing he/she wants
     *
     * @param client  is a client object
     * @param showing is a showing object
     */
    public BookingControl(Client client, Showing showing) {
        //System.out.println(client.getEmail());

        tickets = new ArrayList<>();
        this.client = client;
        this.showing = showing;
        Initialize();
    }

    /**
     * Loads the prices from file
     */
    public static void Initialize() {

        ArrayList<Prices> inte;
        if ((inte = (ArrayList<Prices>) Data.getObjectFromPath(SaveLoadPath.PRICE_PATH, Prices.class)) == null) {
            inte = new ArrayList<>();
        } else {
            prices = inte.get(0);
        }
    }

    /**
     * Add a new ticket. Will deduce the price and assign the selected seat to the client
     *
     * @param age    is a string of either adult or child.
     * @param row    Row of the seat the user wants
     * @param column Column of the seat the user wants
     */
    public void addTicket(String age, int row, int column) {
        Seat seat = showing.getSeatingPlan().getSeat(row, column);
        seat.setSeatID(String.valueOf((char) (row + 65)) + String.valueOf(column + 1));
        int price = calculatePrice(age);

        if (client == null)
            System.out.println("You must Log In to buy Tickets");
        while (client == null) {
            User lis = new LoginScreen().run();
            if (lis.getType().equals("client"))
                client = (Client) lis;
        }
        if (seat == null)
            System.out.println("seat is null");
        if (showing == null)
            System.out.println("showing is null");

        tickets.add(new Ticket(client, seat, showing, price, age));
        seat.assignSeat(client.getUsername());

    }

    /**
     * Calculates the price of a ticket. First checks if its adult or child
     * Then, it addons any markups, such as premium tickets or weekends/holiday prices
     */
    private int calculatePrice(String age) {
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
        if (showing.getDayOfWeek() == 5 || showing.getDayOfWeek() == 6 || prices.getHOLIDAYS().contains(showing.getYYYYMMDD()))
            ;
        price += prices.getHOLIDAY_MARKUP();

        System.out.println("Your ticket costs S$" + price);
        return price;
    }

    /**
     * Prints the details of a confirmed booking.
     * Saves the booking to file
     */
    public void completeBooking() {
        Booking booking = new Booking(tickets, client, showing);
        if (!booking.getTickets().isEmpty()) {
            System.out.println();
            System.out.println("Thank you for booking with us! To view your bookings please look at your booking history.");
            System.out.println("Your booking ID is " + booking.getBookingID());
            System.out.println("Your total amount owed is S$" + booking.getTotalPrice());
            System.out.println();

            ArrayList<Booking> bookings;
            if ((bookings = (ArrayList<Booking>) Data.getInstance().getObjectFromPath(SaveLoadPath.BOOKING_PATH,
                    Booking.class)) == null)
                bookings = new ArrayList<>();
            bookings.add(booking);
            Data.getInstance().saveObjectToPath(SaveLoadPath.BOOKING_PATH, bookings);
        }

    }

    /**
     * Loads an arraylist of bookings from file
     */
    public static ArrayList<Booking> getBookings() {
        return (ArrayList<Booking>) Data.getObjectFromPath(SaveLoadPath.BOOKING_PATH, Booking.class);

    }

}
