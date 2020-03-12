package movieRetal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Rental {
    private Movie _movie;
    private int _daysRented;

    double getCharge() {
        return _movie.getCharge(get_daysRented());
    }

    int calculateFrequentPoints() {
        if (get_movie().get_priceCode() == Movie.NEW_RELEASE && get_daysRented() > 1) {
            return 2;
        }
        return 1;
    }
}
