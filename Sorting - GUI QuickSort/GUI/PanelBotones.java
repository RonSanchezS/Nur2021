/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareapro.GUI;

import tareapro.algoritmos.genRandom;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tareapro.MODELOS.Numero;
import tareapro.algoritmos.QuickSort;

/**
 *
 * @author Ron
 */
public class PanelBotones extends JPanel {
    
    private JButton btnReordenar;
    private JButton btnReordenar2;
    private JButton btnReordenar3;
    private int ram;
    private int milis;
    private int[] A;
    private Numero[] listanum;
    private final static Logger log = LogManager.getRootLogger();
    
    public PanelBotones(int random, int[] A, Numero[] listanum, int milis) {
        this.ram = random;
        this.A = A;
        this.listanum = listanum;
        this.milis = milis;
        init();
    }
    
    private void init() {
        btnReordenar = new JButton("QuickSort");
        btnReordenar2 = new JButton("QuickSortInverso");
        btnReordenar3 = new JButton("Generar serie aleatoria");
        this.setLayout(null);
        btnReordenar.setBounds(10, 10, 180, 35);
        btnReordenar2.setBounds(190, 10, 180, 35);
        btnReordenar3.setBounds(370, 10, 180, 35);
        this.add(btnReordenar, BorderLayout.WEST);
        this.add(btnReordenar2, BorderLayout.CENTER);
        this.add(btnReordenar3, BorderLayout.EAST);
        agregarListeners();
        log.debug("Se han iniciado los botones");
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 50);
    }
    
    private void agregarListeners() {
        btnReordenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                QuickSort qs = new QuickSort();
                qs.quickSort(A, listanum, '+');
            }
        });
        btnReordenar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                QuickSort qs = new QuickSort();
                qs.quickSort(A, listanum, '-');
                
            }
        });
        btnReordenar3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                genRandom gr = new genRandom();
                gr.randomizar(A, listanum, ram, milis);
            }
        });
    }
}
