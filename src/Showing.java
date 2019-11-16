import java.io.Serializable;
import java.util.*;

public class Showing implements Serializable {
    private Cinema cinema;
    private Movie movie;
    private String type;
    private Calendar date;
    private Cineplex cineplex;

    public Showing(Cinema cinema,Cineplex cineplex, Movie movie, RoomLayout layout, Calendar date, String type) {
        this.setCinema(cinema);
        this.setMovie(movie);
        this.setDate(date);
        this.setType(type);
        this.setCineplex(cineplex);
    }

    private void setCineplex(Cineplex cineplex) {
        this.cineplex = cineplex;
    }

    public Cineplex getCineplex() {
        return cineplex;
    }

    public void setMovie(Movie movie) {
        if (movie == null)
            throw new IllegalArgumentException("Movie cannot be null");
        this.movie = movie;
    }


    public void setDate(Calendar date) {
        if (date == null)
            throw new IllegalArgumentException("Date cannot be null");
        this.date = date;
    }

    public void setCinema(Cinema cinema) {
        if (cinema == null)
            throw new IllegalArgumentException("Cinema cannot be null");
        this.cinema = cinema;
    }

    public void setType(String type) {
        if (type.isEmpty())
            throw new IllegalArgumentException("Type cannot be empty");
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Cinema getCinema() {
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
