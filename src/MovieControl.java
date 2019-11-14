import java.util.*;

/**
 *
 * Movie Manager for movies which handles all interfacing with the Movie class.
 * has all the static methods to seperate from the purely
 *
 */


public class MovieControl {

    private static MovieControl sSoleInstance = null;
    private ArrayList<Cineplex> reviews;
    private static ArrayList<Movie> currentMovies = new ArrayList();
    private static ArrayList<Movie> currentTicketSales = new ArrayList();
    private static Data data;

    public static MovieControl getInstance(){

        if (sSoleInstance == null)
            sSoleInstance = new MovieControl();

        return sSoleInstance;

    }

    private MovieControl(){

        data = Data.getInstance();
        currentMovies = (ArrayList<Movie>) data.getObjectFromPath("Data/movies.txt",Movie.class);
        currentTicketSales = (ArrayList<Movie>) data.getObjectFromPath("Data/movies.txt",Movie.class);

    }

    public ArrayList<Movie> getCurrentMovies() {
        return currentMovies;
    }


    public ArrayList<Movie> setAllMoviesByRating() {

        int i = 0;
        System.out.println("The top rated movies are \n");
        ArrayList<Review> sortedList = ReviewControl.getAllReviews();
        //review has a lot of key values (K = name / V = rating)
        sortedList.sort(new AlphabeticalOrder());
        //sorts into alphabetical order all movies with same name are in order
        String oldReviewMovie;
        Review oldReview;
        double total;
        boolean exitCond=false;

        for (i = 0; i < sortedList.size(); i++) {
            total = 0;
            int j = 0;

            oldReviewMovie = sortedList.get(i).getMovieName();

            while (i+j < sortedList.size() && sortedList.get(i+j).getMovieName().equals(oldReviewMovie)) {
                total += sortedList.get(i+j).getRating();
                oldReview = sortedList.get(i+j);
                oldReviewMovie = oldReview.getMovieName();
                j++;

                if(i+j == sortedList.size())
                    exitCond = true;

            }



            if (exitCond)
                break;
        }



        return null;

    }

    private class AlphabeticalOrder implements Comparator<Review> {

        @Override
        public int compare(Review o1, Review o2) {
            return o1.getMovieName().compareTo(o2.getMovieName());

        }
    }


    public void printAllMoviesByName() {

        int i = 0;
        System.out.println("All movies we have at every Cinema are \n");
        Set<String> uniqueMovies = new HashSet<>(ReviewControl.getAllReviewsNames());
        System.out.println("" + uniqueMovies);

    }

    //havent tested

    public void printAllMoviesByName(String locationName) {

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

    //havent tested

    public ArrayList<String> MoviesToMovieNames(ArrayList<Movie> allAtLocation){

        ArrayList<String> strings = new ArrayList<>();
        for(Movie movie:allAtLocation){
            strings.add(movie.getName());
        }
        return strings;
    }

    //havent tested

    public Set<String> getUniqueMovieNames(ArrayList<String> allMovieNames,boolean alphabetical) {

        ArrayList<String> sortedMovieNames = new ArrayList<>();
        sortedMovieNames.addAll(allMovieNames);
        if (alphabetical)
            Collections.sort(sortedMovieNames);

        Set<String> uniqueMovies = new HashSet<String>(sortedMovieNames);
        return uniqueMovies;
    }



    //havent tested
    public ArrayList<Movie> printMoviesByTicketSales(){

        TicketControl tc = TicketControl.getInstance();
        ArrayList<String> uniqueMovies =  new ArrayList<>(getUniqueMovieNames(MoviesToMovieNames(getCurrentMovies()),true));
        int total;

        for(String movies:uniqueMovies){

            total = tc.getAllTickets(movies).size();
            System.out.println(movies +" has sold " +total + " tickets");

        }

        return null;
    }



}

