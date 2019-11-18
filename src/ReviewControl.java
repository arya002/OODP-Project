import java.util.*;

/**
 * Deals with arrays of reviews and various methods to process them
 *
 *
 */

public class ReviewControl {

    public static ArrayList<Review> allReviews = new ArrayList<>();
    
/**
 * Get all the reviews from the file
 */
    public static ArrayList<Review> getAllReviews() {

        return (ArrayList<Review>) Data.getInstance().getObjectFromPath(SaveLoadPath.REVIEW_PATH,Review.class);

    }
    /**
 * Ran at the start of program to load reviews from file.
 */
    public static void Reinitialize(){
        if ((allReviews = (ArrayList<Review>) Data.getInstance().getObjectFromPath(SaveLoadPath.REVIEW_PATH,Review.class)) == null){
            allReviews = new ArrayList<>();
        }
    }

    /**
 * @returns an array of movies that have reviews
 */
    public static ArrayList<String> getAllReviewsNames() {

        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Review> allReviews = getAllReviews();

        for (int i =0; i < allReviews.size();i++){

            arrayList.add(allReviews.get(i).getMovieName());

        }
        return arrayList;

    }

    public static void print(Review review) { // print review
        System.out.println("Review by: " + review.getReviewer().getUsername());
        System.out.println("Movie: " + review.getMovieName());
        System.out.println("Date: " + review.getDate());
        //System.out.printf("*".repeat((int) rating) + ", %.1f/5\n\n", rating);
        System.out.println("Review:\n" + review.getReview());
    }
    
    /**
 * Get all reviews for a movie
 */
    public static ArrayList<Review> getMovieReviews(String movieName){ //get all reviews for a movie
        ArrayList<Review> listReviews = new ArrayList();
        for (int i=0; i<allReviews.size();i++)  {
            if(allReviews.get(i).getMovieName().equals(movieName))  {
            listReviews.add(allReviews.get(i));
            }
        }
        return listReviews;
    }

    public static ArrayList<String> getAllReviewsNames(ArrayList<Review> customReviews) {

        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Review> allReviews = customReviews;

        for (int i =0; i < allReviews.size();i++){

            arrayList.add(allReviews.get(i).getMovieName());

        }
        return arrayList;

    }

/**
 * Add a review (already created) to the list of all other reviews
 @param review a review object
 */
    public static void addReview(Review review) {

        ArrayList<Review> ar = getAllReviews();
        ar.add(review);
        Data.saveObjectToPath(SaveLoadPath.REVIEW_PATH,ar);
        //new Review(review.getReview(), review.getMovieName(), review.getRating(), review.getReviewer());

    }

    public static void addReview(ArrayList<Review> review) {

        ArrayList<Review> ar = getAllReviews();
        ar.addAll(review);
        Data.saveObjectToPath(SaveLoadPath.REVIEW_PATH,ar);

    }


}
