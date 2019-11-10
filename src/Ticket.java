import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.HashMap;

public class Ticket implements Serializable {

    private String name;
    private String email;
    private String phoneNumber;
    private String date;
    private String ticketId;
    private Seat seat;
    private double price;

    public Ticket(String name, String email, String phoneNumber, Seat seat, String cineplex)
    {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.seat = seat;

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddhhmm");
        this.ticketId = cineplex + format1.format(calendar.getTime());

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        this.date = formatter.format(calendar.getTime());
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name; 
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhoneNumbeString()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String  getTicketId()
    {
        return ticketId;
    }

    public void assignSeat(Seat seat) {
        this.seat = seat;
    }

    public void print() {
        HashMap<String, String> fields =  new HashMap<>();
        fields.put("name", this.name);
        fields.put("email", this.email);
        fields.put("phone", this.phoneNumber);
        fields.put("TID", this.ticketId);
//        TODO  fields.put("cineplex", );
//        TODO  fields.put("room", );
        fields.put("seat", Integer.toString(this.seat.getSeatID()));
        fields.put("type", this.seat.getType());
        fields.put("date", this.date);
        fields.put("price", Double.toString(this.price));

//        ++++++++++++++++++++++++
//        +  name:     name      +
//        +  email:    email     +
//        +  phone:    number    +
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
