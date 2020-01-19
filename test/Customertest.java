import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Customer_class;

public class Customertest {

	public static void main(String[] args) {
		Customer_class customer_class=new Customer_class();
		customer_class.setAddressString("esenyali");
		customer_class.setCityString("ankara");
		customer_class.setCountryString("turkey2");
		customer_class.setEmailString("era@gmail.com");
		customer_class.setFullnameString("amaraz");
		customer_class.setPasswordString("amrz123");
		customer_class.setPhoneString("2359266963");
	//	customer_class.setRegisterdateString("1898-10-03");
		customer_class.setZipcodeString("34902");
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		//-Begin Transactions
		
		entityManager.getTransaction().begin();
		entityManager.persist(customer_class);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("Customer Test succeded");

	}

}
