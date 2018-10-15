package fr.formation.hello;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/hello")
@Secured("ROLE_USER")
public class HelloController {

	Logger logger = LoggerFactory.getLogger(HelloController.class);

	@GetMapping("/admin")
	@Secured("ROLE_ADMIN")
	Hello sayHelloAdmin() { return new Hello("Hello Admin!");}

	@GetMapping("/user")
	@Secured("ROLE_USER")
	Hello sayHelloUser() {
		return new Hello("Hello User!");
	}

	@PostMapping("/upload")
	public String handleFormUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file)
			throws IOException {

		if (!file.isEmpty()) {

			// Vous pouvez trouvez dans ce post un exemple pour sauvegarder un fichier sur le filesystem
			// https://grokonez.com/frontend/angular/angular-4-uploadget-multipartfile-tofrom-spring-boot-server
			logger.info("File Name : " + name);
			logger.info("File Type : " + file.getContentType());

			byte[] bytes = file.getBytes();

			// For the test, we gave txt files that we can display
			// Remove all the code below for production !

			return new String(bytes, "UTF-8");
		}

		return "redirect:uploadFailure";
	}

	@GetMapping("/uploadFailure")
	public String uploadFailure() {
		return "Upload Failure !";

	}

}
