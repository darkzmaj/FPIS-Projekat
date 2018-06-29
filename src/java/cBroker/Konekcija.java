/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cBroker;

import com.mysql.jdbc.Driver;
import java.io.Serializable;

import java.sql.*;

/**
 *
 * @author Zmaj9
 */
public class Konekcija implements Serializable {

    private final String db_url = "jdbc:mysql://localhost:3306/fpis";
    private final String db_username = "root";
    private final String db_pass = "root";

    private Connection connection = null;
    protected PreparedStatement ps = null;

    protected ResultSet rs = null;

    public Connection connect() throws SQLException {
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(db_url, db_username, db_pass);
        return connection;
    }

    public void disconnect() {
        try {
            connection.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
