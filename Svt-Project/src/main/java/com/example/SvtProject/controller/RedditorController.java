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

import com.example.SvtProject.dto.RedditorDTO;
import com.example.SvtProject.model.Redditor;
import com.example.SvtProject.model.UserType;
import com.example.SvtProject.serviceInterface.RedditorServiceInterface;

@RestController
@RequestMapping(value = "api/redditor")
public class RedditorController {

	@Autowired
	RedditorServiceInterface redditorServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<RedditorDTO>> getRedditors(){

		List<Redditor> redditors = redditorServiceInterface.findAll();
		
		List<RedditorDTO> redditorDTO = new ArrayList<RedditorDTO>();
		for(Redditor redditor: redditors) {
			redditorDTO.add(new RedditorDTO(redditor));
		}
		return new ResponseEntity<List<RedditorDTO>>(redditorDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<RedditorDTO> getRedditor(@PathVariable("id") Long id){
		Redditor redditor = redditorServiceInterface.findOne(id);
		
		if(redditor == null) {
			return new ResponseEntity<RedditorDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<RedditorDTO>(new RedditorDTO(redditor), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<RedditorDTO> addRedditor(@RequestBody RedditorDTO redditorDTO){

		Date creationDate = new Date();
		
		Redditor redditor = new Redditor();
		redditor.setUserName(redditorDTO.getUserNameRedditor());
		redditor.setPassword(redditorDTO.getPasswordRedditor());
		redditor.setEmail(redditorDTO.getEmailRedditor());
		redditor.setAvatar(redditorDTO.getAvatarRedditor());
		redditor.setBanned(redditorDTO.isBanned());
		redditor.setRegistrationDate(creationDate);
		redditor.setUserType(UserType.REDDITOR);
		
		redditor = redditorServiceInterface.save(redditor);
		return new ResponseEntity<RedditorDTO>(new RedditorDTO(redditor), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<RedditorDTO> updateRedditor(@RequestBody RedditorDTO redditorDTO, @PathVariable("id") Long id){

		Redditor redditor = redditorServiceInterface.findById(id);
		
		if(redditor == null) {
			return new ResponseEntity<RedditorDTO>(HttpStatus.BAD_REQUEST);
		}
		redditor.setUserName(redditorDTO.getUserNameRedditor());
		redditor.setPassword(redditorDTO.getPasswordRedditor());
		redditor.setEmail(redditorDTO.getEmailRedditor());
		redditor.setAvatar(redditorDTO.getAvatarRedditor());
		redditor.setBanned(redditorDTO.isBanned());

		redditor = redditorServiceInterface.save(redditor);
		return new ResponseEntity<RedditorDTO>(new RedditorDTO(redditor), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteRedditor(@PathVariable("id") Long id){
		Redditor redditor = redditorServiceInterface.findById(id);
		if(redditor != null) {
			redditorServiceInterface.remove(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/{id}/blokiranje")
	public ResponseEntity<RedditorDTO> blok(@PathVariable("id") Long id){

		Redditor redditor = redditorServiceInterface.findById(id);
		
		if(redditor.isBanned() == false) {
			redditor.setBanned(true);
		}else {
			redditor.setBanned(false);
		}
		
		redditor = redditorServiceInterface.save(redditor);
		return new ResponseEntity<RedditorDTO>(new RedditorDTO(redditor), HttpStatus.CREATED);
	}
	
}
