package restful.booker.tests.utils;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;

@Component
@AllArgsConstructor
public class CommonRestSteps {

  private static final String HEALTH_CHECK_URI = "/ping";
  private WebTestClient webTestClient;

  @Step("Проверяем состояние сервиса")
  public void healthCheck() {
    syncGetRequest(HEALTH_CHECK_URI)
      .expectStatus()
      .isCreated();
  }

  @Step("Выполняем синхронный POST запрос")
  public ResponseSpec syncPostRequest(String URI, Object requestBody) {
    return webTestClient.post()
      .uri(URI)
      .contentType(MediaType.APPLICATION_JSON)
      .bodyValue(requestBody)
      .exchange();
  }

  @Step("Выполняем синхронный GET запрос")
  public ResponseSpec syncGetRequest(String URI) {
    return webTestClient.get()
      .uri(URI)
      .exchange();
  }
}
