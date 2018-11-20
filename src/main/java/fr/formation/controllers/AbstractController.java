package fr.formation.controllers;

import fr.formation.user.User;
import fr.formation.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class AbstractController {

    @Autowired
    UserService userService;

    /**
     * Get authenticated user
     * @return
     */
    protected User getAuthenticatedUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.findUserByUsername(username);
    }
}
