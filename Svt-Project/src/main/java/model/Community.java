package model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "community")
public class Community {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCommunity", nullable = false, unique = true)
	private Long idCommunity;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "creationDate", nullable = false)
	private Date creationDate;
	
	@Column(name = "rules", nullable = false)
	private String rules;
	
	@Column(name = "isSuspended", nullable = false)
	private boolean isSuspended;
	
	@Column(name = "suspendedReason", nullable = false)
	private String suspendedReason;
	
	@OneToMany(cascade = {ALL}, fetch=LAZY, mappedBy="community")
	private List<Post> posts = new ArrayList<Post>();
	
	@OneToMany(cascade = {ALL}, fetch=LAZY, mappedBy="community")
	private List<Moderator> moderators = new ArrayList<Moderator>();
	
	public Community() {
		super();
	}

	public Community(Long idCommunity, String name, String description, Date creationDate, String rules,
			boolean isSuspended, String suspendedReason, List<Post> posts, List<Moderator> moderators) {
		super();
		this.idCommunity = idCommunity;
		this.name = name;
		this.description = description;
		this.creationDate = creationDate;
		this.rules = rules;
		this.isSuspended = isSuspended;
		this.suspendedReason = suspendedReason;
		this.posts = posts;
		this.moderators = moderators;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	public boolean isSuspended() {
		return isSuspended;
	}

	public void setSuspended(boolean isSuspended) {
		this.isSuspended = isSuspended;
	}

	public String getSuspendedReason() {
		return suspendedReason;
	}

	public void setSuspendedReason(String suspendedReason) {
		this.suspendedReason = suspendedReason;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Moderator> getModerators() {
		return moderators;
	}

	public void setModerators(List<Moderator> moderators) {
		this.moderators = moderators;
	}
	
}
