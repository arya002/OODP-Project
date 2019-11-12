import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class Ticket implements Serializable {

    private Client client;
    private Showing showing;
    private String ticketId;
    private Seat seat;
    private double price;

    public Ticket(Client client, Seat seat, Showing showing)
    {
        this.client = client;
        this.seat = seat;
        this.showing = showing;

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddhhmm");
        this.ticketId = showing.getCinema() + format1.format(calendar.getTime());

        this.calculatePrice();
    }

    private void calculatePrice() {
        this.price = 0;
        int age = this.client.getAge();
        if (age < 12) {
            this.price += 1;
        } else if (age < 65) {
            this.price += 4;
        } else {
            this.price += 1;
        }

        switch (this.showing.getType()) {
            case "3D":
                this.price += 1;
                break;
            case "Blockbuster":
                this.price += 2;
                break;
            case "Normal":
                this.price += 0;
                break;
            default:
                break;
        }

        switch (this.seat.getType()) {
            case "Premium":
                this.price += 3;
                break;
            case "Love":
                this.price += 2;
                break;
            case "Normal":
                this.price += 1;
                break;
            default:
                break;
        }

        switch (this.showing.getRoom_type()) {
            case "Platinum Movie Suites":
                this.price += 4;
                break;
            case "Normal":
                this.price += 1;
                break;
            default:
                break;
        }
    }

    //<editor-fold desc="Getters">
    public String getName()
    {
        return this.client.getName();
    }

    public String getEmail()
    {
        return this.client.getEmail();
    }

    public String getPhoneNumbeString()
    {
        return this.client.getPhoneNum();
    }

    public String  getTicketId()
    {
        return ticketId;
    }

    public int getDate() {
        return this.showing.getDate();
    }

    public Client getClient() {
        return client;
    }

    public Seat getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }
    //</editor-fold>

    //<editor-fold desc="Mutators">
    public void assignSeat(Seat seat) {
        this.seat = seat;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//</editor-fold>

    public void print() {
        HashMap<String, String> fields =  new HashMap<>();
        fields.put("TID", this.ticketId);
        fields.put("cineplex", showing.getCineplex());
        fields.put("room", this.showing.getCinema());
        fields.put("seat", Integer.toString(this.seat.getSeatID()));
        fields.put("type", this.seat.getType());
        fields.put("date", Integer.toString(this.getDate()));
        fields.put("price", Double.toString(this.price));

//        ++++++++++++++++++++++++
//        +  TID:      Id        +
//        +  cineplex: cineplex  +
//        +  room:     cinema    +
//        +  seat:     Id        +
//        +  type:     type      +
//        +  date:     date      +
//        +  price:    price     +
//        ++++++++++++++++++++++++
    }
}
