package fr.formation.upload;

import fr.formation.controllers.AbstractController;
import fr.formation.security.SecurityConstants;
import fr.formation.user.User;
import fr.formation.user.UserInfoDTO;
import fr.formation.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/file")
@Secured(SecurityConstants.ROLE_USER)
public class ImageController extends AbstractController {

    Logger log = LoggerFactory.getLogger(ImageController.class);

    @Autowired
    UploadService uploadService;
    @Autowired
    UserService userService;
    @Autowired
    ImageService imageService;

    @PostMapping(value = "/add")
    public void addFile(@RequestParam("file") MultipartFile file) {
        Assert.notNull(file, "Le fichier ne peut être null");

        log.info(file.getOriginalFilename());

        User user = super.getAuthenticatedUser();
        UserInfoDTO userInfo = userService.getUserInfo(user);

        imageService.addFile(file, userInfo);
    }
}