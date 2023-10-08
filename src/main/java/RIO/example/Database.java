package RIO.example;

import RIO.example.PropertyReader;
import RIO.example.description.LongestProject;

import java.sql.*;

public class Database {
    private static final Database INSTANCE = new Database(); // робимо статичне поле INSTANCE що містить єдиний екземпляр класу Database.
    private static Connection connection;

    private Database() {   //приватний конструктор що вказує на сінглтон  - ініціалізуємо зєднання з БД
        String url = PropertyReader.getConnectionUrlForPostgres();
        String user = PropertyReader.getUserForPostgres();
        String pass = PropertyReader.getPasswordForPostgres();

        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println(String.format("SQL exception. Can not create connection. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can not create connection");
        }
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public int executeUpdate(String query) {
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can't run query.");
        }
    }

    public void executeResult(String query) {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                LongestProject lp = new LongestProject(resultSet.getInt("projectId"), resultSet.getInt("name"));
                System.out.println("------------------>>>>>>>>>>" + lp.toString());
            }
        } catch (SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can't run query.");
        }
    }
    public void executeResultFromFile(String filePath) {
        SqlReader sqlReader = new SqlReader();
        StringBuffer sqlBuffer = sqlReader.readSqlFromFile(filePath);
        String sqlQuery = sqlBuffer.toString();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                StringBuilder resultRow = new StringBuilder();
                for (int i = 1; i <= columnCount; i++) {
                    resultRow.append(metaData.getColumnLabel(i)).append(": ").append(resultSet.getString(i)).append(", ");
                }
                System.out.println(resultRow.toString());
            }
        } catch (SQLException e) {
            System.err.println("Error executing SQL query: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error closing connection: " + e.getMessage());
        }
    }
}
