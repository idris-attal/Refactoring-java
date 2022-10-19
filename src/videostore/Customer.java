package videostore;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	
	private String _name;
	private Vector _rentals = new Vector();
	double totalAmount =0;
	int frequentRenterPoints =0;

	public Customer(String name) {
		_name = name;
	};

	public void addRental(Rental rental) {
		_rentals.addElement(rental);
		totalAmount += rental.getPrice();
		frequentRenterPoints += rental.getFrequentPoints();
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {		
			Rental each = (Rental) rentals.nextElement();
			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(each.getPrice()) + "\n";
		}
		result += "Amount owed is " + String.valueOf(totalAmount()) + "\n";
		result += "You earned " + String.valueOf(frequentPoints())
				+ " frequent renter points";
		return result;
	}
	
	public double totalAmount() {
		return totalAmount;
	}
	public int frequentPoints() {
		return frequentRenterPoints;
	} 
}