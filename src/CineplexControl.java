import java.util.ArrayList;

public class CineplexControl {

    private static ArrayList<Cineplex> cineplexs = null;

    public static void Reinitialize() {
        if ((cineplexs = (ArrayList<Cineplex>) Data.getInstance().getObjectFromPath(SaveLoadPath.CINEPLEX_PATH, Cineplex.class)) == null) {
            cineplexs = new ArrayList<>();
        }
    }

    public CineplexControl() {

    }

    public static ArrayList<String> getCineplexesByNames() {
        Reinitialize();
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < cineplexs.size(); i++) {

            arrayList.add(cineplexs.get(i).getName());

        }
        return arrayList;
    }

//    public static String getCineplexName(String name) {
//        Reinitialize();
//        for (int i = 0; i < cineplexs.size(); i++) {
//            if (cineplexs.get(i).getName().equals(name)) ;
//            return cineplexs.get(i).getName();
//        }
//        return null;
//    }

    public static Cineplex getCineplex(String name) {
        Reinitialize();
        for (int i = 0; i < cineplexs.size(); i++) {
            if (cineplexs.get(i).getName().equals(name)) ;
            return cineplexs.get(i);
        }
        return null;
    }


    public static ArrayList<Cineplex> getCineplexes() {

        return (ArrayList<Cineplex>) Data.getObjectFromPath(SaveLoadPath.CINEPLEX_PATH, Cineplex.class);

    }

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
