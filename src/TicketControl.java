import java.util.ArrayList;

public class TicketControl {


    private static TicketControl sSoleInstances=null;

    private static ArrayList<Ticket> currentTickets;

    private TicketControl(){

        Data data = Data.getInstance();
        currentTickets = (ArrayList<Ticket>) data.getObjectFromPath("Data/ticket.txt",Ticket.class);

    }

    public static TicketControl getInstance(){

        if (sSoleInstances == null)
            sSoleInstances = new TicketControl();

        return sSoleInstances;
    }

    public ArrayList<Ticket> getAllTickets(){
        return currentTickets;
    }

    public ArrayList<Ticket> getAllTickets(String movieName){
        ArrayList<Ticket> retArray = new ArrayList<>();
        for(Ticket ticket: currentTickets)
            if (ticket.getName() == movieName)
                retArray.add(ticket);
        return currentTickets;
    }



}
