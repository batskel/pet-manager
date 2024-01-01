package pl.pet.manager.services;

import lombok.NonNull;
import org.springframework.stereotype.Service;

/**
 * The ManagerService class provides functionality for managing managers.
 */
@Service
public class ManagerService {

  /**
   * This method is deprecated and scheduled for removal. Please refrain from using it in new code.
   *
   * @param name The string to be duplicated.
   * @return A string that consists of two copies of the input string concatenated together.
   * @deprecated This method is deprecated and scheduled for removal.
   */
  @Deprecated
  public String testMethod(@NonNull final String name) {
    return String.format("%s_%s", name, name);
  }

}
