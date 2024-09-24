package ma.znagui.repository;

import ma.znagui.Enum.ComponentType;
import ma.znagui.Model.Component;
import ma.znagui.Model.Labor;
import ma.znagui.Model.Project;
import ma.znagui.repository.Interface.LaborRepositoryInterface;
import main.java.ma.znagui.Config.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LaborRepository implements LaborRepositoryInterface {
    private static Connection conn = DbConnection.getConnection();


    public void addLabor(Labor lab) {
        PreparedStatement ps = null;
        try {
            String sql = "insert into labors(name,type,tva,projectID,hourlyrate,workingHours,productivityCff) values(?,?::componenttype,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, lab.getName());
            ps.setString(2,lab.getType().name());
            ps.setInt(3,lab.getTva());
            ps.setInt(4,lab.getProject().getId());
            ps.setDouble(5,lab.getHourlyRate());
            ps.setDouble(6,lab.getWorkingHours());
            ps.setDouble(7,lab.getProductivityCff());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public List<Component> getProjectLabors(Project project){
        List<Component> components = new ArrayList<Component>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from labors where projectID=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,project.getId());
            rs = ps.executeQuery();
            while(rs.next()){
                Labor labor = new Labor(rs.getInt("id"),rs.getString("name"),rs.getInt("tva"), ComponentType.valueOf(rs.getString("type")),project,rs.getDouble("hourlyRate"),rs.getDouble("workingHours"),rs.getDouble("productivityCff"));
                components.add(labor);
            }
            return components;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
