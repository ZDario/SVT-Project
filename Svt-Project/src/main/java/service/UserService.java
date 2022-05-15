package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.User;
import repository.UserRepository;
import serviceInterface.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findOne(Long id) {
		return userRepository.getOne(id);
	}

	@Override
	public User findById(Long userId) {
		return userRepository.findByIdUser(userId);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public void remove(Long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public User findByUNameAndPassword(String uName, String pass) {
		return userRepository.findByUserNameAndPassword(uName, pass);
	}

}
