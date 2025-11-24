package restful.booker.tests.scenario.auth;

import io.qameta.allure.Story;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import restful.booker.tests.models.AuthRequest;
import restful.booker.tests.models.ErrorReason;
import restful.booker.tests.utils.JUnitTags;

@Story("Негативы")
public class NegativeAuthTest extends AuthTest {

  private static Stream<AuthRequest> authWithoutRequiredFields() {
    return Stream.of(
      new AuthRequest().setUsername("admin"),
      new AuthRequest().setPassword("password123")
    );
  }

  @ParameterizedTest
  @MethodSource("authWithoutRequiredFields")
  @DisplayName("Запрос авторизации без обязательных полей")
  @Tags(
    {
      @Tag(JUnitTags.NEGATIVE),
      @Tag(JUnitTags.TECH)
    }
  )
  public void authWithoutRequiredFieldsTest(AuthRequest requestBody) {
    authRestSteps.checkErrorAuth(
      requestBody,
      ErrorReason.BAD_CREDENTIALS
    );
  }

  @Test
  @DisplayName("Запрос авторизации неизвестного пользователя")
  @Tags(
    {
      @Tag(JUnitTags.NEGATIVE),
      @Tag(JUnitTags.BUSINESS)
    }
  )
  public void unknownUserAuthTest() {
    var requestBody = new AuthRequest()
      .setUsername("admin123")
      .setPassword("password123");

    authRestSteps.checkErrorAuth(
      requestBody,
      ErrorReason.BAD_CREDENTIALS
    );
  }
}
