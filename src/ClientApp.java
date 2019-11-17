import java.util.ArrayList;
import java.util.Scanner;


public class ClientApp {
    private Client current;

    public ClientApp (Client current) {
        this.current = current;
        run();
    }

    private void run() {
        int sc_in;
        Scanner sc = new Scanner(System.in);

        do {
            if (current != null)
                System.out.println("Welcome " + current.getFirstName());
            else
                System.out.println("Welcome guest!");

            System.out.println
                    ("1. Display movies " +
                            "\n2. Search for a movie" +
                            "\n3. Display all cineplexes" +
                            "\n4. View booking history" +                            
                            "\n5. Exit\n");


            sc_in = sc.nextInt();
            switch (sc_in) {
                case 1:
                    System.out.println("Would you like to see \n1. Every movie\n2. Top 5 movies by ticket sales\n3. Top 5 movies by review score");
                    sc_in = sc.nextInt();
                    switch (sc_in) {
                        case 1:
                            printMovies(MovieControl.getAllMovies());
                            break;
                        case 2:
                            //TODO
                            break;
                        case 3:
                            printMovies(MovieControl.getAllMoviesByRating()); //TODO print top 5
                            break;
                    }
                    //Without break here to automatically go to case 2. Makes intuitive sense 
                case 2:
                    String mov;
                    System.out.println("Enter movie name to search for: ");
                    mov = sc.nextLine();
                    Movie searchedMovie = null;
                    for (Movie movie : MovieControl.getAllMovies()) {

                        if (movie.getName().contains(mov)) {

                            System.out.println("Movie Found");
                            searchedMovie = movie;

                        }

                    }

                    System.out.println("Would you like to see \n1. Reviews \n2. Listings\n for this movie?");
                    sc_in = sc.nextInt();
                    switch (sc_in) {
                        case 1:
                            ArrayList<Review> listReviews = new ArrayList();
                            double overallRating = 0;
                            listReviews = ReviewControl.getMovieReviews(mov);
                            for (int i = 0; i < listReviews.size(); i++) {
                                listReviews.get(i).print(); // print all Reviews for a movie    
                                overallRating = overallRating + listReviews.get(i).getRating();
                            }
                            overallRating = overallRating / listReviews.size(); //average ratings
                            //System.out.printf("❀".repeat((int) overallRating) + ", %.1f/5\n\n", overallRating);
                            break;
                        case 2:
                            int count = 0;
                            for (Showing showing : ShowingControl.getAllShowingOfMovie(searchedMovie)) {

                                System.out.println(count + ". " + showing.printShowing() + " on " + showing.getDate());
                                count++;
                            }
                            count = sc.nextInt();
                            if (count > 0 && count < ShowingControl.getAllShowingOfMovie(searchedMovie).size()) {
                                new BookingApp(current, ShowingControl.getAllShowingOfMovie(searchedMovie).get(count));
                            } else {
                                System.out.println("error in selecting movies");
                            }
                            break;
                    }
                    break;

                case 3:
                    for (Cineplex cineplex : CineplexControl.getCineplexes())
                        System.out.println(cineplex.getName());

                    sc_in = sc.nextInt();
                    int temp=0;
                    int count=0;
                    Showing selectedShowing =null;
                    if(sc_in > 0 && sc_in <=3) {
                        for (Cinema cinema : CineplexControl.getCineplexes().get(sc_in).getCinemas()) {
                            for (Showing showing : cinema.getShowings()) {
                                System.out.println(temp + ". " +showing.printShowing());
                                temp++;
                            }
                        }
                    }

                    for (Cinema cinema : CineplexControl.getCineplexes().get(sc_in).getCinemas()) {
                        for (Showing showing : cinema.getShowings()) {
                            count++;
                            if(count == temp)
                                selectedShowing = showing;


                        }
                    }

                    sc_in = sc.nextInt();
                    if (sc_in > 0 && sc_in < temp&& selectedShowing !=null) {
                        if(current!=null) {
                            new BookingApp(current, selectedShowing);
                        }else{
                            LoginScreen lin=null;
                            while(lin == null) {
                                current = (Client) new LoginScreen().run();
                            }
                            new BookingApp(current, selectedShowing);
                        }
                    } else {
                        System.out.println("error in selecting movies");
                    }

                    //BookingApp(current, showing);
                case 4:
                    if(current!=null) {
                        for(Booking bookings:BookingControl.getBookings()){
                            if(bookings.getClient().equals(current)){
                                System.out.println(bookings.bookingPrint());
                            }
                        }
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid input, please choose from the following:");
                    break;
            }

        } while (sc_in != 4);
    }
/*
    public void bookMovie(Showing showingToBook)
    {

        showingToBook.getCinema().getRoomLayout().print();

        String[][] seats = showingToBook.getCinema().getRoomLayout().getSeats();
        String choice = MainApp.sc.next();
        for(int i = 0;i<showingToBook.getCinema().n;i++){
            for (int j =0; j < showingToBook.getCinema().m;j++){

                if (choice == seats[i][j]){



                }

            }
        }
        //TODO let user choose a seat and display the price
        //TODO process the booking
    }
    */

    private void printMovies(ArrayList<Movie> movies)
    {
        for (Movie movie : movies)
        {
            System.out.println(movie.getName());

        }
    }

}
