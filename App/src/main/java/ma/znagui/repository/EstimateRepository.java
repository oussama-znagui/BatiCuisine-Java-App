package ma.znagui.repository;

import ma.znagui.Model.Estimate;
import ma.znagui.Model.Project;
import ma.znagui.repository.Interface.EstimateRepositoryInterface;
import ma.znagui.repository.Interface.ProjectRepositoryInterface;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EstimateRepository implements EstimateRepositoryInterface {
    private static ProjectRepositoryInterface projectRepos = new ProjectRepository();
    private static Connection conn = main.java.ma.znagui.Config.DbConnection.getConnection();

    public boolean addEstimate(Estimate estimate) {

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


    public List<Estimate> getAllEstimates() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from estimates";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Estimate> estimates = new ArrayList<Estimate>();
            while (rs.next()) {
                Estimate estimate = new Estimate();
                estimate.setId(rs.getInt("ID"));
                estimate.setEstimatedAmount(rs.getDouble("estimatedAmount"));
                estimate.setIssueDate(LocalDate.parse(rs.getString("issueDate")));
                estimate.setExpirationDate(LocalDate.parse(rs.getString("expirationDate")));
                estimate.setAccepted(rs.getBoolean("accepted"));
                estimate.setProject(projectRepos.getProject(rs.getInt("projectID")));
                estimates.add(estimate);
            }
            return estimates;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean updateEstimate(Estimate estimate) {
        PreparedStatement ps = null;
        try {
            String sql = "update estimates set accepted = true where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, estimate.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
