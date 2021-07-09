/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.sql.*;

class mySqlCon {

    public mySqlCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/arboles", "root", "root");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from expresiones");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            // create a mysql database connection
            // create a sql date object so we can use it in our INSERT statement
            // the mysql insert statement
            // create the mysql insert preparedstatement
            // execute the preparedstatement
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
