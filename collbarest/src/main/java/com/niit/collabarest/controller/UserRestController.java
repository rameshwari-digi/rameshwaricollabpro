package com.niit.collabarest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collabpro.dao.UserDomainInterface;
import com.niit.collabpro.model.User_Domain;

@RestController
public class UserRestController 
{
	
	@Autowired
	UserDomainInterface userDao;

	@GetMapping(value="/user/")
	public ResponseEntity<List<User_Domain>>  listAllUsers()
	{
		
        List<User_Domain> users = userDao.listUsers();
  
        if(users.isEmpty()){
            return new ResponseEntity<List<User_Domain>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User_Domain>>(users, HttpStatus.OK);

	}
	
	@PostMapping(value = "/useradd/")
    public ResponseEntity<Void> createUser(@RequestBody User_Domain user) {
        System.out.println("Creating User " + user.getUname());
  
        if (userDao.isExistingUser(user)) {
            System.out.println("A User with name " + user.getUname() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
  
        userDao.addUser(user);
        
       
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
	

	@PostMapping("/login")
	public ResponseEntity<User_Domain> loginemail(@RequestBody User_Domain user)
	{
		System.out.println("get the email id :"+user.getUname());
		
		User_Domain usere = userDao.getUsername(user.getUname(),user.getPassword());
		if(usere!=null)
		{
		return new ResponseEntity<User_Domain>(usere,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<User_Domain>(user,HttpStatus.UNAUTHORIZED);
		}
	}
	

	
	
}
