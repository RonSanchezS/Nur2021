/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author Ronal
 */
class panelRecuperar extends JFrame {

    JComboBox<String> list = new JComboBox<>();
    JButton btn = new JButton("Recuperar Arbol");
    JButton btn2 = new JButton("Eliminar todo");
    JButton btn3 = new JButton("Eliminar Arbol");
    JButton btn4 = new JButton("Actualizar");

    public panelRecuperar(ArbolAritmetico arb) {
        this.setLayout(null);
        btn.setBounds(165, 10, 150, 50);
        btn2.setBounds(165, 130, 150, 50);
        btn4.setBounds(320, 130, 150, 50);
        btn3.setBounds(165, 70, 150, 50);
        setSize(500, 250);
        list.setBounds(10, 10, 145, 35);
        this.add(list);
        this.add(btn);
        this.add(btn2);
        this.add(btn3);
        this.add(btn4);

        mySqlCon sql = new mySqlCon();
        recuperar();
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    arb.setExpresion((String) list.getSelectedItem());
                } catch (Exception ex) {
                    Logger.getLogger(panelRecuperar.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    list.removeAllItems();
                    eliminarDB();
                    recuperar();
                } catch (Exception ex) {
                    Logger.getLogger(panelRecuperar.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    eliminarArbol();
                } catch (Exception ex) {
                    Logger.getLogger(panelRecuperar.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                try {
                    recuperar();
                } catch (Exception ex) {
                    Logger.getLogger(panelRecuperar.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    public void eliminarDB() {
        mySqlConInsertar nuevo = new mySqlConInsertar();
        nuevo.limpiarDB();

    }

    public void eliminarArbol() {
        mySqlConInsertar nuevo = new mySqlConInsertar();
        nuevo.limpiar((String) list.getSelectedItem());
        recuperar();

    }

    public void recuperar() {
        try {
            list.removeAllItems();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/arboles", "root", "root");
//here sonoo is database name, root is username and password  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from expresiones");
            String texto = "";
            while (rs.next()) {
                texto = rs.getString(1);
                list.addItem(texto);
            }

            con.close();

        } catch (Exception e) {
        }
    }
}
