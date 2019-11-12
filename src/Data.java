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

    static public Data getInstance() {
        if (instance == null) {
            instance = (Data) loadObject(path);
            if (instance == null)
                instance = new Data();
        }
        return instance;
    }

    public void save() {
        saveObject(instance, path);
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

    static private Object loadObject(String file) {
        try {
            FileInputStream f = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(f);
            Object temp =  in.readObject();
            in.close();
            f.close();
            return temp;
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

    static private void saveObject(Object o, String file) {
        try {
            FileOutputStream f = new FileOutputStream(file, false);
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
