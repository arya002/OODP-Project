public class Data {
    static private User[] users;
    static private Cineplex[] cineplexes;

    static public User[] getUsers(){
        if (users == null) {
//            load users from file
        }
        return users;
    }

    static public Cineplex[] getCineplexes(){
        if (cineplexes == null) {
//            load users from file
        }
        return cineplexes;
    }
}
