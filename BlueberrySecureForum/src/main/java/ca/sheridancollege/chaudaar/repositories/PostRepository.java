package ca.sheridancollege.chaudaar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.chaudaar.beans.Post;
import ca.sheridancollege.chaudaar.beans.User;

public interface PostRepository extends JpaRepository<Post, Long> {

	public List<Post> findAll();

	public List<Post> findByPosttopic(String topic);

	public List<Post> findByPosttitle(String title);

	

	
	
}
