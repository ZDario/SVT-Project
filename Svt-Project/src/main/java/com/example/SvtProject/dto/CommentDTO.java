package com.example.SvtProject.dto;

import java.util.Date;

import com.example.SvtProject.model.Comment;

public class CommentDTO {
	
    private Long idComment;
    private Date timeStamp;
    private String text;
    private boolean isDeleted;
    private Long idPost;
    private String title;
    private Long idUser;
    private String userName;

	public CommentDTO() {
		super();
	}

	public CommentDTO(Long idComment, Date timeStamp, String text, boolean isDeleted, Long idPost, String title,
			Long idUser, String userName) {
		super();
		this.idComment = idComment;
		this.timeStamp = timeStamp;
		this.text = text;
		this.isDeleted = isDeleted;
		this.idPost = idPost;
		this.title = title;
		this.idUser = idUser;
		this.userName = userName;
	}

	public CommentDTO(Comment comment) {
		this(comment.getIdComment(), comment.getTimeStamp(), comment.getText(), comment.isDeleted(), 
				comment.getPost().getIdPost(), comment.getPost().getTitle(), comment.getUser().getIdUser(), comment.getUser().getUserName());
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