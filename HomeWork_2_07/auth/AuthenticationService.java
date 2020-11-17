package HomeWork_2_07.auth;

import HomeWork_2_07.entity.User;
import java.util.Optional;

public interface AuthenticationService {
    Optional<User> doAuth(String login, String password);
}
