package movieRetal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    @Getter
    private String _title;

    @Getter
    @Setter
    private int _priceCode;

    double calculateMovieAmount(int daysRented) {
        if (this instanceof RegularMovie) {
            return calculateRegularRentalAmount(daysRented);
        }

        if (this instanceof NewReleaseMovie) {
            return calculateNewReleaseAmount(daysRented);
        }

        if (this instanceof ChildrenMovie) {
            return calculateChildrenAmount(daysRented);
        }
        return 0;
    }

    private double calculateRegularRentalAmount(int daysRented) {
        double thisAmount = 2;
        if (daysRented > 2) {
            thisAmount += (daysRented - 2) * 1.5;
        }
        return thisAmount;
    }

    private double calculateChildrenAmount(int daysRented) {
        double thisAmount = 1.5;
        if (daysRented > 3) {
            thisAmount += (daysRented - 3) * 1.5;
        }
        return thisAmount;
    }

    private double calculateNewReleaseAmount(int daysRental) {
        return daysRental * 3;
    }
}
