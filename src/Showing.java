import java.io.Serializable;
import java.util.*;

public class Showing implements Serializable {
    private String cineplex;
    private Movie movie;
    private String type;
    private String room_type;
    private Date date;
    private SeatingPlan plan;
    private String cinema;

    public Showing(String cineplex, Movie movie, RoomLayout layout, Date date, String type) {
        this.cineplex = cineplex;
        this.movie = movie;
        this.plan = new SeatingPlan(layout);
        this.date = date;
        this.cinema = layout.getName();
        this.type = type;
        this.room_type = layout.getType();
    }

    public String getRoom_type() {
        return room_type;
    }

    public String getType() {
        return type;
    }

    public String getCineplex() {
        return cineplex;
    }

    public String getCinema() {
        return cinema;
    }

    public Movie getMovie() {
        return movie;
    }
    // date stores time as well
    public Date getDateObject() {
        return date;
    }
    // redundant functions, can get all this from getDate()
    public int getDate() {
        return date.getDate();
    }

    public int getMonth() {
        return date.getMonth();
    }

    public int getYear() {
        return date.getYear();
    }

    public int getHrs() {
        return date.getHours();
    }

    public int getMinutes() {
        return date.getMinutes();
    }
}
