package com.example.SvtProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SvtProject.model.Comment;
import com.example.SvtProject.model.Post;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	Comment findByIdComment(Long idComment);
	
	List<Comment> findByPost(Post post);
}
