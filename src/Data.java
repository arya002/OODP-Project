import java.io.*;
import java.util.ArrayList;
/**
Our IO interface to deal with saving and loading data files
*/

public class Data implements Serializable {

    static private String path = "../Data/state.txt";
    static private Data instance = null;

    private Data () {

    }
/**
Create new data object 
*/
    static public Data getInstance() {
        if (instance == null) {
                //instance = (Data) loadObject(path);
            if (instance == null)
                instance = new Data();

        }
        return instance;
    }
/**
Saves data
@param gives the location to save the data
@param arrayToSave is the arraylist of entity objects to be saved (e.g. Reviews etc)
*/
    public static void saveObjectToPath(String path,ArrayList<?> arrayToSave) {
        if (arrayToSave.size() !=0) {
            System.out.println("saving" + arrayToSave.get(0).getClass() + " type of class");
            SaveLoad saveLoad = new SaveLoad(arrayToSave.get(0).getClass());
            saveLoad.saveObject(arrayToSave,path);
        } else {
            System.out.println("Array empty :(");
        }
    }
/**
Returns an arraylist of objects loaded
*/
    public static ArrayList<?> getObjectFromPath(String path,Class o){
        SaveLoad pair= new SaveLoad<>(o);
        ArrayList objectsFromPath = pair.loadObject(path);
        return objectsFromPath;

    }


}
