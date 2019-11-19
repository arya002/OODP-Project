import java.io.Serializable;
import java.util.ArrayList;

public class Cinema implements Serializable {

    public int n = 20;
    public int m =  15;
    //private ArrayList<Showing> showings;
    private RoomLayout roomLayout;
    private int[][] timeSlotsArray;
    private boolean isPremium;
    private String CinemaID;


    enum DaysOfWeek {
        Monday{
            @Override
            public String toString() {
                return "Monday";
            }
        }, Tuesday{
            @Override
            public String toString() {
                return "Tuesday";
            }
        }, Wednesday{
            @Override
            public String toString() {
                return "Wedndesday";
            }
        }, Thursday{
            @Override
            public String toString() {
                return "Thursday";
            }
        }, Friday{
            @Override
            public String toString() {
                return "Friday";
            }
        }, Saturday{
            @Override
            public String toString() {
                return "Saturday";
            }
        }, Sunday{
            @Override
            public String toString() {
                return "Sunday";
            }
        };
        static int size = 7;
    }

    enum TimeSlots {
        TenAm,OnePm,FourPm,SixPm,TenPm;
        static int size = 5;

    }

    public Cinema (Boolean type,String cinemaID){

        //showings = new ArrayList<>();
        this.isPremium = type;
        this.CinemaID = cinemaID;
        timeSlotsArray = new int[DaysOfWeek.size][TimeSlots.size];
        buildTimeSlots();
        buildRoomLayout();

    }

    private void buildRoomLayout() {

        String[][] seats = new String[10][15];
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 15; j ++)
            {
                seats[i][j] = "N";
            }
        }
        this.roomLayout = new RoomLayout(seats);  
    }

    public void buildRoomLayout(String[][] layout)
    {
        this.roomLayout = new RoomLayout(layout);
    }

    private void buildTimeSlots() {

        for(int i =0; i < DaysOfWeek.size;i++){
            for (int j =0; j<TimeSlots.size;j++){
                timeSlotsArray[i][j]=1;
            }
        }
    }

    public int[][] getTimeSlotsArray() {
        return timeSlotsArray;
    }

//    public void addShowing(Showing showing){
//
//        showings.add(showing);
//
//    }

    public boolean isPremium() {
        return isPremium;
    }

//    public ArrayList<Showing> getShowings() {
//        return showings;
//    }

    public String getCinemaID() {
        return CinemaID;
    }

    public RoomLayout getRoomLayout() {
        return roomLayout;
    }

}
