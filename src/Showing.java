import java.io.Serializable;
import java.util.*;

/**
* Represents a movie showing
*/
public class Showing implements Serializable {
    
    /**
    * Cinema where the showing would happen
    */
    private Cinema cinema;
    
    /**
    * Movie the showing would showcase
    */
    private Movie movie;
    
    /**
    * Represents whether the movie shown is 3D or not
    */
    private boolean is3D;
    
    /**
    * Date the showing would take place on
    */
    private String date;
    
    /**
    * Cineplex where the showing would take place
    */
    private Cineplex cineplex;
    
    /**
     * Type of the showing
     */
    private String type;
    
    /**
     * seating plan for the showing
     */
    private final SeatingPlan seatingPlan;



    /**
     * Creates a new showing
     * @param cinema Cinema where the showing would happen
     * @param cineplex Cineplex where the showing would take place
     * @param movie Movie the showing would showcase
     * @param date YYYYMMDDXY (X = DOTW, Y = TimeSlot)
     * @param type Type of the showing
     */
    public Showing(final Cinema cinema, final Cineplex cineplex, final Movie movie, final String date,
            final String type) {
        this.setCinema(cinema);
        this.setMovie(movie);
        this.setDate(date);
        this.setType(type);
        this.setCineplex(cineplex);
        this.seatingPlan = new SeatingPlan(cinema.getRoomLayout());
    }

    /**
     * Gets the seating plan
     */
    public SeatingPlan getSeatingPlan() {
        return seatingPlan;
    }

    /**
     * Changes the cineplex for the showing
     */
    private void setCineplex(final Cineplex cineplex) {
        this.cineplex = cineplex;
    }

    /**
     * Gets the cineplex for the showing
     */
    public Cineplex getCineplex() {
        return cineplex;
    }

    /**
     * Changes the movie for the showing
     * @param movie Movie object
     */
    public void setMovie(final Movie movie) {
        if (movie == null)
            throw new IllegalArgumentException("Movie cannot be null");
        this.movie = movie;
    }

    /**
     * Prints the showing
     */
    public String printShowing(){
        if(getMovie().getStatus() == Movie.Status.Showing || getMovie().getStatus() == Movie.Status.comingSoon) {
            return ((movie.isBlockbuster()? "": "The BlockBuster ")+ movie.getName() + (is3D ? "":" in 3D" ) + " is playing at " + cineplex.getName() + " on "
                    + (getDotwString(getDayOfWeek())) + " at " + getTimeSlotString(getTimeSlot())
                    + " on the " + getDDMMYYYYformatted() + " on screen " + cinema.getCinemaID());
        }
        return "this move is no longer showing";

    }

    /**
     * Gets the time slot for the showing
     * @param timeSlot Time slot for the showing
     */
    public String getTimeSlotString(int timeSlot) {
        switch (timeSlot) {
        case 0:
            return "10 am";
        case 1:
            return "1 pm";
        case 2:
            return "3 pm";
        case 3:
            return "6 pm";
        case 4:
            return "9 pm";
        default:
            return "";
        }
    }

    /**
     * Changes the date for the showing
     * @param date Date for the showing
     */
    public void setDate(final String date) {

        this.date = date;
        // YYYYMMMDDXY
        // X = DOTW
        // Y = TIMESLOT

    }

    /**
     * Changes the cinema for the showing
     * @param cinema Cinema object
     */
    public void setCinema(final Cinema cinema) {
        if (cinema == null)
            throw new IllegalArgumentException("Cinema cannot be null");
        this.cinema = cinema;
    }

    /**
     * Specifies whether the movie is 3D or not
     * @param is3D Specifies whether the movie is 3D or not
     */
    public void setType(final String is3D) {
        if (is3D.equalsIgnoreCase("yes"));
            this.is3D = true;
    }

    /**
     * Retuns the 3D status of the movie
     */
    public boolean is3D() {
        return is3D;
    }

    /**
     * Gets the cinema for the showing
     */
    public Cinema getCinema() {
        return cinema;
    }

    /**
     * Gets the movie of the showing
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Gets the date of the showing
     */
    public String getDate() {
        return date;
    }

    /**
     * Gets the day of the showing
     */
    public int getDayOfWeek() {
        return Integer.parseInt(date.substring(8, 9));
    }

    /**
     * Gets the date of the showing
     */
    public int getDay() {
        return Integer.parseInt(date.substring(6,8));
    }
    //YYYYMMDDXY

    /**
     * Gets the time slot of the showing
     */
    public int getTimeSlot() {
        return Integer.parseInt(date.substring(9));
    }

    /**
     * Gets the date in YYYYMMDD formate of the showing
     */
    public String getYYYYMMDD() {
        return date.substring(0,8);
    }

    /**
     * Gets the allocated status of a seat
     */
    public boolean isAllocated(int i, int j)
    {
        if (seatingPlan.getSeat(i, j).isAllocated())
            return true;
        return false;
    }

    public String getDotwString(int i){
        Cinema.DaysOfWeek[] dotw = Cinema.DaysOfWeek.values();
        return dotw[i].toString();

    }

    public String getDDMMYYYYformatted(){
        String string= "";
        string+= getDay() + "/";
        string+= date.substring(4,6) + "/";
        string+= date.substring(0,4);



        return string;
    }

    public void setIs3D(boolean is3D) {
        this.is3D = is3D;
    }
}
