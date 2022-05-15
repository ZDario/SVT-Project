package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Moderator;

public interface ModeratorRepository extends JpaRepository<Moderator, Long>{
	
	Moderator findByIdUser(Long idUser);
	
	Moderator findByUserNameAndPassword(String userName, String password);

}
