package fr.formation.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;

import fr.formation.security.SecurityConstants;

/**
 * The type User service.
 */
@Service
public class UserService implements UserDetailsService {

	private UserRepository userRepository;

	private UserRoleRepository userRoleRepository;

	/**
	 * Instantiates a new User service.
	 *
	 * @param userRepository     the user repository
	 * @param userRoleRepository the user role repository
	 */
	@Autowired
	public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
	}

	/**
	 * transform a list of roles (as {@link String}) into a list of {@link GrantedAuthority}
	 *
	 * @param userRoles
	 *
	 * @return
	 */
	private static Collection<? extends GrantedAuthority> transformToAuthorities(List<String> userRoles) {
		String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);

		if (user != null) {
			List<String> roles = userRoleRepository.findRoleByUserName(username);
			return new org.springframework.security.core.userdetails.User(username, user.getPassword(),
					transformToAuthorities(roles));
		} else {
			throw new UsernameNotFoundException("No user exists with username: " + username);
		}

	}

	/**
	 * Add a new user with the user repository
	 *
	 * @param username the username
	 * @param password the password
	 * @param email    the email
	 * @param cityName the cityName
	 * @param cityCode the cityCode
	 * @param deptName the deptName
	 * @param deptCode the deptCode
	 */
	public User addNewUser(String username,String password, String email, String cityName, 
			String cityCode, String deptName, String deptCode) {

		User user = new User(username, password, email, cityName, cityCode, deptName, deptCode);
		user = userRepository.save(user);

		if (username == "admin") {
			UserRole userRole = new UserRole();
			userRole.setRole(SecurityConstants.ROLE_ADMIN);
			userRole.setUserId(user.getId());
			userRoleRepository.save(userRole);
		} else {
			UserRole userRole = new UserRole();
			userRole.setRole(SecurityConstants.ROLE_USER);
			userRole.setUserId(user.getId());
			userRoleRepository.save(userRole);
		}
		return user;

	}
}