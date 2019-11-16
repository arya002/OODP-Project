import java.util.*;

/**
 * Deals with arrays of reviews
 *
 *
 */

public class ReviewControl {

    public static ArrayList<Review> allReviews = new ArrayList<>();

    public ReviewControl() {

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
