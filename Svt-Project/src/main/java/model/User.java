package model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public abstract class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUser", nullable = false, unique = true)
	private Long idUser;
	
	@Column(name = "userName", nullable = false)
	private String userName;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "avatar", nullable = false)
	private String avatar;

	@Column(name = "isBanned", nullable = false)
	private boolean isBanned;
	
	@Column(name = "registrationDate", nullable = false)
	private Date registrationDate;
	
	@Column(name = "userType", nullable = false)
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	@OneToMany(cascade = {ALL}, fetch=LAZY, mappedBy="user")
	private List<Post> posts = new ArrayList<Post>();
	
	
	public User() {
		super();
	}

	public User(Long idUser, String userName, String password, String email, String avatar,
			boolean isBanned, Date registratioDate, UserType userType, List<Post> posts) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.avatar = avatar;
		this.isBanned = isBanned;
		this.registrationDate = registratioDate;
		this.userType = userType;
		this.posts = posts;
	}

	public User(String userName, String password, UserType userType) {
		super();
		this.userName = userName;
		this.password = password;
		this.userType = userType;
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

	public boolean isBanned() {
		return isBanned;
	}

	public void setBanned(boolean isBanned) {
		this.isBanned = isBanned;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
	
}
