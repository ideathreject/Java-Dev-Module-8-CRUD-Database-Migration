package jdbc;

import java.time.LocalDate;

public class ProjectPrice {
    private int id;
    private int clientId;
    private LocalDate startDate;
    private LocalDate finishDate;
    private int durationMonths;
    private int totalSalary;
    private int projectCost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }

    public int getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(int totalSalary) {
        this.totalSalary = totalSalary;
    }

    public int getProjectCost() {
        return projectCost;
    }

    public void setProjectCost(int projectCost) {
        this.projectCost = projectCost;
    }
    @Override
    public String toString() {
        return "ProjectPrice{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", durationMonths=" + durationMonths +
                ", totalSalary=" + totalSalary +
                ", projectCost=" + projectCost +
                '}';
    }

}
