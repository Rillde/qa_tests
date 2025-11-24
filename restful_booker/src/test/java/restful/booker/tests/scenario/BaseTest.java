package restful.booker.tests.scenario;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import restful.booker.tests.config.Config;
import restful.booker.tests.utils.CommonRestSteps;

@SpringBootTest(classes = Config.class)
public abstract class BaseTest {


  @BeforeAll
  public static void healthCheck(@Autowired CommonRestSteps commonRestSteps) {
    commonRestSteps.healthCheck();
  }
}
