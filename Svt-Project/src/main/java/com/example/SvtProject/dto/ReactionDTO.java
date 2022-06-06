package com.example.SvtProject.dto;

import java.util.Date;

import com.example.SvtProject.model.Reaction;
import com.example.SvtProject.model.ReactionType;

public class ReactionDTO {

    private Long idReaction;
    private Date timeStamp;
    private ReactionType reactionType;
    private Long idPost;
    private String title;
    private Long idUser;
    private String userName;
     
	public ReactionDTO() {
		super();
	}
	
	public ReactionDTO(Long idReaction, Date timeStamp, ReactionType reactionType, Long idPost, String title,
			Long idUser, String userName) {
		super();
		this.idReaction = idReaction;
		this.timeStamp = timeStamp;
		this.reactionType = reactionType;
		this.idPost = idPost;
		this.title = title;
		this.idUser = idUser;
		this.userName = userName;
	}
	
	public ReactionDTO(Reaction reaction) {
		this(reaction.getIdReaction(), reaction.getTimeStamp(), reaction.getReactionType(), 
				reaction.getPost().getIdPost(), reaction.getPost().getTitle(), reaction.getUser().getIdUser(), reaction.getUser().getUserName());
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
}
