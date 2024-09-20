package ma.znagui.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Client> getClients() {
        PreparedStatement ps = null;
        ResultSet rs  = null;
        List<Client> clients = new ArrayList<Client>();
        try{
            String sql = "select * from clients";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Client client = new Client(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("phone"),rs.getBoolean("ispro"));
                clients.add(client);
            }
            return clients;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Client getClient(int id) {
        PreparedStatement ps = null;
        ResultSet rs  = null;
        try{
            String sql = "select * from clients where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Client client = new Client(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("phone"),rs.getBoolean("ispro"));
                return client;
            }else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean UpdateClient(Client oldClient, Client client) {
        PreparedStatement ps = null;
        ResultSet rs  = null;
        try {
            String sql = "update clients set name = ?,email = ?,phone = ?,ispro = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getEmail());
            ps.setString(3, client.getPhone());
            ps.setBoolean(4, client.getIsPro());
            ps.setInt(5, oldClient.getId());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteClient(Client client) {
        PreparedStatement ps = null;
        ResultSet rs  = null;
        try{
            String sql = "delete from clients where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, client.getId());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
