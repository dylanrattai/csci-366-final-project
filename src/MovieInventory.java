
public class MovieInventory {
    private int inventoryId;
    private int movieId;
    private boolean isAvailable;

    public MovieInventory() {
    }

    public MovieInventory(int movieId, boolean isAvailable) {
        this.movieId = movieId;
        this.isAvailable = isAvailable;
    }

    public MovieInventory(int inventoryId, int movieId, boolean isAvailable) {
        this.inventoryId = inventoryId;
        this.movieId = movieId;
        this.isAvailable = isAvailable;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public boolean checkAvailability(){
        return isAvailable;
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public int getMovie() {
        return movieId;
    }

    @Override
    public String toString() {
        return "Inventory ID: " + inventoryId + ", Movie ID: " + movieId + ", Available: " + isAvailable;
    }
}