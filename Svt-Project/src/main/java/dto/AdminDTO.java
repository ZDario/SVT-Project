package dto;

import java.util.Date;

import model.Admin;
import model.UserType;

public class AdminDTO {

	private Long idAdmin;
	private String userNameAdmin;
	private String passwordAdmin;
	private String emailAdmin; 
	private String avatarAdmin;
	private Date registrationDateAdmin;
	private boolean isBanned;
	private UserType userType;
	
	public AdminDTO() {
		super();
	}
	
    public AdminDTO(Long idAdmin, String userNameAdmin, String passwordAdmin, String emailAdmin, String avatarAdmin, Date registrationDateAdmin, boolean isBanned, UserType userType){
        this.idAdmin = idAdmin;
        this.userNameAdmin = userNameAdmin;
        this.passwordAdmin = passwordAdmin;
        this.emailAdmin = emailAdmin;
        this.avatarAdmin = avatarAdmin;
        this.registrationDateAdmin = registrationDateAdmin;
        this.isBanned = isBanned;
        this.userType = userType;
    }
    
	public AdminDTO(Admin admin) {
		this(admin.getIdUser(), admin.getUserName(), admin.getPassword(), admin.getEmail(), admin.getAvatar(), admin.getRegistrationDate(), admin.isBanned(), admin.getUserType());
	}

	public Long getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Long idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getUserNameAdmin() {
		return userNameAdmin;
	}

	public void setUserNameAdmin(String userNameAdmin) {
		this.userNameAdmin = userNameAdmin;
	}

	public String getPasswordAdmin() {
		return passwordAdmin;
	}

	public void setPasswordAdmin(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}

	public String getEmailAdmin() {
		return emailAdmin;
	}

	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
	}

	public String getAvatarAdmin() {
		return avatarAdmin;
	}

	public void setAvatarAdmin(String avatarAdmin) {
		this.avatarAdmin = avatarAdmin;
	}

	public Date getRegistrationDateAdmin() {
		return registrationDateAdmin;
	}

	public void setRegistrationDateAdmin(Date registrationDateAdmin) {
		this.registrationDateAdmin = registrationDateAdmin;
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
