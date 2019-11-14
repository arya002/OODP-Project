import java.util.*;

/**
 *
 * Movie Manager for movies which handles all interfacing with the Movie class.
 * has all the static methods to seperate from the purely
 *
 */


public class MovieControl {

    private static ArrayList<Movie> currentMovies = new ArrayList();

//    public void addMovieListing(String name, Movie.Status status, String synopsis, String director, String[] cast, ArrayList<Review> reviews,ArrayList<Cineplex> locations){
//        currentMovies.add(new Movie(name,status,synopsis,director,cast,reviews,locations));
//    }

    public MovieControl(){

        Data data = Data.getInstance();
        currentMovies = (ArrayList<Movie>) data.getObjectFromPath("Data/movies.txt",Movie.class);

    }

    public ArrayList<Movie> getCurrentMovies() {
        return currentMovies;
    }

    public void saveAllMovies(ArrayList<Movie> newMovieState){

        Data data = Data.getInstance();
        data.saveObjectToPath("Data/movies.txt",newMovieState);

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

    public static void printAllMoviesByName() {

        int i = 0;
        System.out.println("All movies we have at every Cinema are \n");
        Set<String> uniqueMovies = new HashSet<>(ReviewControl.getAllReviewsNames());
        System.out.println("Unique gas count: " + uniqueMovies);

    }

    public static void printAllMoviesByName(String locationName) {

        int i = 0;
        System.out.println("Movies at your cinema \n");
        ArrayList<Showing> ar_ = ShowingControl.getAllShowings();
        ArrayList<String> allAtLocation= new ArrayList<>();
        if (ar_ != null) {
            for (Showing ar:ar_){

                if(ar.getCineplex().equals(locationName)){

                    allAtLocation.add(ar.getMovie().getName());

                }

            }
        }
        Collections.sort(allAtLocation);
        Set<String> uniqueMovies = new HashSet<>(allAtLocation);
        System.out.println(uniqueMovies);

    }


    private static class CustomComparitor implements Comparator<Review> {

        @Override
        public int compare(Review o1, Review o2) {
            return o1.getMovieName().compareTo(o2.getMovieName());

        }
    }

}
