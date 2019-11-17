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

    public String printShowing(){
        return (movie.getName() + " is playing at " + cineplex.getName() + " on "
                + getDayOfWeekString(getDayOfWeek()) + " at " + getTimeSlotString(getTimeSlot()));
    }

    private String getTimeSlotString(int timeSlot) {
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

    public String getDayOfWeekString(int dotw) {
        switch (dotw) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7 :
                return "Sunday";
            default:
                return "";
        }

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
