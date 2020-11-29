package HomeWork_3_03.server;

import HomeWork_3_03.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepository {

    public static Optional<User> getUserFromDB(String email, String password) {
        //ResultSet resultSet = null;
        String andCondition = "";
        String sqlSelect = String.format("SELECT * FROM users WHERE mail = '%s' AND password = '%s' ", email, password);

        try (Connection connect = DBSource.getConnection();
             PreparedStatement statement = connect.prepareStatement(sqlSelect);) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User(
                        resultSet.getString("nickname"),
                        resultSet.getString("mail"),
                        resultSet.getString("password")
                );
                return Optional.of(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(null);
    }


    public static String changeNickname(ClientHandler client, String newName) {
        int id;
        String sqlSelect = "SELECT * FROM users WHERE nickname = ?";
        String sqlUpdate = "UPDATE users SET nickname = ? WHERE id = ?";


        try (Connection connection = DBSource.getConnection();) {
            PreparedStatement statement = connection.prepareStatement(sqlSelect);

            statement.setNString(1, client.getName());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            id = resultSet.getInt("id");

            statement = connection.prepareStatement(sqlUpdate);
            statement.setNString(1, newName);
            statement.setInt(2, id);
            statement.executeUpdate();

            statement = connection.prepareStatement(sqlSelect);
            statement.setNString(1, newName);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return newName;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client.getName();
    }

}

