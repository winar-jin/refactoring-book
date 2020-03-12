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

    int getFrequentPoint() {
        return _movie.getFrequentPoint(get_daysRented(), this);
    }
}
