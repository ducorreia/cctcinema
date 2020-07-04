/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.ticket.system;

import java.util.ArrayList;

/**
 *
 * @author GILMAR
 */
public class CinemaTicketSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //        Usar somenten qdo iniciar o Menu

        System.out.println("WELCOME TO CCT CINEMA");
        
       Menu menu = new Menu();
       Movie[] line = new Movie[8];
       ArrayList<Order> orders = new ArrayList();
 
       while(true) {
           menu.displayingMenu(line, orders);
      }
       
    }
      
}
