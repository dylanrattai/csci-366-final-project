
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Dylan Rattai
 * Data Access Object for MovieInventory. Handles all CRUD operations for the movie_inventory table.
 * Relationship: Many MovieInventory records -> One Movie (via movie_id FK).
 */
public class MovieInventoryDAO {

    /**
     * Adds a new inventory copy of a movie to the database.
     * A single movie can have many inventory records (one per physical copy).
     *
     * @param movieId     The movie this inventory copy belongs to (FK to movie table).
     * @return true if the inventory record was added successfully, false otherwise.
     */
    public boolean addMovieToInventory(int movieId) {
    String sqlStatement = "INSERT INTO movie_inventory (movie_id) VALUES (?)";

    try (Connection conn = DBManager.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sqlStatement)) {

        stmt.setInt(1, movieId);

        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Movie added to inventory successfully.");
        } else {
            System.out.println("Failed to add movie to inventory.");
            return false;
        }

    } catch (SQLException e) {
        System.out.println("Error adding movie to inventory: " + e.getMessage());
        return false;
    }

    return true;
}

    /**
     * Updates the availability status of a specific inventory copy.
     *
     * @param inventoryId The unique identifier for the inventory record to update.
     * @param isAvailable The new availability status.
     * @return true if the record was updated successfully, false otherwise.
     */
    public boolean updateMovieAvailability(int inventoryId, boolean isAvailable) {
        String sqlStatement = "UPDATE movie_inventory SET is_available = ? WHERE inventory_id = ?";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlStatement)) {

            stmt.setBoolean(1, isAvailable);
            stmt.setInt(2, inventoryId);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Movie availability updated successfully.");
            } else {
                System.out.println("No inventory record found with the given ID.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error updating movie availability: " + e.getMessage());
            return false;
        }

        return true;
    }

    /**
     * Deletes a single inventory copy by its inventory ID.
     *
     * @param inventoryId The unique identifier of the inventory record to delete.
     * @return true if the record was deleted successfully, false otherwise.
     */
    public boolean deleteMovieFromInventory(int inventoryId) {
        String sqlStatement = "DELETE FROM movie_inventory WHERE inventory_id = ?";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlStatement)) {

            stmt.setInt(1, inventoryId);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Movie deleted from inventory successfully.");
            } else {
                System.out.println("No inventory record found with the given ID.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error deleting movie from inventory: " + e.getMessage());
            return false;
        }

        return true;
    }

    /**
     * Deletes ALL inventory records associated with a given movie ID.
     * Called by MovieDao.deleteMovie() before removing the movie row
     * to prevent foreign key constraint violations.
     *
     * @param movieId The movie whose inventory records should all be removed.
     * @return true if the records were removed successfully, false otherwise.
     */
    public boolean deleteAllForMovie(int movieId) {
        String sqlStatement = "DELETE FROM movie_inventory WHERE movie_id = ?";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlStatement)) {

            stmt.setInt(1, movieId);
            stmt.executeUpdate();
            System.out.println("All inventory records removed for movie ID: " + movieId);

        } catch (SQLException e) {
            System.out.println("Error deleting inventory for movie: " + e.getMessage());
            return false;
        }

        return true;
    }
}