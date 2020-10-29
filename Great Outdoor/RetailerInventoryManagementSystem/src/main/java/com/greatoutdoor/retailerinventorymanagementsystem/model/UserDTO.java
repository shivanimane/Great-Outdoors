package com.greatoutdoor.retailerinventorymanagementsystem.model;
/**
 * 
 * @author Deepali
 *
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = -8450180103620249767L;
	
	@Column(name = "USER_NAME", unique = false, nullable = false, length = 50)
	private String userName;

	@Id
	@Column(name = "USER_ID", unique = true, nullable = false)
	private String userId;

	@Column(name = "USER_MAIL", unique = false, nullable = false, length = 50)
	private String userMail;

	@Column(name = "USER_PASSWORD", unique = false, nullable = false, length = 30)
	private String userPassword;

	@Column(name = "USER_CONTACT", unique = false, nullable = false, length = 10)
	private long userNumber;

	@Column(name = "USER_CATEGORY", unique = false, nullable = false, length = 1)
	private int userCategory;
	
	@Column(name = "USER_ACTIVE_STATUS", unique = false, nullable = false, length = 1)
	private boolean userActiveStatus;

	public UserDTO() {

	}

	public UserDTO(String userName, String userId, String userMail, String userPassword, long userNumber,
			int userCategory, boolean userActiveStatus) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userMail = userMail;
		this.userPassword = userPassword;
		this.userNumber = userNumber;
		this.userCategory = userCategory;
		this.userActiveStatus = userActiveStatus;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public long getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(long userNumber) {
		this.userNumber = userNumber;
	}

	public int getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(int userCategory) {
		this.userCategory = userCategory;
	}

	public boolean isUserActiveStatus() {
		return userActiveStatus;
	}

	public void setUserActiveStatus(boolean userActiveStatus) {
		this.userActiveStatus = userActiveStatus;
	}

	@Override
	public String toString() {
		return "UserEntity [userName=" + userName + ", userId=" + userId + ", userMail=" + userMail + ", userPassword="
				+ userPassword + ", userNumber=" + userNumber + ", userCategory=" + userCategory + ", userActiveStatus="
				+ userActiveStatus + "]";
	}

}