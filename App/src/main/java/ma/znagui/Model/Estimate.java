package ma.znagui.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Estimate {
    private int id;
    private double estimatedAmount;
    private LocalTime issueDate;
    private LocalDate expirationDate;
    private boolean accepted;
    private Project project;

    public Estimate() {

    }
    public Estimate(int id, double estimatedAmount, LocalTime issueDate, LocalDate expirationDate, boolean accepted, Project project) {
        this.id = id;
        this.estimatedAmount = estimatedAmount;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
        this.accepted = accepted;
        this.project = project;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public double getEstimatedAmount() {
        return estimatedAmount;
    }
    public void setEstimatedAmount(double estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
    }

    public LocalTime getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(LocalTime issueDate) {
        this.issueDate = issueDate;
    }


    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isAccepted() {
        return accepted;
    }
    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }


}
