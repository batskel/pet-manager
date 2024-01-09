package pl.pet.manager.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pet.manager.model.User;
import pl.pet.manager.services.UserService;

import java.util.List;

/**
 * Controller for CRUD operations with USER.
 */
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class AdminController {
    /**
     * Service for user.
     */
    private final UserService userService;

    /**
     * Get all users.
     *
     * @return list users
     */
    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Get a specific user.
     *
     * @param userId userId
     * @return {@link User}
     */
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable final Long userId) {
        return userService.getUserById(userId);
    }

    /**
     * Create user.
     *
     * @param user {@link User}
     * @return new {@link User}
     */
    @PostMapping
    public User createUser(@RequestBody final User user) {
        return userService.createUser(user);
    }

    /**
     * Delete user.
     *
     * @param userId userId
     */
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable final Long userId) {
        userService.deleteUser(userId);
    }
}
