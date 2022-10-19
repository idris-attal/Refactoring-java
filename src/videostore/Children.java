package videostore;

public class Children extends Movie {

	public Children(String title, int priceCode) {
		super(title, priceCode);
		// TODO Auto-generated constructor stub
	}

	@Override
	double getPrice(int days) {
		// TODO Auto-generated method stub
		double thisAmount = 1.5;
		if (days > 3)
			thisAmount += (days - 3) * 1.5;
		return thisAmount;
	}
	 

}
