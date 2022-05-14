package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "post")
public class Post {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPost", nullable = false, unique = true)
	private Long idPost;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "text", nullable = false)
	private String text;
	
	@Column(name = "creationDate", nullable = false)
	private Date creationDate;
	
	@Column(name = "imagePath", nullable = false)
	private String imagePath;
	
	@ManyToOne
	@JoinColumn(name = "community", referencedColumnName = "idCommunity", nullable = false)
	private Community community;

	@ManyToOne
	@JoinColumn(name = "user", referencedColumnName = "idUser", nullable = false)
	private User user;
	
	public Post() {
		super();
	}

	public Post(Long idPost, String title, String text, Date creationDate, String imagePath,
			Community community, User user) {
		super();
		this.idPost = idPost;
		this.title = title;
		this.text = text;
		this.creationDate = creationDate;
		this.imagePath = imagePath;
		this.community = community;
		this.user = user;
	}

	public Long getIdPost() {
		return idPost;
	}

	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
