package HomeWork_3_03.auth;

import HomeWork_3_03.entity.User;
import HomeWork_3_03.server.UserRepository;

import java.util.Optional;

public class BasicAuthenticationService implements AuthenticationService {

    @Override
    public Optional<User> doAuth(String email, String password) {
        return UserRepository.getUserFromDB(email,password);
    }
}
