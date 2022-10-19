package videostore;

public class NewRelease extends Movie {

	protected NewRelease(String title, int priceCode) {
		super(title, priceCode);
	}

	@Override
	double getPrice(int days) {
		return days*3;
	}
	
	int getFrequentPoints(int days) {
		if (days > 1)
			return 2;
		return 1;
	};

}
