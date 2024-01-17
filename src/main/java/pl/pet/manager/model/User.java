package pl.pet.manager.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entity for User table.
 */
@Entity
@Getter
@Table(name = "pet_user")
public class User {
    /**
     * Field user id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Filed user name.
     */
    @Column(nullable = false)
    private String username;
    /**
     * Field user location.
     */
    @Column(nullable = true)
    private String location;
    /**
     * Field timestamp.
     */
    @CreatedDate
    private LocalDateTime timestamp;
    /**
     * Join for User cred table.
     */
    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private UserCred userCred;
    /**
     * Join for User log table.
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<UserLog> userLogs;
}
