package com.example.SvtProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SvtProject.model.Redditor;

public interface RedditorRepository extends JpaRepository<Redditor, Long>{
	
	Redditor findByIdUser(Long idUser);
	
	Redditor findByUserNameAndPassword(String userName, String password);

}