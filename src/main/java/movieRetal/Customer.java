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
            Rental each = (Rental) rentals.nextElement();

            double thisAmount = each.calculateARental();

            // add frequent renter points
            frequentRentalPoints++;
            // add bonus for a two day new release rental
            if (each.get_movie().get_priceCode() == Movie.NEW_RELEASE && each.get_daysRented() > 1) {
                frequentRentalPoints++;
            }

            // show figures for this rental
            result += "\t" + each.get_movie().get_title() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRentalPoints + " frequent rental points";
        return result;
    }
}
