package ma.znagui.repository;

import ma.znagui.Model.Equipment;
import ma.znagui.repository.Interface.EquipmentRepositoryInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EquipmentRepository implements EquipmentRepositoryInterface {
    private static Connection conn = main.java.ma.znagui.Config.DbConnection.getConnection();

    public void addEquipment(Equipment equipment) {
        PreparedStatement ps = null;
        try {
            String sql = "insert into equipments values(?,?,?::componenttype,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, null);
            ps.setString(2, equipment.getName());
            ps.setString(3,equipment.getType().name());
            ps.setInt(4,equipment.getTva());
            ps.setInt(5,equipment.getProject().getId());
            ps.setDouble(6,equipment.getUnitCost());
            ps.setDouble(7,equipment.getQuantity());
            ps.setDouble(8,equipment.getTransportCost());
            ps.setDouble(9,equipment.getQualityCoefficient());
            ps.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
