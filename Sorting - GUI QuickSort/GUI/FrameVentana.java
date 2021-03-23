/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareapro.GUI;

import tareapro.VISTA.Dibujador;
import tareapro.VISTA.iDibujo;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tareapro.MODELOS.Numero;

/**
 *
 * @author Ron
 */
public class FrameVentana extends JFrame {

    private Numero[] listaNumero;
    private int[] listaEnteros;
    private int milis;
    private int ram;
    private final static Logger log = LogManager.getRootLogger();

    public FrameVentana() {
        super("Práctico 1 - Ordenamiento con gráfica");
        iniciar();
    }

    private void iniciar() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setResizable(false);
        
        setLocation(330 , 160);
        listaNumero = new Numero[299];
        ram = 400;
        listaEnteros = new int[listaNumero.length];

        milis = 30;

        iDibujo dibujo = new Dibujador(listaNumero);
        PanelDibujo panDibujo = new PanelDibujo(dibujo);
        PanelLabels panLabels = new PanelLabels(listaNumero);
        PanelBotones panBotones = new PanelBotones(ram, listaEnteros, listaNumero, milis);
        log.debug("Paneles agregados", panDibujo, panLabels, panBotones);
        cargarNumerosObservers(panDibujo, panLabels);

        this.setLayout(new BorderLayout());
        this.getContentPane().add(panDibujo, BorderLayout.CENTER);
        this.getContentPane().add(panLabels, BorderLayout.SOUTH);
        this.getContentPane().add(panBotones, BorderLayout.NORTH);

        this.pack();
    }

    private void cargarNumerosObservers(PanelDibujo pan, PanelLabels panlbl) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < listaNumero.length - 1; i++) {
                    int val = 1 + (int) (Math.random() * 400);
                    Numero aux = new Numero(val);
                    listaNumero[i] = aux;
                    listaEnteros[i] = val;
                    listaNumero[i].addObserver(pan);
                    listaNumero[i].addObserver(panlbl);
                    try {
                        listaNumero[i].setValor(listaNumero[i].getValor() + 1);
                        Thread.sleep(milis / 10);
                    } catch (InterruptedException ex) {
                        log.debug(ex.getMessage() + " " + FrameVentana.class.getName());
                    }
                }
            }
        });
        t.start();
        log.debug("Numeros Cargados");
    }
}
