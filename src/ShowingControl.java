import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

public class ShowingControl  {

    private static ShowingControl sSoleInstance;

    private ShowingControl(){}

    public static ArrayList<Showing> getAllShowings(){


        return null;
    }

    public static ShowingControl getInstance(){
        if (sSoleInstance == null){
            sSoleInstance = new ShowingControl();
        }
        return sSoleInstance;
    }

    public static void printAllShowingsAtCineplex(String cineplex) {

        int i = 0;
        System.out.println("All movies we have at your location\n");
        ArrayList<Cineplex> ar = new ArrayList<>();
        ArrayList<String> allAtLocation= new ArrayList<>();
        CineplexControl cp = new CineplexControl();

        for (Cineplex cpa:cp.getCineplexs()){

            if cpa.getName() ==

        }

    }

}
