package com.example.SvtProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SvtProject.model.Community;
import com.example.SvtProject.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

	Post findByIdPost(Long idPost);
	
	List<Post> findByCommunity(Community community);
}
