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
        User user = userRepository.findByUsername(login);
        UserCred userCred = userCredRepository.findByUserId(user.getId()).orElse(null);
        boolean success = userCred.getPassword().equals(password);
        saveLog(success, user.getId(), ActionEnum.SIGN_IN);
        return success;
    }

    /**
     * Logout into the system.
     *
     * @param login user name
     * @return true if success logOut
     */
    public boolean logOut(final String login) {
        User user = userRepository.findByUsername(login);
        saveLog(true, user.getId(), ActionEnum.LOG_OUT);
        return true;
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
        UserLog userLog = new UserLog();
        userLog.setUser(userRepository.findById(userId).orElse(null));
        userLog.setAction(action);
        userLog.setSuccess(success);
        userLog.setTimestamp(LocalDateTime.now());
        userLogRepository.save(userLog);
    }
}
