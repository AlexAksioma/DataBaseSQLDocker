import java.sql.*;
import java.util.Random;

public class DataBase {
    static Connection connection;
    static Statement statement;

    static final String URL = "jdbc:mysql://localhost:8181/alexbase";
    static final String USER = "root";
    static final String PASSWORD = "qwerty";

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("create new connection");
                statement = connection.createStatement();
                int id = new Random().nextInt(1000) + 10;
                int quantity;
                quantity = statement.executeUpdate("INSERT INTO table1 (id, name, family, email) " +
                        "VALUES ('" + id + "', 'alex5', 'med15', 'alex5@mail');");
                System.out.println(" --> " + quantity);

                ResultSet resultSet  = statement.executeQuery("select * from table1");
                while (resultSet.next()){
                    System.out.print(resultSet.getString("id")+" ");
                    System.out.print(resultSet.getString(2)+" ");
                    System.out.print(resultSet.getString(3)+" ");
                    System.out.println(resultSet.getString("email")+" ");
                }

                connection.close();
            } else
                System.out.println("connection don't create");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
