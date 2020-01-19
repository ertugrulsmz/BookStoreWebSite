import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Users;

public class UserTest {
	
	public static void main(String[] args) {
		
		Users user1=new Users();
		user1.setEmail("st@gmail.com");
		user1.setFullnameString("ertu");
		user1.setPassword("aali");
	
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		//-Begin Transactions
		
		entityManager.getTransaction().begin();
		entityManager.persist(user1);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("Test succeded");
		
	}

}
