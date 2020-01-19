package com.bookstore.entity;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Users.findall",query = "select u from Users u ORDER BY u.fullnameString"),
	@NamedQuery(name="Users.countall",query = "select count (*) from Users u"),
	@NamedQuery(name="Users.findbyemail",query = "select u from Users u where u.email = :email"),
	@NamedQuery(name="Users.checklogin",query = "select u from Users u where u.email = :email and u"
			+ ".password =:password")

	
})

public class Users
{

	private String fullnameString;
	private Integer userId;
    private String email;
    private String password;
    
    public Users() {
    }
    
    
    
    
 
	public Users(String fullnameString, Integer userId, String email, String password) {
		super();
		this.fullnameString = fullnameString;
		this.userId = userId;
		this.email = email;
		this.password = password;
	}





	public Users(String fullnameString,String email, String password) {
		
		this.fullnameString = fullnameString;
		this.email = email;
		this.password = password;
	}


	@Column(name = "full_name") 
    public String getFullnameString() {
		return fullnameString;
	}
    
	public void setFullnameString(String fullnameString) {
		this.fullnameString = fullnameString;
	}


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    public Integer getUserId() {
        return this.userId;
    }
 
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
 
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return this.email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    @Column(name = "password", nullable = false, length = 10)
    public String getPassword() {
        return this.password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
}