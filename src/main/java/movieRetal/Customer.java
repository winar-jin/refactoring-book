package movieRetal;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Enumeration;
import java.util.Vector;

@SuppressWarnings("unchecked")
@RequiredArgsConstructor
public class Customer {
    @NonNull
    @Getter
    private final String _name;
    private Vector _rentals = new Vector();

    public void addRental(Rental rental) {
        _rentals.addElement(rental);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRentalPoints = 0;
        final Enumeration rentals = _rentals.elements();

        String result = "Rental Record for " + get_name() + "\n";

        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental rental = (Rental) rentals.nextElement();

            // determine amounts for rental line
            switch (rental.get_movie().get_priceCode()) {
                case Movie.REGULAR:
                    thisAmount = calculateRegularRentalAmount(rental);
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount = calculateNewReleaseAmount(rental);
                    break;
                case Movie.CHILDREN:
                    thisAmount = calculateChildrenAmount(rental);
                    break;
            }

            // add frequent renter points
            frequentRentalPoints++;
            // add bonus for a two day new release rental
            if (rental.get_movie().get_priceCode() == Movie.NEW_RELEASE && rental.get_daysRented() > 1) {
                frequentRentalPoints++;
            }

            // show figures for this rental
            result += "\t" + rental.get_movie().get_title() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRentalPoints + " frequent rental points";
        return result;
    }

    private double calculateChildrenAmount(Rental rental) {
        double thisAmount = 1.5;
        if (rental.get_daysRented() > 3) {
            thisAmount += (rental.get_daysRented() - 3) * 1.5;
        }
        return thisAmount;
    }

    private double calculateNewReleaseAmount(Rental rental) {
        return rental.get_daysRented() * 3;
    }

    private double calculateRegularRentalAmount(Rental rental) {
        double thisAmount = 2;
        if (rental.get_daysRented() > 2) {
            thisAmount += (rental.get_daysRented() - 2) * 1.5;
        }
        return thisAmount;
    }
}
