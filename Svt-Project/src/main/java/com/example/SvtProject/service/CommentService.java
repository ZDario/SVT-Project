package com.example.SvtProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SvtProject.model.Comment;
import com.example.SvtProject.repository.CommentRepository;
import com.example.SvtProject.serviceInterface.CommentServiceInterface;

@Service
public class CommentService implements CommentServiceInterface{
	
	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public List<Comment> findAll() {
		return commentRepository.findAll();
	}

	@Override
	public Comment findOne(Long id) {
		return commentRepository.getOne(id);
	}

	@Override
	public Comment findById(Long commentId) {
		return commentRepository.findByIdComment(commentId);
	}

	@Override
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public void remove(Long id) {
		commentRepository.deleteById(id);
		
	}

}
