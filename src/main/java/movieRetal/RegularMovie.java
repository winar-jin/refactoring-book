package movieRetal;

public class RegularMovie extends Movie {
    public RegularMovie(String _title) {
        super(_title, Movie.REGULAR);
    }

    @Override
    double calculateMovieAmount(int daysRented) {
        double thisAmount = 2;
        if (daysRented > 2) {
            thisAmount += (daysRented - 2) * 1.5;
        }
        return thisAmount;
    }
}
