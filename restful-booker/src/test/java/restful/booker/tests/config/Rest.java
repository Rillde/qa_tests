package restful.booker.tests.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.reactive.server.WebTestClient;

@Configuration
public class Rest {

  @Bean
  public WebTestClient restClient() {
    WebTestClient client = WebTestClient.bindToServer()
        .baseUrl("https://restful-booker.herokuapp.com")
        .build();
    return client;
  }
}
