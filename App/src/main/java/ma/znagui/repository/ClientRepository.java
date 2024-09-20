package ma.znagui.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ma.znagui.repository.Interface.ClientRepositoryInterface;
import main.java.ma.znagui.Config.DbConnection;
import main.java.ma.znagui.Model.Client;

public class ClientRepository implements ClientRepositoryInterface {

    public static Connection conn = DbConnection.getConnection();


    public void addClient(Client client) {
        PreparedStatement ps = null;
        try {
            String sql = "insert into client(name,email,phone,ispro) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getEmail());
            ps.setString(3, client.getPhone());
            ps.setBoolean(4, client.getIsPro());
            ps.executeUpdate();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
