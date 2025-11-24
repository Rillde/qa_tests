package restful.booker.tests.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorReason {

  BAD_CREDENTIALS("Bad credentials");

  private String reason;
}
