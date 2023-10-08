package RIO.example;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitService {

    public static void main(String[] args) {
        String filePath = "src/main/resources/init_db.sql";  // Шлях до SQL-файлу

        try {
            // Отримуємо з'єднання з базою даних
            Connection connection = Database.getInstance().getConnection();

            // Створюємо об'єкт для читання SQL з файлу
            SqlReader sqlReader = new SqlReader();
            StringBuffer sqlBuffer = sqlReader.readSqlFromFile(filePath);

            // Розділяємо запити по кожній порожній строці
            String[] queries = sqlBuffer.toString().split("\n\n");

            // Виконуємо кожен SQL-запит
            for (String query : queries) {
                query = query.trim();
                if (!query.isEmpty()) {
                    try (Statement statement = connection.createStatement()) {
                        statement.execute(query);
                        System.out.println("Query executed: " + query);
                    } catch (Exception e) {
                        System.err.println("Error executing SQL query: " + query);
                        e.printStackTrace();
                    }
                }
            }

            // Закриваємо з'єднання з базою даних
            Database.getInstance().closeConnection();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
