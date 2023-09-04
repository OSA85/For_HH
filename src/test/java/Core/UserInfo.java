package Core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import static Data.Values.LOGIN;
import static Data.Values.PASSWORD;
@Data
@AllArgsConstructor
public class UserInfo {
//      private final String login = LOGIN;
//      private final String password = PASSWORD;


      @Value
      public static class AuthInfo {
            private String login;
            private String password;
      }
      public static AuthInfo getAuthInfo() {
            return new AuthInfo(LOGIN, PASSWORD);
      }
}
