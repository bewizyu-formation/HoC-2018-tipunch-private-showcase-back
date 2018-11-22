/**
 * 
 */
package fr.formation.artist;

import fr.formation.upload.Image;
import fr.formation.upload.ImageService;
import fr.formation.user.UserInfoDTO;
import fr.formation.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import fr.formation.user.User;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author adminHOC
 *
 */
@Service
public class ArtistService {

	private ArtistRepository artistRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private ImageService imageService;
	
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
			String artist_phone, String artist_email, String artist_website, User user, Image image) {

		if(image == null) {
			image = imageService.getDefaultImg();
		}

		Artist artist = new Artist(artist_name, artist_shortDesc, artist_longDesc, 
				 artist_phone, artist_email, artist_website, user, image);
		artist = artistRepository.save(artist);

		return artist;
	}

	public Artist updateArtist(String artist_name, String artist_shortDesc, String artist_longDesc,
							   String artist_phone, String artist_email, String artist_website, User user, MultipartFile file) {

		Artist artist = artistRepository.findArtistByUser_Id(user.getId());

		if(artist_name != null) {artist.setArtistName(artist_name);}
		if(artist_shortDesc != null) {artist.setShortDescription(artist_shortDesc);}
		if(artist_longDesc != null) {artist.setlongDescription(artist_longDesc);}
		if(artist_phone != null) {artist.setPhone(artist_phone);}
		if(artist_email != null) {artist.setEmail(artist_email);}
		if(artist_website != null) {artist.setWebsite(artist_website);}
		if(file != null) {

			UserInfoDTO userInfo = userService.getUserInfo(user);
			Image image = imageService.addFile(file, userInfo);
			if(image != null) {
				artist.setImage(image);
			}
		} else {
			artist.setImage(imageService.getDefaultImg());
		}

		artist = artistRepository.saveAndFlush(artist);

		return artist;
	}

	public List<Artist> findArtistsByDepartementCode (final String codeDepartement, Long userId) {
		return artistRepository.findArtistsByUser_DepartmentCode(codeDepartement, userId);
	}




}
