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

        return (ArrayList<Review>) Data.getInstance().getObjectFromPath(SaveLoadPath.SHOWING_PATH,Showing.class);

    }
    public static void Reinitialize(){
        if ((allReviews = (ArrayList<Review>) Data.getInstance().getObjectFromPath(SaveLoadPath.SHOWING_PATH,Showing.class)) == null){
            allReviews = new ArrayList<>();
        }
    }

    public static ArrayList<String> getAllReviewsNames() {

        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Review> allReviews = getAllReviews();

        for (int i =0; i < allReviews.size();i++){

            arrayList.add(allReviews.get(i).getMovieName());

        }
        return arrayList;

    }
    
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


    public static void addReview(Review review) {

        allReviews.add(review);
        new Review(review.getReview(), review.getMovieName(), review.getRating(), review.getReviewer());


    }



}
