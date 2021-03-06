package fr.formation.user;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import fr.formation.artist.Artist;
import fr.formation.artist.ArtistRepository;
import fr.formation.geo.model.Departement;
import fr.formation.geo.services.DepartementService;
import fr.formation.security.SecurityConstants;

/**
 * The type User service.
 */
@Service
public class UserService implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private DepartementService departementService;
    private ArtistRepository artistRepository;
    private PasswordEncoder passwordEncoder;

    /**
     * Instantiates a new User service.
     *
     * @param userRepository     the user repository
     * @param userRoleRepository the user role repository
     */
    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository,
            ArtistRepository artistRepository, DepartementService departementService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.departementService = departementService;
        this.artistRepository = artistRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * transform a list of roles (as {@link String}) into a list of {@link GrantedAuthority}
     *
     * @param userRoles the user roles list
     *
     * @return
     */
    private static Collection<? extends GrantedAuthority> transformToAuthorities(List<String> userRoles) {
        String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findUserByUsername(username);
        List<String> roles = userRoleRepository.findRoleByUserName(username);
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(),
                transformToAuthorities(roles));
    }

    /**
     * findUserByUsername.
     * @param username
     * @return user
     * @throws UsernameNotFoundException
     */
    public User findUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("No user exists with username: " + username);
        }
    }

    /**
     * Get User Info.
     * @param user
     * @return
     */
    public UserInfoDTO getUserInfo(User user) {

        UserInfoDTO userInfoDTO = new UserInfoDTO(null, user.getUsername(), null,
                user.getDepartmentCode());
        Artist artist = artistRepository.findArtistByUser_Id(user.getId());

        if(artist != null) {
            userInfoDTO.setArtistId(artist.getId());
            userInfoDTO.setArtistName(artist.getArtistName());
        }

        return userInfoDTO;
    }

    /**
     * Add a new user with the user repository
     *
     * @param username the username
     * @param password the password
     * @param email    the email
     * @param cityName the cityName
     * @param cityCode the cityCode
     * @param deptCode the deptCode
     */
    public User addNewUser(String username, String password, String email, String cityName, String cityCode,
            String deptCode) {

        List<Departement> departmentName = departementService.getDepartementByCode(deptCode);
        String deptName = departmentName.get(0).getNom();

        String passwordEncoded = passwordEncoder.encode(password);

        User user = new User(username, passwordEncoded, email, cityName, cityCode, deptName, deptCode);
        user = userRepository.save(user);

        if (username == "admin") {
            UserRole userRole = new UserRole();
            userRole.setRole(SecurityConstants.ROLE_ADMIN);
            userRole.setUserId(user.getId());
            userRoleRepository.save(userRole);
        } else {
            UserRole userRole = new UserRole();
            userRole.setRole(SecurityConstants.ROLE_USER);
            userRole.setUserId(user.getId());
            userRoleRepository.save(userRole);
        }
        return user;
    }
}