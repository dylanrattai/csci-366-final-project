
package movieproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author awday
 */
public class MostRentedDAO {
    
    public static ArrayList<MostRented> getMostRented() throws SQLException{
              
        ArrayList<MostRented> rows = new ArrayList();
               
        Connection connection = DBManager.getConnection();
        
        String list = "SELECT * FROM most_rented";
        
        PreparedStatement pstmt = connection.prepareStatement(list);
        
        ResultSet rs_pstmt = pstmt.executeQuery();
        
        while(rs_pstmt.next()){
            
            String getMovieTitle = rs_pstmt.getString("movie_title");
            int getTimesRented = rs_pstmt.getInt("times_rented");
            
            MostRented mostRented = new MostRented(getMovieTitle, getTimesRented);
            rows.add(mostRented);
            
        }
        
        return rows;
        
    }
}
