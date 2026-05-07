/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movieproject;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

/**
 *
 * @author awday
 */
public class InventoryStockedDAO {
    
    public List<InventoryStocked> getInventoryStocked() throws SQLException{
        
        List<InventoryStocked> rows = new ArrayList<>();
               
        Connection connection = DBManager.getConnection();
        
        String list = "SELECT * FROM inventory_stocked";
        
        PreparedStatement pstmt = connection.prepareStatement(list);
        
        ResultSet rs_pstmt = pstmt.executeQuery();
        
        while(rs_pstmt.next()){
            String getMovie_Title = rs_pstmt.getString("movie_title");
            int getInventory_Id = rs_pstmt.getInt("inventory_id");
            
            //Start with a null value
            LocalDate getRental_Date = null;        
            Date rental_returned = rs_pstmt.getDate("rental_date");
            
            if(rental_returned != null){        //if the one returned from database is also null, keep the original null
                getRental_Date = rental_returned.toLocalDate();     //otherwise get the database value
            }
            
            //Same as rental_date
            LocalDate getReturned_Date = null;
            Date returned_returned = rs_pstmt.getDate("returned_date");
            
            if(returned_returned != null){
                getReturned_Date = returned_returned.toLocalDate();
            }
            
            //If rental date is null, it was never rented out
            //If returned date is not null, it was returned after it was taken out most recently
            boolean getIn_Stock = false;
            if(getRental_Date == null || getReturned_Date != null){
                getIn_Stock = true;
            }
            
            
            InventoryStocked inventory = new InventoryStocked(getMovie_Title, getInventory_Id, getIn_Stock);
            rows.add(inventory);
        }
        
        return rows;
        
        
    }
}
