package pl.pet.manager.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pet.manager.model.User;
import pl.pet.manager.repository.UserRepository;

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
    private UserRepository userRepository;

    /**
     * Get all users.
     *
     * @return list users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Get a specific user.
     *
     * @param userId userId
     * @return {@link User}
     */
    public User getUserById(final Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    /**
     * Create user.
     *
     * @param user {@link User}
     * @return new {@link User}
     */
    public User createUser(final User user) {
        return userRepository.save(user);
    }

    /**
     * Delete user.
     *
     * @param userId userId
     */
    public void deleteUser(final Long userId) {
        userRepository.deleteById(userId);
    }
}
