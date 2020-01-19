package com.bookstore.test.dao;



import static org.junit.Assert.assertTrue;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.dao.BookDao;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.entity.Review;



public class BookTest{
	
	private static BookDao bookDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bookDao=new BookDao();
		System.out.println("bookdao");
	}
	
	@Test
	public void CreateBook() throws ParseException, IOException {
		System.out.println("bookdao");
		Category category=new Category();
		category.setCategory_id(2);
		category.setName("Matha");
		
		Book book=new Book();
		book.setTitle("uEffectic Java");
		book.setAuthor("uJoshua Blanc");
		book.setDescription("new coverage ");
		book.setPrice((float) 38.87);
		book.setIsbn("0332123");
		book.setCategory(category);
			
		
		DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		Date publishdate=dateFormat.parse("08/28/2008");
		book.setPublish_date(publishdate);
		
		String uri="C:\\Users\\ertug\\Desktop\\books\\Effective Java.JPG";
		byte[] imageByte=Files.readAllBytes(Path.of(uri));
		book.setImage(imageByte);
		
	
		
		Book createdBook=bookDao.create(book);
		if(createdBook==null) {
			System.out.println("created null");
		}
		assertTrue(createdBook.getBook_id()>0);	
	}
	
	@Test
	public void UpdateBook() throws ParseException, IOException {
		Category category=new Category();
		category.setCategory_id(5);
		category.setName("General Science");
		
		
		Book book=new Book();
		book.setTitle("Effectic c++");
		book.setAuthor("Mike Blanc");
		book.setDescription("new coverage ");
		book.setPrice((float) 30.37);
		book.setIsbn("0332123");
		book.setCategory(category);
		book.setBook_id(126);
			
		
		DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
		Date publishdate=dateFormat.parse("08/28/2002");
		book.setPublish_date(publishdate);
		
		String uri="C:\\Users\\ertug\\Desktop\\books\\Effective Java.JPG";
		byte[] imageByte=Files.readAllBytes(Path.of(uri));
		book.setImage(imageByte);
		
		Book updatedBook=bookDao.update(book);
		assertTrue(updatedBook.getBook_id()==book.getBook_id());
	
	}
	@Test
	public void DeleteBook() {
		bookDao.delete(127);
		assertTrue(true);
	}
	@Test
	public void GetBook() {
		Book book=bookDao.get(140);
		assertTrue(book.getBook_id()==140);
	}
	
	@Test
	public void listbooks() {
		List<Book> booklist=bookDao.listall();
		assertTrue(booklist.size()>0);
		
	}
	@Test
	public void findByTitle()
	{
		String searchedtitleString="Head First Servlets and JSP";
		Book book=bookDao.findByTitle(searchedtitleString);
		assertTrue(book!=null);
	}
	
	@Test
	public void Count() {
		long countbook=bookDao.count();
		assertTrue(countbook==2);
	}
	
	@Test
	public void countByCategory()
	{
		List<Book> listbook=bookDao.ListByCategory(12);
		assertTrue(listbook.size()==1);
	}
	
	@Test
	public void newestBook() {
		List<Book> listbook=bookDao.listNewBooks();
		
		for(Book book :listbook) {
			System.out.println(book.getTitle());
		}
		assertTrue(true);
	}
	
	@Test
	public void search() {
		List<Book> booklist=bookDao.searchBooks("java");
		for(Book book:booklist) {
			System.out.println(book.getTitle());
		}
		assertTrue(true);
	}
	
	@Test
	public void countBookByCategory()
	{
		long count=bookDao.countByCategory(12);
		assertTrue(count==1);
	}
	
	@Test
	public void searchReview() {
		Book book=bookDao.get(140);
		Set<Review> reviews=book.getReviews();
		
		for(Review review :reviews) {
			System.out.println(review.getComment());
		}
		assertTrue(true);
	}
	
	@Test
	public void testAverageRating() {
		Book book=bookDao.get(140);
		float floatvalue=book.pointAverageofReview();
		System.out.println("floatvalue : : : : : : "+floatvalue);
		assertTrue(floatvalue>0);
	}
	
	@Test
	public void testStarString() {
		Book book=new Book();
		String string=book.arrangeStars((float) 0);
		System.out.println("star string : : : "+string);
		assertTrue(true);
	}
	
	@Test
	public void MostFavouredBooks()
	{
		List<Book> listBooks=new ArrayList<Book>();
		
		List<Object[]> objectresultList=bookDao.mostFavouredBooks();
		
		for(Object[] obj:objectresultList)
		{
			Book book=(Book) obj[0];
			System.out.println(book.getTitle());
			listBooks.add(book);
		}
		assertTrue(true);
	}
	
	
	
	
}
