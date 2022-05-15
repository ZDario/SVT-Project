package serviceInterface;

import java.util.List;

import model.Post;

public interface PostServiceInterface {
	
	public List<Post> findAll();
	public Post findOne(Long id);
	public Post findById(Long postId);
	public Post save(Post post);
	public void remove(Long id);

}
