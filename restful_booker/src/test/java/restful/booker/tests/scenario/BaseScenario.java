package restful.booker.tests.scenario;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import restful.booker.tests.config.Config;
import restful.booker.tests.utils.RestSteps;

@SpringBootTest(classes = Config.class)
public abstract class BaseScenario {

  @Autowired
  protected RestSteps restSteps;

  @BeforeAll
  public static void healthCheck(@Autowired RestSteps restSteps) {
    restSteps.healthCheck();
  }
}
