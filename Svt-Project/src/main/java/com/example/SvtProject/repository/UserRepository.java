package com.example.SvtProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SvtProject.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByIdUser(Long idUser);
	
	User findByUserNameAndPassword(String userName, String password);

}
