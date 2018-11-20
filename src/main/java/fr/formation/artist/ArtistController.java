/**
 * 
 */
package fr.formation.artist;

import fr.formation.controllers.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.formation.user.User;

import java.util.List;

/**
 * the type artist
 * @author adminHOC
 *
 */

@RestController
@RequestMapping("/artist")
public class ArtistController extends AbstractController {
	
	@Autowired
	private ArtistService artistService;


	@PutMapping("/add")
	public void createArtist(@RequestParam String artist_name, @RequestParam String artist_shortDesc, @RequestParam String artist_longDesc, 
			@RequestParam String artist_phone, @RequestParam String artist_email, @RequestParam String artist_website) {
		
//		String user = SecurityContextHolder.getContext().getAuthentication().getName();
//		
//		artistService.addNewArtist( artist_name,  artist_shortDesc,  artist_longDesc, 
//				 artist_phone,  artist_email,  artist_website, user);
	}

	@GetMapping("/list")
	public List<Artist> getArtistFromDepartement() {
		User user = super.getAuthenticatedUser();
		return artistService.findArtistsByDepartementCode(user.getDepartmentCode());
	}
}
