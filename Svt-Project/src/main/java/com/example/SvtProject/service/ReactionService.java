package com.example.SvtProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SvtProject.model.Reaction;
import com.example.SvtProject.repository.ReactionRepository;
import com.example.SvtProject.serviceInterface.ReactionServiceInterface;

@Service
public class ReactionService implements ReactionServiceInterface{
	
	@Autowired
	ReactionRepository reactionRepository;
	
	@Override
	public List<Reaction> findAll() {
		return reactionRepository.findAll();
	}

	@Override
	public Reaction findOne(Long id) {
		return reactionRepository.getOne(id);
	}

	@Override
	public Reaction findById(Long reactionId) {
		return reactionRepository.findByIdReaction(reactionId);
	}

	@Override
	public Reaction save(Reaction reaction) {
		return reactionRepository.save(reaction);
	}

	@Override
	public void remove(Long id) {
		reactionRepository.deleteById(id);
		
	}

}
