import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * The review data object. Each object is an individual review
 */

public class Review implements Serializable {
    private String review;
    private double rating;
    private String date;
    private Client reviewer;
    private String movieName;

    public Review(String review, String movieName,double rating, Client reviewer) throws IllegalArgumentException {
        /**
 * The age of this student.
 */
        this.setReview(review);
        this.setRating(rating);
        this.movieName =movieName;
        this.reviewer = reviewer;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a, dd-MM-yyyy");
        this.date = formatter.format(calendar.getTime());

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
    public void setReview(String review) {
        if (review.isEmpty())
            throw new IllegalArgumentException("Review cannot be empty");
        this.review = review;
    }
    public void setRating(double rating) {
        if (rating >= 0) {
            if ( rating <= 5)
                this.rating = rating;
            else
                this.rating = 5;
        } else {this.rating = 0;}
    }
    public void setReviewer(Client reviewer) {
        if (this.reviewer == null)
            throw new IllegalArgumentException("Reviewer cannot be null");
        this.reviewer = reviewer;
    }
    //</editor-fold>

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }


}
