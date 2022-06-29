package com.example.SvtProject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.example.SvtProject.dto.PostDTO;
import com.example.SvtProject.dto.ReactionDTO;
import com.example.SvtProject.model.Comment;
import com.example.SvtProject.model.Community;
import com.example.SvtProject.model.Post;
import com.example.SvtProject.model.Reaction;
import com.example.SvtProject.model.User;
import com.example.SvtProject.service.ReactionService;
import com.example.SvtProject.serviceInterface.CommentServiceInterface;
import com.example.SvtProject.serviceInterface.CommunityServiceInterface;
import com.example.SvtProject.serviceInterface.PostServiceInterface;
import com.example.SvtProject.serviceInterface.ReactionServiceInterface;
import com.example.SvtProject.serviceInterface.UserServiceInterface;

@RestController
@RequestMapping(value = "api/post")
public class PostController {
	
	public static final String CHOSEN_POST = "chosenPost";
	
	@Autowired
	PostServiceInterface postServiceInterface;
	
	@Autowired
	UserServiceInterface userServiceInterface;
	
	@Autowired
	CommunityServiceInterface communityServiceInterface;
	
	@Autowired
	CommentServiceInterface commentServiceInterface;
	
	@Autowired
	ReactionServiceInterface reactionServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> getPosts(){

		List<Post> posts = postServiceInterface.findAll();
		
		List<PostDTO> postDTO = new ArrayList<PostDTO>();
		for(Post post: posts) {
			postDTO.add(new PostDTO(post));
		}
		return new ResponseEntity<List<PostDTO>>(postDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDTO> getPost(@PathVariable("id") Long id){
		Post post = postServiceInterface.findOne(id);
		
		if(post == null) {
			return new ResponseEntity<PostDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PostDTO>(new PostDTO(post), HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}/comments")
	public ResponseEntity<List<CommentDTO>> getCommentsFromPostRedditor(@PathVariable("id") Long id, HttpSession session){
				
		Post post = postServiceInterface.findOne(id);
		
		if(post == null) {
			return new ResponseEntity<List<CommentDTO>>(HttpStatus.NOT_FOUND);
		}else {
			List<Comment> comments = commentServiceInterface.findAllByPost(post);
			List<CommentDTO> commentDTO = new ArrayList<CommentDTO>();
			for (Comment comment : comments) {
				session.setAttribute(PostController.CHOSEN_POST, comment);
				CommentDTO dto = new CommentDTO(comment);
				commentDTO.add(dto);
			}
			return new ResponseEntity<List<CommentDTO>>(commentDTO, HttpStatus.OK);
		}
		
	}
	
	@GetMapping(value = "/{id}/reactions")
	public ResponseEntity<List<ReactionDTO>> getReactionsFromPostRedditor(@PathVariable("id") Long id, HttpSession session){
				
		Post post = postServiceInterface.findOne(id);
		
		if(post == null) {
			return new ResponseEntity<List<ReactionDTO>>(HttpStatus.NOT_FOUND);
		}else {
			List<Reaction> reactions = reactionServiceInterface.findAllByPost(post);
			List<ReactionDTO> reactionDTO = new ArrayList<ReactionDTO>();
			for (Reaction reaction : reactions) {
				session.setAttribute(PostController.CHOSEN_POST, reaction);
				ReactionDTO dto = new ReactionDTO(reaction);
				reactionDTO.add(dto);
			}
			return new ResponseEntity<List<ReactionDTO>>(reactionDTO, HttpStatus.OK);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<PostDTO> addPost(@RequestBody PostDTO postDTO){

		User user = userServiceInterface.findById(postDTO.getIdUser());
		Community community = communityServiceInterface.findById(postDTO.getIdCommunity());
		
		Date creationDate = new Date();
		
		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		post.setText(postDTO.getText());
		post.setCreationDate(creationDate);
		post.setImagePath(postDTO.getImagePath());
		post.setUser(user);
		post.setCommunity(community);
		
		post = postServiceInterface.save(post);
		return new ResponseEntity<PostDTO>(new PostDTO(post), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable("id") Long id){
		
		Post post = postServiceInterface.findById(id);
		
		if(post == null) {
			return new ResponseEntity<PostDTO>(HttpStatus.BAD_REQUEST);
		}
		
		post.setTitle(postDTO.getTitle());
		post.setText(postDTO.getText());
		post.setImagePath(postDTO.getImagePath());

		post = postServiceInterface.save(post);
		return new ResponseEntity<PostDTO>(new PostDTO(post), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletePost(@PathVariable("id") Long id){
		Post post = postServiceInterface.findById(id);
		if(post != null) {
			postServiceInterface.remove(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}