package com.example.SvtProject.model;

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
@Table(name = "comment")
public class Comment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idComment", nullable = false, unique = true)
	private Long idComment;
	
	@Column(name = "text", nullable = false)
	private String text;
	
	@Column(name = "timeStamp", nullable = false)
	private Date timeStamp;
	
	@Column(name = "isDeleted", nullable = false)
	private boolean isDeleted;
	
	@ManyToOne
	@JoinColumn(name = "post", referencedColumnName = "idPost", nullable = false)
	private Post post;

	@ManyToOne
	@JoinColumn(name = "user", referencedColumnName = "idUser", nullable = false)
	private User user;

	public Comment() {
		super();
	}

	public Comment(Long idComment, String text, Date timeStamp, boolean isDeleted, Post post, User user) {
		super();
		this.idComment = idComment;
		this.text = text;
		this.timeStamp = timeStamp;
		this.isDeleted = isDeleted;
		this.post = post;
		this.user = user;
	}

	public Long getIdComment() {
		return idComment;
	}

	public void setIdComment(Long idComment) {
		this.idComment = idComment;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
