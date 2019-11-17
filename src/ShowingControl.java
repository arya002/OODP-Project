import java.util.ArrayList;

public class ShowingControl  {

    private static ArrayList<Showing> allShowings= null;

    public ShowingControl(){

    }

    public static void Reinitialize(){
        if ((allShowings = (ArrayList<Showing>) Data.getInstance().getObjectFromPath(SaveLoadPath.SHOWING_PATH,Showing.class)) == null){
            allShowings = new ArrayList<>();
        }
    }



    public static void addShowing(Showing showing){

        allShowings.add(showing);
        //CineplexControl.addShowingToCinema(showing);
        //Data.getInstance().(SaveLoadPath.SHOWING_PATH,allShowings);

    }

    public static void addShowing(ArrayList<Showing> showing){

        allShowings.addAll(showing);
//        for(Showing showings:allShowings) {
//            CineplexControl.addShowingToCinema(showings);
//        }

        //Data.getInstance().saveObjectToPath(SaveLoadPath.SHOWING_PATH,allShowings);

    }

    public static boolean isAllocated(Showing showing, int i, int j)
    {
        if (showing.isAllocated(i, j) || showing.getSeatingPlan().getSeat(i, j).getType().equals(" "))
            return true;
        return false;
    }



    public static void print(Showing showing)
    {
        Seat seatingPlan[][] = showing.getSeatingPlan().getSeats();

        for (int j = 0; j < seatingPlan[1].length; j++)
            System.out.print(j + " ");
        System.out.println();
        
        for (int i = 0; i < seatingPlan.length; i ++)
        {
            System.out.print(i);
            for (int j = 0; j < seatingPlan[1].length; j++)
            {
                System.out.print(" ");
                if (seatingPlan[i][j].isAllocated())
                    System.out.print("U");
                else
                    System.out.print(seatingPlan[i][j].getType());
            }
            System.out.println();
        }
    }

    public static void printSeats(Showing showing)
    {
        Seat seatingPlan[][] = showing.getSeatingPlan().getSeats();
        System.out.println("\n\n");

        //int [][] arr = new int[seatingPlan.length][seatingPlan[1].length];
        
        for(int i=65; i<65+seatingPlan[1].length/2; ++i) {
          System.out.print(" " + (char)i + "  ");
        }
        System.out.print("     ");
        for(int i=65+seatingPlan[1].length/2; i<65+seatingPlan[1].length; ++i) {
          System.out.print(" " + (char)i + "  ");
        }
        System.out.println("\n");
        
        for(int i=0, r=1; i<seatingPlan.length; ++i) {
          for(int j=0; j<seatingPlan[1].length; ++j) {
            if(seatingPlan[i][j].isAllocated())
              System.out.print("[" + "U");
            else if (seatingPlan[i][j].getType().equals("N"))
              System.out.print("[" + "N");
            else
                System.out.print("[" + "P");

            if(j==seatingPlan[1].length/2-1)
              System.out.print("]" +  " |==| ");
            else
              System.out.print("]" +  " ");
            if(j==seatingPlan[1].length-1) {
              System.out.println(" (" + r++ + ")");
            }
          }
        }
        for(int i=1; i<=4*seatingPlan.length+4; ++i) {
            System.out.print("_");
        }
        System.out.println();
        for(int i=1; i<=2*seatingPlan[1].length-2; ++i) {
            System.out.print(" ");
        }
        System.out.print("SCREEN");
    }


    public static ArrayList<Showing> getAllShowings() {
        return allShowings;
    }

    public static ArrayList<Showing> getAllShowingsAtCineplex(String cineplex) {

        int i = 0;
        System.out.println("All movies we have at your location\n");
        ArrayList<Cineplex> ar = new ArrayList<>();
        ArrayList<Showing> allAtLocation= new ArrayList<>();
        CineplexControl cp = new CineplexControl();

        for (Cineplex cpa:cp.getCineplexes()){

            if (cpa.getName().equals(cineplex)){

                for (Cinema cinema :cpa.getCinemas()) {

                    return cinema.getShowings();

                }

            }

        }
        return null;
    }

    public static ArrayList<Showing> getAllShowingOfMovie(Movie movie){

        ArrayList<Showing> allShowingsOfMovie = new ArrayList<>();

        for(Showing showing:allShowings) {
            if (movie.getName().equals(showing.getMovie().getName()) && showing.getMovie().getStatus() == Movie.Status.Showing) {

                allShowingsOfMovie.add(showing);

            }
        }

        return allShowingsOfMovie;
    }

}
