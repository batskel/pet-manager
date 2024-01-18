package pl.pet.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pet.manager.model.User;

import java.util.Optional;

/**
 * Repository for User table.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Find by username.
     *
     * @param userName user name
     * @return {@link User}
     */
    Optional<User> findByUsername(String userName);
}
