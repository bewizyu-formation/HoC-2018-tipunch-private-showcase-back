/**
 * 
 */
package fr.formation.artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.artist.ArtistService;
import fr.formation.user.User;

/**
 * the type artist
 * @author adminHOC
 *
 */

@RestController
@RequestMapping("/artist")
public class ArtistController {
	
	@Autowired
	private ArtistService artistService;

	/**
	 * Signup.
	 *
	 * @param username the user_name
	 * @param password the password
	 * @param roles    the roles
	 */
	@PutMapping("/add")
	public void createArtist(@RequestParam String artist_name, @RequestParam String artist_shortDesc, @RequestParam String artist_longDesc, 
			@RequestParam String artist_phone, @RequestParam String artist_email, @RequestParam String artist_website) {
		
//		String user = SecurityContextHolder.getContext().getAuthentication().getName();
//		
//		artistService.addNewArtist( artist_name,  artist_shortDesc,  artist_longDesc, 
//				 artist_phone,  artist_email,  artist_website, user);
	}
	

}
