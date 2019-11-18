import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

/**
 * Client application to display the interface
 */
public class ClientApp {
    private Client current;
    private static Scanner sc = MainApp.sc;

    /**
     * Create a ClientApp for the current user
     *
     * @param current is the current user account
     */
    public ClientApp(Client current) {
        this.current = current;
        run();
    }

    private void run() {
        int sc_in = 0;
        do {
            System.out.println();
            if (current != null)
                System.out.println("Welcome back, " + current.getFirstName());
            else
                System.out.println("Welcome guest!");

            do {
                System.out.println("Please select your next action from the following:");
                System.out.println
                        ("1. Display movies " +
                                "\n2. Search for a movie" +
                                "\n3. Display all cineplexes" +
                                "\n4. View booking history" +
                                "\n5. Exit\n");
                sc.nextLine();
                sc_in = sc.nextInt();

                switch (sc_in) {
                    case 1:
                        displayMovies();
                        //Without break here to automatically go to case 2. Makes intuitive sense
                    case 2:
                        searchForMovie();
                        break;
                    case 3:
                        displayCineplexes();
                        break;
                    // BookingApp(current, showing);
                    case 4:
                        viewBookingHistory();
                        sc_in = 0;
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid input, please choose from the following:");
                        break;
                }
            } while (sc_in != 5);

        } while (sc_in != 5);
    }

    /**
     * Print the list of movies
     *
     * @param movies array of movies
     */

