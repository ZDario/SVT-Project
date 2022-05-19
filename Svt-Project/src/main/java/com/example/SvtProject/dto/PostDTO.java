package com.example.SvtProject.dto;

import java.util.Date;

import com.example.SvtProject.model.Post;

public class PostDTO {

    private Long idPost;
    private String title;
    private String text;
    private Date creationDate;
    private String imagePath;
    private Long idCommunity;
    private String name;
    private Long idUser;
    private String userName;
    
	public PostDTO() {
		super();
	}

	public PostDTO(Long idPost, String title, String text, Date creationDate, String imagePath, Long idCommunity, String name, Long idUser, String userName) {
		super();
		this.idPost = idPost;
		this.title = title;
		this.text = text;
		this.creationDate = creationDate;
		this.imagePath = imagePath;
		this.idCommunity = idCommunity;
		this.name = name;
		this.idUser = idUser;
		this.userName = userName;
	}
	
	public PostDTO(Post post) {
		this(post.getIdPost(), post.getTitle(), post.getText(), post.getCreationDate(), post.getImagePath(), 
				post.getCommunity().getIdCommunity(), post.getCommunity().getName(), post.getUser().getIdUser(), post.getUser().getUserName());
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
