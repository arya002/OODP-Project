import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.HashMap;

public class Ticket implements Serializable {
    private Client client;
    private Showing showing;
    private Seat seat;
    private enum type { child, adult }; 
    private double price;

    private static ArrayList<Integer> holidays;
    {
        holidays.add(359);
    }


    public Ticket(Client client, Seat seat, Showing showing, double price)
    {
        this.client = client;
        this.seat = seat;
        this.showing = showing;
        this.price = price;

        this.calculatePrice();
    }

    private void calculatePrice() {
        int age = this.client.getAge();
        if (age < 12) {
            this.price += 1;
        } else if (age < 65) {
            this.price += 4;
        } else {
            this.price += 1;
        }

        switch (this.showing.getDayOfWeek()) {
            case 1:
            case 2:
            case 3:
            case 4:
                for (Integer day : this.holidays) {
                    if (showing.getDay() == day) {
                        this.price += 2;
                        break;
                    } else {
                        this.price += 0;
                        break;
                    }
                }
            case 5:
            case 6:
            case 7:
                for (Integer day : this.holidays) {
                    if (showing.getDay() == day) {
                        this.price += 3;
                        break;
                    } else {
                        this.price += 2;
                        break;
                    }
                }
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

        switch (this.showing.getCinema().getType()) {
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

    public String getDate() {
        SimpleDateFormat ft = new SimpleDateFormat("hh:mm dd/MM/yyyy");
        return ft.format(this.showing.getDate());
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
        fields.put("cineplex", showing.getCineplex().getName());
        fields.put("room", this.showing.getCinema().getType());
        fields.put("seat", this.seat.getSeatID());
        fields.put("type", this.seat.getType());
        fields.put("date", this.getDate());
        fields.put("price", Double.toString(this.price));

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
}
