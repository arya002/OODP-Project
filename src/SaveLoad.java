import java.io.*;
import java.util.ArrayList;
/**
 * Saves and loads all the data in file
 * @param <K> Key value for generic class
 */
public class SaveLoad<K> implements Serializable{

    private K key;

    /**
     * Creates a new saveload instance with given key value
     * @param key Key value
     */
    public SaveLoad(K key) {
        this.key = key;
    }

    /**
     * Loads a file
     * @param file File name
     * @return null
     */
    public ArrayList<K> loadObject(String file) {
        try {
            FileInputStream f = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(f);
            ArrayList<K> retArray;
            retArray = (ArrayList<K>) in.readObject();
            in.close();
            f.close();
            return retArray;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;}
            catch (EOFException e){
                //System.out.println();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Saves an object arraylist to the file
     * @param o Arraylist of objects
     * @param file File name
     */
    public void saveObject(ArrayList<K> o, String file) {
        try {
            FileOutputStream f = new FileOutputStream(file,false);
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(o);
            out.close();
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

