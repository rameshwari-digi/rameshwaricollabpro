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
	@Pattern(regexp="[a-zA-Z]{5,10}")
	private String uname;
	@Column(unique=true)
	@Pattern(regexp=".+@.+\\..+", message="Wrong email!")
	private String emailid;
	@Size(min=10, message="You cannot entered lessthan 10 digits.")
	private String contactno;
	@NotNull(message="Please select a password")
	 @Length(min=5, max=10, message="Password should be between 5 - 10 charactes")
	/*@Pattern.List({
	    @Pattern(regexp = "(?=.*[0-9])", message = "Password must contain one digit."),
	    @Pattern(regexp = "(?=.*[a-z])", message = "Password must contain one lowercase letter."),
	    @Pattern(regexp = "(?=.*[A-Z])", message = "Password must contain one uppercase letter."),
	    @Pattern(regexp = "(?=\\S+$)", message = "Password must contain no whitespace.")
	})
	*/
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8}")
	private String password;
	
	private String role;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

	
	

}
