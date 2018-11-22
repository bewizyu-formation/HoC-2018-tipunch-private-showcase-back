package fr.formation.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.artist.ArtistService;
import fr.formation.controllers.AbstractController;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("/users")
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;

    @Autowired
    private ArtistService artistService;

    /**
     * Signup.
     *
     * @param username the user_name
     * @param password the password
     */
    @PutMapping("/add")
    public User signup(@RequestParam String username, @RequestParam String password, @RequestParam String email,
            @RequestParam String cityName, @RequestParam String cityCode, @RequestParam String deptCode,
            @RequestParam(required = false) String artistName, @RequestParam(required = false) String shortDesc) {

        User user = userService.addNewUser(username, password, email, cityName, cityCode, deptCode);

        if (artistName != null && shortDesc != null) {
            artistService.addNewArtist(artistName, shortDesc, null, null, null, null, user, null);
        }

        return user;
    }

    @GetMapping("/info")
    public UserInfoDTO getUserInfo() {
        User user = super.getAuthenticatedUser();
        UserInfoDTO userDTO = userService.getUserInfo(user);

        return userDTO;
    }
}
