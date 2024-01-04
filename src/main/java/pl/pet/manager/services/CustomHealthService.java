package pl.pet.manager.services;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * The CustomHealthService class provides custom logic to health check.
 */
@Component
public class CustomHealthService implements HealthIndicator {

    /**
     * This method provided more detailed information about the health status of our service providers.
     */
    @Override
    public Health health() {
        return Health.up().withDetail("customDetail", "Everything is fine").build();
    }
}
