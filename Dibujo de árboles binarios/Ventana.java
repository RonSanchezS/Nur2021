/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dibujoarboles;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Ronal
 */
class Ventana extends JFrame {

    private panelDibujo panel;

    public Ventana() {

        super("Dibuja un arbol");
       
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setResizable(false);
        panel = new panelDibujo();
        this.setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);

        this.pack();
    }

}
