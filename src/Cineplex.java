import java.io.Serializable;
import java.util.ArrayList;

public class Cineplex implements Serializable {

    private String name;
    private ArrayList<Cinema> cinemas;

    //<editor-fold desc="Constructors">
    public Cineplex(String name) {
        this.name = name;
        this.cinemas = new ArrayList<>();
        int count = 0;
        Cinema cinema1 = new Cinema(false,this.getName().substring(0,2)+count++);
        Cinema cinema2 = new Cinema(false,this.getName().substring(0,2)+count++);
        Cinema cinema3 = new Cinema(true,this.getName().substring(0,2)+count++);

        cinemas.add(cinema1);
        cinemas.add(cinema2);
        cinemas.add(cinema3);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Cinema> getCinemas() {
        return cinemas;
    }

}
