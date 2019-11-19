import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Controls all the showings data
 */
public class ShowingControl {

    /**
     * Array list of all the showing objects
     */
    private static ArrayList<Showing> allShowings = null;

    /**
     * Constructor for ShowingControl class
     */
    public ShowingControl() {

    }

    /**
     * Reinitializes the array list of showings
     */
    public static void Reinitialize() {
        if ((allShowings = (ArrayList<Showing>) Data.getInstance().getObjectFromPath(SaveLoadPath.SHOWING_PATH, Showing.class)) == null) {
            allShowings = new ArrayList<>();
        }
    }

    /**
     * Adds a new showing to the file
     *
     * @param showing new Showing object
     */
    public static void addShowing(Showing showing) {

        ArrayList al = getAllShowings();
        al.add(showing);
        Data.saveObjectToPath(SaveLoadPath.SHOWING_PATH, al);


    }

    /**
     * Stores the array list of showings to the file
     *
     * @param showing list of showing objects
     */
    public static void addShowing(ArrayList<Showing> showing) {

        Data.saveObjectToPath(SaveLoadPath.SHOWING_PATH, showing);

    }

    /**
     * Checks if a particular seat is allocated or not
     *
     * @param showing Showing object
     * @param i       Seat row
     * @param j       Seat column
     */
    public static boolean isAllocated(Showing showing, int i, int j) {
        if (showing.isAllocated(i, j) || showing.getSeatingPlan().getSeat(i, j).getType().equals(" "))
            return true;
        return false;
    }

    /**
     * Prints the seating plan
     *
     * @param showing Showing object
     */
    public static void print(Showing showing) {
        Seat seatingPlan[][] = showing.getSeatingPlan().getSeats();

        for (int j = 0; j < seatingPlan[1].length; j++)
            System.out.print(j + " ");
        System.out.println();

        for (int i = 0; i < seatingPlan.length; i++) {
            System.out.print(i);
            for (int j = 0; j < seatingPlan[1].length; j++) {
                System.out.print(" ");
                if (seatingPlan[i][j].isAllocated())
                    System.out.print("U");
                else
                    System.out.print(seatingPlan[i][j].getType());
            }
            System.out.println();
        }
    }

    /**
     * Prints the cinema seats layout
     *
     * @param showing Showing object
     */
    public static void printSeats(Showing showing) {
        Seat seatingPlan[][] = showing.getSeatingPlan().getSeats();
        System.out.println("\n\n");

        //int [][] arr = new int[seatingPlan.length][seatingPlan[1].length];

        for (int i = 65; i < 65 + seatingPlan[1].length / 2; ++i) {
            System.out.print(" " + (char) i + "  ");
        }
        System.out.print("     ");
        for (int i = 65 + seatingPlan[1].length / 2; i < 65 + seatingPlan[1].length; ++i) {
            System.out.print(" " + (char) i + "  ");
        }
        System.out.println("\n");

        for (int i = 0, r = 1; i < seatingPlan.length; ++i) {
            for (int j = 0; j < seatingPlan[1].length; ++j) {
                if (seatingPlan[i][j].isAllocated())
                    System.out.print("[" + "U");
                else if (seatingPlan[i][j].getType().equals("N"))
                    System.out.print("[" + "N");
                else
                    System.out.print("[" + "P");

                if (j == seatingPlan[1].length / 2 - 1)
                    System.out.print("]" + " |==| ");
                else
                    System.out.print("]" + " ");
                if (j == seatingPlan[1].length - 1) {
                    System.out.println(" (" + r++ + ")");
                }
            }
        }
        for (int i = 1; i <= 4 * seatingPlan.length + 4; ++i) {
            System.out.print("_");
        }
        System.out.println();
        for (int i = 1; i <= 2 * seatingPlan[1].length - 2; ++i) {
            System.out.print(" ");
        }
        System.out.print("SCREEN");
    }

    /**
     * Gets all the showings
     */
    public static ArrayList<Showing> getAllShowings() {
        return (ArrayList<Showing>) Data.getObjectFromPath(SaveLoadPath.SHOWING_PATH, Showing.class);
    }



    /**
     * Gets all the showings for a particular movie
     *
     * @param movie Movie object
     */
    public static ArrayList<Showing> getAllShowingOfMovie(Movie movie) {

        ArrayList<Showing> allShowingsOfMovie = new ArrayList<>();

        for (Showing showing : getAllShowings()) {
            if (movie.getName().equals(showing.getMovie().getName()) && showing.getMovie().getStatus() == Movie.Status.Showing) {

                allShowingsOfMovie.add(showing);

            }
        }

        return allShowingsOfMovie;
    }

    public static void saveAllShowings(ArrayList<Showing> showings)
    {
        Data.getInstance().saveObjectToPath(SaveLoadPath.SHOWING_PATH, showings);
    }

    /**
     * deletes all showings of a movie thats status is no longer showing
     *
     * @param movieName is the movie no longer showing
     */
    public static void notShowing(String movieName) {

        ArrayList<Showing> showings = ShowingControl.getAllShowings();

        for (int i = 0; i < showings.size(); i++)
            if (showings.get(i).getMovie().getName().equals(movieName))
                showings.remove(i);

        Data.saveObjectToPath(SaveLoadPath.SHOWING_PATH,showings);
    }


}

