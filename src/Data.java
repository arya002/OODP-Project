import java.io.*;
import java.util.ArrayList;

public class Data implements Serializable {

    static private String path = "../Data/state.txt";
    static private Data instance = null;

    private Data () {

    }

    static public Data getInstance() {
        if (instance == null) {
                //instance = (Data) loadObject(path);
            if (instance == null)
                instance = new Data();

        }
        return instance;
    }

    public static void saveObjectToPath(String path,ArrayList<?> arrayToSave) {
        if (arrayToSave.size() !=0) {
            System.out.println("saving" + arrayToSave.get(0).getClass() + " type of class");
            SaveLoad saveLoad = new SaveLoad(arrayToSave.get(0).getClass());
            saveLoad.saveObject(arrayToSave,path);
        } else {
            System.out.println("Array empty :(");
        }
    }

    public static ArrayList<?> getObjectFromPath(String path,Class o){
        SaveLoad pair= new SaveLoad<>(o);
        ArrayList objectsFromPath = pair.loadObject(path);
        return objectsFromPath;

    }


}
