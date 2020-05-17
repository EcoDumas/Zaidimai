package Zaidimai.model;

import Zaidimai.utils.Constant;

import java.sql.*;

public class UserDAO {
    public String login(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String msg = "";
        try {
            connection = DriverManager.getConnection(Constant.URL + Constant.DB_NAME, "root", "");
            preparedStatement = connection.prepareStatement("SELECT * FROM " + Constant.TABLE_NAME + " WHERE username = ? AND password = ?");

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                msg = "Successful login";
            } else {
                msg = "No user found under these credentials";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return msg;
    }

    public User getUser(String username) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        boolean isAdmin = false;
        User user = null;
        try {
            connection = DriverManager.getConnection(Constant.URL + Constant.DB_NAME, "root" , "");
            preparedStatement = connection.prepareStatement("SELECT * FROM " + Constant.TABLE_NAME + " WHERE username = ?");

            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username2 = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                boolean admin = resultSet.getBoolean("admin");

                user = new User (id, username2, password, email, admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public String register(User user) {
        String query = "INSERT INTO" + Constant.TABLE_NAME + " (username, password, email, admin) Values(?, ?, ?, ?)";

        String msg = "";
        try {
            Connection connection = DriverManager.getConnection(Constant.URL + Constant.DB_NAME, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setBoolean(4, user.isAdmin());

            preparedStatement.executeUpdate();
            msg = "New user successfully added";
        } catch (SQLException e) {
            e.printStackTrace();
            msg = "Failed to add new user";

        }
        return msg;
    }

}
