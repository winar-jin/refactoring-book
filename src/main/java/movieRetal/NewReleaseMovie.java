package movieRetal;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String _title) {
        super(_title, Movie.NEW_RELEASE);
    }

    @Override
    double calculateMovieAmount(int daysRented) {
        return daysRented * 3;
    }
}
