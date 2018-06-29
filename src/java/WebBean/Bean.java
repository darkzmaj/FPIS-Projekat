/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Zmaj9
 */
@Stateless
public class Bean {

    public List webBean() {
        List list = new ArrayList();
        String drajver = "com.mysql.jdbc.Driver";
        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/fpis";
        try {

            Class.forName(drajver);
            Connection con = DriverManager.getConnection(url, user, pass);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from proizvod");

            while (rs.next()) {
                list.add(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
            }
            con.close();
        } catch (Exception exc) {
            exc.printStackTrace();

        }
        return list;
    }

}
