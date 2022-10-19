package videostore;

public class Regular extends Movie {

	public Regular(String title, int priceCode) {
		super(title, priceCode); 
	}
	
	double getPrice(int days) {
		double thisAmount = 2;
			if (days > 2)
				thisAmount += (days - 2) * 1.5;
			return thisAmount; 
		
		}

}
