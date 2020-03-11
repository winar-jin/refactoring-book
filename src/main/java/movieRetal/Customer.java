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
            Rental each = (Rental) rentals.nextElement();

            // determine amounts for each line
            switch (each.get_movie().get_priceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.get_daysRented() > 2) {
                        thisAmount += (each.get_daysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.get_daysRented() * 3;
                    break;
                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if (each.get_daysRented() > 3) {
                        thisAmount += (each.get_daysRented() - 3) * 1.5;
                    }
                    break;
            }

            // add frequent renter points
            frequentRentalPoints++;
            // add bonus for a two day new release rental
            if (each.get_movie().get_priceCode() == Movie.NEW_RELEASE && each.get_daysRented() > 1) {
                frequentRentalPoints++;
            }

            // show figures for this rental
            result += "\t" + each.get_movie().get_title() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRentalPoints) + " frequent rental points";
        return result;
    }
}
