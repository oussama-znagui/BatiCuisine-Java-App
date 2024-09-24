package ma.znagui.repository;

import ma.znagui.Enum.ComponentType;
import ma.znagui.Model.Component;
import ma.znagui.Model.Equipment;
import ma.znagui.Model.Project;
import ma.znagui.repository.Interface.EquipmentRepositoryInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Component> getProjectEquipments(Project project){
        List<Component> components = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql2 = "select * from equipments where projectID = ?";
            ps = conn.prepareStatement(sql2);
            ps.setInt(1,project.getId());
            rs = ps.executeQuery();
            while(rs.next()){
                Equipment equipment = new Equipment(rs.getInt("id"),rs.getString("name"),rs.getInt("tva"), ComponentType.valueOf(rs.getString("type")),project,rs.getDouble("unitCost"),rs.getDouble("quantity"),rs.getDouble("transportCost"),rs.getDouble("qualityCoefficient"));
                components.add(equipment);
            }
            return components;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
