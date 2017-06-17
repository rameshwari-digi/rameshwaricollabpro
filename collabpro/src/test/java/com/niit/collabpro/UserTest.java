package com.niit.collabpro;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collabpro.dao.UserDomainInterface;
import com.niit.collabpro.model.User_Domain;

public class UserTest {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDomainInterface userDao;
	private User_Domain user_domain;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.collabpro");
		context.refresh();
		userDao=(UserDomainInterface)context.getBean("userDao");
	}
	

	@Test
	public void userTest()
	{
		user_domain=new User_Domain();
		user_domain.setUname("ebinezer");
		user_domain.setEmailid("ebi@gmail.com");
		user_domain.setPassword("12345678");
		user_domain.setRole("User");
		
		assertEquals("success",true,userDao.addUser(user_domain));
		
	}
	
}
