package com.example.SvtProject.dto;

import java.util.Date;

import com.example.SvtProject.model.Redditor;
import com.example.SvtProject.model.UserType;

public class RedditorDTO {
	
	private Long idRedditor;
	private String userNameRedditor;
	private String passwordRedditor;
	private String emailRedditor; 
	private String avatarRedditor;
	private Date registrationDateRedditor;
	private boolean isBanned;
	private UserType userType;
	
	public RedditorDTO() {
		super();
	}
	
    public RedditorDTO(Long idRedditor, String userNameRedditor, String passwordRedditor, String emailRedditor, String avatarRedditor, Date registrationDateRedditor, boolean isBanned, UserType userType){
        this.idRedditor = idRedditor;
        this.userNameRedditor = userNameRedditor;
        this.passwordRedditor = passwordRedditor;
        this.emailRedditor = emailRedditor;
        this.avatarRedditor = avatarRedditor;
        this.registrationDateRedditor = registrationDateRedditor;
        this.isBanned = isBanned;
        this.userType = userType;
    }
    
	public RedditorDTO(Redditor redditor) {
		this(redditor.getIdUser(), redditor.getUserName(), redditor.getPassword(), redditor.getEmail(), redditor.getAvatar(), redditor.getRegistrationDate(), redditor.isBanned(), redditor.getUserType());
	}

	public Long getIdRedditor() {
		return idRedditor;
	}

	public void setIdRedditor(Long idRedditor) {
		this.idRedditor = idRedditor;
	}

	public String getUserNameRedditor() {
		return userNameRedditor;
	}

	public void setUserNameRedditor(String userNameRedditor) {
		this.userNameRedditor = userNameRedditor;
	}

	public String getPasswordRedditor() {
		return passwordRedditor;
	}

	public void setPasswordRedditor(String passwordRedditor) {
		this.passwordRedditor = passwordRedditor;
	}

	public String getEmailRedditor() {
		return emailRedditor;
	}

	public void setEmailRedditor(String emailRedditor) {
		this.emailRedditor = emailRedditor;
	}

	public String getAvatarRedditor() {
		return avatarRedditor;
	}

	public void setAvatarRedditor(String avatarRedditor) {
		this.avatarRedditor = avatarRedditor;
	}

	public Date getRegistrationDateRedditor() {
		return registrationDateRedditor;
	}

	public void setRegistrationDateRedditor(Date registrationDateRedditor) {
		this.registrationDateRedditor = registrationDateRedditor;
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
