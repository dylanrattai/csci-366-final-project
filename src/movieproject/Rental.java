
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
 * rental table. Used to get records from the table
 * 
 * @author awday
 */
public class Rental {
    
    private int rentalID;
    private LocalDate rentalDate;
    private int customerID;
    private int soldBy;

    
    public Rental(int rentalID, LocalDate rentalDate, int customerID, int soldBy){
        this.rentalID = rentalID;
        this.rentalDate = rentalDate;
        this.customerID = customerID;
        this.soldBy = soldBy;
    }
    
    /**
     * @return the rentalId
     */
    public int getRentalID() {
        return rentalID;
    }

    /**
     * @return the rentalDate
     */
    public LocalDate getRentalDate() {
        return rentalDate;
    }

    /**
     * @return the customerID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * @return the soldBy
     */
    public int getSoldBy() {
        return soldBy;
    }
    
    
  
    
    
}
