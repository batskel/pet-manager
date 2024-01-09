package pl.pet.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
    @OneToOne()
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private User user;
}
