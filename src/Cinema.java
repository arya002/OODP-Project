import java.io.Serializable;
import java.util.ArrayList;

public class Cinema implements Serializable {

    public int n = 20;
    public int m =  15;
    private ArrayList<Showing> showings;
    private RoomLayout roomLayout;
    private int[][] timeSlotsArray;
    private String type;


    enum DaysOfWeek {
        Mon, Tue, Wed, Thu, Fri, Sat, Sun;
        static int size = 7;
    }

    enum TimeSlots {
        tenAm,twelvePm,twoPm,sixPm,tenPm;
        static int size = 5;

    }

    public RoomLayout getRoomLayout() {
        return roomLayout;
    }

    public Cinema (String type){

        this.type = type;
        timeSlotsArray = new int[DaysOfWeek.size][TimeSlots.size];
        buildTimeSlots();
        buildRoomLayout();

    }

    private void buildRoomLayout() {

        if (type == "normal"){

            roomLayout = new RoomLayout(n,m,"stub",type);
        }

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

    public void addShowing(Showing showing){

        showings.add(showing);


    }

    public void setTimeSlotsArray(int[][] timeSlotsArray) {
        this.timeSlotsArray = timeSlotsArray;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Showing> getShowings() {
        return showings;
    }
}
