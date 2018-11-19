package fr.formation.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.formation.artist.ArtistService;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ArtistService artistService;

	/**
	 * Signup.
	 *
	 * @param username the user_name
	 * @param password the password
	 */
	@PutMapping("/add")
	public User signup(@RequestParam String username, @RequestParam String password, @RequestParam String email,
					   @RequestParam String cityName, @RequestParam String cityCode, @RequestParam String deptCode,
					   @RequestParam(required = false) String artistName, @RequestParam(required = false) String shortDesc) {
		
		User user = userService.addNewUser(username, password, email, cityName, cityCode, deptCode);
		
		if(artistName != null && shortDesc != null) {
		artistService.addNewArtist(artistName,  shortDesc,  null, null, null, null, user);
		}

		return user;
	}
}
