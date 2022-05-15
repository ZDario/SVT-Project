package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Community;

public interface CommunityRepository extends JpaRepository<Community, Long>{

	Community findByIdCommunity(Long idCommunity);
}
