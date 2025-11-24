package restful.booker.tests.scenario;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import restful.booker.tests.models.AuthRequest;
import restful.booker.tests.utils.JUnitTags;

@Feature("Авторизация клиента")
public class PositiveAuthTest extends BaseScenario {

  @Test
  @DisplayName("Успешное получение токена авторизации")
  @Tags(
    {
      @Tag(JUnitTags.POSITIVE),
      @Tag(JUnitTags.TECH)
    }
  )
  public void positiveAuthTest() {
    var requestBody = new AuthRequest()
      .setUsername("admin")
      .setPassword("password123");

    var token = restSteps.getAuth(requestBody);

    assertTrue(!token.isBlank(), "Отсутсвует токен");
  }


}
