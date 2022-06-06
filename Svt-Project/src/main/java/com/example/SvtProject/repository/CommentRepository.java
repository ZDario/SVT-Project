package com.example.SvtProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SvtProject.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	Comment findByIdComment(Long idComment);
}
