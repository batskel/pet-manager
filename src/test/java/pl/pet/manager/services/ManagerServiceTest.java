package pl.pet.manager.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ManagerServiceTest {

  @InjectMocks
  private ManagerService managerService;

  @Test
  void testMethod(){
    final String expectedResult = "test_test";
    final String testInput = "test";

    final String result = managerService.testMethod(testInput);

    Assertions.assertThat(result).isEqualTo(expectedResult);
  }

}