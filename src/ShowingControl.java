import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

public class ShowingControl  {

    private static ArrayList<Showing> allShowings;

    public ShowingControl(){

        allShowings = (ArrayList<Showing>) Data.getInstance().getObjectFromPath(SaveLoadNames.SHOWING_PATH,Showing.class);

    }


    public static void printAllShowingsAtCineplex(String cineplex) {

        int i = 0;
        System.out.println("All movies we have at your location\n");
        ArrayList<Cineplex> ar = new ArrayList<>();
        ArrayList<Showing> allAtLocation= new ArrayList<>();
        CineplexControl cp = new CineplexControl();

        for (Cineplex cpa:cp.getCineplexs()){

            if (cpa.getName().equals(cineplex)){



            }

        }

    }

    public static ArrayList<Showing> getAllShowingOfMovie(Movie movie){

        ArrayList<Showing> allShowingsOfMovie = new ArrayList<>();

        for(Showing showing:allShowings) {
            if (movie.getName().equals(showing.getMovie().getName()) && showing.getMovie().getStatus() == Movie.Status.Showing) {

                allShowingsOfMovie.add(showing);

            }
        }

        return allShowingsOfMovie;
    }

}
