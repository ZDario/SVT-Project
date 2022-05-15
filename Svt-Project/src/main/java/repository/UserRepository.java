package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByIdUser(Long idUser);
	
	User findByUserNameAndPassword(String userName, String password);

}
