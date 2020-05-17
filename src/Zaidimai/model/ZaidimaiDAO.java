package Zaidimai.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ZaidimaiDAO {
    final static String URL = "jdbc:mysql://localhost:3306/zaidimai?serverTimezone=UTC";
    public String add(Zaidimai zaidimai){
        //genre,console/howmuch/userid
        String query = "instert into zaidimai (genre, console, how_much, user_id)" +
                "values (?,?,?,?)";
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, zaidimai.getGenre());
            preparedStatement.setString(2, zaidimai.getConsole());
            preparedStatement.setInt(3, zaidimai.getHowMuch());
            preparedStatement.setInt(4,zaidimai.getUserid());

            return "Successfully created new entry";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Failed to add new entry";
        }
    }

}
