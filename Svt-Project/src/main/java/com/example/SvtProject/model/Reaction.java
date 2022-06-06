package com.example.SvtProject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reaction")
public class Reaction {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idReaction", nullable = false, unique = true)
	private Long idReaction;
	
	@Column(name = "timeStamp", nullable = false)
	private Date timeStamp;
	
	@Column(name = "reactionType", nullable = false)
	@Enumerated(EnumType.STRING)
	private ReactionType reactionType;
	
	@ManyToOne
	@JoinColumn(name = "post", referencedColumnName = "idPost", nullable = false)
	private Post post;

	@ManyToOne
	@JoinColumn(name = "user", referencedColumnName = "idUser", nullable = false)
	private User user;

	public Reaction() {
		super();
	}
	
	public Reaction(Long idReaction, Date timeStamp, ReactionType reactionType, Post post, User user) {
		super();
		this.idReaction = idReaction;
		this.timeStamp = timeStamp;
		this.reactionType = reactionType;
		this.post = post;
		this.user = user;
	}

	public Long getIdReaction() {
		return idReaction;
	}

	public void setIdReaction(Long idReaction) {
		this.idReaction = idReaction;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public ReactionType getReactionType() {
		return reactionType;
	}

	public void setReactionType(ReactionType reactionType) {
		this.reactionType = reactionType;
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
