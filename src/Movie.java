import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
    private String name;
    private Status status;
    private String synopsis;
    private String director;
    private String[] cast;
    private String locations;
    private String Reviews;
    private double avgRating;


    public enum Status{
        notShowing,preview,Showing
    }

    //<editor-fold desc="Constructors">
    public Movie(String name, Status status, String synopsis, String director, String[] cast, ArrayList<Review> reviews, ArrayList<Cineplex> locations) throws IllegalArgumentException {
        if (reviews == null || locations == null)
                throw new IllegalArgumentException();

        this.setName(name);
        this.setStatus(status);
        this.setSynopsis(synopsis);
        this.setDirector(director);
        this.setCast(cast);
        //this.locations = locations;
        //this.calcAvg_rating();
    }


    public Movie(String name, Status status, String synopsis, String director, String[] cast, ArrayList<Cineplex> locations) {
        this(name, status, synopsis, director, cast, new ArrayList<>(), locations);
    }
    //</editor-fold>

    public void addReviews(){


    }


//    public void addCineplex(Cineplex cineplex) {
//        if (cineplex == null) return;
//        this.locations.add(cineplex);
//    }
//
//    public void removeCineplex(Cineplex cineplex) {
//        if (cineplex == null) return;
//        this.locations.remove(cineplex);
//    }

    //<editor-fold desc="Printers">

    public void print() {
        System.out.println(status);
        System.out.println("Name: " + name);
        System.out.println("Directed by: " + director);
        System.out.println("Starring: " + String.join(", ", cast));
        System.out.println("\nSynopsis:\n" + synopsis);
        System.out.println();
    }

    //</editor-fold>

    //<editor-fold desc="Setters">
    public void setStatus(Status status) {
        if (status == null)
            throw new IllegalArgumentException("Status cannot be empty");
        this.status = status;
    }

    public void setName(String name) {
        if (name.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    public void setCast(String[] cast) {
        if (cast == null)
            throw new IllegalArgumentException("Cast cannot be empty");
        this.cast = cast;
    }

    public void setSynopsis(String synopsis) {
        if (synopsis.isEmpty())
            throw new IllegalArgumentException("Synopsis cannot be empty");
        this.synopsis = synopsis;
    }

    public void setDirector(String director) {
        if (director.isEmpty())
            throw new IllegalArgumentException("Director cannot be empty");
        this.director = director;
    }
    //</editor-fold>

    public String getDirector() {
        return director;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public String[] getCast() {
        return cast;
    }

    public double getAvgRating(){return avgRating;}

    public void setAvgRating(Double avgRating){this.avgRating = avgRating;}

    public String getSynopsis() {
        return synopsis;
    }

//    public ArrayList<Cineplex> getLocations() {
//        return locations;
//    }
    //</editor-fold>
}
