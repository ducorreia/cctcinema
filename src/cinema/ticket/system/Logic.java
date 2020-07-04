/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema.ticket.system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author GILMAR
 */

public class Logic {

    int inputMovie;
    int inputNumberOfTickets;
    //double numInFile;
    //ArrayList<Ticket> numberOfTicketsPerOrder;
    // Ticket [] numberOfTicket;
// This method is used to read the information from the movies. There is possible to find the movie`s name, type and also a descripition of each movie.

    public Movie[] readingMovies(Movie[] line) {
        int i = 0;
        try {

            BufferedReader listOfMovies = new BufferedReader(new FileReader("movies.txt"));

            String nextWord = "a";

            while (nextWord != null) {

                nextWord = listOfMovies.readLine();
                if (nextWord == null) {
                    break;
                }
                // Slipting the parts of text file 
                String[] parts = nextWord.split(";");
                String nameofTheMovie = parts[0];
                String type = parts[1];
                String description = parts[2];

                // Adding movies to an array 
                line[i] = new Movie(nameofTheMovie, type, description);

                System.out.println("Movie " + "[" + (i + 1) + "]");// Somei mais um para mostrar o numero do numero do filme corretamente

                System.out.println(line[i]);
                i++;

            }

        } catch (IOException e) {
            System.out.println("File Access Error.");
            System.exit(1);

        }
        return line;
    }
// That is a method to read the price from the file. The price is in an file a part from the movie.

    public double readingPrices() {
        String fileInput = "";
        double numInFile = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("prices.txt"));
            fileInput = reader.readLine();
            numInFile = Double.parseDouble(fileInput);
        } catch (Exception e) {
            System.out.println("Error message");

        }
        return numInFile;
    }

    public void choosingMovie(Movie[] line) {
        Scanner inputNumberMovie = new Scanner(System.in);
        System.out.println("Please, choose the movie number that you would like to watch");
        inputMovie = inputNumberMovie.nextInt();
    }
// Here it can be seen the method responsable to create orders. In this method will be used the input from the user about number 
    //  of tickets and also the movie name of the movie chosen.

    public Order creatingOrder(Movie[] line, ArrayList<Order> orders) {
        Order order = new Order(line[inputMovie - 1].getNameOfTheMovie(), inputNumberOfTickets);

        orders.add(order);

        setTicketValue(order.getTickets());

        return order;
    }
    //System.out.println(tickets[inputNumberOfTickets].toString());

    //Method to return the input of the number of tickets. 
    public int creatingTickets() {

        Scanner inputTickets = new Scanner(System.in);
        System.out.println("How many tickets would you like?");
        inputNumberOfTickets = inputTickets.nextInt();

        return inputNumberOfTickets;
    }
// Method to set the value to tickets bought

    public void setTicketValue(ArrayList<Ticket> tickets) {
        double numInFile = readingPrices();
        double discount1;
        double normalPrice;
        double discount2;
        for (int count = 0; count < tickets.size(); count++) {

            System.out.println("Please, choose the range of age of the customer " + count + ":");
// The user has the possibility to choose the age of each customer.
            Scanner rangeAge = new Scanner(System.in);
            System.out.println("1) Ages 0 – 12. ");
            System.out.println("2) Ages 13 – 64. ");
            System.out.println("3) Ages 65 and older. ");
            int optionRange = rangeAge.nextInt();
            // According to the option chosen by the user, it will calcute of price of each ticket
            switch (optionRange) {

                case 1:
                    discount1 = (numInFile * 0.6);
                    tickets.get(count).setPrice(discount1);

                    break;
                case 2:
                    normalPrice = numInFile;
                    tickets.get(count).setPrice(normalPrice);
                    break;
                case 3:
                    discount2 = (numInFile * 0.6);
                    tickets.get(count).setPrice(discount2);
                    break;

                default:
                    System.out.println("--------------------------------------------");

                    System.out.println("Invalid age, please choose age");
                    System.out.println("--------------------------------------------");
            }
        }
        //return;
    }

    //Used to sum all the prices of tickets in an order.
    public double summingPrice(ArrayList<Ticket> priceOfTickets) {

        double sum = 0;
        for (Ticket ticket : priceOfTickets) {
            sum += ticket.getPrice();
        }
        return sum;

    }
    //This method is used to print the historic of orders in the screen.

    public void printHistory(ArrayList<Order> orders) {

        for (int count = 0; count < orders.size(); count++) {
            System.out.println(orders.get(count));

        }
    }
//This method was created to append the historic of order into a file.txt

    public void savingHistoric(ArrayList<Order> orders) {

        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter("myHistory.txt"));

            for (int count = 0; count < orders.size(); count++) {

                myWriter.append(Double.toString(orders.get(count).getTickets().get(count).getPrice()));
            }

        } catch (Exception e) {
            System.out.println("No File");
        }
    }

 
}

   
