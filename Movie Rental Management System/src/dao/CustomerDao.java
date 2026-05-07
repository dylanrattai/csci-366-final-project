/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Customer;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {

    public boolean addCustomer(Customer customer) {
        String sql = """
            INSERT INTO customer (first_name, last_name, email, phone, membership_id, created_date)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getPhone());

            if (customer.getMembershipId() == null) {
                stmt.setNull(5, Types.INTEGER);
            } else {
                stmt.setInt(5, customer.getMembershipId());
            }

            LocalDate createdDate = customer.getCreatedDate();
            if (createdDate == null) {
                stmt.setDate(6, Date.valueOf(LocalDate.now()));
            } else {
                stmt.setDate(6, Date.valueOf(createdDate));
            }

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error adding customer: " + e.getMessage());
            return false;
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();

        String sql = """
            SELECT customer_id, first_name, last_name, email, phone, membership_id, created_date
            FROM customer
            ORDER BY last_name, first_name
        """;

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Date sqlDate = rs.getDate("created_date");

                Customer customer = new Customer(
                    rs.getInt("customer_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    (Integer) rs.getObject("membership_id"),
                    sqlDate == null ? null : sqlDate.toLocalDate()
                );

                customers.add(customer);
            }

        } catch (SQLException e) {
            System.out.println("Error getting customers: " + e.getMessage());
        }

        return customers;
    }

    public boolean updateCustomer(Customer customer) {
        String sql = """
            UPDATE customer
            SET first_name = ?, last_name = ?, email = ?, phone = ?, membership_id = ?
            WHERE customer_id = ?
        """;

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getPhone());

            if (customer.getMembershipId() == null) {
                stmt.setNull(5, Types.INTEGER);
            } else {
                stmt.setInt(5, customer.getMembershipId());
            }

            stmt.setInt(6, customer.getCustomerId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error updating customer: " + e.getMessage());
            return false;
        }
    }

    public boolean assignMembership(int customerId, Integer membershipId) {
        String sql = "UPDATE customer SET membership_id = ? WHERE customer_id = ?";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (membershipId == null) {
                stmt.setNull(1, Types.INTEGER);
            } else {
                stmt.setInt(1, membershipId);
            }

            stmt.setInt(2, customerId);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error assigning membership: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteCustomer(int customerId) {
        String sql = "DELETE FROM customer WHERE customer_id = ?";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, customerId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting customer: " + e.getMessage());
            return false;
        }
    }
}
