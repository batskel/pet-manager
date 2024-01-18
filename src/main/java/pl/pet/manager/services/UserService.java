package pl.pet.manager.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pet.manager.dao.UserDAO;
import pl.pet.manager.model.User;

import java.util.List;

/**
 * The User Service class provides methods for user.
 */
@Service
@AllArgsConstructor
public class UserService {
    /**
     * Repository for User table.
     */
    private final UserDAO userDAO;

    /**
     * Get all users.
     *
     * @return list users
     */
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    /**
     * Get a specific user.
     *
     * @param userId userId
     * @return {@link User}
     */
    public User getUserById(final Long userId) {
        return userDAO.getUserById(userId);
    }

    /**
     * Create user.
     *
     * @param user {@link User}
     */
    public void createUser(final User user) {
        userDAO.saveUser(user);
    }

    /**
     * Delete user.
     *
     * @param userId userId
     */
    public void deleteUser(final Long userId) {
        userDAO.deleteUser(userId);
    }
}
