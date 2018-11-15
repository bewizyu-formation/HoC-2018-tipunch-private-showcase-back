package fr.formation.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Signup.
	 *
	 * @param username the user_name
	 * @param password the password
	 * @param roles    the roles
	 */
	@PutMapping("/")
	public void signup(@RequestParam String username, @RequestParam String password, @RequestParam String email, 
			@RequestParam String cityName, @RequestParam String cityCode, @RequestParam String deptName, @RequestParam String user_departementCode,String... roles) {
		userService.addNewUser(username, password, email, cityName, cityCode, deptName, user_departementCode, roles);
	}

}
