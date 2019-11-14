import java.io.*;
import java.util.ArrayList;

public class Data implements Serializable {

    static private ArrayList<Cineplex> locations;
    static private ArrayList<Client> clients;
    static private ArrayList<Staff> staff;

    static private String path = "../Data/state.txt";
    static private Data instance = null;

    private Data () {
        this.locations = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.staff = new ArrayList<>();
    }

    //<editor-fold desc="Adders">
    public void addCineplex(Cineplex cineplex) {
        if (cineplex == null)
            return;
        this.locations.add(cineplex);
    }

    public void addClient(Client client) {
        if (client == null)
            return;
        this.clients.add(client);
    }

    public void addStaff(Staff staff) {
        if (staff == null) {
            return;
        }

        this.staff.add(staff);
    }
    //</editor-fold>

    //<editor-fold desc="Removers">
    public void removeCineplex(Cineplex cineplex) {
        this.locations.remove(cineplex);
    }

    public void removeClient(Client client) {
        this.clients.remove(client);
    }

    public void removeStaff(Staff staff) {
        this.staff.remove(staff);
    }
    //</editor-fold>

    static public Data getInstance() {
        System.out.println("Gathering data please hold...");
        if (instance == null) {
            try {
                //instance = (Data) loadObject(path);
                if (instance == null)
                    instance = new Data();
            }catch (Exception e){

            }
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
                System.out.println(retArray.size() + " size of array");
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
}
