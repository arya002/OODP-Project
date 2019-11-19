import java.util.ArrayList;
import java.util.Scanner;

/**
 * helper class to break down some of the writing/saving of StaffApp
 */
public class StaffControl{

    public static void function(){


    }

    /**
     * prints all the holidays from file
     */
    public static void printHolidays(){
        ArrayList<Prices> prices;
        if((prices= (ArrayList<Prices>) Data.getInstance().getObjectFromPath(SaveLoadPath.PRICE_PATH, Prices.class))!=null)
            prices.get(0).getHOLIDAYS().forEach(System.out::println);
    }


    /**
     * Adds a new holiday
     */

    public static void addHoliday(String holiday) {
        ArrayList<Prices> prices = new ArrayList<>();
        if ((prices = (ArrayList<Prices>) Data.getInstance().getObjectFromPath(SaveLoadPath.PRICE_PATH, Prices.class)) != null);

        Prices price = prices.get(0);
        price.addHolyday(holiday);
        prices.add(price);
        System.out.println("Holiday added");
    }

    /**
     * Adds a new staff member
     *
     * @param user  Staff member's username
     * @param pass  Staff member's password
     * @param first Staff member's first name
     */
    public static void addNewStaff(String user, String pass, String first) {

        ArrayList<User> allusers = (ArrayList<User>) Data.getInstance().getObjectFromPath(SaveLoadPath.USER_PATH, User.class);
        allusers.add(new Staff(user, pass, first));
        Data.getInstance().saveObjectToPath(SaveLoadPath.USER_PATH, allusers);

    }

    /**
     *  prints all the movies in arraylist, and gets users choice for which to edit in index.
     *
     * @param movies the arrayList of movies which will be edited
     * @return index of the movie to edit
     */
    public static int printWhichMovieToEdit(ArrayList<Movie> movies) {


        int i = 0;
        for (Movie movie : movies) {

            System.out.println(i + ". " + movie.getName() + " is currently " + movie.getStatus());
            i++;
        }

        int sc_in = new Scanner(System.in).nextInt();
        int indexToEdit = sc_in;
        return indexToEdit;
    }

    /**
     * prints all the prices for the
     */
    public static void printPrices()
    {
        ArrayList<Prices> prices =new ArrayList<>();
        if((prices= (ArrayList<Prices>) Data.getInstance().getObjectFromPath(SaveLoadPath.PRICE_PATH, Prices.class))!=null);
        Prices price = prices.get(0);
        System.out.println("Adult base price: S$" + price.getBASE_ADULT());
        System.out.println("Child base price: S$" + price.getBASE_CONCESSION());
        System.out.println("Holiday/weekend markup: S$" + price.getHOLIDAY_MARKUP());
        System.out.println("Premium cinema markum: S$" + price.getPREMIUM_CINEMA_MARKUP());
        System.out.println("Premium movie markup: S$" + price.getPREMIUM_MOVIE_MARKUP());
        System.out.println("Premium seat markup: S$" + price.getPREMIUM_SEAT_MARKUP());


        System.out.println();

    }

    /**
     * making a new layout for a cinema.
     *
     * @param rows how many rows
     * @param columns how many columns
     * @return
     */
    public static String[][] newLayout(int rows, int columns)
    {
        String[][] layout = new String[rows][columns];
        System.out.println("Would you like the first two rows to be premium?");
        boolean premium = (MainApp.sc.next()).equalsIgnoreCase("yes");
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                if(premium && i > rows - 2)
                    layout[i][j] = "P";
                else
                    layout[i][j] = "N";
            }
        }
        return layout;
    }

    /**
     * removes a holdiay from the arraylist
     * @param holiday holiday string to remove
     */
    public static void removeHoliday(String holiday){
        ArrayList<Prices> prices;
        if((prices= (ArrayList<Prices>) Data.getInstance().getObjectFromPath(SaveLoadPath.PRICE_PATH, Prices.class))!=null)
            if (prices.get(0).getHOLIDAYS().remove(holiday))
                System.out.println("Holiday removed");
            else
                System.out.println("Holiday not on the list");
    }

    /**
     * Changes the price of a ticket
     *
     */

    public static void changePrices() {

        ArrayList<Prices> prices = new ArrayList<>();
        if ((prices = (ArrayList<Prices>) Data.getInstance().getObjectFromPath(SaveLoadPath.PRICE_PATH, Prices.class)) != null)
            ;
        Prices price = prices.get(0);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the new adult base price");
        price.setBASE_ADULT(sc.nextInt());
        System.out.println("Enter the new concession base price");
        price.setBASE_CONCESSION(sc.nextInt());
        System.out.println("Enter the new holiday/weekend markup");
        price.setHOLIDAY_MARKUP(sc.nextInt());
        System.out.println("Enter the new premium cinema markup");
        price.setPREMIUM_CINEMA_MARKUP(sc.nextInt());
        System.out.println("Enter the new premium movie markup");
        price.setPREMIUM_MOVIE_MARKUP(sc.nextInt());
        System.out.println("Enter the new premium seat markup");
        price.setPREMIUM_SEAT_MARKUP(sc.nextInt());


        Data.saveObjectToPath(SaveLoadPath.PRICE_PATH, prices);
    }

    /**
     * helper method for speaking to cinema enum and capturing user input.
     *
     * @param sc a scanner object so we dont need to create
     * @return
     */
    public static String getDateInput(Scanner sc) {
        System.out.println("Enter date in format YYYYMMDD: ");
        String date;
        date = sc.next();

        Cinema.DaysOfWeek[] dotwvals = Cinema.DaysOfWeek.values();
        System.out.println("Enter which Day of the week: ");
        for (int choice = 0; choice < dotwvals.length; choice++) {
            System.out.println(choice + ". " + dotwvals[choice].toString());
        }
        int dotwIndex = sc.nextInt();
        date += (dotwIndex);

        System.out.println("Enter Time Slot: ");
        Cinema.TimeSlots[] timeSlots = Cinema.TimeSlots.values();

        for (int choice = 0; choice < timeSlots.length; choice++) {
            System.out.println(choice + ". " + timeSlots[choice].toString());
        }
        int timeSlotIndex = sc.nextInt();
        date += (timeSlotIndex);
        return date;
    }
}