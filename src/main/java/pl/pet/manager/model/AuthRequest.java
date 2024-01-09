package pl.pet.manager.model;

import lombok.Getter;
import lombok.Setter;

/**
 * User auth information.
 */
@Getter
@Setter
public class AuthRequest {
    /**
     * User login.
     */
    private String username;
    /**
     * User password.
     */
    private String password;
}
