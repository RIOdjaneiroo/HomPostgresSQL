package RIO.example;

import RIO.example.description.LongestProject;
import RIO.example.description.MaxProjectCountClient;
import RIO.example.description.MaxSalaryWorker;
import RIO.example.description.YoungestOldestWorkers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {


    public List<MaxSalaryWorker> findMaxSalaryWorkerFromFile() {
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList<>();
        String filePath = "src/main/resources/find_max_salary_worker.sql"; // шлях до SQL-файлу

        try {
            // Читаємо SQL-запит з файлу
            SqlReader sqlReader = new SqlReader();
            StringBuffer sqlBuffer = sqlReader.readSqlFromFile(filePath);
            String query = sqlBuffer.toString().trim();

            // Отримуємо з'єднання з базою даних
            Connection connection = Database.getInstance().getConnection();

            // Виконуємо SQL-запит та обробляємо результат
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    String workerName = resultSet.getString("name");
                    String levelsName = resultSet.getString("levels_name");
                    int salary = resultSet.getInt("salary");
                    MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker(workerName, levelsName, salary);
                    maxSalaryWorkers.add(maxSalaryWorker);
                }
            } catch (Exception e) {
                System.err.println("Error executing SQL query: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return maxSalaryWorkers;
    }

    public List<MaxProjectCountClient> findMaxProjectsClientFromFile() {
        List<MaxProjectCountClient> result = new ArrayList<>();
        String filePath = "src/main/resources/find_max_projects_client.sql"; // шлях до SQL-файлу

        try {
            // Читаємо SQL-запит з файлу
            SqlReader sqlReader = new SqlReader();
            StringBuffer sqlBuffer = sqlReader.readSqlFromFile(filePath);
            String query = sqlBuffer.toString().trim();

            // Отримуємо з'єднання з базою даних
            Connection connection = Database.getInstance().getConnection();

            // Виконуємо SQL-запит та обробляємо результат
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    String clientName = resultSet.getString("client_name");
                    int projectCount = resultSet.getInt("project_count");
                    MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient(clientName, projectCount);
                    result.add(maxProjectCountClient);
                }
            } catch (Exception e) {
                System.err.println("Error executing SQL query: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return result;
    }



        public List<LongestProject> findLongestProject() {
        List<LongestProject> longestProjects = new ArrayList<>();
        String filePath = "src/main/resources/find_longest_project.sql"; // шлях до SQL-файлу

        try {
            // Отримуємо з'єднання з базою даних
            Connection connection = Database.getInstance().getConnection();

            // Читаємо SQL-запит з файлу
            SqlReader sqlReader = new SqlReader();
            StringBuffer sqlBuffer = sqlReader.readSqlFromFile(filePath);
            String sqlQuery = sqlBuffer.toString().trim();

            // Виконуємо SQL-запит та обробляємо результат
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sqlQuery)) {

                while (resultSet.next()) {
                    int projectId = resultSet.getInt("project_id");
                    int months = resultSet.getInt("months");
                    LongestProject longestProject = new LongestProject(projectId, months);
                    longestProjects.add(longestProject);
                }
            } catch (Exception e) {
                System.err.println("Error executing query: " + e.getMessage());
                e.printStackTrace();
            }

            // Закриваємо з'єднання з базою даних
            //Database.getInstance().closeConnection();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        return longestProjects;
    }
    public List<YoungestOldestWorkers> findYoungestOldestWorkers() {
        List<YoungestOldestWorkers> youngestOldestWorkersList = new ArrayList<>();

        String filePath = "src/main/resources/find_youngest_eldest_workers.sql"; // Шлях до SQL-файлу

        try {
            // Отримуємо з'єднання з базою даних
            Connection connection = Database.getInstance().getConnection();

            // Читаємо SQL-запит з файлу
            SqlReader sqlReader = new SqlReader();
            StringBuffer sqlBuffer = sqlReader.readSqlFromFile(filePath);
            String sqlQuery = sqlBuffer.toString().trim();

            // Виконуємо SQL-запит та обробляємо результат
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sqlQuery)) {

                while (resultSet.next()) {
                    String type = resultSet.getString("type");
                    String name = resultSet.getString("name");
                    Date birthday = resultSet.getDate("birthday");
                    YoungestOldestWorkers worker = new YoungestOldestWorkers(type, name, birthday);
                    youngestOldestWorkersList.add(worker);
                }
            } catch (Exception e) {
                System.err.println("Error executing SQL query: " + e.getMessage());
                e.printStackTrace();
            }

            // Закриваємо з'єднання з базою даних
            Database.getInstance().closeConnection();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        return youngestOldestWorkersList;
    }
}

