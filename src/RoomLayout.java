import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RoomLayout implements Serializable {
    private String[][] seats;
    //private String type;
    //private String name;
    //static private HashMap<String, Character> representations = new HashMap<>();

    /*static {
        representations.put("None", ' ');
        representations.put("Normal", 'N');
        representations.put("Premium", 'P');
        //representations.put("Love", 'L');
    } */

    public RoomLayout(int n, int m) throws IllegalArgumentException {
        this.seats = new String[n][m];
        for (String[] row : this.seats) {
            Arrays.fill(row, "None");
        }

        //this.setName(name);
        //this.setType(type);
    }

    public String[][] getSeats() {
        return seats;
    }

    public void assignSeatType(int n, int m, String type) {
        if (type.isEmpty())
            type = "None";
        this.seats[n][m] = type;
    }

    public void assignSeatTypes(String[][] locations) {
        for (int row = 0; row < locations.length; row ++) {
            for (int column = 0; column < locations[1].length; column++)
            {
                this.seats[row][column] = locations[row][column]; 
            }
        }
    }
    /*
    public void assignSeatTypes(HashMap<Integer, String> locations) {
        for (Map.Entry<Integer, String> entry : locations.entrySet()) {
            this.assignSeatType(entry.getKey(), entry.getValue());
        }
    }

    public void assignSeatType(int pos, String type) {
        this.assignSeatType(pos/this.seats[0].length, pos%this.seats[0].length, type);
    }

    static public HashMap<String, Character> getRepresentations() {
        return representations;
    }
    //</editor-fold>
*/
    /*
    public void setType(String type) {
        if (type.isEmpty())
            throw new IllegalArgumentException("Type cannot be empty");
        this.type = type;
    }

    public void setName(String name) {
        if (name.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    //<editor-fold desc="Getters">
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
    */

    //</editor-fold>

        /*
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
    */
}
