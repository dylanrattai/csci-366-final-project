
package movieproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author awday
 */
public class DBManager {
    
    static String jdbcURL = "jdbc:postgresql://localhost:5432/movie_rental";
    static String username = "postgres";
    static String password = "Stmc20520";
    
    private static Connection connection;
    
    public DBManager(){
        
    }
    
    public static Connection getConnection(){
        if(connection == null){
            setConnection();
        }
        return connection;
    }
    
    private static void setConnection(){
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcURL, username, password);
        }
        catch(ClassNotFoundException cnf){
            System.out.println("Cannot load the postgresql driver.");
            cnf.printStackTrace();
        }
        catch(SQLException sql){
            System.out.println("Got SQL exception 1");
            
        }
    }
    
}
