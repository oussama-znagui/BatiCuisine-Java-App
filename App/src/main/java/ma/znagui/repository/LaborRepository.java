package ma.znagui.repository;

import ma.znagui.Model.Labor;
import ma.znagui.repository.Interface.LaborRepositoryInterface;
import main.java.ma.znagui.Config.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
