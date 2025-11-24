package restful.booker.tests.scenario.auth;

import static org.junit.jupiter.api.Assertions.assertFalse;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import restful.booker.tests.models.AuthRequest;
import restful.booker.tests.utils.JUnitTags;

@Story("Позитивы")
public class PositiveAuthTest extends AuthTest {

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

    var token = authRestSteps.checkSuccessAuth(requestBody);

    assertFalse(
      token.isBlank(),
      "Отсутствует токен"
    );
  }


}
