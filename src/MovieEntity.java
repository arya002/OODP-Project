import java.util.*;

public class MovieEntity {

    public static void printAllMoviesByRating() {

        int i = 0;
        System.out.println("The top rated movies are \n");
        ArrayList<Review> sortedList = MovieReview.getAllReviews();
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

            while (i+j < sortedList.size() && j+index < sortedList.size() &&sortedList.get(i+j).getMovieName() == oldReviewMovie) {
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
        Set<String> uniqueMovies = new HashSet<String>(MovieReview.getAllReviewsNames());
        System.out.println("Unique gas count: " + uniqueMovies);

    }

    public static void printAllMoviesByName(String locationName) {

        int i = 0;
        System.out.println("All movies we have at every Cinema are \n");
        ArrayList<Showing> ar_ = ShowingEntity.getAllShowings();
        ArrayList<String> allAtLocation= new ArrayList<>();
        for (Showing ar:ar_){

            if(ar.getCineplex().equals(locationName)){

                allAtLocation.add(ar.getMovie().getName());

            }

        }
        Collections.sort(allAtLocation);
        Set<String> uniqueMovies = new HashSet<String>(allAtLocation);
        System.out.println(uniqueMovies);

    }


    private static class CustomComparitor implements Comparator<Review> {

        @Override
        public int compare(Review o1, Review o2) {
            return o1.getMovieName().compareTo(o2.getMovieName());

        }
    }

}
