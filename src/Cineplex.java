import java.io.Serializable;
import java.util.ArrayList;

public class Cineplex implements Serializable {

    private String name;
    private ArrayList<Cinema> cinemas;
    private ArrayList<Movie> movies;


    //<editor-fold desc="Constructors">
    public Cineplex(String name) {
        this.name = name;
        this.cinemas = new ArrayList<>();
        this.movies = new ArrayList<>();
        Cinema cinema1 = new Cinema("normal");
        Cinema cinema2 = new Cinema("normal");
        Cinema cinema3 = new Cinema("gold");

        cinemas.add(cinema1);
        cinemas.add(cinema2);
        cinemas.add(cinema3);

    }

    private void setMovies(ArrayList<Movie> movies) {
        if (movies == null)
            throw new IllegalArgumentException("Movies connot be null");
        this.movies = movies;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie) {
        if (movie == null) return;

        for (Movie elem : this.movies){
            if (elem.equals(movie))
                return;
        }
        this.movies.add(movie);
    }


    public String getName() {
        return name;
    }


    public ArrayList<Cinema> getCinemas() {
        return cinemas;
    }

}
