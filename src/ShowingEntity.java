import java.util.ArrayList;

public class ShowingEntity {

    private static ShowingEntity sSoleInstance;

    private ShowingEntity(){}

    public static ArrayList<Showing> getAllShowings(){


        return null;
    }

    public static ShowingEntity getInstance(){
        if (sSoleInstance == null){
            sSoleInstance = new ShowingEntity();
        }
        return sSoleInstance;
    }

}
