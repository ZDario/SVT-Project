package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Moderator;
import repository.ModeratorRepository;
import serviceInterface.ModeratorServiceInterface;

@Service
public class ModeratorService implements ModeratorServiceInterface{

	@Autowired
	ModeratorRepository moderatorRepository;
	
	@Override
	public List<Moderator> findAll() {
		return moderatorRepository.findAll();
	}

	@Override
	public Moderator findOne(Long id) {
		return moderatorRepository.getOne(id);
	}

	@Override
	public Moderator findById(Long userId) {
		return moderatorRepository.findByIdUser(userId);
	}

	@Override
	public Moderator save(Moderator moderator) {
		return moderatorRepository.save(moderator);
	}

	@Override
	public void remove(Long id) {
		moderatorRepository.deleteById(id);
		
	}

	@Override
	public Moderator findByUNameAndPassword(String uName, String pass) {
		return moderatorRepository.findByUserNameAndPassword(uName, pass);
	}

}
