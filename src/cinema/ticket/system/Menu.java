/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.ticket.system;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author GILMAR
 */
public class Menu {
    Logic logic = new Logic();
  
  
    
public void displayingMenu(Movie [] line,  ArrayList<Order> orders){
    
    Scanner mainMenu = new Scanner(System.in);
    
    System.out.println("Please choose an option below:");
    System.out.println("1) Create an order");
    System.out.println("2) List of Movies");
    System.out.println("3) History");
    System.out.println("4) Exit");
    int option = mainMenu.nextInt();
        switch (option){
            
            case 1:
                  System.out.println("Create an order");
                  System.out.println("_______________");
                  logic.readingMovies(line);
                  logic.choosingMovie(line);
                  int inputNumberOfTickets = logic.creatingTickets();
                  Order order = logic.creatingOrder(line, orders);
                  System.out.println(order.toString());
                  System.out.println("Purchase total: € "+logic.summingPrice(order.getTickets()));
                  System.out.println(" ");
                  break;
             
            case 2:
                System.out.println("List of movies");
                System.out.println("_______________");
                logic.readingMovies(line);
        
                break;
               
           case 3:
               System.out.println("View previous orders");
               System.out.println("_______________");
               logic.printHistory(orders);
               logic.savingHistoric(orders);
               
                break;
          
            case 4:
                System.exit(0);

                break;
              
            default:
                System.out.println("--------------------------------------------");
                System.out.println("Invalid option");
                System.out.println("--------------------------------------------");
                
               displayingMenu(line, orders);
        
        }    
    }
}
