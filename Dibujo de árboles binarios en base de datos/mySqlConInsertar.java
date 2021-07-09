/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Ronal
 */
public class mySqlConInsertar {

    public mySqlConInsertar() {

    }

    public void limpiarDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/arboles", "root", "root");
//here sonoo is database name, root is username and password  
            Statement stmt = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement("drop table expresiones");
            preparedStmt.execute();
            preparedStmt = con.prepareStatement("create table expresiones(\n"
                    + "expresion varchar(50) PRIMARY KEY\n"
                    + ");");
            preparedStmt.execute();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertar(String texto) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/arboles", "root", "root");
//here sonoo is database name, root is username and password  
            Statement stmt = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement("insert into expresiones values ('" + texto + "')");
            preparedStmt.execute();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void limpiar(String str) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/arboles", "root", "root");
//here sonoo is database name, root is username and password  
            Statement stmt = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement("delete from expresiones where expresion = '" + str + "'");
            preparedStmt.execute();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
