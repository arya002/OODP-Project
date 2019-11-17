import java.util.ArrayList;

public class CineplexControl {

    private static ArrayList<Cineplex> cineplexs=null;

    public static void Initialize() {
        if (((ArrayList<Cineplex>) Data.getInstance().getObjectFromPath(SaveLoadPath.CINEPLEX_PATH, Cineplex.class)) == null){
            cineplexs = new ArrayList<>();
        } else {
            cineplexs = (ArrayList<Cineplex>) Data.getInstance().getObjectFromPath(SaveLoadPath.CINEPLEX_PATH, Cineplex.class).clone();
        }

    }

    public CineplexControl() {

    }

    public static ArrayList<String> getCineplexesByNames() {

        ArrayList<String> arrayList = new ArrayList<>();

        for (int i =0; i < cineplexs.size();i++){

            arrayList.add(cineplexs.get(i).getName());

        }
        return arrayList;
    }

    public static String getCineplexName(String name) {

        for (int i = 0; i < cineplexs.size(); i++) {
            if (cineplexs.get(i).getName().equals(name)) ;
            return cineplexs.get(i).getName();
        }
        return null;
    }

    public static Cineplex getCineplex(String name) {

        for (int i = 0; i < cineplexs.size(); i++) {
            if (cineplexs.get(i).getName().equals(name)) ;
            return cineplexs.get(i);
        }
        return null;
    }


    public static ArrayList<Cineplex> getCineplexes() {
        return cineplexs;
    }


    public static void addCineplex(Cineplex cineplex) {

        cineplexs.add(cineplex);
        // Data.getInstance().saveObjectToPath(SaveLoadPath.CINEPLEX_PATH, cineplexs);

    }

    public static void addCineplex(ArrayList<Cineplex> cineplex) {

        cineplexs.addAll(cineplex);
        // Data.getInstance().saveObjectToPath(SaveLoadPath.CINEPLEX_PATH, cineplexs);

    }

    private static boolean allocateTimeSlot(Cinema whichCinema, int whichDay, int whichTimeSlot) {


        int[][] tempTS;
        tempTS = whichCinema.getTimeSlotsArray();
        if (tempTS[whichDay][whichTimeSlot] == 1) {
            tempTS[whichDay][whichTimeSlot] = 0;
            System.out.println(" to " + Cinema.DaysOfWeek.values()[whichDay] + " at " + Cinema.TimeSlots.values()[whichTimeSlot]);
            return true;
        }
        return false;

    }

    public static Cinema addShowingToCinema(Showing showing) {

        int whichDay = showing.getDayOfWeek();
        int whichTimeSlot = showing.getTimeSlot();
        Cinema whichCinema = showing.getCinema();
        for (Cineplex thisCineplex : cineplexs)
            for(Cinema cinema : thisCineplex.getCinemas())
                if(cinema.equals(whichCinema))
                    if (allocateTimeSlot(showing.getCinema(), whichDay, whichTimeSlot)) {
                        cinema.addShowing(showing);
                        return cinema;
                }else{
                    System.out.println("error already allocated");
                }



        return null;

    }

    public static ArrayList<Cinema> getCinemaFromCineplex(String whichCineplex) {

        for (Cineplex cineplex : cineplexs) {

            if (whichCineplex == cineplex.getName())
                return cineplex.getCinemas();

        }


        return null;
    }

    public static ArrayList<Cinema> getCinemaFromCineplex(Cineplex whichCineplex) {

        for (Cineplex cineplex : cineplexs) {

            if (whichCineplex == cineplex)
                return cineplex.getCinemas();

        }


        return null;
    }


}
