package ma.znagui.Model;

import ma.znagui.Enum.ProjectStatus;

public class Project {
    private int id;
    private String projectName;
    private double profitMargin;
    private double TotalCost;
    private ProjectStatus status;


    public Project() {

    }

    public Project(int id, String projectName, double profitMargin, double TotalCost, ProjectStatus status) {
        this.id = id;
        this.projectName = projectName;
        this.profitMargin = profitMargin;
        this.TotalCost = TotalCost;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public double getProfitMargin() {
        return profitMargin;
    }
    public void setProfitMargin(double profitMargin) {
        this.profitMargin = profitMargin;
    }

    public double getTotalCost() {
        return TotalCost;
    }
    public void setTotalCost(double totalCost) {
        TotalCost = totalCost;
    }

    public ProjectStatus getStatus() {
        return status;
    }
    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public String toString() {
        return "Project [id=" + id + ", projectName=" + projectName + ", profitMargin=" + profitMargin + ", TotalCost=" + TotalCost + ", status=" + status + "]";
    }
}
