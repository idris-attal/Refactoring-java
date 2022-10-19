package videostore.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import videostore.Customer;
import videostore.Movie;
import videostore.Rental;

public class TestCustomer{
	
	Customer client;

	@BeforeEach
	protected void setUp() throws Exception {
		client = new Customer("John");
	}
	
	@Test
	public void nameCreation(){
		String result = client.statement();
		assertContain(result,"Rental Record for John");
	}
	
	@Test
	public void oneRegularOneDay(){
		rentMovie("Indiana Jones",Movie.REGULAR,1);
		String result = client.statement();
		assertContain(result,"Amount owed is 2.0");
		assertContain(result,"You earned 1 frequent renter points");
	}
	
	@Test
	public void oneRegularTreeDays(){
		rentMovie("Indiana Jones",Movie.REGULAR,3);
		String result = client.statement();
		assertContain(result,"Amount owed is 3.5");
		assertContain(result,"You earned 1 frequent renter points");
	}
	
	@Test
	public void oneChildrensOneDay(){
		rentMovie("Finding Nemo",Movie.CHILDRENS,1);
		String result = client.statement();
		assertContain(result,"Amount owed is 1.5");
		assertContain(result,"You earned 1 frequent renter points");
	}
	
	@Test
	public void oneChildrensFiveDays(){
		rentMovie("Finding Nemo",Movie.CHILDRENS,5);
		String result = client.statement();
		assertContain(result,"Amount owed is 4.5");
		assertContain(result,"You earned 1 frequent renter points");
	}
	
	@Test
	public void oneNewReleaseOneDay(){
		rentMovie("Spider Man - Far from Home",Movie.NEW_RELEASE,1);
		String result = client.statement();
		assertContain(result,"Amount owed is 3.0");
		assertContain(result,"You earned 1 frequent renter points");
	}
	
	@Test
	public void oneNewReleaseTreeDays(){
		rentMovie("Spider Man - Far from Home",Movie.NEW_RELEASE,3);
		String result = client.statement();
		assertContain(result,"Amount owed is 9.0");
		assertContain(result,"You earned 2 frequent renter points");
	}
	
	@Test
	public void manyRents(){
		rentMovie("Spider Man - Far from Home",Movie.NEW_RELEASE,2);
		rentMovie("Dune",Movie.NEW_RELEASE,3);
		rentMovie("Finding Nemo",Movie.CHILDRENS,3);
		rentMovie("Indiana Jones",Movie.REGULAR,2);
		rentMovie("The Lion King",Movie.CHILDRENS,4);
		rentMovie("Matrix",Movie.REGULAR,3);
		String result = client.statement();
		assertContain(result,"Amount owed is 25.0");
		assertContain(result,"You earned 8 frequent renter points");
	}
	
	private void rentMovie(String title, int type, int days) {
		Movie movie =  Movie.create(title,type);
		Rental rent = new Rental(movie,days);
		client.addRental(rent);
	}

	private void assertContain(String result, String content) {
		assertTrue(result.indexOf(content)>=0);
	}
	
}
