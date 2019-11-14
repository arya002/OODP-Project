import java.io.*;
import java.util.ArrayList;

public class Data implements Serializable {


    static private String path = "../Data/state.txt";
    static private Data instance = null;

    private Data () {

    }

    static public Data getInstance() {
        System.out.println("Gathering data please hold...");
        if (instance == null) {
            instance = new Data();
        }
        System.out.println("Finished thank you for waiting...\n\n");
        return instance;
    }

    public void saveObjectToPath(String path,ArrayList<?> arrayToSave) {
        if (arrayToSave.size() !=0) {
            SaveLoad saveLoad = new SaveLoad(arrayToSave.get(0).getClass());
            saveLoad.saveObject(arrayToSave,path);
        } else {
            System.out.println("Array empty :(");
        }
    }

    public ArrayList<?> getObjectFromPath(String path,Class o){
        System.out.println(o);
        SaveLoad pair= new SaveLoad<>(o);
        ArrayList objectsFromPath = pair.loadObject(path);
        System.out.println(objectsFromPath.size() + " size of array");
        return objectsFromPath;

    }

}
