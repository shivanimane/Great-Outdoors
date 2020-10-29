package com.greatoutdoor.authenticationservice.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

//, cascade=CascadeType.ALL

@Entity
@Table(name = "user_tbl")
public class User {

	@Id
	private int id;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	private String phoneno;
	
	@ElementCollection
	@CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "roles")
	private Set<String> roles = new HashSet<>();

	public User() {}

	public User(int id, @NotBlank String username, @NotBlank String password, @Email @NotBlank String email,
			@NotBlank String phoneno) {

		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneno = phoneno;
	}
	

	public User(int id, @NotBlank String username, @NotBlank String password, @Email @NotBlank String email,
			@NotBlank String phoneno, Set<String> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneno = phoneno;
		this.roles = roles;
	}

	

	public User(@NotBlank String username, @NotBlank String password, @Email @NotBlank String email,
			@NotBlank String phoneno, Set<String> roles) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneno = phoneno;
		this.roles = roles;
	}
	

	public User(@NotBlank String username, @NotBlank String password, @Email @NotBlank String email,
			@NotBlank String phoneno) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneno = phoneno;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
	
	
	
	
	
	
}
