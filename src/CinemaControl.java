import java.util.ArrayList;

public class CinemaControl {


    private static ArrayList<Cinema> allCinemas;

    private static CinemaControl instance= null;

    private Data data = Data.getInstance();

    private CinemaControl(){

        data.getObjectFromPath(SaveLoadNames.CINEMA_PATH,Cinema.class);

    }

    public static CinemaControl getInstance() {
        if (instance == null)
            instance = new CinemaControl();


        return instance;
    }

    public ArrayList<Cinema> getAllCinemas() {
        return allCinemas;
    }

    private boolean allocateTimeSlot(int whichCinema,int whichDay,int whichTimeSlot){

        Cinema cinema = allCinemas.get(whichCinema);
        int[][] tempTS;
        tempTS = cinema.getTimeSlotsArray();
        if( tempTS[whichDay][whichTimeSlot] == 1){
            tempTS[whichDay][whichTimeSlot] = 0;
            System.out.println(" allocated to "+Cinema.DaysOfWeek.values()[whichDay] + " at " +  Cinema.TimeSlots.values()[whichTimeSlot] );
            return true;
        }
        return false;

    }

    public void addShowingToCinema(int whichCinema,int whichDay,int whichTimeSlot){

        if(allocateTimeSlot(whichCinema,whichDay,whichTimeSlot)){



        }

    }


}
