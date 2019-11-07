import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RoomLayout {
    private String[][] seats;
    private HashMap<String, Character> representations;

    public RoomLayout(String file) {
//        TODO read matrix from file.
    }

    public RoomLayout(int n, int m) {
        this.seats = new String[n][m];
        for (String[] row : this.seats) {
            Arrays.fill(row, "None");
        }
        this.representations = new HashMap<String, Character>();
        representations.put("None", ' ');
        representations.put("Normal", 'N');
        representations.put("Premium", 'P');
        representations.put("Love", 'L');

    }

    public void assignType(int n, int m, String type) {
//        TODO check if admin.
        this.seats[n][m] = type;
    }

    public void assignType(int pos, String type) {
//        TODO check if admin.
        this.seats[pos/this.seats[0].length][pos%this.seats[0].length] = type;
    }

    public void assignTypes(HashMap<Integer, String> locations) {
//        TODO check if admin.
        for (Map.Entry<Integer, String> entry : locations.entrySet()) {
            this.assignType(entry.getKey(), entry.getValue());
        }
    }

    public String[][] getSeats() {
        return seats;
    }

    public HashMap<String, Character> getRepresentations() {
        return representations;
    }

    public void print() {
        String line = "-".repeat(this.seats[0].length);
        System.out.println(" " + line);
        for (String[] row : this.seats) {
            System.out.print("|");
            for (String seat : row) {
                System.out.print(this.representations.get(seat));
            }
            System.out.println("|");
        }
        System.out.println(" " + line);
    }

    public void save() {
//        TODO save matrix to file.
//        TODO check if admin.
    }
}
