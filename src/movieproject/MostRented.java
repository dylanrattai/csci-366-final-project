
package movieproject;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * most_rented view. Used to get queries about how many times each movie has been rented
 * 
 * @author awday
 */
public class MostRented {
    
    private String movie_title;
    private int times_rented;

    
    public MostRented(String movie_name, int times_rented){
        this.movie_title = movie_name;
        this.times_rented = times_rented;
    }
    
    /**
     * @return the movie_name
     */
    public String getMovie_title() {
        return movie_title;
    }

    /**
     * @return the times_rented
     */
    public int getTimes_rented() {
        return times_rented;
    }
    
   
    
    
    
    
    
}
