import java.util.*;

/**
 * Deals with arrays of reviews
 *
 *
 */

public class ReviewControl {

    public static ArrayList<Review> allReviews = new ArrayList<>();
    private static ReviewControl sSoleInstance;

    private ReviewControl() {

    }

    public static ReviewControl getInstance() {
        if (sSoleInstance == null) { //if there is no instance available... create new one
            sSoleInstance = new ReviewControl();
        }

        return sSoleInstance;
    }

    public static ArrayList<Review> getAllReviews() {

        return allReviews;

    }

    public static ArrayList<String> getAllReviewsNames() {

        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Review> allReviews = getAllReviews();

        for (int i =0; i < allReviews.size();i++){

            arrayList.add(allReviews.get(i).getMovieName());

        }
        return arrayList;

    }

    public static ArrayList<String> getAllReviewsNames(ArrayList<Review> customReviews) {

        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Review> allReviews = customReviews;

        for (int i =0; i < allReviews.size();i++){

            arrayList.add(allReviews.get(i).getMovieName());

        }
        return arrayList;

    }


    public static void addReview(Review review) {

        allReviews.add(review);
        new Review(review.getReview(), review.getMovieName(), review.getRating(), review.getReviewer());


    }



}
