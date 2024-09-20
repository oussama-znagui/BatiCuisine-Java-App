package main.java.ma.znagui.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public static Connection con = null;

    public static void Dbconnexion() {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/BatiCuisine";
        String username = "postgres";
        String password = "Azerty";

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(jdbcUrl,username,password);

            if(con != null) {
                System.out.println("Connected to PostgreSQL database" + con);
            }else {
                System.out.println("noooo");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("not found: " + e.getMessage());
        }
    }


    public static  Connection getConnection() {
        if (con == null) {
            Dbconnexion();
            return con;
        }else {
            return con;
        }
    }
}
