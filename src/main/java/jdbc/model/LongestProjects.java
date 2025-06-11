package jdbc.model;

import java.time.LocalDate;

public class LongestProjects {
    private int id;
    private int clientId;
    private LocalDate startDate;
    private LocalDate finishDate;
    private int durationMonths;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
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

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    @Override
    public String toString() {
        return "LongestProject{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", durationMonths=" + durationMonths +
                '}';
    }

}

