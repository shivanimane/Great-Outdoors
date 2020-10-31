package com.greatoutdoor.retailerinventorymanagementsystem.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User implements Serializable{
	private String userName;
	@Id
	private String userId;
	private String userMail;
	private String userPassword;
	private String userContact;
	private int userCategory;
	private boolean userActiveStatus;
	
	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userName
	 * @param userId
	 * @param userMail
	 * @param userPassword
	 * @param userContact
	 * @param userCategory
	 * @param userActiveStatus
	 */
	public User(String userName, String userId, String userMail, String userPassword, String userContact,
			int userCategory, boolean userActiveStatus) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userMail = userMail;
		this.userPassword = userPassword;
		this.userContact = userContact;
		this.userCategory = userCategory;
		this.userActiveStatus = userActiveStatus;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userMail
	 */
	public String getUserMail() {
		return userMail;
	}

	/**
	 * @param userMail the userMail to set
	 */
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * @return the userContact
	 */
	public String getUserContact() {
		return userContact;
	}

	/**
	 * @param userContact the userContact to set
	 */
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	/**
	 * @return the userCategory
	 */
	public int getUserCategory() {
		return userCategory;
	}

	/**
	 * @param userCategory the userCategory to set
	 */
	public void setUserCategory(int userCategory) {
		this.userCategory = userCategory;
	}

	/**
	 * @return the userActiveStatus
	 */
	public boolean isUserActiveStatus() {
		return userActiveStatus;
	}

	/**
	 * @param userActiveStatus the userActiveStatus to set
	 */
	public void setUserActiveStatus(boolean userActiveStatus) {
		this.userActiveStatus = userActiveStatus;
	}
	
	
}