
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alq24
 */
public class RoleDao {
    
    public List<Role> getAllRoles() throws SQLException {
        List<Role> roles = new ArrayList<>();
        
        String sql = "SELECT role_id, role_type FROM role ORDER BY role_id";
        
        try(Connection conn = DBManager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            
            while(rs.next()){
                Role role = new Role(
                rs.getInt("role_id"),
                rs.getString("role_type"));
                roles.add(role);
            }
        } catch (SQLException e) {
            System.out.println("Error getting roles: " + e.getMessage());
        }
        return roles;
    }
    
}
