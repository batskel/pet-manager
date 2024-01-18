package pl.pet.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * Table for user logs.
 */
@Entity
@Table(name = "log_user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLog {
    /**
     * Field user id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Login status.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ActionEnum action;
    /**
     * Success login.
     */
    @Column(nullable = false)
    private boolean success;
    /**
     * Field timestamp.
     */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime timestamp;
    /**
     * Join column for User table.
     */
    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private User user;
}
