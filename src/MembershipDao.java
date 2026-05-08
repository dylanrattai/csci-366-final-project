/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Membership;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import movieproject.DBManager;

public class MembershipDao {

    public List<Membership> getAllMemberships() {
        List<Membership> memberships = new ArrayList<>();

        String sql = """
            SELECT membership_id, membership_type, discount_percent
            FROM membership
            ORDER BY membership_type
        """;

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Membership membership = new Membership(
                    rs.getInt("membership_id"),
                    rs.getString("membership_type"),
                    rs.getBigDecimal("discount_percent")
                );

                memberships.add(membership);
            }

        } catch (SQLException e) {
            System.out.println("Error getting memberships: " + e.getMessage());
        }

        return memberships;
    }

    public boolean addMembership(Membership membership) {
        String sql = """
            INSERT INTO membership (membership_type, discount_percent)
            VALUES (?, ?)
        """;

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, membership.getMembershipType());
            stmt.setBigDecimal(2, membership.getDiscountPercent());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error adding membership: " + e.getMessage());
            return false;
        }
    }

    public boolean updateMembership(Membership membership) {
        String sql = """
            UPDATE membership
            SET membership_type = ?, discount_percent = ?
            WHERE membership_id = ?
        """;

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, membership.getMembershipType());
            stmt.setBigDecimal(2, membership.getDiscountPercent());
            stmt.setInt(3, membership.getMembershipId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error updating membership: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteMembership(int membershipId) {
        String sql = "DELETE FROM membership WHERE membership_id = ?";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, membershipId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting membership: " + e.getMessage());
            return false;
        }
    }
}