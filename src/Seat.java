public class Seat {

    private int SeatID;
    private int CustID;
    private String type;
    private boolean allocated;

    public Seat(int seatID, int custID, String type)
    {   
        this.SeatID = seatID;
        this.CustID = custID;
        this.type = type;
        this.allocated = false;
    }
    public int getSeatID() {
        return SeatID;
    }

    public void setSeatID(int seatID) {
        SeatID = seatID;
    }

    public int getCustID() {
        return CustID;
    }

    public void setCustID(int custID) {
        CustID = custID;
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

    public void setAllocated(boolean allocated) {
        this.allocated = allocated;
    }
}