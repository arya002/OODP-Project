import java.util.*;

/**
 *
 * Movie Manager for movies which handles all interfacing with the Movie class.
 * has all the static methods to seperate from the purely
 *
 */


public class MovieControl {

    static ArrayList<Movie> allMovies = new ArrayList();

    //    public Movie(String name, Status status, String synopsis, String director, String[] cast, ArrayList<Review> reviews, ArrayList<Cineplex> locations) throws IllegalArgumentException {
    public void addMovieListing(Movie movie){

        allMovies.add(movie);

    }



    public static void printAllMoviesByRating() {

        int i = 0;
        System.out.println("The top rated movies are \n");
        ArrayList<Review> sortedList = ReviewControl.getAllReviews();
        sortedList.sort(new CustomComparitor());
        String oldReviewMovie = sortedList.get(0).getMovieName();
        Review oldReview;
        double total;
        boolean exitCond=false;
        for (i = 0; i < sortedList.size(); i++) {
            total = 0;
            int j = 0;
            int index = i;

            oldReviewMovie = sortedList.get(i).getMovieName();

            while (i+j < sortedList.size() && j+index < sortedList.size() &&sortedList.get(i+j).getMovieName().equals(oldReviewMovie)) {
                System.out.println("old -" + oldReviewMovie);
                System.out.println("new - i + j- " + sortedList.get(i+j).getMovieName() +"\n");
                total += sortedList.get(index+j).getRating();
                oldReview = sortedList.get(index+j);
                oldReviewMovie = oldReview.getMovieName();
                j++;
                if(index+j == sortedList.size())
                    exitCond = true;

            }

            System.out.println("total " + sortedList.get(i).getMovieName() + " " + total + "\n");

            if (exitCond)
                break;
        }

    }

    public static void printAllMovies() {

        int i = 0;
        System.out.println("All movies are\n");

        ArrayList<String> names = new ArrayList<>();

        for (Movie movie:allMovies){

            names.add(movie.getName());

        }

        Set<String> uniqueMovies = new HashSet<String>(names);
        System.out.println("All Movies: " + uniqueMovies);

    }




    private static class CustomComparitor implements Comparator<Review> {

        @Override
        public int compare(Review o1, Review o2) {
            return o1.getMovieName().compareTo(o2.getMovieName());

        }
    }

}
