package RIO.example;

import RIO.example.description.LongestProject;
import RIO.example.description.MaxProjectCountClient;
import RIO.example.description.MaxSalaryWorker;
import RIO.example.description.YoungestOldestWorkers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome!");
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();
        // викликаємо метод для знаходження найтривалішого проекту
        List<LongestProject> longestProjects = databaseQueryService.findLongestProject();
        // виводимо результат роботи методу
        for (LongestProject longestProject : longestProjects) {
            System.out.println("Project ID: " + longestProject.getProjectId()+" Months: " + longestProject.getMonths());
            System.out.println("------------------");
        }
        // викликаємо метод для знаходження клієнтів і кількості проектів
        List<MaxProjectCountClient> maxProjectsClients = databaseQueryService.findMaxProjectsClientFromFile();
        for (MaxProjectCountClient client : maxProjectsClients) {
            System.out.println("Client Name: " + client.getName()+ " Project Count: " + client.getProjectCount());
            System.out.println("------------------");
        }

        // викликаємо метод для знаходження найбільщої зарплати працівника
        List<MaxSalaryWorker> maxSalaryWorkers = databaseQueryService.findMaxSalaryWorkerFromFile();
        for (MaxSalaryWorker maxSalaryWorker : maxSalaryWorkers) {
            System.out.println("Worker Name: " + maxSalaryWorker.getWorkerName() + " Levels Name: " + maxSalaryWorker.getLevelsName()
                  +  " Salary: " + maxSalaryWorker.getSalary());
            System.out.println("------------------");
        }

        // викликаємо метод для знаходження наймолодшоно і найстаршого працівника
        List<YoungestOldestWorkers> youngestOldestWorkersList = databaseQueryService.findYoungestOldestWorkers();
        for (YoungestOldestWorkers worker : youngestOldestWorkersList) {
            System.out.println("Type: " + worker.type + ", Name: " + worker.name + ", Birthday: " + worker.birthday);
            System.out.println("------------------");
        }

            //Database database = Database.getInstance();
            //database.executeResultFromFile("src/main/resources/find_max_projects_client.sql");


        }
    }
