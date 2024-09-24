package ma.znagui.repository;

import ma.znagui.Model.Estimate;
import ma.znagui.Model.Project;
import ma.znagui.repository.Interface.EstimateRepositoryInterface;

import java.sql.*;
import java.time.LocalDate;

public class EstimateRepository implements EstimateRepositoryInterface {
    private static Connection conn = main.java.ma.znagui.Config.DbConnection.getConnection();

    public boolean addEstimate(Estimate estimate) {
        System.out.println("Adding estimate " + estimate.getIssueDate());
        PreparedStatement ps = null;
        try {
            String sql = "insert into estimates(estimatedAmount, issueDate,expirationDate,accepted,projectID) values(?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, estimate.getEstimatedAmount());
            ps.setDate(2, Date.valueOf(estimate.getIssueDate()));
            ps.setDate(3, Date.valueOf(estimate.getExpirationDate()));
            ps.setBoolean(4, estimate.isAccepted());
            ps.setInt(5, estimate.getProject().getId());
            ps.executeUpdate();
            return true;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Estimate getEstimateProject(Project project) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from estimates where projectID = ?";
            Estimate estimate = new Estimate();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, project.getId());
            rs = ps.executeQuery();
            if (rs.next()) {

                estimate.setId(rs.getInt("ID"));
                estimate.setEstimatedAmount(rs.getDouble("estimatedAmount"));
                estimate.setIssueDate(LocalDate.parse(rs.getString("issueDate")));
                estimate.setExpirationDate(LocalDate.parse(rs.getString("expirationDate")));
                estimate.setAccepted(rs.getBoolean("accepted"));
                estimate.setProject(project);

            }
            return estimate;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
