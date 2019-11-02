import java.util.ArrayList;

public class Movie {
    private String name;
    private String status;
    private String synopsis;
    private String director;
    private String[] cast;
    private double avg_rating;
    private ArrayList<Review> reviews;

    public Movie(String file){
//        TODO load from file
//        this(args);
    }

    public Movie(String name, String status, String synopsis, String director, String[] cast, ArrayList<Review> reviews) {
        this.name = name;
        this.status = status;
        this.synopsis = synopsis;
        this.director = director;
        this.cast = cast;
        this.reviews = reviews;
    }

    public Movie(String name, String status, String synopsis, String director, String[] cast) {
        this(name, status, synopsis, director, cast, null);
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void print() {
        System.out.println(status);
        System.out.println("Name: " + name);
        System.out.println("Directed by: " + director);
        System.out.println("Starring: " + String.join(", ", cast));
        System.out.println("Average rating:" + avg_rating);
        System.out.println("Synopsis:\n" + synopsis);
        System.out.println("Revies:");
        for (Review rev : reviews) {
            rev.print();
        }
    }

    //<editor-fold desc="Setters/modifiers">
    public void changeStatus(String status) {
//          TODO check access level
        this.status = status;
    }

    public void changeName(String name) {
//        TODO check access level
        this.name = name;
    }

    public void changeCast(String[] cast) {
//        TODO check access level
        this.cast = cast;
    }

    public void changeSynopsis(String synopsis) {
//        TODO check access level
        this.synopsis = synopsis;
    }

    public void changeDirector(String director) {
//        TODO check access level
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
    //</editor-fold>
}
