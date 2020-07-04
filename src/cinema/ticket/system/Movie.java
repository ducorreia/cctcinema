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
public class Movie {
    private String nameOfTheMovie;
    private String type;
    private String description;
 
    public Movie (String nameOfTheMovie){
        this.nameOfTheMovie = nameOfTheMovie;
   }
    
    public Movie (String nameOfTheMovie, String type, String description){
        this.nameOfTheMovie = nameOfTheMovie;
        this.type = type;
        this.description=description;
    }
//    public Movie (String [] nameOfTheMovie){
//        
//    }

    public String getNameOfTheMovie() {
        return nameOfTheMovie;
    }

    public String getType() {
        return type;
    }

    public void setNameOfTheMovie(String nameOfTheMovie) {
        this.nameOfTheMovie = nameOfTheMovie;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return nameOfTheMovie +"\n"+ type +"\n"+  description +"\n" ;
    }

    
    
    
}
    
    
    


