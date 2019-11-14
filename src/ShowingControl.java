import java.util.ArrayList;

public class ShowingControl {

    private static ShowingControl sSoleInstance;

    private ShowingControl(){}

    public static ArrayList<Showing> getAllShowings(){

        return null;
    }

    public static ShowingControl getInstance(){
        if (sSoleInstance == null){
            sSoleInstance = new ShowingControl();
        }
        return sSoleInstance;
    }

}
