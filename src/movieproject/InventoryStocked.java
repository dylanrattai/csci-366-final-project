
package movieproject;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * inventory_stocked view. Used to get queries about which movies are in stock
 * 
 * @author awday
 */
public class InventoryStocked {
    
    private String movie_title;
    private int inventory_id;
    private LocalDate rental_date;
    private LocalDate returned_date;
    private boolean in_stock;

    
    public InventoryStocked(String movie_title, int inventory_id, boolean in_stock){
        this.movie_title = movie_title;
        this.inventory_id = inventory_id;
        this.in_stock = in_stock;
    }
    
    /**
     * @return the movie_title
     */
    public String getMovie_title() {
        return movie_title;
    }

    /**
     * @return the inventory_id
     */
    public int getInventory_id() {
        return inventory_id;
    }

    /**
     * @return the rental_date
     */
    public LocalDate getRental_date() {
        return rental_date;
    }

    /**
     * @return the returned_date
     */
    public LocalDate getReturned_date() {
        return returned_date;
    }
    
    /**
     * @return the in_stock
     */
    public boolean getIn_stock() {
        return in_stock;
    }
    

    
}
