package HomeWork_3_03.auth;

import HomeWork_3_02.entity.User;
import java.util.Optional;

public interface AuthenticationService {
    Optional<User> doAuth(String login, String password);
}
