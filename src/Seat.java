public class Seat {

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
    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAllocated() {
        return allocated;
    }

    public void assignSeat(int custID) {
        this.allocated = true;
        this.custID = custID;
    }

    public void unassignSeat() {
        this.allocated = false;
    }

    public void print() {
        System.out.println("seatID: " + Integer.toString(seatID));
        System.out.println("custID: " + Integer.toString(custID));
        System.out.println("type: " + type);
        System.out.println("allocated: " + Boolean.toString(allocated));
    }
}