import java.time.Instant;

public class Ticket {

    private String name;
    private String email;
    private String phoneNumber;
    private long ticketId;

    public Ticket(String name, String email, String phoneNumber)
    {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.ticketId = Instant.now().getEpochSecond();
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

    public long getTicketId()
    {
        return ticketId;
    }

    public void print() {

    }
}
