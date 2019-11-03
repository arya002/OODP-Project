public class RoomLayout {
    private String[][] seats;

    public RoomLayout(String file) {
//        TODO read matrix from file.
    }

    public RoomLayout(int n, int m) {
        this.seats = new String[n][m];
    }

    public void assignType(int n, int m, String type) {
        this.seats[n][m] = type;
    }

    public void save() {
//        TODO save matrix to file.
    }
}
