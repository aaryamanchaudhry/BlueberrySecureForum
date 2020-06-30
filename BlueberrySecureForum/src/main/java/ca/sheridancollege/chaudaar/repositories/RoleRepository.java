package ca.sheridancollege.chaudaar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.chaudaar.beans.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	
	public Role findByRolename(String rolename);
}
