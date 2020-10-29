package com.greatoutdoor.authenticationservice.entity.request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class SignupRequest {

	@NotBlank
    private String username;
 
    @NotBlank
    @Email
    private String email;
    
    private Set<String> role;
    
    @NotBlank
    private String password;
    
    @NotBlank
    private String phoneno;
  
    public String getUsername() {
        return username;
    }
 
    
    public String getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}


	public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}
