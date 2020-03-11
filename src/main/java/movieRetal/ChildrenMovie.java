package movieRetal;

public class ChildrenMovie extends Movie {
    public ChildrenMovie(String _title) {
        super(_title, Movie.CHILDREN);
    }

    @Override
    double calculateMovieAmount(int daysRented) {
        double thisAmount = 1.5;
        if (daysRented > 3) {
            thisAmount += (daysRented - 3) * 1.5;
        }
        return thisAmount;
    }
}
