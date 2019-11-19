import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.HashMap;
/**
 * Individual ticket as an object
 */
public class Ticket implements Serializable {
    private Client client;
    private Showing showing;
    private Seat seat;
    private  String type;
    private double price;

/**
Create a new ticket
 * @param client takes in a client object
 @param seat takes a seat object, to identify which particular seat is to be booked
 @showing takes a showing object to indicate which timeslot, cinema and movie has been selected
 @price is the price of the ticket
 @age is the age of the client
 */
    public Ticket(Client client, Seat seat, Showing showing, double price, String age)
    {
        this.client = client;
        this.seat = seat;
        this.showing = showing;
        this.price = price;
        this.type = age;

    }

    public String getType() {
        return type;
    }

    //<editor-fold desc="Getters">
    public String getName()
    {
        return this.client.getFirstName();
    }

    public String getEmail()
    {
        return this.client.getEmail();
    }

    public String getPhoneNumbeString()
    {
        return this.client.getPhoneNum();
    }

    public String getDate() {
        return "";
    }

    public Client getClient() {
        return client;
    }

    public Seat getSeat() {
        return seat;
    }

    public String getShowingMovieName(){
        return showing.getMovie().getName();
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
/*
    public void print() {
        HashMap<String, String> fields =  new HashMap<>();
        fields.put("cineplex", showing.getCineplex().getName());
        fields.put("room", this.showing.getCinema().getType());
        fields.put("seat", this.seat.getSeatID());
        fields.put("type", this.seat.getType());
        fields.put("date", this.getDate());
        fields.put("price", Double.toString(this.price));
*/
//        TODO
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

