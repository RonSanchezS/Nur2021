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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WinImagen extends JFrame {

    private static final long serialVersionUID = 1L;
  private final static Logger log = LogManager.getRootLogger();
    private Imagen primeraImagen;
    private Imagen segundaImagen;
    PanelImagen panel;

    public WinImagen() {
        super("Tarea 2 - Pro3");
        init();
    }

    public void init() {

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        primeraImagen = new Imagen(400, 400);
        segundaImagen = new Imagen(400, 400);
        cargarArchivos();

        panel = new PanelImagen(primeraImagen, segundaImagen);

        primeraImagen.addObserver(panel);
        segundaImagen.addObserver(panel);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();

        JMenu mnuImagen = new JMenu("Modificar");
        JMenu mnuAlterar = new JMenu("Revertir");
        JMenu mnu = new JMenu("Opciones");

        JMenuItem item = new JMenuItem("Mostrar segunda Imagen");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarSegundaImagen();
            }
        });

        mnuImagen.add(item);
        item = new JMenuItem("Juntar o separar imagenes");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel.merge();
            }
        });

        mnuImagen.add(item);

        item = new JMenuItem("Mostrar primera imagen");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarPrimeraImagen();
            }
        });
        mnuImagen.add(item);
        item = new JMenuItem("Revertir primera imagen");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ocultarSegundaImagen();
            }

        });
        mnuAlterar.add(item);
        item = new JMenuItem("Revertir segunda imagen");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ocultarPrimerImagen();
            }

        });
        mnuAlterar.add(item);
        item = new JMenuItem("Salir");
        item.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }

        });
        log.debug("Se han creado las opciones");
        mnu.add(item);

        menuBar.add(mnu);
        menuBar.add(mnuImagen);
        menuBar.add(mnuAlterar);

        this.setJMenuBar(menuBar);

        this.pack();
    }

    private void ocultarSegundaImagen() {

        for (int i = 0; i < segundaImagen.getAncho(); i++) {
            for (int j = 0; j < segundaImagen.getAlto(); j++) {

                segundaImagen.setPixel(255 << 16 | 255 << 8 | 255, i, j);
            }
        }
        log.debug("Ocultada la segunda imagen");

    }

    private void ocultarPrimerImagen() {
        for (int i = 0; i < primeraImagen.getAncho(); i++) {
            for (int j = 0; j < primeraImagen.getAlto(); j++) {

                primeraImagen.setPixel(255 << 16 | 255 << 8 | 255, i, j);
            }
        }
                log.debug("Ocultada la primer imagen");

    }

    protected void MostrarPrimeraImagen() {
        //PrimeraImagen f = new PrimeraImagen(segundaImagen);
        //f.hacer();
        panel.MostrarImg();

    }

    protected void MostrarSegundaImagen() {
        //SegundaImagen f = new SegundaImagen(primeraImagen);
        //f.hacer();
        panel.MostrarImg2();
        /*
        if (primeraImagen.getAlto() != segundaImagen.getAlto() || primeraImagen.getAncho() != segundaImagen.getAncho()) {
            if (primeraImagen.getAncho() != 10 && segundaImagen.getAncho() != 10) {
                System.exit(1);

            }
        }
         */

    }

    private void cargarArchivos() {
        /*
        try {
            File file = new File("C:\\Users\\Ron\\Downloads\\amogus.jpg");
            BufferedImage img;
            img = ImageIO.read(file);
            File file2 = new File("C:\\Users\\Ron\\Downloads\\amogus2.jpg");
            BufferedImage img2;
            img2 = ImageIO.read(file2);
            if (img.getHeight() != img2.getHeight() || (img.getWidth() != img2.getWidth())) {
                JOptionPane.showMessageDialog(this, "Las imagenes no son del mismo tamaño, por ende el programa no puede seguir");
                System.exit(1);
            }
            primeraImagen.setAlto(img.getHeight());
            segundaImagen.setAlto(img2.getHeight());
            primeraImagen.setAncho(img.getHeight());
            segundaImagen.setAncho(img2.getHeight());
        } catch (IOException ex) {
            Logger.getLogger(WinImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         */

    }
}
