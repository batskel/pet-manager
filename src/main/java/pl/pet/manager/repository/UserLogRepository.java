package pl.pet.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pet.manager.model.UserLog;

/**
 * Repository for User log table.
 */
public interface UserLogRepository extends JpaRepository<UserLog, Long> {
}
