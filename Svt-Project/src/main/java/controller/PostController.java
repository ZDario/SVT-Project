package controller;

import java.util.ArrayList;
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

import dto.PostDTO;
import model.Community;
import model.Post;
import model.User;
import serviceInterface.CommunityServiceInterface;
import serviceInterface.PostServiceInterface;
import serviceInterface.UserServiceInterface;

@RestController
@RequestMapping(value = "api/post")
public class PostController {
	
	@Autowired
	PostServiceInterface postServiceInterface;
	
	CommunityServiceInterface communityServiceInterface;
	
	UserServiceInterface userServiceInterface;
	
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
	
	@PostMapping
	public ResponseEntity<PostDTO> addPost(@RequestBody PostDTO postDTO){

		User user = userServiceInterface.findById(postDTO.getIdUser());
		Community community = communityServiceInterface.findById(postDTO.getIdCommunity());
		
		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		post.setText(postDTO.getText());
		post.setCreationDate(postDTO.getCreationDate());
		post.setImagePath(postDTO.getImagePath());
		post.setUser(user);
		post.setCommunity(community);
		
		post = postServiceInterface.save(post);
		return new ResponseEntity<PostDTO>(new PostDTO(post), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable("id") Long id){
		
		Post post = postServiceInterface.findById(id);
		User user = userServiceInterface.findById(postDTO.getIdUser());
		Community community = communityServiceInterface.findById(postDTO.getIdCommunity());
		
		if(post == null) {
			return new ResponseEntity<PostDTO>(HttpStatus.BAD_REQUEST);
		}
		
		post.setTitle(postDTO.getTitle());
		post.setText(postDTO.getText());
		post.setCreationDate(postDTO.getCreationDate());
		post.setImagePath(postDTO.getImagePath());
		post.setUser(user);
		post.setCommunity(community);

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