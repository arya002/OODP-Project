import java.util.ArrayList;

public class StaffControl{

    public static void function(){


    }

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



}