package movieRetal;

import lombok.Getter;

public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    @Getter
    private String _title;

    private Price price;

    public Movie(String _title, int price) {
        this._title = _title;
        setPrice(price);
    }

    private void setPrice(int priceCode) {
        switch (priceCode) {
            case CHILDREN:
                price = new ChildrenPrice();
                break;
            case REGULAR:
                price = new RegularPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    double getCharge(int daysRented) {
        double thisAmount = 0;
        switch (getPrice()) {
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

    private int getPrice() {
        return price.getPriceCode();
    }

    int getFrequentPoint(int daysRented, Rental rental) {
        if (rental.get_movie().getPrice() == NEW_RELEASE && daysRented > 1) {
            return 2;
        }
        return 1;
    }
}
