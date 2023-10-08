package RIO.example.description;
public class MaxSalaryWorker {
    public String workerName;
    public String levelsName;
    public int salary;

    public MaxSalaryWorker(String workerName, String levelsName, int salary) {
        this.workerName = workerName;
        this.levelsName = levelsName;
        this.salary = salary;
    }

    public String getWorkerName() {
        return workerName;
    }

    public String getLevelsName() {
        return levelsName;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "MaxSalaryWorker{" +
                "workerName='" + workerName + '\'' +
                ", levelsName='" + levelsName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
