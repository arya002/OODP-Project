import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class SeatingPlan implements Serializable {
    private Seat[][] seats;

    //<editor-fold desc="Constructors">
    /*
    public SeatingPlan(Seat[][] seats) throws IllegalArgumentException{
        if (seats == null || seats.length == 0 || seats[0].length == 0)
            throw new IllegalArgumentException();
        this.seats = seats;
    }

    public SeatingPlan(String[][] layout) {
        for (int i=0; i < layout.length; i++) {
            for (int j=0; j < layout[0].length; j++) {
                this.seats[i][j] = new Seat(i*layout[0].length + j, layout[i][j]);
            }
        }
    }
    */

    public SeatingPlan(RoomLayout layout) {
        String seatTypes[][] = layout.getSeats();
        seats = new Seat[seatTypes.length][seatTypes[1].length];

        for (int i = 0; i < seatTypes.length; i++)
        {
            for (int j = 0; j < seatTypes[1].length; j++)
            {
                seats[i][j] = new Seat(i + j, seatTypes[i][j]);
            }
        }
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public Seat getSeat(int n, int m) {
        return this.seats[n][m];
    }

    /*
    public Integer[] getOccupied() {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i=0; i<this.seats.length; i++) {
            for (int j=0; j<this.seats[0].length; j++) {
                if (this.seats[i][j].isAllocated()) {
                    temp.add(i*this.seats[0].length);
                }
            }
        }
        Integer[] res = new Integer[temp.size()];
        temp.toArray(res);
        return res;
    }

    public Integer[] getUnOccupied() {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i=0; i<this.seats.length; i++) {
            for (int j=0; j<this.seats[0].length; j++) {
                if (!this.seats[i][j].isAllocated()) {
                    temp.add(i*this.seats[0].length);
                }
            }
        }
        Integer[] res = new Integer[temp.size()];
        temp.toArray(res);
        return res;
    }
    */


    /*
    public Seat getSeat(int index) {
        return this.seats[index/this.seats[0].length][index%this.seats[0].length];
    }
    //</editor-fold>

    public void assignSeat(int index, int custID) {
        this.seats[index/this.seats[0].length][index%this.seats[0].length].assignSeat(custID);
    }

    public void unAssignSeat(int index) {
        this.seats[index/this.seats[0].length][index%this.seats[0].length].unassignSeat();
    }

    public void print(){
        String line = "-".repeat(this.seats[0].length);
        System.out.println(" " + line);
        for (Seat[] row : this.seats) {
            System.out.print("|");
            for (Seat seat : row) {
                if (seat.isAllocated())
                    System.out.print("X");
                else
                    System.out.print(RoomLayout.getRepresentations().get(seat.getType()));
            }
            System.out.println("|");
        }
        System.out.println(" " + line);
    }
    */
}
