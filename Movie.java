

import java.math.BigDecimal;

public class Movie {
    private int movieId;
    private String movieTitle;
    private BigDecimal moviePrice;

    public Movie() {
    }

    public Movie(String movieTitle, BigDecimal moviePrice) {
        this.movieTitle = movieTitle;
        this.moviePrice = moviePrice;
    }

    public Movie(int movieId, String movieTitle, BigDecimal moviePrice) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.moviePrice = moviePrice;
    }

    public void setTitle(String title) {
        this.movieTitle = title;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return movieTitle;
    }
    

    public void setRentPrice(BigDecimal rentPrice) {
        this.moviePrice = rentPrice;
    }

    public boolean validate() {
        if (movieTitle == null || movieTitle.trim().isEmpty()) {
            System.out.println("Movie title cannot be empty.");
            return false;
        }
        if (getMoviePrice() == null || getMoviePrice().compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Movie price must be a positive value.");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movie ID: " + movieId + ", Title: " + movieTitle + ", Price: $" + getMoviePrice();
    }

    /**
     * @return the moviePrice
     */
    public BigDecimal getMoviePrice() {
        return moviePrice;
    }
}