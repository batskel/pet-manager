package pl.pet.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The ManagerApplication class is the entry point of the application.
 * It is responsible for launching the Spring Boot application.
 */
@SpringBootApplication
public class ManagerApplication {

  /**
   * This is the main method of the ManagerApplication class.
   *
   * @param args the command line arguments
   */
  public static void main(final String[] args) {
    SpringApplication.run(ManagerApplication.class, args);
  }

}
