package HomeWork_3_02.auth;

import HomeWork_3_02.entity.User;
import HomeWork_3_02.server.DBConnection;

import java.sql.*;
import java.util.Optional;

public class BasicAuthenticationService implements AuthenticationService {

    @Override
    public Optional<User> doAuth(String email, String password) {

        try {
            try (Connection connect = DBConnection.getConnection();
                 PreparedStatement statement = connect.prepareStatement(
                         "SELECT * FROM users WHERE mail = ? AND password = ?");
            ) {
                statement.setNString(1, email);
                statement.setNString(2, password);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    User user = new User(
                            resultSet.getString("nickname"),
                            resultSet.getString("mail"),
                            resultSet.getString("password")
                    );
                    return Optional.of(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
