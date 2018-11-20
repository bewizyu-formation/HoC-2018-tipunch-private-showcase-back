/**
 * 
 */
package fr.formation.artist;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import fr.formation.user.User;

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
	 * Add a new artist with the artist repository.
	 * @param artist_name the artist name
	 * @param artist_shortDesc the artist short description
	 * @param artist_longDesc the artist long description
	 * @param artist_phone the artist phone
	 * @param artist_email the artist email
	 * @param artist_website the artist website
	 * @param user the user linked to the artist
	 * @return Artist
	 */
	public Artist addNewArtist(String artist_name, String artist_shortDesc, String artist_longDesc,
			String artist_phone, String artist_email, String artist_website, User user) {

		Artist artist = new Artist(artist_name, artist_shortDesc, artist_longDesc, 
				 artist_phone, artist_email, artist_website, user);
		artist = artistRepository.save(artist);

		return artist;
	}

	public List<Artist> findArtistsByDepartementCode (final String codeDepartement) {
		return artistRepository.findArtistsByUser_DepartmentCode(codeDepartement);
	}


}
