import java.util.ArrayList;

public class seatingPlan {
    private Seat[][] seats;

    //<editor-fold desc="Constructors">
    public seatingPlan(Seat[][] seats) {
        this.seats = seats;
    }

    public seatingPlan(String file) {
//        TODO load from file.
//        this(iterable);
    }

    public seatingPlan(String[][] layout) {
        for (int i=0; i < layout.length; i++) {
            for (int j=0; j < layout[0].length; j++) {
                this.seats[i][j] = new Seat(i*layout[0].length + j, layout[i][j]);
            }
        }
    }
    //</editor-fold>

    //<editor-fold desc="Getters">
    public Seat[][] getSeats() {
        return seats;
    }

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
    //</editor-fold>

    public void assignSeat(int index, int custID) {
        this.seats[index/this.seats[0].length][index%this.seats[0].length].assignSeat(custID);
    }

//\e[41m
}
