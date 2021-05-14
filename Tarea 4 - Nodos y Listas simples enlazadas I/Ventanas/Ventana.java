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
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Ronal
 */
public class Ventana extends JFrame {

    /*  public PanelPrincipal panel;*/
    private JMenuBar menubar;
    private JMenu menu;
    private JMenuItem item;
    private JMenuItem item2;
    private VentanaCrear vent;
    private VentanaEliminar ventEli;
    private final static Logger lDefecto = LogManager.getRootLogger();

    public Ventana() {
        super("Pro 3 - tarea 4");
        init();
    }

    private void init() {
        ListaOrdenada<Persona> list = new ListaOrdenada<>();
        PanelPrincipal panel = new PanelPrincipal(list);

        list.addObserver(panel);
        menubar = new JMenuBar();
        menu = new JMenu("Accion");
        item = new JMenuItem("Agregar");
        item2 = new JMenuItem("Eliminar");

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                panel.iniciar();
                vent = new VentanaCrear(panel);
                vent.setVisible(true);
                lDefecto.debug("Pulsado boton de creacion de nodos");
            }
        });
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ventEli = new VentanaEliminar(list);
                ventEli.setVisible(true);
                list.removerPorPosicion(2);
                lDefecto.debug("Pulsado boton de eliminacion de nodos");
            }
        });

        menu.add(item);
        menu.add(item2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        menubar.add(menu);
        this.setLayout(new BorderLayout());
        this.setJMenuBar(menubar);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.pack();
        lDefecto.debug("Creada la ventana principal");
    }

}
