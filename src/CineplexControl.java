import java.util.ArrayList;

/**
 * Manages Cineplexes
 */
public class CineplexControl {

    private static ArrayList<Cineplex> cineplexs = null;

    /**
     * Loads the data of cineplexes from file into an arraylist of Cineplex objects
     */
    public static void Reinitialize() {
        if ((cineplexs = (ArrayList<Cineplex>) Data.getInstance().getObjectFromPath(SaveLoadPath.CINEPLEX_PATH, Cineplex.class)) == null) {
            cineplexs = new ArrayList<>();
        }
    }

    /**
     * Get names of the cineplexes available
     *
     * @return an arraylist of the String names
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
     * @param name the name of a cineplex to find
     * @return a single Cineplex object
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
     * @return an arraylist of all available cineplexes object
     */
    public static ArrayList<Cineplex> getCineplexes() {

        return (ArrayList<Cineplex>) Data.getObjectFromPath(SaveLoadPath.CINEPLEX_PATH, Cineplex.class);

    }

    /**
     * Time slots are not really needed as input is staff, left in here to show this is easily
     * implemented at any time, just need to do it from a certain point and every week.
     *
     * @return true as its a stub
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
        return true;

    }

    /**
     * Get all cinemas in a cineplex
     *
     * @param whichCineplex in a Cineplex Name (String)
     * @return arraylist of all Cinema(objects) within a particular cineplex
     */
    public static ArrayList<Cinema> getCinemaFromCineplex(String whichCineplex) {

        for (Cineplex cineplex : cineplexs) {

            if (whichCineplex == cineplex.getName())
                return cineplex.getCinemas();

        }


        return null;
    }

    /**
     * Get all cinemas in a cineplex
     *
     * @param whichCineplex in a Cineplex object to load cinemas from
     * @return arraylist of all Cinema(objects) within a particular cineplex
     */
    public static ArrayList<Cinema> getCinemaFromCineplex(Cineplex whichCineplex) {

        for (Cineplex cineplex : cineplexs) {

            if (whichCineplex == cineplex)
                return cineplex.getCinemas();

        }


        return null;
    }

    /**
     * gets a new roomlayout for a cinema with specified size
     *
     * @param rows    how many columns in new layout
     * @param columns how many columns in new layout
     * @return
     */
    public static RoomLayout getNewRoomLayout(int rows, int columns) {
        String[][] seats = new String[rows][columns];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                seats[i][j] = "N";
            }
        }
        return new RoomLayout(seats);
    }

    /**
     * set the new roomlayout to the cinema with cinemaID
     *
     * @param cinemaID is the cinema which layout will change
     */

}
