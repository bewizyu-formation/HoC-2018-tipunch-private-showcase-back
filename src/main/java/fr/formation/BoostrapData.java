package fr.formation;

import fr.formation.artist.ArtistService;
import fr.formation.upload.UploadService;
import fr.formation.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * This class configure the dataset at application start
 */
@Component
public class BoostrapData {

	private ArtistService artistService;
	private UserService userService;
	private PasswordEncoder passwordEncoder;
	private UploadService uploadService;

	/**
	 * Instantiates a new Boostrap data.
	 *
	 * @param userService     the user service
	 * @param passwordEncoder the password encoder
	 *
	 */
	@Autowired
	public BoostrapData(UserService userService, ArtistService artistService, PasswordEncoder passwordEncoder, UploadService uploadService) {
		this.userService = userService;
		this.artistService = artistService;
		this.passwordEncoder = passwordEncoder;
		this.uploadService = uploadService;
	}

	/**
	 * On start.
	 */
	@EventListener(ContextRefreshedEvent.class)
	public void onStart() {

		uploadService.deleteAll();
		uploadService.init();

		userService.addNewUser(
				"admin",
				passwordEncoder.encode("admin"),
				"admin@admin.fr",
				"adminCity",
				"adminCode",
				"01"
		);

		userService.addNewUser(
				"user",
				passwordEncoder.encode("user"),
				"user@user.fr",
				"userCity",
				"userCode",
				"02"
		);

		artistService.addNewArtist(
				"Jean the magician",
				"I'm a very great magician",
				"I'm the magician that everyone wants",
				"0689451365",
				"jean@mail.fr",
				"jeanmagician.fr",
				userService.addNewUser(
						"jean",
						passwordEncoder.encode("1Azerty1"),
						"jean@user.fr",
						"Paris",
						"75001",
						"75"
				),
				null
		);

		artistService.addNewArtist(
				"Smelling Dave",
				"Je fais des bulles avec mon cul !",
				"Aérophagique depuis tout petit, je maîtrise mon cul comme personne !",
				"0769696969",
				"dave@mail.fr",
				"dave.ass",
				userService.addNewUser(
						"Dave",
						passwordEncoder.encode("2Qwerty2"),
						"Dave@user.fr",
						"Saint-Quentin",
						"02100",
						"02"
				),
				null
		);

		artistService.addNewArtist(
				"Patrick and the incredible Band",
				"La musique ? C'est notre passion !",
				"Mais on joue surtout du pipeau et de la flûte !",
				"0645124512",
				"patrick@incredibleband.fr",
				"pantrickandtheincredibleband.fr",
				userService.addNewUser(
						"patrick",
						passwordEncoder.encode("1Azerty1"),
						"patrick@user.fr",
						"Laon",
						"02000",
						"02"
				),
				null
		);

		userService.addNewUser(
				"Yann",
				passwordEncoder.encode("2Qwerty2"),
				"Yann@user.fr",
				"Paris",
				"75009",
				"75"
		);

		artistService.addNewArtist(
				"Ping Pong Woman",
				"Devinez ce que je fais avec mon vagin !",
				"Championne du monde toute catégorie avec mon vagin.",
				"0645454545",
				"jeanine@event.fr",
				"event.fr",
				userService.addNewUser(
						"Jeanine",
						passwordEncoder.encode("3Wxcvbn3"),
						"Jeanine@user.fr",
						"Fère-en-Tardenois",
						"02130",
						"02"
				),
				null
		);
	}
}
