import java.io.Serializable;
import java.util.ArrayList;

public class Cineplex implements Serializable {
    private String name;
    private ArrayList<RoomLayout> cinemas;
    private ArrayList<Showing> showings;
    private ArrayList<Movie> movies;

    //<editor-fold desc="Constructors">
    public Cineplex(String name) {
        this.name = name;
        this.cinemas = new ArrayList<>();
        this.showings = new ArrayList<>();
        this.movies = new ArrayList<>();
    }

    public Cineplex(String name, ArrayList<RoomLayout> cinemas, ArrayList<Showing> showings, ArrayList<Movie> movies) throws IllegalArgumentException {
        this.setName(name);
        this.setCinemas(cinemas);
        this.setShowings(showings);
        this.setMovies(movies);
    }

    public Cineplex(String name, ArrayList<RoomLayout> cinemas, ArrayList<Showing> showings) throws IllegalArgumentException{
        this.setName(name);
        this.setCinemas(cinemas);
        this.setShowings(showings);
        this.movies = new ArrayList<>();
        for (Showing showing : showings) {
            this.movies.add(showing.getMovie());
        }
    }
    //</editor-fold>

    //<editor-fold desc="Setters">
    public void setName(String name) {
        if (name.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");
        else
            this.name = name;
    }

    private void setCinemas(ArrayList<RoomLayout> cinemas) {
        if (cinemas == null)
            throw new IllegalArgumentException("Cinemas connot be null");
        this.cinemas = cinemas;
    }

    private void setShowings(ArrayList<Showing> showings) {
        if (showings == null)
            throw new IllegalArgumentException("Showings connot be null");
        this.showings = showings;
    }

    private void setMovies(ArrayList<Movie> movies) {
        if (movies == null)
            throw new IllegalArgumentException("Movies connot be null");
        this.movies = movies;
    }
    //</editor-fold>

    //<editor-fold desc="Adders">
    public void addCinema(RoomLayout layout) {
        if (layout == null) return;

        for (RoomLayout elem : this.cinemas){
            if (elem.equals(layout))
                return;
        }
        this.cinemas.add(layout);
    }

    public void addMovie(Movie movie) {
        if (movie == null) return;

        for (Movie elem : this.movies){
            if (elem.equals(movie))
                return;
        }
        this.movies.add(movie);
    }

    public void addShowing(Showing showing) {
        if (showing == null) return;

        for (Showing elem : this.showings){
            if (elem.equals(showing))
                return;
        }

        this.showings.add(showing);
        for (Movie movie : this.movies) {
            if (movie.equals(showing.getMovie())){
                return;
            }
        }
        addMovie(showing.getMovie());
    }
    //</editor-fold>

    //<editor-fold desc="Removers">
    public void removeCinema(RoomLayout layout) {
        this.cinemas.remove(layout);
    }

    public void removeShowing(Showing showing){
        this.showings.remove(showing);
    }

    public void removeMovie(Movie movie) {
        this.movies.remove(movie);
        for (Showing showing : this.showings) {
            if (showing.getMovie().equals(movie)) {
                this.removeShowing(showing);
            }
        }
    }
    //</editor-fold>

    //<editor-fold desc="Getters">
    public String getName() {
        return name;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public ArrayList<Movie> getMovies(String status) {
        ArrayList<Movie> result = new ArrayList<>();
        for (Movie movie : this.movies) {
            if (movie.getStatus().equals(status))
                result.add(movie);
        }
        return result;
    }

    public ArrayList<RoomLayout> getCinemas() {
        return cinemas;
    }

    public ArrayList<Showing> getShowings() {
        return showings;
    }
    //</editor-fold>

}
