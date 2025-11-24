package restful.booker.tests.scenario.auth.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import restful.booker.tests.models.AuthRequest;
import restful.booker.tests.models.AuthResponse;
import restful.booker.tests.models.ErrorAuthResponse;
import restful.booker.tests.models.ErrorReason;
import restful.booker.tests.utils.CommonRestSteps;

@Component
@AllArgsConstructor
public class AuthRestSteps {

  private static final String AUTH_URI = "/auth";
  private CommonRestSteps commonRestSteps;

  @Step("Получаем токен авторизации")
  public String checkSuccessAuth(AuthRequest authRequestBody) {

    var responseBody = commonRestSteps
      .syncPostRequest(
        AUTH_URI,
        authRequestBody
      )
      .expectStatus()
      .isOk()
      .expectBody(AuthResponse.class)
      .returnResult()
      .getResponseBody();
    assertNotNull(
      responseBody,
      "Отсутсвует тело ответа"
    );

    return responseBody.getToken();
  }

  @Step("Ошибка при авторизации")
  public void checkErrorAuth(AuthRequest authRequestBody,
    ErrorReason errorReason) {
    var responseBody = commonRestSteps
      .syncPostRequest(
        AUTH_URI,
        authRequestBody
      )
      .expectStatus()
      .isOk()
      .expectBody(ErrorAuthResponse.class)
      .returnResult()
      .getResponseBody();
    assertNotNull(
      responseBody,
      "Отсутсвует тело ответа"
    );
    assertEquals(
      errorReason.getReason(),
      responseBody.getReason(),
      "Ошибка заполнения поля reason"
    );
  }
}
