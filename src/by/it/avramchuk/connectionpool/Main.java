package by.it.avramchuk.connectionpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static final String QUERY = "SELECT * FROM users";
    public static void main(String[] args) throws ConnectionPoolException, SQLException {

        ConnectionPool pool = new ConnectionPool();
        pool.initPoolData();

        Connection connection = pool.takeConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(QUERY);

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + " - " + resultSet.getString(2) +
                    " - " + resultSet.getString(3)
                    + " - " + resultSet.getString(4));
        }

        pool.dispose();
    }
}