    /**
     * Print the list of movies
     *
     * @param movies The cast of a movie as a string
     */
    private void printMovies(ArrayList<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie.getName());
        }
    }

    private void viewBookingHistory() {

        while (current == null) {
            User lis = new LoginScreen().run();
            if (lis != null && lis.getType().equals("client"))
                current = (Client) new LoginScreen().run();
        }

        for (Booking booking : BookingControl.getBookings()) {
            if (booking.getClient().getUsername().equals(current.getUsername())) {
                System.out.println(booking.bookingPrint());
            }
        }
    }

    private void displayCineplexes() {
        int sc_in = 0;
        int temp = 1;
        int count = 0;
        for (Cineplex cineplex : CineplexControl.getCineplexes()) {
            System.out.println(temp + ". " + cineplex.getName());
            temp++;
        }
        sc_in = sc.nextInt();
        sc_in--;
        System.out.println("you chose " + CineplexControl.getCineplexes().get(sc_in).getName());
        temp = 0;
        Showing selectedShowing = null;
        if (sc_in >= 0 && sc_in < 3) {

            for (Cinema cinema : CineplexControl.getCineplexes().get(sc_in).getCinemas()) {

                for (Showing showing : cinema.getShowings()) {
                    System.out.println(temp + ". " + showing.printShowing());
                    temp++;
                }
            }
        }

        for (Cinema cinema : CineplexControl.getCineplexes().get(sc_in).getCinemas()) {
            for (Showing showing : cinema.getShowings()) {
                count++;
                if (count == temp)
                    selectedShowing = showing;

            }
        }

        sc_in = sc.nextInt();
        if (sc_in > 0 && sc_in < temp && selectedShowing != null) {
            if (current != null) {
                new BookingApp(current, selectedShowing);
            } else {
                while (current == null) {
                    current = (Client) new LoginScreen().run();
                }
                new BookingApp(current, selectedShowing);
            }
        } else {
            System.out.println("error in selecting movies");
        }
    }

    private void searchForMovie() {
        int sc_in = 0;
        String mov = "";
        int counter = 0;
        System.out.println("Enter movie name to search for or type exit to go back:");
        if (!mov.equals("exit")) {
            sc.nextLine();
            mov = sc.nextLine();
            Movie searchedMovie = null;
            while (counter < MovieControl.getAllMovies().size() && !mov.equals("exit")) {
                for (Movie movie : MovieControl.getAllMovies()) {
                    if (mov.equals("exit"))
                        break;
                    if (movie.getName().contains(mov)) {

                        System.out.println("Movie Found");
                        searchedMovie = movie;
                        printMovie(searchedMovie);
                        System.out.println();

                        System.out.println("What would you like to see? \n1. Reviews \n2. All listings\n3. Listings on a specific date\n4. Leave review \n5. Exit");
                        sc_in = sc.nextInt();
                        switch (sc_in) {
                            case 1:
                                seeReviews(mov);
                                break;
                            case 2:
                                seeAllListings(searchedMovie);
                                mov = "exit";
                                break;
                            case 3:
                                seeListingsOnDate(searchedMovie);
                                mov = "exit";
                                break;
                            case 4:
                                leaveReview(searchedMovie);
                                sc_in = 0;
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("error select a correct statement");
                        }
                        if (searchedMovie != null && sc_in != 4) {
                            break;
                        }
                    }
                }
                counter++;
                if (searchedMovie == null || counter >= MovieControl.getAllMovies().size()) {
                    System.out.println("Movie with this name has not been found");
                } else {
                    break;
                }
            }
        }
    }

    private void leaveReview(Movie searchedMovie) {
        int rating = 0;
        String blurb = "";
        while (current == null) {
            User lis = new LoginScreen().run();
            current = (Client) lis;
            System.out.println(current.getFirstName());
        }
        System.out.println("What would you like to rate this film (1-5)");

        rating = sc.nextInt();
        System.out.println("Please write a short blurb about why you have chosen your score");

        // sc.next();
        blurb = sc.next();
        ReviewControl
                .addReview(new Review(blurb, searchedMovie.getName(), new Double(rating), current));
    }

    private void seeListingsOnDate(Movie searchedMovie) {
        System.out.println("Enter the date (YYYYMMDD):");
        String dateOfShowing = sc.next();
        int c = 0;
        System.out.println("\nListings on the date selected:");
        ArrayList<Showing> allShowings = ShowingControl.getAllShowingOfMovie(searchedMovie);
        ArrayList<Showing> showingsOnDate = new ArrayList<>();
        for (Showing showing : allShowings) {
            if (showing.getDate().substring(0, 8).equals(dateOfShowing)) {
                System.out.println(c + ". " + showing.printShowing());
                c++;
                showingsOnDate.add(showing);
            }
        }
        System.out.println("\nPlease select which showing you would like to attend:");
        c = sc.nextInt();
        if (c > 0 && c < showingsOnDate.size()) {
            new BookingApp(current, showingsOnDate.get(c));
            ShowingControl.saveAllShowings(allShowings);
        } else {
            System.out.println("error in selecting movies");
        }
        System.out.println();
    }


    private void seeAllListings(Movie searchedMovie) {
        int count = 0;
        System.out.println("\nAll listings:");
        for (Showing showing : ShowingControl.getAllShowingOfMovie(searchedMovie)) {

            System.out.println(count + ". " + showing.printShowing());
            count++;
        }
        System.out.println("\nPlease select which showing you would like to attend:");
        count = sc.nextInt();
        if (count > 0 && count < ShowingControl.getAllShowingOfMovie(searchedMovie).size()) {
            ArrayList<Showing> allShowings = ShowingControl.getAllShowingOfMovie(searchedMovie);
            new BookingApp(current, allShowings.get(count));
            ShowingControl.saveAllShowings(allShowings);
        } else {
            System.out.println("error in selecting movies");
        }
        System.out.println();
    }

    private void seeReviews(String mov) {
        ArrayList<Review> listReviews = new ArrayList();
        double overallRating = 0;
        listReviews = ReviewControl.getMovieReviews(mov);
        for (int i = 0; i < listReviews.size(); i++) {
            ReviewControl.print(listReviews.get(i)); // print all Reviews for a movie
            overallRating = overallRating + listReviews.get(i).getRating();
        }
        System.out.println();
        if (listReviews.size() == 0) {
            System.out.println("No reviews have been left");
        } else if (listReviews.size() > 1) {
            overallRating = overallRating / listReviews.size(); // average ratings
            System.out.printf("Average rating: %.1f/5\n\n", overallRating);
        } else {
            System.out.println("Average rating unavailable, not enough reviews");
        }
    }

    private void displayMovies() {
        int sc_in = 0;
        System.out.println(
                "Would you like to see \n1. Every movie\n2. Top 5 movies by ticket sales\n3. Top 5 movies by review score");
        sc_in = sc.nextInt();
        switch (sc_in) {
            case 1:
                printMovies(MovieControl.getAllMovies());
                break;
            case 2:
                MovieControl.getMoviesByTicketSales();
                break;
            case 3:
                MovieControl.getAllMoviesByRating(); // TODO print top 5
                break;
        }
        System.out.println();
    }

    private void printMovie(Movie movie) {
        System.out.println("------------------------------------------");
        System.out.println("Name: " + movie.getName());
        System.out.println("\nSynopsis:\n" + movie.getSynopsis());
        System.out.println(movie.getStatus());
        System.out.println("Directed by: " + movie.getDirector());
        System.out.println("Starring: " + String.join(", ", movie.getCast()));
        //System.out.printf("Average rating: %.1f/5\n", avg_rating);
        System.out.println("------------------------------------------");
    }


}
