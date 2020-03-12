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

    double getCharge(int daysRented) {
        double thisAmount = 0;
        switch (get_priceCode()) {
            case REGULAR:
                thisAmount += 2;
                if (daysRented > 2) {
                    thisAmount += (daysRented - 2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case CHILDREN:
                thisAmount += 1.5;
                if (daysRented > 3) {
                    thisAmount += (daysRented - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }

    int getFrequentPoint(int daysRented, Rental rental) {
        if (rental.get_movie().get_priceCode() == NEW_RELEASE && daysRented > 1) {
            return 2;
        }
        return 1;
    }
}
