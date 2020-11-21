package HomeWork_3_02.auth;

import HomeWork_3_02.entity.User;
import HomeWork_3_02.server.DBConnection;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class BasicAuthenticationService implements AuthenticationService {

    Connection connect = DBConnection.getConnection();

    @Override
    public Optional<User> doAuth(String email, String password) {

        PreparedStatement statement = null;
        try {
            statement = connect.prepareStatement(
                    "SELECT * FROM users WHERE mail = ? AND password = ?");
            statement.setNString(1, email);
            statement.setNString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User u1 = new User(
                        resultSet.getString("nickname"),
                        resultSet.getString("mail"),
                        resultSet.getString("password")
                );
                if (u1.getEmail().equals(email) && u1.getPassword().equals(password)) {
                    return Optional.of(u1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
