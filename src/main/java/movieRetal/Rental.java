package movieRetal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Rental {
    private Movie _movie;
    private int _daysRented;

    double calculateRentalAmount() {
        return _movie.calculateMovieAmount(get_daysRented());
    }

    int addFrequentPoints(int frequentRentalPoints) {
        frequentRentalPoints++;
        if (_movie instanceof NewReleaseMovie && get_daysRented() > 1) {
            frequentRentalPoints++;
        }
        return frequentRentalPoints;
    }
}
