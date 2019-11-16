import java.io.*;
import java.util.ArrayList;


public class SaveLoad<K> {


    private K key;

    public SaveLoad(K key) {
        this.key = key;
    }

    public ArrayList<K> loadObject(String file) {
        try {
            System.out.println(System.getProperty("user.dir"));
            FileInputStream f = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(f);
            ArrayList<K> retArray;
            retArray = (ArrayList<K>) in.readObject();
            in.close();
            f.close();
            return retArray;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveObject(ArrayList<K> o, String file) {

        try {
            FileOutputStream f = new FileOutputStream(file);
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

