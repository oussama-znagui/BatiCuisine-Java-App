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
            String sql = "insert into equipments(name,type,tva,projectID,unitcost,quantity,transportcost,qualityCoefficient) values(?,?::componenttype,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, equipment.getName());
            ps.setString(2,equipment.getType().name());
            ps.setInt(3,equipment.getTva());
            ps.setInt(4,equipment.getProject().getId());
            ps.setDouble(5,equipment.getUnitCost());
            ps.setDouble(6,equipment.getQuantity());
            ps.setDouble(7,equipment.getTransportCost());
            ps.setDouble(8,equipment.getQualityCoefficient());
            ps.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
