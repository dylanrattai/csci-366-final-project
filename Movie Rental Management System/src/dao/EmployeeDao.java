/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public boolean addEmployee(Employee employee) {
        String sql = """
            INSERT INTO employee (first_name, last_name, phone, role_id)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getPhone());
            stmt.setInt(4, employee.getRoleId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error adding employee: " + e.getMessage());
            return false;
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        String sql = """
            SELECT employee_id, first_name, last_name, phone, role_id
            FROM employee
            ORDER BY last_name, first_name
        """;

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Employee employee = new Employee(
                    rs.getInt("employee_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("phone"),
                    rs.getInt("role_id")
                );

                employees.add(employee);
            }

        } catch (SQLException e) {
            System.out.println("Error getting employees: " + e.getMessage());
        }

        return employees;
    }

    public List<Employee> getEmployeesByRole(int roleId) {
        List<Employee> employees = new ArrayList<>();

        String sql = """
            SELECT employee_id, first_name, last_name, phone, role_id
            FROM employee
            WHERE role_id = ?
            ORDER BY last_name, first_name
        """;

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, roleId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Employee employee = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone"),
                        rs.getInt("role_id")
                    );

                    employees.add(employee);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error getting employees by role: " + e.getMessage());
        }

        return employees;
    }

    public boolean updateEmployeeRole(int employeeId, int roleId) {
        String sql = "UPDATE employee SET role_id = ? WHERE employee_id = ?";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, roleId);
            stmt.setInt(2, employeeId);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error updating employee role: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteEmployee(int employeeId) {
        String sql = "DELETE FROM employee WHERE employee_id = ?";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, employeeId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
            return false;
        }
    }
}