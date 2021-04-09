/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro3tarea;

/**
 *
 * @author Ron
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class WinImagen extends JFrame {

    private static final long serialVersionUID = 1L;

    private Imagen primeraImagen;
    private Imagen segundaImagen;

    public WinImagen() {
        super("Tarea 2 - Pro3");
        init();
    }

    public void init() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        primeraImagen = new Imagen(400, 400);
        segundaImagen = new Imagen(400, 400);

        PanelImagen panel = new PanelImagen(primeraImagen, segundaImagen);

        primeraImagen.addObserver(panel);
        segundaImagen.addObserver(panel);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();

        JMenu mnuImagen = new JMenu("Modificar");
        JMenu mnuAlterar = new JMenu("Revertir");

        JMenuItem item = new JMenuItem("Mostrar segunda Imagen");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mnuImagen_franjaRoja();
            }
        });

        mnuImagen.add(item);

        item = new JMenuItem("Mostrar primera imagen");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mnuImagen_franjaCafeClaro();
            }
        });

        mnuImagen.add(item);

        menuBar.add(mnuImagen);
        menuBar.add(mnuAlterar);

        this.setJMenuBar(menuBar);

        this.pack();
    }

    protected void mnuImagen_franjaCafeClaro() {
        PrimeraImagen f = new PrimeraImagen(segundaImagen);
        f.hacer();
    }

    protected void mnuImagen_franjaRoja() {
        SegundaImagen f = new SegundaImagen(primeraImagen);
        f.hacer();
    }
}
