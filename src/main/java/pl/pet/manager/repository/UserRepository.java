package pl.pet.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pet.manager.model.User;

/**
 * Repository for User table.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Find.
     *
     * @param userName user name
     * @return {@link User}
     */
    User findByUsername(String userName);
}
