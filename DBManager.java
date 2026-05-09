


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author awday
 */
public class DBManager {

    
    private static final String jdbcURL =
            "jdbc:postgresql://localhost:5432/movie_rental";

    private static final String username = "postgres";
    private static final String password = "Stmc20520";

    

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, username, password);
    }
}
    

