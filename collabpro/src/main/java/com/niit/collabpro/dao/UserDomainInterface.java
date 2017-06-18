package com.niit.collabpro.dao;

import com.niit.collabpro.model.User_Domain;
import java.util.*;
public interface UserDomainInterface 
{
	
	public boolean addUser(User_Domain user);
	public List<User_Domain> listUsers();
	public User_Domain getUsername(String username, String password);
	public User_Domain getUsernamed(String username);
	public User_Domain getEmailid(String email,String password);
	public boolean isExistingUser(User_Domain user);

}
