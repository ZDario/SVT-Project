package serviceInterface;

import java.util.List;

import model.Redditor;

public interface RedditorServiceInterface {
	
	public List<Redditor> findAll();
	public Redditor findOne(Long id);
	public Redditor findById(Long userId);
	public Redditor findByUNameAndPassword(String uName, String pass);
	public Redditor save(Redditor redditor);
	public void remove(Long id);

}
