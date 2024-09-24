package ma.znagui.Model;

import ma.znagui.Enum.ProjectStatus;
import main.java.ma.znagui.Model.Client;

import java.util.List;

public class Project {
    private int id;
    private String projectName;
    private double profitMargin;
    private double TotalCost;
    private ProjectStatus status;
    private Client client;
    private List<Component> components;


    public Project() {

    }

    public Project(int id, String projectName, double profitMargin, double TotalCost, ProjectStatus status, Client client) {
        this.id = id;
        this.projectName = projectName;
        this.profitMargin = profitMargin;
        this.TotalCost = TotalCost;
        this.status = status;
        this.client = client;
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

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public String toString() {
        return "Project [id=" + id + ", projectName=" + projectName + ", profitMargin=" + profitMargin + ", TotalCost=" + TotalCost + ", status=" + status + "] --> Client : " + client.getName();
    }
}
