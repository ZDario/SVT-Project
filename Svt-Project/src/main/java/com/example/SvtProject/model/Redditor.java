package com.example.SvtProject.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Redditor extends User{
	
	public Redditor() {
		super();
	}
	
	public Redditor(Long idUser, String userName, String password, String email, String avatar,
			boolean isBanned, Date registratioDate, UserType userType, List<Post> posts) {
		super(idUser, userName, password, email, avatar, isBanned, registratioDate, userType, posts);
	}
}

