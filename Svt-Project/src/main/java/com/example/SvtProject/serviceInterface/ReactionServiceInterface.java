package com.example.SvtProject.serviceInterface;

import java.util.List;

import com.example.SvtProject.model.Reaction;

public interface ReactionServiceInterface {
	
	public List<Reaction> findAll();
	public Reaction findOne(Long id);
	public Reaction findById(Long reactionId);
	public Reaction save(Reaction reaction);
	public void remove(Long id);

}
