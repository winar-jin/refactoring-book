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
}
