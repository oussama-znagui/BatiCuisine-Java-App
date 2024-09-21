package ma.znagui.repository;

import ma.znagui.Enum.ProjectStatus;
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
                Project project = new Project(rs.getInt("id"),rs.getNString("projectname"),rs.getDouble("profitMargin"),rs.getDouble("TotalCost"), ProjectStatus.valueOf(rs.getString("status")),clientRepo.getClient(rs.getInt("clientID")));
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
                Project project = new Project(rs.getInt("id"),rs.getNString("projectname"),rs.getDouble("profitMargin"),rs.getDouble("TotalCost"), ProjectStatus.valueOf(rs.getString("status")),clientRepo.getClient(rs.getInt("clientID")));
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
            String sql = "update projects set projectname = ? , profitmargin = ? , totalcost =  ?,projectstatus = ? ,clientid = ? WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,project.getProjectName());
            ps.setDouble(2,project.getProfitMargin());
            ps.setDouble(3,project.getTotalCost());
            ps.setString(4,project.getStatus().name());
            ps.setInt(5,oldProject.getClient().getId());
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
}


