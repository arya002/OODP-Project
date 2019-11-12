import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
    private String name;
    private String status;
    private String synopsis;
    private String director;
    private String[] cast;
    private double avg_rating;
    private ArrayList<Review> reviews;
    private ArrayList<Cineplex> locations;

    //<editor-fold desc="Constructors">
    public Movie(String name, String status, String synopsis, String director, String[] cast, ArrayList<Review> reviews, ArrayList<Cineplex> locations) throws IllegalArgumentException {
        if (reviews == null || locations == null)
                throw new IllegalArgumentException();

        this.setName(name);
        this.setStatus(status);
        this.setSynopsis(synopsis);
        this.setDirector(director);
        this.setCast(cast);


        this.reviews = reviews;
        this.locations = locations;
        this.calcAvg_rating();
    }

    public Movie(String name, String status, String synopsis, String director, String[] cast, ArrayList<Cineplex> locations) {
        this(name, status, synopsis, director, cast, new ArrayList<>(), locations);
    }
    //</editor-fold>

    public void addReview(Review review) {
        if (review == null) return;

        this.reviews.add(review);
        this.calcAvg_rating();
    }

    public void addCineplex(Cineplex cineplex) {
        if (cineplex == null) return;
        this.locations.add(cineplex);
    }

    public void removeCineplex(Cineplex cineplex) {
        if (cineplex == null) return;
        this.locations.remove(cineplex);
    }

    private void calcAvg_rating() {
        if (this.reviews.size() == 0) {return;}

        double total = 0;
        for (Review rev : this.reviews) {
            total += rev.getRating();
        }
        this.avg_rating = total/this.reviews.size();
    }

    //<editor-fold desc="Printers">
    public void print() {
        System.out.println(status);
        System.out.println("Name: " + name);
        System.out.println("Directed by: " + director);
        System.out.println("Starring: " + String.join(", ", cast));
        System.out.printf("Average rating: %.1f/5\n", avg_rating);
        System.out.println("\nSynopsis:\n" + synopsis);
        System.out.println();
        this.printReviews();
    }

    public void printLess() {
        System.out.println(status);
        System.out.println("Name: " + name);
        System.out.println("Directed by: " + director);
        System.out.println("Starring: " + String.join(", ", cast));
        System.out.printf("Average rating: %.1f/5\n", avg_rating);
        System.out.println("\nSynopsis:\n" + synopsis);
    }

    public void printReviews() {
        System.out.println("Reviews:");
        for (Review rev : this.reviews) {
            rev.print();
            System.out.println();
        }
    }

    public void printReviews(int n) {
        System.out.println("Reviews:");
        for (int i=0; i<n; i++) {
            this.reviews.get(i).print();
            System.out.println();
        }
    }
    //</editor-fold>

    //<editor-fold desc="Setters">
    public void setStatus(String status) {
        if (status.isEmpty())
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

    //<editor-fold desc="Getters">
    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public double getAvg_rating() {
        return avg_rating;
    }

    public String getDirector() {
        return director;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String[] getCast() {
        return cast;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public ArrayList<Cineplex> getLocations() {
        return locations;
    }
    //</editor-fold>
}
