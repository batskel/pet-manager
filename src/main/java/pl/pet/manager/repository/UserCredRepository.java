package pl.pet.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.pet.manager.model.UserCred;

import java.util.Optional;

/**
 * Repository for User cred table.
 */
public interface UserCredRepository extends JpaRepository<UserCred, Long> {

    /**
     * Find UserCred by id_user.
     *
     * @param userId user id
     * @return {@link UserCred}
     */
    @Query("SELECT uc FROM UserCred uc WHERE uc.user.id = :userId")
    Optional<UserCred> findByUserId(@Param("userId") Long userId);
}
