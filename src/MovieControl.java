import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Movie Manager for movies which handles all interfacing with the Movie class.
 * has all the static methods to seperate from the purely
 */

public class MovieControl {

    private static ArrayList<Movie> allMovies = null;

    public static void Reinitialize() {

        if ((allMovies = (ArrayList<Movie>) Data.getInstance().getObjectFromPath(SaveLoadPath.MOVIE_PATH, Movie.class)) == null) {
            allMovies = new ArrayList<>();
        }
    }

    public MovieControl() {
    }


    public static void addMovieListing(Movie movie) {

        if (!allMovies.contains(movie)) {
            allMovies.add(movie);
            Data.getInstance().saveObjectToPath(SaveLoadPath.MOVIE_PATH, allMovies);
        }

    }

    public static ArrayList<Movie> getMoviesByTicketSales() {

        ArrayList<String> allMovieNames = getAllMoviesNames();
        Map<String, Integer> ticketSalesMap = new HashMap<String, Integer>();
        for (int i = 0; i < allMovieNames.size(); i++) {
            ticketSalesMap.put(allMovieNames.get(i), 0);
        }

        HashSet<Booking> bookings = new HashSet<>(BookingControl.getBookings());
        for (Booking booking : bookings) {
            for (Ticket ticket : booking.getTickets()) {
                for (Map.Entry<String, Integer> entry : ticketSalesMap.entrySet()) {
                    if (ticket.getShowingMovieName().equals(entry.getKey()))
                        entry.setValue(entry.getValue() + 1);
                }
            }
        }

        System.out.println("Top 5 movies by ticket sales:");
        ticketSalesMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(5).forEach(System.out::println);
        return null;
    }

    public static void getAllMoviesByRating() {
        Reinitialize();

        ArrayList<String> allMovieNames = getAllMoviesNames();
        Map<String, String> avgReviewMap = new HashMap<String, String>();
        ArrayList<Review> allReviews = ReviewControl.getAllReviews();
        if (allReviews == null)
            allReviews = new ArrayList<Review>();

        for (int i = 0; i < allMovieNames.size(); i++) {
            avgReviewMap.put(allMovieNames.get(i), String.valueOf(0));
        }


        for (Review review : allReviews) {
            String movieName = review.getMovieName();
            String reviewScore = String.valueOf(review.getRating());
            if (avgReviewMap.containsKey(movieName))
                avgReviewMap.replace(movieName, String.valueOf(Double.parseDouble(avgReviewMap.get(movieName)) + Double.parseDouble(reviewScore)));
            else
                avgReviewMap.put(movieName, reviewScore);
        }

        ArrayList<String> notEnoughReviewsNames = new ArrayList<>();

        for (Map.Entry<String, String> entry : avgReviewMap.entrySet()) {
            int counter = 0;
            for (Review review : allReviews) {
                if (review.getMovieName().equals(entry.getKey()))
                    counter++;
            }
            if (counter > 1)
            {
                double avg = Double.parseDouble(entry.getValue()) / counter;
                entry.setValue(String.valueOf(avg));
            }
            else
            {
                notEnoughReviewsNames.add(entry.getKey());
            }
        }

        for (String movie : notEnoughReviewsNames)
        {
            avgReviewMap.remove(movie);
        }
        
        System.out.println("Top 5 rated movies (Movies with lass than 2 reviews not included):");
        avgReviewMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(5).forEach(System.out::println);
    }



    public static ArrayList<String> getAllMoviesNames() {

        Reinitialize();

        ArrayList<String> names = new ArrayList<>();

        for (Movie movie : allMovies) {

            names.add(movie.getName());

        }

        return names;
        //System.out.println("All Movies: " + uniqueMovies);
    }

    public static ArrayList<Movie> getAllMovies() {

        return (ArrayList<Movie>) Data.getObjectFromPath(SaveLoadPath.MOVIE_PATH, Movie.class);
        //System.out.println("All Movies: " + uniqueMovies);
    }


    private static class CustomComparitor implements Comparator<Review> {

        @Override
        public int compare(Review o1, Review o2) {
            return o1.getMovieName().compareTo(o2.getMovieName());

        }
    }

}
