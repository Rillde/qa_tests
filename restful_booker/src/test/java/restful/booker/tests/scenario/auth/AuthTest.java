package restful.booker.tests.scenario.auth;

import io.qameta.allure.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import restful.booker.tests.scenario.BaseTest;
import restful.booker.tests.scenario.auth.steps.AuthRestSteps;

@Feature("Авторизация клиента")
public abstract class AuthTest extends BaseTest {

  @Autowired
  protected AuthRestSteps authRestSteps;
}
