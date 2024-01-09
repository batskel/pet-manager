package pl.pet.manager.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pet.manager.model.AuthRequest;
import pl.pet.manager.model.UserLog;
import pl.pet.manager.services.UserLogService;

import java.util.List;

/**
 * Controller for login/logout into the system.
 */
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class UserController {
    /**
     * Service for login/logout into the system.
     */
    private UserLogService userLogService;

    /**
     * Get information about user logs.
     *
     * @return list user log
     */
    @GetMapping("/info")
    public List<UserLog> getInfo() {
        return userLogService.getInfo();
    }

    /**
     * Login into the system.
     *
     * @param authRequest user information
     * @return true if success login
     */
    @PostMapping("/login")
    public boolean logIn(@RequestBody final AuthRequest authRequest) {
        return userLogService.login(authRequest.getUsername(), authRequest.getPassword());
    }

    /**
     * Logout into the system.
     *
     * @param authRequest user information
     * @return true if success logOut
     */
    @PostMapping("/logout")
    public boolean logOut(@RequestBody final AuthRequest authRequest) {
        return userLogService.logOut(authRequest.getUsername());
    }
}
