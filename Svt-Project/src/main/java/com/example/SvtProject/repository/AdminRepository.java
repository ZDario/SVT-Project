package com.example.SvtProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SvtProject.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{
	
	Admin findByIdUser(Long idUser);
	
	Admin findByUserNameAndPassword(String userName, String password);

}
