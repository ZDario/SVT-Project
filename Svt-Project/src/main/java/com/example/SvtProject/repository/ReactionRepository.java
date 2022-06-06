package com.example.SvtProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SvtProject.model.Reaction;

public interface ReactionRepository extends JpaRepository<Reaction, Long>{
	
	Reaction findByIdReaction(Long idReaction);

}
