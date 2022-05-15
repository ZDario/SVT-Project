package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Redditor;
import repository.RedditorRepository;
import serviceInterface.RedditorServiceInterface;

@Service
public class RedditorService implements RedditorServiceInterface{

	@Autowired
	RedditorRepository redditorRepository;
	
	@Override
	public List<Redditor> findAll() {
		return redditorRepository.findAll();
	}

	@Override
	public Redditor findOne(Long id) {
		return redditorRepository.getOne(id);
	}

	@Override
	public Redditor findById(Long userId) {
		return redditorRepository.findByIdUser(userId);
	}

	@Override
	public Redditor save(Redditor redditor) {
		return redditorRepository.save(redditor);
	}

	@Override
	public void remove(Long id) {
		redditorRepository.deleteById(id);
		
	}

	@Override
	public Redditor findByUNameAndPassword(String uName, String pass) {
		return redditorRepository.findByUserNameAndPassword(uName, pass);
	}

}