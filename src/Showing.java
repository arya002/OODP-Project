import java.util.*;

public class Showing {
    private String cineplex;
    private int cinema;
    private String movie;
    private Date date;
    private SeatingPlan plan;

    public Showing(String cineplex, int room, String movie, RoomLayout layout, Date date) {
        this.cineplex = cineplex;
        this.cinema = room;
        this.movie = movie;
        this.plan = new SeatingPlan(layout);
        this.date = date;
    }

    public String getCineplex() {
        return cineplex;
    }

    public int getCinema() {
        return cinema;
    }

    public String getMovie() {
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
