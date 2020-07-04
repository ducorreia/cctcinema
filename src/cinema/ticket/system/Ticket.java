/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.ticket.system;

/**
 *
 * @author GILMAR
 */
public class Ticket {
   
    private double price;
   // private int number;
    
    public Ticket(){
        
    }
    public Ticket (double price){
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
     
        return "Ticket " + "price: € "+ price ;
    }
    
    
    
    }
    

    
    
   
    

