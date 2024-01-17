package pl.pet.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

/**
 * The table for getting information about the user.
 */
@Entity
@Table(name = "cred_user")
@Getter
public class UserCred {
    /**
     * Field user id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * User password.
     */
    @Column(nullable = false)
    private String password;
    /**
     * Join column for User table.
     */
    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private User user;
}
