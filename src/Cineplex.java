import java.util.ArrayList;

public class Cineplex {
    private String name;
    private ArrayList<RoomLayout> cinemas;
    private ArrayList<Showing> showings;
    private ArrayList<Movie> movies;

    public Cineplex(String name) {
        this.name = name;
        this.cinemas = new ArrayList<>();
        this.showings = new ArrayList<>();
        this.movies = new ArrayList<>();
    }

    public Cineplex(String name, ArrayList<RoomLayout> cinemas, ArrayList<Showing> showings, ArrayList<Movie> movies) {
        this.name = name;
        this.cinemas = cinemas;
        this.showings = showings;
        this.movies = movies;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void addCinema(RoomLayout layout) {
        for (RoomLayout elem : this.cinemas){
            if (elem.equals(layout))
                return;
        }
        this.cinemas.add(layout);
    }

    public void addMovie(Movie movie) {
        for (Movie elem : this.movies){
            if (elem.equals(movie))
                return;
        }
        this.movies.add(movie);
    }

    public void addShowing(Showing showing) {
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

}
