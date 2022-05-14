package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Moderator extends User{
	
	@ManyToOne
	@JoinColumn(name = "community", referencedColumnName = "idCommunity", nullable = false)
	private Community community;
	
	public Moderator() {
		super();
	}
	
	public Moderator(Long idUser, String userName, String password, String email, String avatar,
			boolean isBanned, Date registratioDate, UserType userType, List<Post> posts, Community community) {
		super(idUser, userName, password, email, avatar, isBanned, registratioDate, userType, posts);
		this.community = community;
	}

	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}
	
}
