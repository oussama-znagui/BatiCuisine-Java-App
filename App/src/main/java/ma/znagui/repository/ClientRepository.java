package ma.znagui.repository;

import java.sql.*;

import ma.znagui.repository.Interface.ClientRepositoryInterface;
import main.java.ma.znagui.Config.DbConnection;
import main.java.ma.znagui.Model.Client;

public class ClientRepository implements ClientRepositoryInterface {

    public static Connection conn = DbConnection.getConnection();


    public Client addClient(Client client) {
        PreparedStatement ps = null;
        ResultSet rs  = null;
        try {
            String sql = "insert into clients(name,email,phone,ispro) values(?,?,?,?)";
            ps = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getName());
            ps.setString(2, client.getEmail());
            ps.setString(3, client.getPhone());
            ps.setBoolean(4, client.getIsPro());
             ps.executeUpdate();
             rs = ps.getGeneratedKeys();

           if (rs.next()) {
               int id = rs.getInt(1);
               client.setId(id);
           }

           return client;







        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
