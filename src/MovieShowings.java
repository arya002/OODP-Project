package movie_booking_system;
import java.util.*;

public class MovieShowings {
    private String cineplex;
    private int cinema;
    private String movie;
    private Date date;

    public MovieShowings() {
        this.cineplex = "";
        this.cinema = 0;
        this.movie = "";
        this.date = new Date(100,01,01,00,00);
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
    public Date getDate() {
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
