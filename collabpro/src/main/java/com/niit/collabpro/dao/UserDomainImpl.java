package com.niit.collabpro.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collabpro.model.User_Domain;

@Transactional
@Repository("userDao")
public class UserDomainImpl implements UserDomainInterface
{

	
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) 
	{
	    this.sessionFactory = sessionFactory;
	}


	
	
	//add the user info in the database
	public void addUser(User_Domain user)
	{
		System.out.println("i am in add user dao method");
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		System.out.println("successfully data add");	
		
	}

	@SuppressWarnings("unchecked")
	public List<User_Domain> listUsers() {
	
		Session session=sessionFactory.openSession();
		List<User_Domain> users=session.createQuery("from User_Domain").getResultList();
		
		return users;
	}

	
	public User_Domain getUsername(String username) {
		Session session = sessionFactory.openSession();
		User_Domain user = (User_Domain)session.createQuery("from User_Domain where uname='"+username+"'").getSingleResult();
		return user;

	}

	public User_Domain getEmailid(String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		User_Domain useremail = (User_Domain)session.createQuery("from User_Domain where emailid ='"+email+"' and password='"+password+"'").getSingleResult();
		return useremail;

		
	}

}
