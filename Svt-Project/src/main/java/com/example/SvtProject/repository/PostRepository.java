package com.example.SvtProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SvtProject.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

	Post findByIdPost(Long idPost);
}
