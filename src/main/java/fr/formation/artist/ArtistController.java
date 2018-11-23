/**
 * 
 */
package fr.formation.artist;

import fr.formation.controllers.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.formation.user.User;
import org.springframework.web.multipart.MultipartFile;

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

		User user = super.getAuthenticatedUser();
		artistService.addNewArtist( artist_name,  artist_shortDesc,  artist_longDesc, artist_phone,  artist_email,  artist_website, user, null);
	}

	@GetMapping("/list")
	public List<Artist> getArtistsFromDepartement() {
		User user = super.getAuthenticatedUser();
		return artistService.findArtistsByDepartementCode(user.getDepartmentCode(), user.getId());
	}

	@PostMapping("/update")
	public Artist updateArtist(@RequestParam("name") String artist_name, @RequestParam("shortdesc") String artist_shortDesc, @RequestParam("longdesc") String artist_longDesc,
							   @RequestParam("phone") String artist_phone, @RequestParam("email") String artist_email, @RequestParam("website") String artist_website,
							   @RequestParam("file") MultipartFile file) {

		User user = super.getAuthenticatedUser();
		Artist artist = artistService.updateArtist(artist_name, artist_shortDesc, artist_longDesc, artist_phone, artist_email, artist_website, user, file);

		return artist;
	}
	@GetMapping("/info/{artistId}")
	public Artist ArtistInfo(@PathVariable Long artistId) {

		User user = super.getAuthenticatedUser();
		Artist artist = artistService.getArtistInfo(user, artistId);

		return artist;
	}


}
