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

import com.example.SvtProject.dto.CommunityDTO;
import com.example.SvtProject.dto.PostDTO;
import com.example.SvtProject.model.Community;
import com.example.SvtProject.model.Post;
import com.example.SvtProject.serviceInterface.CommunityServiceInterface;
import com.example.SvtProject.serviceInterface.PostServiceInterface;

@RestController
@RequestMapping(value = "api/community")
public class CommunityController {
	
	public static final String COMMUNITY_KEY = "communityPosts";
	
	@Autowired
	CommunityServiceInterface communityServiceInterface;
	
	@Autowired
	PostServiceInterface postServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<CommunityDTO>> getCommunities(){

		List<Community> communities = communityServiceInterface.findAll();
		
		List<CommunityDTO> communityDTO = new ArrayList<CommunityDTO>();
		for(Community community: communities) {
			communityDTO.add(new CommunityDTO(community));
		}
		return new ResponseEntity<List<CommunityDTO>>(communityDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CommunityDTO> getCommunity(@PathVariable("id") Long id){
		Community community = communityServiceInterface.findOne(id);
		
		if(community == null) {
			return new ResponseEntity<CommunityDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CommunityDTO>(new CommunityDTO(community), HttpStatus.OK);
	}
	
	@GetMapping(value = "/posts")
	public ResponseEntity<List<PostDTO>> getPostsFromCommunity(HttpSession session){
				
		Community community = (Community) session.getAttribute(COMMUNITY_KEY);
		
		if(community == null) {
			return new ResponseEntity<List<PostDTO>>(HttpStatus.NOT_FOUND);
		}else {
			List<Post> posts = postServiceInterface.findAllByCommunity(community);
			List<PostDTO> postDTO = new ArrayList<PostDTO>();
			for (Post post : posts) {
				PostDTO dto = new PostDTO(post);
				postDTO.add(dto);
			}
			return new ResponseEntity<List<PostDTO>>(postDTO, HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<PostDTO>> getPostsFromCommunityRedditor(@PathVariable("id") Long id, HttpSession session){
				
		Community community = communityServiceInterface.findOne(id);
		
		if(community == null) {
			return new ResponseEntity<List<PostDTO>>(HttpStatus.NOT_FOUND);
		}else {
			List<Post> posts = postServiceInterface.findAllByCommunity(community);
			List<PostDTO> postDTO = new ArrayList<PostDTO>();
			for (Post post : posts) {
				session.setAttribute(PostController.CHOSEN_POST, post);
				PostDTO dto = new PostDTO(post);
				postDTO.add(dto);
			}
			return new ResponseEntity<List<PostDTO>>(postDTO, HttpStatus.OK);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<CommunityDTO> addCommunity(@RequestBody CommunityDTO communityDTO){

		String suspendedReason = "none"; 
		Date creationDate = new Date();
		
		Community community = new Community();
		community.setName(communityDTO.getName());
		community.setDescription(communityDTO.getDescription());
		community.setCreationDate(creationDate);
		community.setRules(communityDTO.getRules());
		community.setSuspended(communityDTO.isSuspended());
		community.setSuspendedReason(suspendedReason);
		
		community = communityServiceInterface.save(community);
		return new ResponseEntity<CommunityDTO>(new CommunityDTO(community), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<CommunityDTO> updateCommunity(@RequestBody CommunityDTO communityDTO, @PathVariable("id") Long id){

		Community community = communityServiceInterface.findById(id);
		
		if(community == null) {
			return new ResponseEntity<CommunityDTO>(HttpStatus.BAD_REQUEST);
		}
		community.setDescription(communityDTO.getDescription());
		community.setRules(communityDTO.getRules());

		community = communityServiceInterface.save(community);
		return new ResponseEntity<CommunityDTO>(new CommunityDTO(community), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteCommunity(@PathVariable("id") Long id){
		Community community = communityServiceInterface.findById(id);
		if(community != null) {
			communityServiceInterface.remove(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(value = "/{id}/suspend", consumes = "application/json")
	public ResponseEntity<CommunityDTO> communitySuspend(@RequestBody CommunityDTO communityDTO, @PathVariable("id") Long id){

		Community community = communityServiceInterface.findById(id);
		
		if(community == null) {
			return new ResponseEntity<CommunityDTO>(HttpStatus.BAD_REQUEST);
		}
		boolean suspended = true;
		
		community.setSuspended(suspended);
		community.setSuspendedReason(communityDTO.getSuspendedReason());
		
		community = communityServiceInterface.save(community);
		return new ResponseEntity<CommunityDTO>(new CommunityDTO(community), HttpStatus.CREATED);
	}
}