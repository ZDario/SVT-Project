package com.example.SvtProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SvtProject.model.Community;

public interface CommunityRepository extends JpaRepository<Community, Long>{

	Community findByIdCommunity(Long idCommunity);
}
