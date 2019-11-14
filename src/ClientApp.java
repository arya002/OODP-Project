public class ClientApp {
    private Client current;

    public ClientApp (Client current) {
        this.current = current;
        run();
    }

    private void run() {
        int sc_in;

        do {
            System.out.println("Welcome " + current.getName());
            System.out.println
                    ("1. Browse Movie Listings " +
                            "\n2. Browse cinema Show times and the movies to be shown " +
                            "\n3. Search for a Movie" +
                            "\n4. Exit\n");


            sc_in = main.sc.nextInt();
            switch (sc_in) {
                case 1:
                    
                case 2:
                    
                case 3:
                    
                case 4:
                    break;
                default:
                    System.out.println("Invalid input, please choose from the following:");
                    break;
            }

        } while (sc_in != 4);
    }
    
    public void searchMovie() {
        

    }

}
