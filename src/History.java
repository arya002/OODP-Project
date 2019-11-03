import java.util.ArrayList;

public class History {
    private ArrayList<Review> reviews;
    private ArrayList<Ticket> tickets;

    //<editor-fold desc="Constructors">
    public History(String file) {
//        TODO read from file
//        this(attributes);
    }

    public History(ArrayList<Review> reviews, ArrayList<Ticket> tickets) {
        this.reviews = reviews;
        this.tickets = tickets;
    }

    public History() {
        this.reviews = new ArrayList<Review>();
        this.tickets = new ArrayList<Ticket>();
    }
    //</editor-fold>

    //<editor-fold desc="Adders">
    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void addReviews(Iterable<Review> reviews) {
        for (Review rev : reviews) {
            this.addReview(rev);
        }
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public void addTickets(Iterable<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            this.addTicket(ticket);
        }
    }
    //</editor-fold>

    //<editor-fold desc="Getters">
    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public Review getReview(int i) {
        return this.reviews.get(i);
    }

    public Ticket getTicket(int i) {
        return this.tickets.get(i);
    }
    //</editor-fold>

    //<editor-fold desc="Printing">
    public void printTickets(int begin, int end) {
        for (int i=begin; i<end; i++) {
            this.tickets.get(i).print();
        }
    }

    public void printTickets(int i) {
        this.printTickets(0, i);
    }

    public void printTickets() {
        this.printTickets(0, this.tickets.size());
    }

    public void printTickets(Iterable<Integer> positions) {
        for (Integer i : positions) {
            this.tickets.get(i).print();
        }
    }

    public void printReviews(int begin, int end) {
        for (int i=begin; i<end; i++) {
            this.reviews.get(i).print();
        }
    }

    public void printReviews(int i) {
        this.printReviews(0, i);
    }

    public void printReviews() {
        this.printReviews(0, this.reviews.size());
    }

    public void printReviews(Iterable<Integer> positions) {
        for (Integer i : positions) {
            this.reviews.get(i).print();
        }
    }
    //</editor-fold>

}
