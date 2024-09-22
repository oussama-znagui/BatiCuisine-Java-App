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
            String sql = "insert into labors values(?,?,?::componenttype,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, null);
            ps.setString(2, lab.getName());
            ps.setString(3,lab.getType().name());
            ps.setInt(4,lab.getTva());
            ps.setInt(5,lab.getProject().getId());
            ps.setDouble(6,lab.getHourlyRate());
            ps.setDouble(7,lab.getWorkingHours());
            ps.setDouble(8,lab.getProductivityCff());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
