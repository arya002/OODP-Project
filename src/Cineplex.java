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
    }

    public Cineplex(String name, ArrayList<Cinema> cinemas, ArrayList<Movie> movies) throws IllegalArgumentException {
        this.setName(name);
        this.setCinemas(cinemas);
        //this.setShowings(showings);
        this.setMovies(movies);
    }

    public Cineplex(String name, ArrayList<Cinema> cinemas) throws IllegalArgumentException{
        this.setName(name);
        this.setCinemas(cinemas);
       // this.setShowings(showings);
        this.movies = new ArrayList<>();
//        for (Showing showing : showings) {
//            this.movies.add(showing.getMovie());
//        }
    }
    //</editor-fold>

    //<editor-fold desc="Setters">
    public void setName(String name) {
        if (name.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");

        this.name = name;
    }

    private void setCinemas(ArrayList<Cinema> cinemas) {
        if (cinemas == null)
            throw new IllegalArgumentException("Cinemas connot be null");
        this.cinemas = cinemas;
    }



    private void setMovies(ArrayList<Movie> movies) {
        if (movies == null)
            throw new IllegalArgumentException("Movies connot be null");
        this.movies = movies;
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
    //</editor-fold>

    //<editor-fold desc="Adders">

    //</editor-fold>


    public void addMovie(Movie movie) {
        if (movie == null) return;

        for (Movie elem : this.movies){
            if (elem.equals(movie))
                return;
        }
        this.movies.add(movie);
    }

//    public void addShowing(Showing showing) {
//        if (showing == null) return;
//
//        for (Showing elem : this.showings){
//            if (elem.equals(showing))
//                return;
//        }
//
//        this.showings.add(showing);
//        for (Movie movie : this.movies) {
//            if (movie.equals(showing.getMovie())){
//                return;
//            }
//        }
//        addMovie(showing.getMovie());
//    }




    //<editor-fold desc="Removers">
    public void removeCinema(RoomLayout layout) {
        this.cinemas.remove(layout);
    }
//
//    public void removeShowing(Showing showing){
//        this.showings.remove(showing);
//    }
//
//    public void removeMovie(Movie movie) {
//        this.movies.remove(movie);
//        for (Showing showing : this.showings) {
//            if (showing.getMovie().equals(movie)) {
//                this.removeShowing(showing);
//            }
//        }
//    }
    //</editor-fold>

    //<editor-fold desc="Getters">
    public String getName() {
        return name;
    }


    public ArrayList<Cinema> getCinemas() {
        return cinemas;
    }

}
