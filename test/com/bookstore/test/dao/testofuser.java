package com.bookstore.test.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bookstore.dao.UserDao;
import com.bookstore.entity.Users;






class testofuser {
	
	static UserDao UserDao1;
	
	
	@BeforeEach
	public void msetUpBeforeClass() throws Exception {
		
		System.out.print("-----------!!!---------");
		UserDao1=new UserDao();
	}
	
	
	
	@Test
	void test() {
		
		
		Users user1=new Users();
		user1.setEmail("zda@gmail.com");
		user1.setFullnameString("asali");
		user1.setPassword("asmysecret");
	
		user1=UserDao1.create(user1);
		assertTrue(user1.getUserId()>0);
	
		
	}
	
	@Test()
	void TestwithoutInfo() {
		Users user2=new Users();	
		user2=UserDao1.create(user2);
		assertTrue(user2.getUserId()>0);
		
	}
	@Test
	void Update_Succesfull_Test() {
		Users user3=new Users();
		user3.setEmail("user3@gmail.com");
		user3.setFullnameString("user3");
		user3.setPassword("user3");
		user3.setUserId(1);
		Users user4=UserDao1.update(user3);
		assertEquals(user3.getUserId(),user4.getUserId());
	}
	@Test
	void Update_Unsuccesfull_Test() {
		Users user3=new Users();
		user3.setEmail("user3@gmail.com");
		user3.setFullnameString("user3");
		user3.setPassword("user3");
		user3.setUserId(108);
		Users user4=UserDao1.update(user3);
		assertEquals(user3.getUserId(),user4.getUserId());

	}
	
	@Test
	void get_succesfull_test() {
		Integer idInteger=7;
		Users users=UserDao1.get(idInteger);
		System.out.println("users : "+users.getFullnameString());
		assertNotNull(users);
	}
	

	@Test
	void get_unsuccesfull_test() {
		Integer idInteger=62;
		Users users=UserDao1.get(idInteger);
		assertNotNull(users);
	}
	
	@Test
	void deletetest() {
		UserDao1.delete(7);
		Users userdeleted=UserDao1.get(7);
		assertNull(userdeleted);
		
	}
	@Test
	void delete2test() {
		Users u=UserDao1.get(9);
		UserDao1.delete(u);
		assertNull(UserDao1.get(9));
	}
	@Test
	void Listall_succesfull_test() {
		List<Users> list= UserDao1.listall();
		
		for(Users u:list) {
			System.out.println(u.getFullnameString());
		}
		
		assertTrue(list.size()>0);
	}
	
	@Test
	void count_all()
	{
		long count_value=UserDao1.count();
		System.out.println("counter : -------- : "+count_value);
		assertTrue(count_value>0);
	}
	
	
	
	@Test
	void findbyemailtest() {
		Users user1=UserDao1.findByEmail("zaasaza@hotmail.com");	
		assertNull(user1);
		
	}
	
	@Test
	void CheckLogin() {
		String emailString="adw";
		String passwordString="ddd";
		boolean loginvalue=UserDao1.checklogin(emailString,passwordString);
		assertTrue(loginvalue);
	}
	
	
	
	@AfterEach
	public void FinishTest() 
	{
		
		
	}

}
