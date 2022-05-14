package dto;

import java.util.Date;

import model.Moderator;
import model.UserType;

public class ModeratorDTO {
	
	private Long idModerator;
	private String userNameModerator;
	private String passwordModerator;
	private String emailModerator; 
	private String avatarModerator;
	private Date registrationDateModerator;
	private boolean isBanned;
	private UserType userType;
	private Long idCommunity;
	private String name;
	
	public ModeratorDTO() {
		super();
	}
	
    public ModeratorDTO(Long idModerator, String userNameModerator, String passwordModerator, String emailModerator, String avatarModerator, Date registrationDateModerator, boolean isBanned, UserType userType,
    		Long idCommunity, String name){
        this.idModerator = idModerator;
        this.userNameModerator = userNameModerator;
        this.passwordModerator = passwordModerator;
        this.emailModerator = emailModerator;
        this.avatarModerator = avatarModerator;
        this.registrationDateModerator = registrationDateModerator;
        this.isBanned = isBanned;
        this.userType = userType;
        this.idCommunity = idCommunity;
        this.name = name;
    }
    
	public ModeratorDTO(Moderator moderator) {
		this(moderator.getIdUser(), moderator.getUserName(), moderator.getPassword(), moderator.getEmail(), moderator.getAvatar(), moderator.getRegistrationDate(), moderator.isBanned(), moderator.getUserType(),
				moderator.getCommunity().getIdCommunity(), moderator.getCommunity().getName());
	}

	public Long getIdModerator() {
		return idModerator;
	}

	public void setIdModerator(Long idModerator) {
		this.idModerator = idModerator;
	}

	public String getUserNameModerator() {
		return userNameModerator;
	}

	public void setUserNameModerator(String userNameModerator) {
		this.userNameModerator = userNameModerator;
	}

	public String getPasswordModerator() {
		return passwordModerator;
	}

	public void setPasswordModerator(String passwordModerator) {
		this.passwordModerator = passwordModerator;
	}

	public String getEmailModerator() {
		return emailModerator;
	}

	public void setEmailModerator(String emailModerator) {
		this.emailModerator = emailModerator;
	}

	public String getAvatarModerator() {
		return avatarModerator;
	}

	public void setAvatarModerator(String avatarModerator) {
		this.avatarModerator = avatarModerator;
	}

	public Date getRegistrationDateModerator() {
		return registrationDateModerator;
	}

	public void setRegistrationDateModerator(Date registrationDateModerator) {
		this.registrationDateModerator = registrationDateModerator;
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

	public Long getIdCommunity() {
		return idCommunity;
	}

	public void setIdCommunity(Long idCommunity) {
		this.idCommunity = idCommunity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
