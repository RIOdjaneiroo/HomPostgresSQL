package RIO.example.description;
public class LongestProject {
    public int projectId;
    public int months;

    public LongestProject(int projectId, int months) {
        this.projectId = projectId;
        this.months = months;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getMonths() {
        return months;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "projectId=" + projectId +
                ", months=" + months +
                '}';
    }
}

