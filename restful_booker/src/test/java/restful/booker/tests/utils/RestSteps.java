package restful.booker.tests.utils;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.reactive.server.WebTestClient;
import restful.booker.tests.models.AuthRequest;
import restful.booker.tests.models.AuthResponse;

@Component
@AllArgsConstructor
public class RestSteps {

  private static final String AUTH_URI = "/auth";
  private static final String HEALTH_CHECK_URI = "/ping";

  private WebTestClient webTestClient;

  @Step("Получаем токен авторизации")
  public String getAuth(AuthRequest authRequestBody) {

    var responseBody = webTestClient.post()
      .uri(AUTH_URI)
      .contentType(MediaType.APPLICATION_JSON)
      .bodyValue(authRequestBody)
      .exchange()
      .expectBody(AuthResponse.class)
      .returnResult()
      .getResponseBody();
    assertNotNull(responseBody, "Отсутсвует тело ответа");

    return responseBody.getToken();
  }

  @Step("Проверяем состояние сервиса")
  public void healthCheck() {
    webTestClient.get()
      .uri(HEALTH_CHECK_URI)
      .exchange()
      .expectStatus()
      .isCreated();
  }
}
