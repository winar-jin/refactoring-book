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
        StringBuilder result = new StringBuilder();

        addHeaderToStatement(result);

        while (rentals.hasMoreElements()) {
            Rental rental = (Rental) rentals.nextElement();

            frequentRentalPoints = rental.addFrequentPoints(frequentRentalPoints);
            double rentalAmount = rental.calculateRentalAmount();
            totalAmount += rentalAmount;

            addRentalToStatement(result, rental, rentalAmount);
        }

        addFooterToStatement(totalAmount, frequentRentalPoints, result);

        return result.toString();
    }

    private void addFooterToStatement(double totalAmount, int frequentRentalPoints, StringBuilder result) {
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRentalPoints).append(" frequent rental points");
    }

    private void addRentalToStatement(StringBuilder result, Rental rental, double thisAmount) {
        result.append("\t").append(rental.get_movie().get_title()).append("\t").append(thisAmount).append("\n");
    }

    private void addHeaderToStatement(StringBuilder result) {
        result.append("Rental Record for ")
              .append(get_name()).append("\n").toString();
    }

}
