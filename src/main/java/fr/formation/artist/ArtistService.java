/**
 * 
 */
package fr.formation.artist;

import org.springframework.stereotype.Service;

import fr.formation.user.User;
import fr.formation.user.UserRole;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author adminHOC
 *
 */
@Service
public class ArtistService {

	private ArtistRepository artistRepository;
	
	/**
	 * Instantiates a new Artist service.
	 * @param artistRepository
	 */
	@Autowired
	public ArtistService(ArtistRepository artistRepository) {
		this.artistRepository = artistRepository;
	}
	
	/**
	 * Add a new artist with the artist repository
	 *
	 * @param username the username
	 * @param password the password
	 * @param roles    the roles
	 * @param email    the email 
	 */
	public void addNewArtist(String artist_name, String artist_shortDesc, String artist_longDesc, 
			String artist_phone, String artist_email, String artist_website, User user) {

		Artist artist = new Artist(artist_name, artist_shortDesc, artist_longDesc, 
				 artist_phone, artist_email, artist_website, user);
		artist = artistRepository.save(artist);
	}
	
	
}
