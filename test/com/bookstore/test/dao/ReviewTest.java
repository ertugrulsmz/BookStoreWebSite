package com.bookstore.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.dao.JpaDao;
import com.bookstore.dao.ReviewDao;
import com.bookstore.entity.Book;
import com.bookstore.entity.Customer_class;
import com.bookstore.entity.Review;

public class ReviewTest {
	
	private static ReviewDao reviewDao;
	private static JpaDao jpaDao1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("tekrar mi");
		reviewDao=new ReviewDao();
		jpaDao1=new JpaDao();
		
	}

	@Test
	public void createReview() {
		Customer_class customer_class=(Customer_class) jpaDao1.find(Customer_class.class,26);
		Book book=(Book) jpaDao1.find(Book.class,140);
		
		Review review=new Review();
		review.setBook(book);
		review.setComment("My third comment !");
		review.setCustomer_class(customer_class);
		review.setHeadline("Another third headline of mine");
		review.setRating(2);
		
		Review review2=reviewDao.create(review);
		assertTrue(review2.getReview_id()>0);
	}
	
	@Test
	public void findReview() {
		Review review=reviewDao.get(15);
		assertTrue(review!=null);
	}
	
	@Test
	public void updateReview() {
		Review review=reviewDao.get(15);
		review.setComment("Nahh , i did not like it ..");
		review.setHeadline("myHeadline");
		
		Review review2=reviewDao.update(review);
		assertTrue(review.getReview_id()==15);
	}
	
	@Test
	public void listAll() {
		List<Review> listreview=reviewDao.listall();
		
		for(Review review : listreview)
		{
			System.out.println(review.getComment());
		}
		
		assertTrue(listreview!=null && listreview.size()==1);

	}
	
	@Test
	public void countAll() {
		long counter=reviewDao.count();
		assertEquals(counter,1);
	}
	
	@Test
	public void reachBook() {
		Review review=reviewDao.get(15);
		String booktitleString=review.getBook().getTitle();
		System.out.println("Book titleeeeeeeee --------------     :"+booktitleString);
		assertTrue(booktitleString!=null && !booktitleString.isBlank());
	}
	
	@Test
	public  void lastReviews() {
		List<Review> lastReviews=reviewDao.lastReviews();
		
		for(Review r:lastReviews)
		{
			System.out.println(r.getHeadline());
		}
		
		assertTrue(!lastReviews.isEmpty());
	}
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("takrar close");
	}

}
