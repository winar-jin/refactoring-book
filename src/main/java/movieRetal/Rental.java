package movieRetal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Rental {
    private Movie _movie;
    private int _daysRented;

    double calculateARental() {
        double thisAmount = 0;
        switch (get_movie().get_priceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (get_daysRented() > 2) {
                    thisAmount += (get_daysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += get_daysRented() * 3;
                break;
            case Movie.CHILDREN:
                thisAmount += 1.5;
                if (get_daysRented() > 3) {
                    thisAmount += (get_daysRented() - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }

    int calculateFrequentPoints() {
        if (get_movie().get_priceCode() == Movie.NEW_RELEASE && get_daysRented() > 1) {
            return 2;
        }
        return 1;
    }
}
