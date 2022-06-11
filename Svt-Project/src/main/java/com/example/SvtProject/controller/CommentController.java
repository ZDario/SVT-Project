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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SvtProject.dto.CommentDTO;
import com.example.SvtProject.model.Comment;
import com.example.SvtProject.model.Post;
import com.example.SvtProject.model.User;
import com.example.SvtProject.serviceInterface.CommentServiceInterface;
import com.example.SvtProject.serviceInterface.PostServiceInterface;
import com.example.SvtProject.serviceInterface.UserServiceInterface;

@RestController
@RequestMapping(value = "api/comment")
public class CommentController {
	
	@Autowired
	CommentServiceInterface commentServiceInterface;
	
	@Autowired
	PostServiceInterface postServiceInterface;
	
	@Autowired
	UserServiceInterface userServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<CommentDTO>> getComments(){

		List<Comment> comments = commentServiceInterface.findAll();
		
		List<CommentDTO> commentDTO = new ArrayList<CommentDTO>();
		for(Comment comment: comments) {
			commentDTO.add(new CommentDTO(comment));
		}
		return new ResponseEntity<List<CommentDTO>>(commentDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CommentDTO> getComment(@PathVariable("id") Long id){
		Comment comment = commentServiceInterface.findOne(id);
		
		if(comment == null) {
			return new ResponseEntity<CommentDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CommentDTO>(new CommentDTO(comment), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CommentDTO> addComment(@RequestBody CommentDTO commentDTO){

		Post post = postServiceInterface.findById(commentDTO.getIdPost());
		User user = userServiceInterface.findById(commentDTO.getIdUser());
		
		Date timeStamp = new Date();
		
		Comment comment = new Comment();
		comment.setTimeStamp(timeStamp);
		comment.setText(commentDTO.getText());
		comment.setDeleted(commentDTO.isDeleted());
		comment.setPost(post);
		comment.setUser(user);
		
		comment = commentServiceInterface.save(comment);
		return new ResponseEntity<CommentDTO>(new CommentDTO(comment), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<CommentDTO> updateComment(@RequestBody CommentDTO commentDTO, @PathVariable("id") Long id){
		
		Comment comment = commentServiceInterface.findById(id);
		
		if(comment == null) {
			return new ResponseEntity<CommentDTO>(HttpStatus.BAD_REQUEST);
		}
		
		comment.setText(commentDTO.getText());
		comment.setDeleted(commentDTO.isDeleted());

		comment = commentServiceInterface.save(comment);
		return new ResponseEntity<CommentDTO>(new CommentDTO(comment), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteComment(@PathVariable("id") Long id){
		Comment comment = commentServiceInterface.findById(id);
		if(comment != null) {
			commentServiceInterface.remove(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}


}
