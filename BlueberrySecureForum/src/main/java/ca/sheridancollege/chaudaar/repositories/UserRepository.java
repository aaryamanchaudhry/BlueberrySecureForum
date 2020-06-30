package ca.sheridancollege.chaudaar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.chaudaar.beans.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);
	
	
}
