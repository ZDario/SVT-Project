package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Redditor;

public interface RedditorRepository extends JpaRepository<Redditor, Long>{
	
	Redditor findByIdUser(Long idUser);
	
	Redditor findByUserNameAndPassword(String userName, String password);

}