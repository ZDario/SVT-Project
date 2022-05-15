package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Post;
import repository.PostRepository;
import serviceInterface.PostServiceInterface;

@Service
public class PostService implements PostServiceInterface{

	@Autowired
	PostRepository postRepository;
	
	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	public Post findOne(Long id) {
		return postRepository.getOne(id);
	}

	@Override
	public Post findById(Long postId) {
		return postRepository.findByIdPost(postId);
	}

	@Override
	public Post save(Post post) {
		return postRepository.save(post);
	}

	@Override
	public void remove(Long id) {
		postRepository.deleteById(id);
		
	}

}
