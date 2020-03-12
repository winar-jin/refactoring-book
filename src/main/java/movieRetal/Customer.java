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
        final Enumeration rentals = _rentals.elements();

        String result = "Rental Record for " + get_name() + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += "\t" + each.get_movie().get_title() + "\t" + each.getCharge() + "\n";
        }

        result += "Amount owed is " + calculateTotalAmount() + "\n";
        result += "You earned " + calculateTotalFrequentPoints() + " frequent rental points";
        return result;
    }

    private double calculateTotalAmount() {
        final Enumeration rentals = _rentals.elements();
        double totalAmount = 0;
        while (rentals.hasMoreElements()) {
            final Rental rental = (Rental) rentals.nextElement();
            totalAmount += rental.getCharge();
        }
        return totalAmount;
    }

    private int calculateTotalFrequentPoints() {
        final Enumeration rentals = _rentals.elements();
        int totalFrequentPoints = 0;
        while (rentals.hasMoreElements()) {
            final Rental rental = (Rental) rentals.nextElement();
            totalFrequentPoints += rental.getFrequentPoint();
        }
        return totalFrequentPoints;
    }
}
