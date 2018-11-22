package fr.formation.upload;

import fr.formation.controllers.AbstractController;
import fr.formation.security.SecurityConstants;
import fr.formation.user.User;
import fr.formation.user.UserInfoDTO;
import fr.formation.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.Resource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/image")
@Secured(SecurityConstants.ROLE_USER)
public class ImageController extends AbstractController {

    Logger log = LoggerFactory.getLogger(ImageController.class);

    @Autowired
    UploadService uploadService;
    @Autowired
    UserService userService;
    @Autowired
    ImageService imageService;

    public void addFile(@RequestParam("file") MultipartFile file) {
        Assert.notNull(file, "Le fichier ne peut être null");

        log.info("File Name : " + file.getOriginalFilename());
        log.info("File Type : " + file.getContentType());

        User user = super.getAuthenticatedUser();
        UserInfoDTO userInfo = userService.getUserInfo(user);

        imageService.addFile(file, userInfo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getImage(@PathVariable(name = "id") Long id) {
        return imageService.getImage(id);
    }
}