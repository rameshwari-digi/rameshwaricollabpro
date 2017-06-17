package com.niit.collabpro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Table(name="User_Domain", schema="AssignTask")
@Entity
public class User_Domain 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userid;
	@Size(min=5, max=10, message="Your name should be between 5 - 10 characters.")
	private String uname;
	@Column(unique=true)
	@Pattern(regexp=".+@.+\\..+", message="Wrong email!")
	private String emailid;
	@Size(min=10, message="You cannot entered lessthan 10 digits.")
	private String contactno;
	@NotNull(message="Please select a password")
	 @Length(min=5, max=10, message="Password should be between 5 - 10 charactes")
	private String password;
	
	private String role;
	

	

}
