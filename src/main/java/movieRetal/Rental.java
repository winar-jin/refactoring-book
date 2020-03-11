package movieRetal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Rental {
    private Movie _movie;
    private int _daysRented;

    double calculateRentalAmount() {
        switch (get_movie().get_priceCode()) {
            case Movie.REGULAR:
                return calculateRegularRentalAmount();
            case Movie.NEW_RELEASE:
                return calculateNewReleaseAmount();
            case Movie.CHILDREN:
                return calculateChildrenAmount();
            default:
                return 0;
        }
    }

    private double calculateNewReleaseAmount() {
        return get_daysRented() * 3;
    }

    private double calculateChildrenAmount() {
        double thisAmount = 1.5;
        if (get_daysRented() > 3) {
            thisAmount += (get_daysRented() - 3) * 1.5;
        }
        return thisAmount;
    }

    private double calculateRegularRentalAmount() {
        double thisAmount = 2;
        if (get_daysRented() > 2) {
            thisAmount += (get_daysRented() - 2) * 1.5;
        }
        return thisAmount;
    }
}
