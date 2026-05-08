

import java.time.LocalDate;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author awday
 */
public class RentalDAO {
    
    public List<Rental> getRentals() throws SQLException{
        
        List<Rental> rows = new ArrayList(); 
                
        Connection connection = DBManager.getConnection();
        
        String list_rentals = "SELECT * FROM rental_view";
        
        PreparedStatement pstmt = connection.prepareStatement(list_rentals);
        
        ResultSet rs_pstmt = pstmt.executeQuery();
        
        while(rs_pstmt.next()){
            int getRentalID = rs_pstmt.getInt("rental_id");
            LocalDate getRentalDate = LocalDate.parse(rs_pstmt.getString("rental_date"));
            int getCustomerID = rs_pstmt.getInt("customer_id");
            String getCustFirstName = rs_pstmt.getString("customer_first_name");
            String getCustLastName = rs_pstmt.getString("customer_last_name");
            int getSoldBy = rs_pstmt.getInt("sold_by");
            String getEmployeeFirstName = rs_pstmt.getString("employee_first_name");
            double getTotalPrice = rs_pstmt.getDouble("total_price");
            
            Rental rental = new Rental(getRentalID, getRentalDate, getCustomerID, getSoldBy, getCustFirstName, getCustLastName, getEmployeeFirstName, getTotalPrice);
            
            rows.add(rental);
            
        }
        
        return rows;
        
    }
}