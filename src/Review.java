import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Review {
    private String review;
    private double rating;
    private String date;
    private Client reviewer;

    public Review(String file) {
//        TODO load from file.
//        this(attrs);
    }

    public Review(String review, double rating, Client reviewer) {
        this.review = review;
        if (rating >= 0) {
                if ( rating <= 5)
                    this.rating = rating;
                else
                    this.rating = 5;
        } else {this.rating = 0;}

        this.reviewer = reviewer;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a, dd-MM-yyyy");
        this.date = formatter.format(calendar.getTime());
    }

    public void print() { // print review
        System.out.println("Review by: " + this.reviewer.getUsername());
        System.out.println("Date: " + this.date);
        System.out.printf("❀".repeat((int) rating) + ", %.1f/5\n\n", rating);
        System.out.println("Review:\n" + review);
    }

    //<editor-fold desc="Getters">
    public double getRating() {
        return rating;
    }
    
    public String getReview(){
        return review;
    }

    public Client getReviewer() {
        return reviewer;
    }

    public String getDate() {
        return date;
    }
    //</editor-fold>

    //<editor-fold desc="mutators">
    public void changeReview(String review) {
        this.review = review;
    }
    public void changeRating(double rating) {
        this.rating = rating;
    }
    public void changeReviewer(Client reviewer) {
        this.reviewer = reviewer;
    }
    public void changeDate(String date) {
        this.date = date;
    }
    //</editor-fold>
}
