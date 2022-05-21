package com.example.SvtProject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SvtProject.dto.UserDTO;
import com.example.SvtProject.model.User;
import com.example.SvtProject.serviceInterface.AdminServiceInterface;
import com.example.SvtProject.serviceInterface.ModeratorServiceInterface;
import com.example.SvtProject.serviceInterface.RedditorServiceInterface;
import com.example.SvtProject.serviceInterface.UserServiceInterface;

@RestController
@RequestMapping(value = "api/user")
public class UserController{
	public static final String USER_KEY = "loggedInUser";
	
	@Autowired
	UserServiceInterface userServiceInterface;
	
	@Autowired
	AdminServiceInterface adminServiceInterface;
	
	@Autowired
	ModeratorServiceInterface moderatorServiceInterface;
	
	@Autowired
	RedditorServiceInterface redditorServiceInterface;
	
	@PostMapping(value = "/login")
	public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO, HttpSession session){

		User redditor =  redditorServiceInterface.findByUNameAndPassword(userDTO.getUserName(), userDTO.getPassword());
		User admin = adminServiceInterface.findByUNameAndPassword(userDTO.getUserName(), userDTO.getPassword());
		User moderator = moderatorServiceInterface.findByUNameAndPassword(userDTO.getUserName(), userDTO.getPassword());
		
		session.setAttribute(UserController.USER_KEY, redditor);
		
		if(redditor==null) {
			redditor = moderator;
		}
		if(redditor==null) {
			redditor = admin;
		}
				
		if (redditor==null) {
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND); 
		}else{
			UserDTO usDTO = new UserDTO();
			usDTO.setIdUser(redditor.getIdUser());
			usDTO.setUserName(redditor.getUserName());
			usDTO.setPassword(redditor.getPassword());
			usDTO.setUserType(redditor.getUserType());
			usDTO.setRegistrationDate(redditor.getRegistrationDate());
			usDTO.setBanned(redditor.isBanned());
			session.setAttribute(ModeratorController.MODERATOR_KEY, moderator);
			return new ResponseEntity<UserDTO>(usDTO,HttpStatus.OK);
		}

	}
}