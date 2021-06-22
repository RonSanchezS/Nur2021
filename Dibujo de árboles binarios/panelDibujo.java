/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dibujoarboles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Ronal
 */
class panelDibujo extends JPanel {

    Arbol<Persona> a = new Arbol();

    public panelDibujo() {
        setBackground(Color.yellow);

        a.addHijo(new Persona("A", "Ron"), null);
        a.addHijo(new Persona("B", "ASD"), "A");
        a.addHijo(new Persona("C", "GGA"), "A");
        a.addHijo(new Persona("D", "GGA"), "C");
        a.addHijo(new Persona("E", "GGA"), "A");
        a.addHijo(new Persona("F", "GGA"), "C");
        a.addHijo(new Persona("F", "GGA"), "B");
        

        System.out.println(a.getRaiz());

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    @Override
    public void paintComponent(Graphics g) {
       // a.getRaiz().pintar(g, 250, WIDTH);
        a.getRaiz().pintar(a.getRaiz(), 10, 10, g);
    }
    
   

}
