package videostore;

public abstract class Movie {
	
	public static final int CHILDRENS = 2;

	public static final int REGULAR = 0;

	public static final int NEW_RELEASE = 1;

	private String _title;

	
	
	public static Movie create(String title, int priceCode) {
		if (priceCode == REGULAR)
			return new Regular(title, priceCode);
		if(priceCode == CHILDRENS)
			return new Children(title, priceCode);
		if(priceCode == NEW_RELEASE)
			return new NewRelease(title, priceCode);
		throw new RuntimeException("Wrong price_code");
	}

	protected Movie(String title, int priceCode) {
		_title = title;
	}


	public String getTitle() {
		return _title;
	}

	abstract double getPrice(int days);

	int getFrequentPoints(int days) {
		 return 1;
	};
}