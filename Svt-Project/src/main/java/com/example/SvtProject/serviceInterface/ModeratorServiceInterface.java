package com.example.SvtProject.serviceInterface;

import java.util.List;

import com.example.SvtProject.model.Moderator;

public interface ModeratorServiceInterface {
	
	public List<Moderator> findAll();
	public Moderator findOne(Long id);
	public Moderator findById(Long userId);
	public Moderator findByUNameAndPassword(String uName, String pass);
	public Moderator save(Moderator moderator);
	public void remove(Long id);

}
