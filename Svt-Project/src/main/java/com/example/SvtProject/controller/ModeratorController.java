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

import com.example.SvtProject.dto.ModeratorDTO;
import com.example.SvtProject.model.Community;
import com.example.SvtProject.model.Moderator;
import com.example.SvtProject.model.UserType;
import com.example.SvtProject.serviceInterface.CommunityServiceInterface;
import com.example.SvtProject.serviceInterface.ModeratorServiceInterface;

@RestController
@RequestMapping(value = "api/moderator")
public class ModeratorController {

	public static final String MODERATOR_KEY = "loggedInModerator";
	
	@Autowired
	ModeratorServiceInterface moderatorServiceInterface;
	
	@Autowired
	CommunityServiceInterface communityServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<ModeratorDTO>> getModerators(){

		List<Moderator> moderators = moderatorServiceInterface.findAll();
		
		List<ModeratorDTO> moderatorDTO = new ArrayList<ModeratorDTO>();
		for(Moderator moderator: moderators) {
			moderatorDTO.add(new ModeratorDTO(moderator));
		}
		return new ResponseEntity<List<ModeratorDTO>>(moderatorDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ModeratorDTO> getModerator(@PathVariable("id") Long id){
		Moderator moderator = moderatorServiceInterface.findOne(id);
		
		if(moderator == null) {
			return new ResponseEntity<ModeratorDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ModeratorDTO>(new ModeratorDTO(moderator), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ModeratorDTO> addModerator(@RequestBody ModeratorDTO moderatorDTO){

		Community community = communityServiceInterface.findById(moderatorDTO.getIdCommunity());
		
		Moderator moderator = new Moderator();
		moderator.setUserName(moderatorDTO.getUserNameModerator());
		moderator.setPassword(moderatorDTO.getPasswordModerator());
		moderator.setEmail(moderatorDTO.getEmailModerator());
		moderator.setAvatar(moderatorDTO.getAvatarModerator());
		moderator.setBanned(moderatorDTO.isBanned());
		moderator.setRegistrationDate(moderatorDTO.getRegistrationDateModerator());
		moderator.setUserType(UserType.MODERATOR);
		moderator.setCommunity(community);
		
		moderator = moderatorServiceInterface.save(moderator);
		return new ResponseEntity<ModeratorDTO>(new ModeratorDTO(moderator), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<ModeratorDTO> updateModerator(@RequestBody ModeratorDTO moderatorDTO, @PathVariable("id") Long id){

		Moderator moderator = moderatorServiceInterface.findById(id);
		
		if(moderator == null) {
			return new ResponseEntity<ModeratorDTO>(HttpStatus.BAD_REQUEST);
		}
		moderator.setUserName(moderatorDTO.getUserNameModerator());
		moderator.setPassword(moderatorDTO.getPasswordModerator());
		moderator.setEmail(moderatorDTO.getEmailModerator());
		moderator.setAvatar(moderatorDTO.getAvatarModerator());
		moderator.setBanned(moderatorDTO.isBanned());
		moderator.setRegistrationDate(moderatorDTO.getRegistrationDateModerator());

		moderator = moderatorServiceInterface.save(moderator);
		return new ResponseEntity<ModeratorDTO>(new ModeratorDTO(moderator), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteAdmin(@PathVariable("id") Long id){
		Moderator moderator = moderatorServiceInterface.findById(id);
		if(moderator != null) {
			moderatorServiceInterface.remove(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/{id}/blokiranje")
	public ResponseEntity<ModeratorDTO> blok(@PathVariable("id") Long id){

		Moderator moderator = moderatorServiceInterface.findById(id);
		
		if(moderator.isBanned() == false) {
			moderator.setBanned(true);
		}else {
			moderator.setBanned(false);
		}
		
		moderator = moderatorServiceInterface.save(moderator);
		return new ResponseEntity<ModeratorDTO>(new ModeratorDTO(moderator), HttpStatus.CREATED);
	}
	
}
