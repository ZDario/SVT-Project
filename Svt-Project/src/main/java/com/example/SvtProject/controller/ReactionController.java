package com.example.SvtProject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.SvtProject.dto.ReactionDTO;
import com.example.SvtProject.model.Post;
import com.example.SvtProject.model.Reaction;
import com.example.SvtProject.model.User;
import com.example.SvtProject.serviceInterface.PostServiceInterface;
import com.example.SvtProject.serviceInterface.ReactionServiceInterface;
import com.example.SvtProject.serviceInterface.UserServiceInterface;

public class ReactionController {
	
	@Autowired
	ReactionServiceInterface reactionServiceInterface;
	
	@Autowired
	PostServiceInterface postServiceInterface;
	
	@Autowired
	UserServiceInterface userServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<ReactionDTO>> getReactions(){

		List<Reaction> reactions = reactionServiceInterface.findAll();
		
		List<ReactionDTO> reactionDTO = new ArrayList<ReactionDTO>();
		for(Reaction reaction: reactions) {
			reactionDTO.add(new ReactionDTO(reaction));
		}
		return new ResponseEntity<List<ReactionDTO>>(reactionDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ReactionDTO> getReaction(@PathVariable("id") Long id){
		Reaction reaction = reactionServiceInterface.findOne(id);
		
		if(reaction == null) {
			return new ResponseEntity<ReactionDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ReactionDTO>(new ReactionDTO(reaction), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ReactionDTO> addReaction(@RequestBody ReactionDTO reactionDTO){

		Post post = postServiceInterface.findById(reactionDTO.getIdPost());
		User user = userServiceInterface.findById(reactionDTO.getIdUser());
		
		Date timeStamp = new Date();
		
		Reaction reaction = new Reaction();
		reaction.setTimeStamp(timeStamp);
		reaction.setReactionType(reactionDTO.getReactionType());
		reaction.setPost(post);
		reaction.setUser(user);
		
		reaction = reactionServiceInterface.save(reaction);
		return new ResponseEntity<ReactionDTO>(new ReactionDTO(reaction), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<ReactionDTO> updateReaction(@RequestBody ReactionDTO reactionDTO, @PathVariable("id") Long id){
		
		Reaction reaction = reactionServiceInterface.findById(id);
		
		if(reaction == null) {
			return new ResponseEntity<ReactionDTO>(HttpStatus.BAD_REQUEST);
		}
		
		reaction.setReactionType(reactionDTO.getReactionType());

		reaction = reactionServiceInterface.save(reaction);
		return new ResponseEntity<ReactionDTO>(new ReactionDTO(reaction), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteReaction(@PathVariable("id") Long id){
		Reaction reaction = reactionServiceInterface.findById(id);
		if(reaction != null) {
			reactionServiceInterface.remove(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
