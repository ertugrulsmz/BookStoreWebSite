import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Book;

import com.bookstore.entity.Category;

public class BookTest {

	public static void main(String[] arStrings) {
		
		Category category=new Category();
		category.setName("aa");
	
		
		Book book=new Book();
		book.setTitle("at");
		book.setPrice(123);
		book.setCategory(category);
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		//-Begin Transactions
		
		entityManager.getTransaction().begin();
		entityManager.persist(category);
		entityManager.persist(book);
	
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("bbok Test succeded");
	}

}
