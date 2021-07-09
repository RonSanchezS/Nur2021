/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Ronal
 */
class panelIngresarTexto extends JFrame {

    ArbolAritmetico modelo;
    private JButton btnAccion;
    private JTextField txt;
    private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getRootLogger();

    public panelIngresarTexto(ArbolAritmetico arb) {
        super("Ingrese una ecuación");
        init(arb);
        this.setLayout(null);

    }

    private void init(ArbolAritmetico arb) {
        setLocationRelativeTo(null);
        txt = new JTextField();
        txt.setBounds(25, 0, 350, 30);
        setSize(400, 200);
        setResizable(false);
        btnAccion = new JButton("Generar Arbol");
        btnAccion.setBounds(140, 50, 120, 50);
        btnAccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    arb.setExpresion(txt.getText());
                    JOptionPane.showMessageDialog(txt, "El resultado del arbol es: " + arb.evaluar());
                    mySqlConInsertar con = new mySqlConInsertar();
                    con.insertar(txt.getText());
                    log.debug("Ingresada la expresion "+txt.getText());
                } catch (Exception ex) {
                    Logger.getLogger(panelIngresarTexto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.add(txt);
        this.add(btnAccion);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

}
