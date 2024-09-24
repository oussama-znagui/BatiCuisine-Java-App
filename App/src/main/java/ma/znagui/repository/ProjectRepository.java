package ma.znagui.repository;

import ma.znagui.Enum.ComponentType;
import ma.znagui.Enum.ProjectStatus;
import ma.znagui.Model.Component;
import ma.znagui.Model.Equipment;
import ma.znagui.Model.Labor;
import ma.znagui.Model.Project;
import ma.znagui.repository.Interface.ClientRepositoryInterface;
import ma.znagui.repository.Interface.ProjectRepositoryInterface;
import main.java.ma.znagui.Config.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository implements ProjectRepositoryInterface {

    public static Connection conn = DbConnection.getConnection();
    public static ClientRepositoryInterface clientRepo = new ClientRepository();


    public Project addProject(Project project){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String sql = "insert into projects(projectName,profitMargin,TotalCost,projectstatus,clientID) values(?,?,?,?::projectstatus,?)";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, project.getProjectName());
            ps.setDouble(2, project.getProfitMargin());
            ps.setDouble(3, project.getTotalCost());
            ps.setString(4,project.getStatus().name());
            ps.setInt(5,project.getClient().getId());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                project.setId(rs.getInt(1));
                return project;
            }else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Project> getProjects(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Project> projects = new ArrayList<Project>();
        try {
            String sql = "select * from projects";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Project project = new Project(rs.getInt("id"),rs.getString("projectname"),rs.getDouble("profitMargin"),rs.getDouble("TotalCost"), ProjectStatus.valueOf(rs.getString("projectstatus")),clientRepo.getClient(rs.getInt("clientID")));
                projects.add(project);
            }
            return projects;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Project getProject(int id){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String sql = "select * from projects where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                Project project = new Project(rs.getInt("id"),rs.getString("projectname"),rs.getDouble("profitMargin"),rs.getDouble("TotalCost"), ProjectStatus.valueOf(rs.getString("projectstatus")),clientRepo.getClient(rs.getInt("clientID")));
                return project;
            }else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean updateProject(Project oldProject, Project project){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "update projects set projectname = ? , profitmargin = ? , totalcost =  ?,projectstatus = ?::projectstatus ,clientid = ? WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,project.getProjectName());
            ps.setDouble(2,project.getProfitMargin());
            ps.setDouble(3,project.getTotalCost());
            ps.setString(4,project.getStatus().name());
            ps.setInt(5,project.getClient().getId());
            ps.setInt(6,oldProject.getId());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public boolean deleteProject(Project project){
        PreparedStatement ps = null;
        try{
            String sql = "delete from projects where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,project.getId());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public List<Component> getProjectComponents(Project project){
        List<Component> components = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from labors where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,project.getId());
            rs = ps.executeQuery();
            while(rs.next()){
                Labor labor = new Labor(rs.getInt("id"),rs.getString("name"),rs.getInt("tva"), ComponentType.valueOf(rs.getString("type")),project,rs.getDouble("hourlyRate"),rs.getDouble("workingHours"),rs.getDouble("productivityCff"));
                components.add(labor);
            }

            String sql2 = "select * from equipments where id = ?";
            ps = conn.prepareStatement(sql2);
            ps.setInt(1,project.getId());
            rs = ps.executeQuery();
            while(rs.next()){
                Equipment equipment = new Equipment(rs.getInt("id"),rs.getString("name"),rs.getInt("tva"), ComponentType.valueOf(rs.getString("type")),project,rs.getDouble("unitCost"),rs.getDouble("quantity"),rs.getDouble("transportCost"),rs.getDouble("qualityCoefficient"));
                components.add(equipment);
            }
            return components;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}



