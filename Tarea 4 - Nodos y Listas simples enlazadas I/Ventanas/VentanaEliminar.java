/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.Ventanas;

import javaapplication2.Listas.ListaOrdenada;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Ronal
 */
class VentanaEliminar extends JFrame {

    ListaOrdenada<Persona> lista;
    private JButton btnBorrar;
    private JTextField txt;
    private Logger log = LogManager.getRootLogger();

    VentanaEliminar(ListaOrdenada<Persona> list) {
        setLayout(null);
        lista = list;
        txt = new JTextField();
        btnBorrar = new JButton("Borrar numero seleccionado");

        txt.setBounds(10, 10, 100, 100);
        btnBorrar.setBounds(10, 200, 100, 100);

        setSize(400, 400);
        btnBorrar.addActionListener(new ActionListener() {
            String pat = "^\\d+$";

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (lista.getTamano() != 0) {

                    if (Pattern.matches(pat, txt.getText())) {
                        list.removerPorPosicion(Integer.parseInt(txt.getText()));

                    } else {
                        JOptionPane.showMessageDialog(txt, "Agregar solo numeros del 0 al " + (list.getTamano() - 1));
                    }
                    JOptionPane.showMessageDialog(txt, "");
                } else {
                    JOptionPane.showMessageDialog(txt, "La lista esta vacia");
                }
log.warn("Presionado el boton para eliminar de VentanaEliminar");
            }
        });
        this.add(txt);
        this.add(btnBorrar);

    }

}
