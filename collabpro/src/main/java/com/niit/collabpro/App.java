package com.niit.collabpro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collabpro.config.ApplicationContextConfig;
import com.niit.collabpro.dao.UserDomainInterface;
import com.niit.collabpro.model.User_Domain;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
     
    	System.out.println( "Main Started..." );
    	
    	@SuppressWarnings("unused")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

    	//get the bean for user dao 
    	UserDomainInterface userDao =(UserDomainInterface) context.getBean("userDao");
    	
    	//creating the user model object;
    	User_Domain userobj = new User_Domain();
    	userobj.setUname("rameshwari");
    	userobj.setContactno("8686469911");
    	userobj.setEmailid("rama.chetan15@gmail.com");
    	userobj.setPassword("Rama.128a");
    	userobj.setRole("User");
    	userDao.addUser(userobj);
    	
    	System.out.println("end the main class");
    	
    }
}
