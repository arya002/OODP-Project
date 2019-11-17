import java.io.Serializable;
import java.util.*;

public class Showing implements Serializable {
    private Cinema cinema;
    private Movie movie;
    private String type;
    private String date;
    private Cineplex cineplex;
    private final SeatingPlan seatingPlan;

    /**
     *
     * @param cinema
     * @param cineplex
     * @param movie
     * @param date     = YYYYMMDDXY (X = DOTW, Y = TimeSlot)
     * @param type
     */
    //
    public Showing(final Cinema cinema, final Cineplex cineplex, final Movie movie, final String date,
            final String type) {
        this.setCinema(cinema);
        this.setMovie(movie);
        this.setDate(date);
        this.setType(type);
        this.setCineplex(cineplex);
        this.seatingPlan = new SeatingPlan(cinema.getRoomLayout());
    }

    public SeatingPlan getSeatingPlan() {
        return seatingPlan;
    }

    private void setCineplex(final Cineplex cineplex) {
        this.cineplex = cineplex;
    }

    public Cineplex getCineplex() {
        return cineplex;
    }

    public void setMovie(final Movie movie) {
        if (movie == null)
            throw new IllegalArgumentException("Movie cannot be null");
        this.movie = movie;
    }

    public String printShowing(){
        return (movie.getName() + " is playing at " + cineplex.getName() + " on "
                + (getDayOfWeek()) + " at " + getTimeSlotString(getTimeSlot()));
    }

    public String getTimeSlotString(int timeSlot) {
        switch (timeSlot) {
        case 1:
            return "10 am";
        case 2:
            return "1 pm";
        case 3:
            return "3 pm";
        case 4:
            return "6 pm";
        case 5:
            return "9 pm";
        default:
            return "";
        }
    }

    public void setDate(final String date) {

        this.date = date;
        // YYYYMMMDDXY
        // X = DOTW
        // Y = TIMESLOT

    }

    public void setCinema(final Cinema cinema) {
        if (cinema == null)
            throw new IllegalArgumentException("Cinema cannot be null");
        this.cinema = cinema;
    }

    public void setType(final String type) {
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
        return Integer.parseInt(date.substring(8,9));
    }

    public int getDay() {
        return Integer.parseInt(date.substring(6,8));
    }

    public int getTimeSlot() {
        return Integer.parseInt(date.substring(9));
    }

    public String getYYYYMMDD() {
        return date.substring(0,8);
    }

    public boolean isAllocated(int i, int j)
    {
        if (seatingPlan.getSeat(i, j).isAllocated())
            return true;
        return false;
    }
}