package fr.formation;

import fr.formation.artist.ArtistService;
import fr.formation.upload.ImageService;
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
	private ImageService imageService;

	/**
	 * Instantiates a new Boostrap data.
	 *
	 * @param userService     the user service
	 * @param passwordEncoder the password encoder
	 *
	 */
	@Autowired
	public BoostrapData(UserService userService, ArtistService artistService, PasswordEncoder passwordEncoder, UploadService uploadService, ImageService imageService) {
		this.userService = userService;
		this.artistService = artistService;
		this.passwordEncoder = passwordEncoder;
		this.uploadService = uploadService;
		this.imageService = imageService;
	}

	/**
	 * On start.
	 */
	@EventListener(ContextRefreshedEvent.class)
	public void onStart() {

		uploadService.deleteAll();
		uploadService.init();
		imageService.addDefaultImage();

		userService.addNewUser(
				"admin",
				"admin",
				"admin@admin.fr",
				"adminCity",
				"adminCode",
				"01"
		);

		userService.addNewUser(
				"user",
				"user",
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
						"1Azerty1",
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
						"2Qwerty2",
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
						"1Azerty1",
						"patrick@user.fr",
						"Laon",
						"02000",
						"02"
				),
				null
		);

		userService.addNewUser(
				"Yann",
				"2Qwerty2",
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
						"3Wxcvbn3",
						"Jeanine@user.fr",
						"Fère-en-Tardenois",
						"02130",
						"02"
				),
				null
		);

		artistService.addNewArtist(
				"Bob le Mécano",
				"Arrive chez vous pour tout démonter !",
				"Manie le marteau et la scie comme personne",
				"0678787878",
				"bob@mecano.fr",
				"bobthemecano.fr",
				userService.addNewUser(
						"Bob",
						"3Wxcvbn3",
						"bob@user.fr",
						"Guise",
						"02120",
						"02"
				),
				null
		);

		artistService.addNewArtist(
				"JaggerMeister",
				"Enchaîne les riffs aussi vite que les shots !",
				"A composé une symphonie mais ne s'en souvient pas (probablement une soirée trop arrosée...)",
				"0632323232",
				"mick@jaggermeister.fr",
				"jaggermeister.fr",
				userService.addNewUser(
						"mick",
						"1Azerty1",
						"mick@jagger.fr",
						"Braine",
						"02220",
						"02"
				),
				null
		);

		artistService.addNewArtist(
				"DaviDetat",
				"Mixeur qui s'adapte au budget",
				"J'ai branché ma platine une fois mais j'ai vite arrêté (trop de câble)",
				"0679797979",
				"davidetat@djdetat.fr",
				"djdetat.fr",
				userService.addNewUser(
						"david",
						"1Azerty1",
						"david@caramail.fr",
						"Coucy-le-Château-Auffrique",
						"02380",
						"02"
				),
				null
		);
	}
}
