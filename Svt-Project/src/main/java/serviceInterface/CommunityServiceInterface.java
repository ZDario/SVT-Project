package serviceInterface;

import java.util.List;

import model.Community;

public interface CommunityServiceInterface {
	
	public List<Community> findAll();
	public Community findOne(Long id);
	public Community findById(Long communityId);
	public Community save(Community community);
	public void remove(Long id);

}
