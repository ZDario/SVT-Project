package serviceInterface;

import java.util.List;

import model.User;

public interface UserServiceInterface {
	
	public List<User> findAll();
	public User findOne(Long id);
	public User findById(Long userId);
	public User findByUNameAndPassword(String uName, String pass);
	public User save(User user);
	public void remove(Long id);

}
