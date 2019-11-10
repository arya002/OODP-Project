import java.io.Serializable;
import java.util.HashMap;

public class Seat implements Serializable {

    private int seatID;
    private int custID = 0;
    private String type;
    private boolean allocated;

    public Seat(int seatID, String type)
    {   
        this.seatID = seatID;
        this.type = type;
        this.allocated = false;
    }

    //<editor-fold desc="Getters">
    public int getSeatID() {
        return seatID;
    }

    public int getCustID() {
        return custID;
    }

    public String getType() {
        return type;
    }

    public boolean isAllocated() {
        return allocated;
    }
    //</editor-fold>

    //<editor-fold desc="Mutators">
    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void assignSeat(int custID) {
        this.allocated = true;
        this.custID = custID;
    }

    public void unassignSeat() {
        this.allocated = false;
    }
    //</editor-fold>

    public void print() {
        System.out.println("seatID: " + Integer.toString(seatID));
        System.out.println("custID: " + Integer.toString(custID));
        System.out.println("type: " + type);
        System.out.println("allocated: " + Boolean.toString(allocated));
    }
}