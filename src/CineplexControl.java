import java.util.ArrayList;
/**
Manages Cineplexes
 */
public class CineplexControl {

    private static ArrayList<Cineplex> cineplexs = null;

    /**
Loads the data of cineplexes from file into an arraylist of Cineplex objects
 */
    public static void Reinitialize() {
        if ((cineplexs = (ArrayList<Cineplex>) Data.getInstance().getObjectFromPath(SaveLoadPath.CINEPLEX_PATH, Cineplex.class)) == null) {
            cineplexs = new ArrayList<>();
        }
    }

/**
 * Get names of the cineplexes available
 @return an arraylist of the String names
 */
    public static ArrayList<String> getCineplexesByNames() {
        Reinitialize();
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < cineplexs.size(); i++) {

            arrayList.add(cineplexs.get(i).getName());

        }
        return arrayList;
    }

/**
@return a single Cineplex object
@param takes the name of a cineplex to find
 */
    public static Cineplex getCineplex(String name) {
        Reinitialize();
        for (int i = 0; i < cineplexs.size(); i++) {
            if (cineplexs.get(i).getName().equals(name)) ;
            return cineplexs.get(i);
        }
        return null;
    }

/**
@return an arraylist of all available cineplexes object
 */
    public static ArrayList<Cineplex> getCineplexes() {

        return (ArrayList<Cineplex>) Data.getObjectFromPath(SaveLoadPath.CINEPLEX_PATH, Cineplex.class);

    }
/**
@return a boolean
 */
    private static boolean allocateTimeSlot(Cinema whichCinema, int whichDay, int whichTimeSlot) {

        Reinitialize();
        int[][] tempTS;
        tempTS = whichCinema.getTimeSlotsArray();
        if (tempTS[whichDay][whichTimeSlot] == 1) {
            tempTS[whichDay][whichTimeSlot] = 0;
            System.out.println(" to " + Cinema.DaysOfWeek.values()[whichDay] + " at " + Cinema.TimeSlots.values()[whichTimeSlot]);
            return true;
        }
        return false;

    }
/**
Add an arraylist showing to cinema. Main purpose is to save the showings in bulk to file
@param is an arraylist of showing objects, which contains the movie, date, and type. As well as the cinema and cineplex
 */
    public static Cinema addShowingToCinema(ArrayList<Showing> showing) {

        Reinitialize();
        ArrayList<Cineplex> testdata = getCineplexes();
        for (Showing this_showing : showing) {
            int whichDay = this_showing.getDayOfWeek();
            int whichTimeSlot = this_showing.getTimeSlot();
            String whichCinema = this_showing.getCinema().getCinemaID();
            for (Cineplex thisCineplex : testdata)
                for (Cinema cinema : thisCineplex.getCinemas())
                    if (cinema.getCinemaID().equals(whichCinema))
                        if (allocateTimeSlot(this_showing.getCinema(), whichDay, whichTimeSlot)) {
                            cinema.addShowing(this_showing);
                        } else {
                            System.out.println("error already allocated");
                        }


        }
        Data.saveObjectToPath(SaveLoadPath.CINEPLEX_PATH, testdata);
        return null;

    }
/**
Add a showing to cinema. Main purpose is to save the showing to file
@param is a showing object, which contains the movie, date, and type. As well as the cinema and cineplex
 */
    public static void addShowingToCinema(Showing showing) {

        Reinitialize();
        int whichDay = showing.getDayOfWeek();
        int whichTimeSlot = showing.getTimeSlot();
        String whichCinema = showing.getCinema().getCinemaID();
        for (Cineplex thisCineplex : cineplexs)
            for (Cinema cinema : thisCineplex.getCinemas())
                if (cinema.getCinemaID().equals(whichCinema))
                    if (allocateTimeSlot(showing.getCinema(), whichDay, whichTimeSlot)) {
                        cinema.addShowing(showing);
                        Data.saveObjectToPath(SaveLoadPath.CINEPLEX_PATH, cineplexs);
                        return;
                    }



    }
/**
Get all cinemas in a cineplex
@return arraylist of all Cinema(objects) within a particular cineplex
@param takes in a Cineplex Name (String)
 */
    public static ArrayList<Cinema> getCinemaFromCineplex(String whichCineplex) {

        for (Cineplex cineplex : cineplexs) {

            if (whichCineplex == cineplex.getName())
                return cineplex.getCinemas();

        }


        return null;
    }
/**
Get all cinemas in a cineplex
@return arraylist of all Cinema(objects) within a particular cineplex
@param takes in a Cineplex object to load cinemas from
 */
    public static ArrayList<Cinema> getCinemaFromCineplex(Cineplex whichCineplex) {

        for (Cineplex cineplex : cineplexs) {

            if (whichCineplex == cineplex)
                return cineplex.getCinemas();

        }


        return null;
    }


}
