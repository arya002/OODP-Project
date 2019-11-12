import java.io.Serializable;
import java.util.*;

public class Showing implements Serializable {
    private String cineplex;
    private Movie movie;
    private String type;
    private String room_type;
    private Calendar date;
    private SeatingPlan plan;
    private String cinema;

    public Showing(String cineplex, Movie movie, RoomLayout layout, Calendar date, String type) {
        this.setCineplex(cineplex);
        this.setCinema(cinema);
        this.setMovie(movie);
        this.setDate(date);
        this.setType(type);
        this.setRoom_type(layout.getType());

        this.plan = new SeatingPlan(layout);
    }

    //<editor-fold desc="Setters">
    public void setCineplex(String cineplex) {
        if (cineplex.isEmpty())
            throw new IllegalArgumentException("Cineplex cannot be empty");
        this.cineplex = cineplex;
    }

    public void setMovie(Movie movie) {
        if (movie == null)
            throw new IllegalArgumentException("Movie cannot be null");
        this.movie = movie;
    }

    public void setPlan(SeatingPlan plan) {
        if (plan == null)
            throw new IllegalArgumentException("Seatingplan cannot be null");
        this.plan = plan;
    }

    public void setDate(Calendar date) {
        if (date == null)
            throw new IllegalArgumentException("Date cannot be null");
        this.date = date;
    }

    public void setCinema(String cinema) {
        if (cinema.isEmpty())
            throw new IllegalArgumentException("Cinema cannot be null");
        this.cinema = cinema;
    }

    public void setType(String type) {
        if (type.isEmpty())
            throw new IllegalArgumentException("Type cannot be empty");
        this.type = type;
    }

    public void setRoom_type(String room_type) {
        if (room_type.isEmpty())
            throw new IllegalArgumentException("Roomtype cannot be empty");
        this.room_type = room_type;
    }
    //</editor-fold>

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

    public Date getDate() {
        return date.getTime();
    }

    public String getDateString() {
        return this.date.toString();
    }

    public int getDayOfWeek() {
        return this.date.DAY_OF_WEEK;
    }

    public int getDay() {
        return this.date.DAY_OF_YEAR;
    }
}
