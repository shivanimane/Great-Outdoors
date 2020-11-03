package com.greatoutdoor.loginservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_master")
public class User {
	
	@Column(name = "user_Id" )
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@Column(name="user_Name")
    private String username;
	
	@Column(name="user_pass")
    private String password;
	
	@Column(name="user_type")
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public void setUserType(String userType) {
		this.role = userType;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int id, String username, String password, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}

   }