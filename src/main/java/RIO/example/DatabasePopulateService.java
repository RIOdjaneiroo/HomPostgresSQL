package RIO.example;
public class DatabasePopulateService {
    public static void main(String[] args) {
        String filePath = "src/main/resources/populate_db.sql";  // шлях до файлу

        try {
            Database database = Database.getInstance();     // робимо зєднання з БД
            DatabasePopulateService populateService = new DatabasePopulateService();
            populateService.populateDatabase(filePath, database);  // виконуємо запити з файлу
            database.closeConnection(); // закриваємо зєднання з базою даних
        } catch (Exception e) {
            System.err.println("Сan't populate the database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void populateDatabase(String filePath, Database database) {
        SqlReader sqlReader = new SqlReader();                          // створюємо обєкт для читання запиту з файлу
        StringBuffer sqlBuffer = sqlReader.readSqlFromFile(filePath);   // створюємо буфер для зберігання контенту Файлу

        if (sqlBuffer != null) {
            String[] queries = sqlBuffer.toString().split(";");   // розділяємо запити по ; на масив строк

            for (String query : queries) {                              // цикл виконуємо кожен запит з масиву
                query = query.trim();                                   // обрізаєм пробіли в строкі
                if (!query.isEmpty()) {                                 // якщо елемент масиву не пустий
                    database.executeUpdate(query);                      // виконуємо запит
                    System.out.println("Query executed: " + query);     // виводимо запит що відпрацював - можна і без цього
                }
            }
        }
    }
}

