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
        this.calcAvg_rating();
    }

    public Movie(String name, String status, String synopsis, String director, String[] cast) {
        this(name, status, synopsis, director, cast, null);
    }

    public void addReview(Review review) {
        this.reviews.add(review);
        this.calcAvg_rating();
    }

    public void print() {
        System.out.println(status);
        System.out.println("Name: " + name);
        System.out.println("Directed by: " + director);
        System.out.println("Starring: " + String.join(", ", cast));
        System.out.println("Average rating: " + avg_rating);
        System.out.println("\nSynopsis:\n" + synopsis);
        System.out.println();
        this.printReviews(this.reviews.size());;
    }

    public void printLess() {
        System.out.println(status);
        System.out.println("Name: " + name);
        System.out.println("Directed by: " + director);
        System.out.println("Starring: " + String.join(", ", cast));
        System.out.println("Average rating: " + avg_rating);
        System.out.println("\nSynopsis:\n" + synopsis);
    }

    public void printReviews(int n) {
        System.out.println("Reviews:");
        for (int i=0; i<n; i++) {
            this.reviews.get(i).print();
        }
    }

    private void calcAvg_rating() {
        if (this.reviews.size() == 0) {return;}

        double total = 0;
        for (Review rev : this.reviews) {
            total += rev.getRating();
        }
        this.avg_rating = total/this.reviews.size();
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
