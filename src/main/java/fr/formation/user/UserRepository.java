package fr.formation.user;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * The interface User repository.
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Find by user_name user.
	 *
	 * @param username the user_name
	 *
	 * @return the user
	 */
	public User findByUsername(String username);


}
