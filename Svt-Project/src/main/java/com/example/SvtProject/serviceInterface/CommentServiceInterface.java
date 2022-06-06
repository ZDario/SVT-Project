package com.example.SvtProject.serviceInterface;

import java.util.List;

import com.example.SvtProject.model.Comment;

public interface CommentServiceInterface {
	
	public List<Comment> findAll();
	public Comment findOne(Long id);
	public Comment findById(Long commentId);
	public Comment save(Comment comment);
	public void remove(Long id);

}
