/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Role;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import movieproject.DBManager;

/**
 *
 * @author alq24
 */
public class RoleDao {
    
    public List<Role> getAllRoles() throws SQLException {
        List<Role> roles = new ArrayList<>();
        
        String sql = "SELECT role_id, role_type FROM role ORDER BY role_type";
        
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
