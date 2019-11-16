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
            System.out.println("Welcome " + current.getName());
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
                            //TODO Display top 5 movies by tickets sold
                            break;
                        case 3:
                            printMovies(MovieControl.getAllMoviesByRating());
                            break;
                    }

                    //TODO follow through to the next case (case 2) from here

                case 2:
                    //TODO take user input for a movie title and return that movie information (cast etc)
                    String mov;
                    System.out.println("Enter movie name: ");
                    mov = sc.next();
                    searchMovie(mov);

                    System.out.println("Would you like to see \n1. Reviews \n2. Listings\n for this movie?");
                    sc_in = sc.nextInt();
                    switch (sc_in) {
                        case 1:
                             ArrayList<Review> listReviews = new ArrayList();
                            int overallRating;
                            listReviews = getMovieReviews(mov);
                            for(int i=0; i<listReviews.size();i++) {
                                listReviews.get(i).print(); // print all Reviews for a movie    
                                overallRating = overallRating + listReviews.get(i).getRating();
                            }
                            overallRating = overallRating/listReviews.size(); //average ratings
                            System.out.printf("❀".repeat((int) overallRating) + ", %.1f/5\n\n", rating);
                        case 2:
                            //TODO Show listings for the movie
                            //TODO allow user to choose listing
                            //bookMovie();
                    }
                   
                case 3:
                    //TODO display every cineplex 
                    //TODO allow user to choose their cineplex
                    //TODO show movie listings for their chosen cineplex
                    //TODO allow user to choose listing
                    //bookMovie();
                case 4:
                    //TODO display user's booking history
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid input, please choose from the following:");
                    break;
            }

        } while (sc_in != 4);
    }

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

    private void printMovies(ArrayList<String> movies)
    {
        for (String movie : movies)
        {
            System.out.println(movie);
        }
    }


    public void searchMovie(String movie){
    // TODO


    }

}
