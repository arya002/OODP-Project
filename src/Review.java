public class Review {
    private String review;
    private double rating;

    public void print() { // print review
        System.out.println(rating);
        System.out.println(review);
    }

    public double getRating() {
        return rating;
    }
    
    public String getReview(){
        return review;
    }
    
    public void setReview(String review, double rating) {
        this.review = review;
        this.rating = rating;
    }
}
