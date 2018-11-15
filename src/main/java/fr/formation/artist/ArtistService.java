/**
 * 
 */
package fr.formation.artist;

import org.springframework.stereotype.Service;
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
	
	
}
