package com.example.SvtProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SvtProject.model.Post;
import com.example.SvtProject.model.Reaction;
import com.example.SvtProject.model.ReactionType;

public interface ReactionRepository extends JpaRepository<Reaction, Long>{
	
	Reaction findByIdReaction(Long idReaction);
	
	List<Reaction> findByPost(Post post);

}
