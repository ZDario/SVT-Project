package com.example.SvtProject.dto;

import java.util.Date;

import com.example.SvtProject.model.User;
import com.example.SvtProject.model.UserType;

public class UserDTO {
	
	private Long idUser;
	private String userName;
	private String password;
	private String email; 
	private String avatar;
	private Date registrationDate;
	private boolean isBanned;
	private UserType userType;
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(String userName, String password, UserType userType) {
		super();
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}
	
    public UserDTO(Long idUser, String userName, String password, String email, String avatar, Date registrationDate, boolean isBanned, UserType userType){
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.registrationDate = registrationDate;
        this.isBanned = isBanned;
        this.userType = userType;
    }
    
	public UserDTO(User user) {
		this(user.getIdUser(), user.getUserName(), user.getPassword(), user.getEmail(), user.getAvatar(), user.getRegistrationDate(), user.isBanned(), user.getUserType());
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public boolean isBanned() {
		return isBanned;
	}

	public void setBanned(boolean isBanned) {
		this.isBanned = isBanned;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}
