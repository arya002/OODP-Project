import java.io.Serializable;
import java.util.HashMap;

/**
 * Represents a seat in the cinema
 */
public class Seat implements Serializable{

    /**
     * Seat ID
     */
    private String seatID;

    /**
     * Customer ID who booked the seat
     */
    private String custID;

    /**
     * Type of the seatt
     */
    private String type;

    /**
     * Specifies whether seat is allocated or not
     */
    private boolean allocated;

    /**
     * Creates a new seat in the cinema
     * @param seatID Seat ID
     * @param type Seat type
     */
    public Seat(String seatID, String type) throws IllegalArgumentException {
        this.setSeatID(seatID);
        this.setType(type);
        this.allocated = false;
    }

    /**
     * Gets the seat ID
     * @return seat ID
     */
    public String getSeatID() {
        return seatID;
    }

    /**
     * Gets Customer ID
     * @return Customer ID
     */
    public String getCustID() {
        return custID;
    }

    /**
     * Gets seat type
     * @return Seat type
     */
    public String getType() {
        return type;
    }

    public boolean isAllocated() {
        return allocated;
    }

    /**
     * Changes the seat ID
     */
    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    /**
     * Changes the customer ID
     */
    public void setCustID(String custID) {
        this.custID = custID;
    }

    /**
     * Changes the seat type
     * @param type Seat type
     */
    public void setType(String type) {
        if (type.isEmpty())
            throw new IllegalArgumentException("Type cannot be empty");
        this.type = type;
    }

    /**
     * Assigns a seat to a customer
     * @param custID Customer ID
     */
    public void assignSeat(String custID) {
        this.allocated = true;
        this.setCustID(custID);
    }

    /**
     * Unassigns a seat
     */
    public void unassignSeat() {
        this.allocated = false;
    }

    /**
     * Prints seat information
     */
    public void print() {
        System.out.println("seatID: " + seatID);
        System.out.println("custID: " + custID);
        System.out.println("type: " + type);
        System.out.println("allocated: " + Boolean.toString(allocated));
    }
}
