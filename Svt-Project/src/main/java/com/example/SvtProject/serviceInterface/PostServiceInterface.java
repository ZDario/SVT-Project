package com.example.SvtProject.serviceInterface;

import java.util.List;

import com.example.SvtProject.model.Community;
import com.example.SvtProject.model.Post;

public interface PostServiceInterface {
	
	public List<Post> findAll();
	public Post findOne(Long id);
	public Post findById(Long postId);
	public Post save(Post post);
	public void remove(Long id);
	public List<Post> findAllByCommunity(Community community);

}
