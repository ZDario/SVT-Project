package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Community;
import repository.CommunityRepository;
import serviceInterface.CommunityServiceInterface;

@Service
public class CommunityService implements CommunityServiceInterface{

	@Autowired
	CommunityRepository communityRepository;
	
	@Override
	public List<Community> findAll() {
		return communityRepository.findAll();
	}

	@Override
	public Community findOne(Long id) {
		return communityRepository.getOne(id);
	}

	@Override
	public Community findById(Long postId) {
		return communityRepository.findByIdCommunity(postId);
	}

	@Override
	public Community save(Community community) {
		return communityRepository.save(community);
	}

	@Override
	public void remove(Long id) {
		communityRepository.deleteById(id);
		
	}

}
