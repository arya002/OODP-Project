import java.io.Serializable;
import java.util.HashMap;

public class Seat {

    private String seatID;
    private String custID;
    private String type;
    private boolean allocated;

    public Seat(String seatID, String type) throws IllegalArgumentException {
        this.setSeatID(seatID);
        this.setType(type);
        this.allocated = false;
    }

    //<editor-fold desc="Getters">
    public String getSeatID() {
        return seatID;
    }

    public String getCustID() {
        return custID;
    }

    public String getType() {
        return type;
    }

    public boolean isAllocated() {
        return allocated;
    }
    //</editor-fold>

    //<editor-fold desc="Setters">
    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public void setType(String type) {
        if (type.isEmpty())
            throw new IllegalArgumentException("Type cannot be empty");
        this.type = type;
    }

    public void assignSeat(String custID) {
        this.allocated = true;
        this.setCustID(custID);
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