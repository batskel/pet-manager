package pl.pet.manager.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pet.manager.model.ActionEnum;
import pl.pet.manager.model.User;
import pl.pet.manager.model.UserCred;
import pl.pet.manager.model.UserLog;
import pl.pet.manager.repository.UserCredRepository;
import pl.pet.manager.repository.UserLogRepository;
import pl.pet.manager.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Service for login/logout into the system.
 */
@Service
@AllArgsConstructor
public class UserLogService {
    /**
     * Repository for User log table.
     */
    private UserLogRepository userLogRepository;
    /**
     * Repository for User cred table.
     */
    private UserCredRepository userCredRepository;
    /**
     * Repository for User table.
     */
    private UserRepository userRepository;

    /**
     * Log in to the system.
     *
     * @param login    user name
     * @param password user password
     * @return true if success login
     */
    public boolean login(final String login, final String password) {
        Optional<User> user = userRepository.findByUsername(login);
        if (user.isPresent()) {
            User foundUser = user.get();
            UserCred userCred = userCredRepository.findByUserId(foundUser.getId()).orElse(null);
            boolean success = userCred.getPassword().equals(password);
            saveLog(success, foundUser.getId(), ActionEnum.SIGN_IN);
            return success;
        } else {
            return false;
        }
    }

    /**
     * Logout into the system.
     *
     * @param login user name
     * @return true if success logOut
     */
    public boolean logOut(final String login) {
        Optional<User> user = userRepository.findByUsername(login);
        if (user.isPresent()) {
            User foundUser = user.get();
            saveLog(true, foundUser.getId(), ActionEnum.LOG_OUT);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get information about user logs.
     *
     * @return list user log
     */
    public List<UserLog> getInfo() {
        return userLogRepository.findAll();
    }

    private void saveLog(final boolean success, final Long userId, final ActionEnum action) {
        Optional<User> user = userRepository.findById(userId);
        User foundUser = null;
        if (user.isPresent()) {
            foundUser = user.get();
        }
        UserLog userLog = UserLog.builder()
                .user(foundUser)
                .action(action)
                .success(success)
                .timestamp(LocalDateTime.now()).build();
        userLogRepository.save(userLog);
    }
}
