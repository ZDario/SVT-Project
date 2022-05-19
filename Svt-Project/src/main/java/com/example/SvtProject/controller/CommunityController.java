package com.example.SvtProject.controller;

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

import com.example.SvtProject.dto.CommunityDTO;
import com.example.SvtProject.model.Community;
import com.example.SvtProject.serviceInterface.CommunityServiceInterface;

@RestController
@RequestMapping(value = "api/community")
public class CommunityController {
	
	@Autowired
	CommunityServiceInterface communityServiceInterface;
	
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
	
	@PostMapping
	public ResponseEntity<CommunityDTO> addCommunity(@RequestBody CommunityDTO communityDTO){

		Community community = new Community();
		community.setName(communityDTO.getName());
		community.setDescription(communityDTO.getDescription());
		community.setCreationDate(communityDTO.getCreationDate());
		community.setRules(communityDTO.getRules());
		community.setSuspended(communityDTO.isSuspended());
		community.setSuspendedReason(communityDTO.getSuspendedReason());
		
		community = communityServiceInterface.save(community);
		return new ResponseEntity<CommunityDTO>(new CommunityDTO(community), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<CommunityDTO> updateCommunity(@RequestBody CommunityDTO communityDTO, @PathVariable("id") Long id){

		Community community = communityServiceInterface.findById(id);
		
		if(community == null) {
			return new ResponseEntity<CommunityDTO>(HttpStatus.BAD_REQUEST);
		}
		community.setName(communityDTO.getName());
		community.setDescription(communityDTO.getDescription());
		community.setCreationDate(communityDTO.getCreationDate());
		community.setRules(communityDTO.getRules());
		community.setSuspended(communityDTO.isSuspended());
		community.setSuspendedReason(communityDTO.getSuspendedReason());

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
}