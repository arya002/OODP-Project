import java.io.Serializable;
import java.util.ArrayList;

/**
Implements the movie object
 */
public class Movie implements Serializable {
    private String name;
    private Status status;
    private String synopsis;
    private String director;
    private String[] cast;
    private boolean isBlockbuster;
    private double avg_rating;
    private String rating;
    private double howManyReviews;
    //private ArrayList<Review> movieReviews;
    
    /**
    Status of the movie: Showing, coming soon, currently showing
 */
    public enum Status{
        notShowing{
            @Override
            public String toString() {
                return "Not Showing";
            }
        },comingSoon{
            @Override
            public String toString() {
                return "Coming Soon";
            }
        },Showing{
            @Override
            public String toString() {
                return "Currently Showing";
            }
        };
        public static int size =3;
    }
    //<editor-fold desc="Constructors">
    /**
Create a new movie object
@param name name of the movie
@param status Status of the movie: Showing, not showing etc
@param synopsis The summary of a movie as a string
@param director The director of the movie as a string
@param cast The cast of a movie as a string
 */
    public Movie(String name, Status status, String synopsis, String director,String rating, String[] cast) {
        this.setName(name);
        this.setStatus(status);
        this.setSynopsis(synopsis);
        this.setDirector(director);
        this.setCast(cast);
        //movieReviews = new ArrayList<>();
        this.rating = rating;
        this.isBlockbuster = false;

    }
/**
Check is movie is a blockbuster
@return a boolean on whether it is
 */
    public boolean isBlockbuster() {
        return isBlockbuster;
    }

    /**
Sets the status 
@param status is a status object
 */
    public void setStatus(Status status) {
        if (status == null)
            throw new IllegalArgumentException("Status cannot be empty");
        this.status = status;
    }
/**Sets the name
@param name Takes a string name of the movie
 */
    public void setName(String name) {
        if (name.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }
/**Sets the cast
@param cast Takes a string of the casts
 */
    public void setCast(String[] cast) {
        if (cast == null)
            throw new IllegalArgumentException("Cast cannot be empty");
        this.cast = cast;
    }
/**Change the sunopsis
@param synopsis a string description of the movie
 */
    public void setSynopsis(String synopsis) {
        if (synopsis.isEmpty())
            throw new IllegalArgumentException("Synopsis cannot be empty");
        this.synopsis = synopsis;
    }
/**Sets the director
@param director Takes the string of the director of a movie
 */
    public void setDirector(String director) {
        if (director.isEmpty())
            throw new IllegalArgumentException("Director cannot be empty");
        this.director = director;
    }
    //</editor-fold>
/**Get the director
@return Gives the string director name
 */
    public String getDirector() {
        return director;
    }
/**Get the name
@return the name of the movie as string
 */
    public String getName() {
        return name;
    }

    public void setBlockbuster(boolean isBlockbuster){this.isBlockbuster = isBlockbuster;}
/**Get the status
@return Status object of the movie
 */
    public Status getStatus() {
        return status;
    }
/**Get the cast
@return the string list of casts
 */
    public String[] getCast() {
        return cast;
    }
/**Get the synopsis
@return the description of the movie as string
 */
    public String getSynopsis() {
        return synopsis;
    }

    //</editor-fold>

}
