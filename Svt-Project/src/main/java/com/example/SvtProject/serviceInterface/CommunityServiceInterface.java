package com.example.SvtProject.serviceInterface;

import java.util.List;

import com.example.SvtProject.model.Community;

public interface CommunityServiceInterface {
	
	public List<Community> findAll();
	public Community findOne(Long id);
	public Community findById(Long communityId);
	public Community save(Community community);
	public void remove(Long id);

}
