import java.io.Serializable;
import java.util.ArrayList;

public class Prices implements Serializable
{
    private int BASE_ADULT;
    private int BASE_CHILD;
    private int HOLIDAY_MARKUP;
    private int PREMIUM_MOVIE_MARKUP;
    private int PREMIUM_CINEMA_MARKUP;

    private static ArrayList<String> HOLIDAYS = new ArrayList<>();

    public static void Initialize(ArrayList<Prices> initialPrices){
    
        Data.saveObjectToPath(SaveLoadPath.PRICE_PATH, initialPrices);

    }

    public Prices(int bASE_ADULT, int bASE_CHILD, int hOLIDAY_MARKUP, int pREMIUM_CINEMA_MARKUP, int pREMIUM_MOVIE_MARKUP, ArrayList<String> holidays)
    {
        this.BASE_ADULT = bASE_ADULT;
        this.BASE_CHILD = bASE_CHILD;
        this.HOLIDAY_MARKUP = hOLIDAY_MARKUP;
        this.PREMIUM_CINEMA_MARKUP = pREMIUM_CINEMA_MARKUP;
        this.PREMIUM_MOVIE_MARKUP = pREMIUM_MOVIE_MARKUP;
        this.HOLIDAYS = holidays;
    }
    

    /**
     * @param bASE_ADULT the bASE_ADULT to set
     */
    public void setBASE_ADULT(int bASE_ADULT) {
        BASE_ADULT = bASE_ADULT;
    }

    /**
     * @param bASE_CHILD the bASE_CHILD to set
     */
    public void setBASE_CHILD(int bASE_CHILD) {
        BASE_CHILD = bASE_CHILD;
    }

    /**
     * @param hOLIDAYS the hOLIDAYS to set
     */
    public void setHOLIDAYS(ArrayList<String> hOLIDAYS) {
        HOLIDAYS = hOLIDAYS;
    }

    public void addHolyday(String holiday)
    {
        HOLIDAYS.add(holiday);
    }

    /**
     * @param hOLIDAY_MARKUP the hOLIDAY_MARKUP to set
     */
    public void setHOLIDAY_MARKUP(int hOLIDAY_MARKUP) {
        HOLIDAY_MARKUP = hOLIDAY_MARKUP;
    }

    /**
     * @param pREMIUM_CINEMA_MARKUP the pREMIUM_CINEMA_MARKUP to set
     */
    public void setPREMIUM_CINEMA_MARKUP(int pREMIUM_CINEMA_MARKUP) {
        PREMIUM_CINEMA_MARKUP = pREMIUM_CINEMA_MARKUP;
    }

    /**
     * @param pREMIUM_MOVIE_MARKUP the pREMIUM_MOVIE_MARKUP to set
     */
    public void setPREMIUM_MOVIE_MARKUP(int pREMIUM_MOVIE_MARKUP) {
        PREMIUM_MOVIE_MARKUP = pREMIUM_MOVIE_MARKUP;
    }

    /**
     * @return the bASE_ADULT
     */
    public int getBASE_ADULT() {
        return BASE_ADULT;
    }

    /**
     * @return the bASE_CHILD
     */
    public int getBASE_CHILD() {
        return BASE_CHILD;
    }

    /**
     * @return the hOLIDAYS
     */
    public ArrayList<String> getHOLIDAYS() {
        return HOLIDAYS;
    }

    /**
     * @return the hOLIDAY_MARKUP
     */
    public int getHOLIDAY_MARKUP() {
        return HOLIDAY_MARKUP;
    }

    /**
     * @return the pREMIUM_CINEMA_MARKUP
     */
    public int getPREMIUM_CINEMA_MARKUP() {
        return PREMIUM_CINEMA_MARKUP;
    }

    /**
     * @return the pREMIUM_MOVIE_MARKUP
     */
    public int getPREMIUM_MOVIE_MARKUP() {
        return PREMIUM_MOVIE_MARKUP;
    }

}