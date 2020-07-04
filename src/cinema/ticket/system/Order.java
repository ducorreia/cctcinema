/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.ticket.system;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GILMAR
 */
public class Order {

   
    private String movie;
    private ArrayList<Ticket> tickets = new ArrayList<>();
    
       
    public Order (String movie, int number){
        this.setMovie(movie);
        for(int i = 0; i < number; i++)
            this.tickets.add(new Ticket());
        
    }

    
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }


    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Order \n" + "Movie: " + movie + "\n" + "Ticket(s) price: " + tickets +"\n";
        
    }


}