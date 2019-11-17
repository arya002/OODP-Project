import java.io.Serializable;
import java.util.*;

public class Showing implements Serializable {
    private Cinema cinema;
    private Movie movie;
    private String type;
    private String date;
    private Cineplex cineplex;
    private SeatingPlan seatingPlan;

    /**
     *
     * @param cinema
     * @param cineplex
     * @param movie
     * @param date = YYYYMMDDXY (X = DOTW, Y = TimeSlot)
     * @param type
     */
    //
    public Showing(Cinema cinema,Cineplex cineplex, Movie movie, String date, String type) {
        this.setCinema(cinema);
        this.setMovie(movie);
        this.setDate(date);
        this.setType(type);
        this.setCineplex(cineplex);
        this.seatingPlan = new SeatingPlan(cinema.getRoomLayout());
    }

    public SeatingPlan getSeatingPlan()
    {
        return seatingPlan;
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


    public void setDate(String date) {

        this.date = date;
        //YYYYMMMDDXY
        // X = DOTW
        // Y = TIMESLOT

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

    public String getDate() {
        return date;
    }

    public int getDayOfWeek() {
        return Integer.parseInt(date.substring(8));
    }

    public int getDay() {
        return Integer.parseInt(date.substring(5,7));
    }

    public int getTimeSlot() {
        return Integer.parseInt(date.substring(9));
    }

    public int getYYYYMMDD() {
        return Integer.parseInt(date.substring(0,7));
    }

    public boolean isAllocated(int i, int j)
    {
        if (seatingPlan.getSeat(i, j).isAllocated())
            return true;
        return false;
    }

}
