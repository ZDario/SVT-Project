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

import com.example.SvtProject.dto.AdminDTO;
import com.example.SvtProject.model.Admin;
import com.example.SvtProject.model.UserType;
import com.example.SvtProject.serviceInterface.AdminServiceInterface;

@RestController
@RequestMapping(value = "api/admin")
public class AdminController {

	@Autowired
	AdminServiceInterface adminServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<AdminDTO>> getAdmins(){

		List<Admin> admins = adminServiceInterface.findAll();
		
		List<AdminDTO> adminDTO = new ArrayList<AdminDTO>();
		for(Admin admin: admins) {
			adminDTO.add(new AdminDTO(admin));
		}
		return new ResponseEntity<List<AdminDTO>>(adminDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AdminDTO> getAdmin(@PathVariable("id") Long id){
		Admin admin = adminServiceInterface.findOne(id);
		
		if(admin == null) {
			return new ResponseEntity<AdminDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AdminDTO>(new AdminDTO(admin), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<AdminDTO> addAdmin(@RequestBody AdminDTO adminDTO){

		Admin admin = new Admin();
		admin.setUserName(adminDTO.getUserNameAdmin());
		admin.setPassword(adminDTO.getPasswordAdmin());
		admin.setEmail(adminDTO.getEmailAdmin());
		admin.setAvatar(adminDTO.getAvatarAdmin());
		admin.setBanned(adminDTO.isBanned());
		admin.setRegistrationDate(adminDTO.getRegistrationDateAdmin());
		admin.setUserType(UserType.ADMIN);
		
		admin = adminServiceInterface.save(admin);
		return new ResponseEntity<AdminDTO>(new AdminDTO(admin), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<AdminDTO> updateAdmin(@RequestBody AdminDTO adminDTO, @PathVariable("id") Long id){

		Admin admin = adminServiceInterface.findById(id);
		
		if(admin == null) {
			return new ResponseEntity<AdminDTO>(HttpStatus.BAD_REQUEST);
		}
		admin.setUserName(adminDTO.getUserNameAdmin());
		admin.setPassword(adminDTO.getPasswordAdmin());
		admin.setEmail(adminDTO.getEmailAdmin());
		admin.setAvatar(adminDTO.getAvatarAdmin());
		admin.setBanned(adminDTO.isBanned());
		admin.setRegistrationDate(adminDTO.getRegistrationDateAdmin());

		admin = adminServiceInterface.save(admin);
		return new ResponseEntity<AdminDTO>(new AdminDTO(admin), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteAdmin(@PathVariable("id") Long id){
		Admin admin = adminServiceInterface.findById(id);
		if(admin != null) {
			adminServiceInterface.remove(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/{id}/blokiranje")
	public ResponseEntity<AdminDTO> blok(@PathVariable("id") Long id){

		Admin admin = adminServiceInterface.findById(id);
		
		if(admin.isBanned() == false) {
			admin.setBanned(true);
		}else {
			admin.setBanned(false);
		}
		
		admin = adminServiceInterface.save(admin);
		return new ResponseEntity<AdminDTO>(new AdminDTO(admin), HttpStatus.CREATED);
	}
	
}
