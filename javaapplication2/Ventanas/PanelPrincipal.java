/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.Ventanas;

import javaapplication2.Listas.ListaOrdenada;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ronal
 */
public class PanelPrincipal extends JPanel implements PropertyChangeListener {

    private ListaOrdenada<Persona> aLista;

    public PanelPrincipal(ListaOrdenada<Persona> t) {
        aLista = t;

    }

    PanelPrincipal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(640, 400);
    }

    public void iniciar() {
        /* Persona p = new Persona(180, 25, "Victor", 'M');
        Persona ps = new Persona(100, 50, "Victor2", 'M');
        Persona pss = new Persona(170, 75, "Victor3", 'M');
        Persona psss = new Persona(30, 100, "Victor4", 'M');
        aLista.insertarMejorado(p);
        aLista.insertarMejorado(ps);
        aLista.insertarMejorado(pss);
        aLista.insertarMejorado(psss);*/

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int desde = 10;
        int hasta = 350;
        for (Persona persona : aLista) {
            if (persona != null) {

                g.setColor(Color.black);
                g.drawRect(desde, 0, persona.getTamano(), hasta);
                persona.dibujar(desde, 0, g, persona.getTamano());
                desde += persona.getTamano();
            }
        }

    }

    public void crearpersona() {

    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {

        this.repaint();

    }

    void crearpersona(String nombre, int tamano, int edad, char genero) {
        if (devolverTamano() < aLista.getLimite()) {

            Persona p = new Persona(tamano, edad, nombre, genero);
            aLista.insertar(p);
        }else{
            JOptionPane.showMessageDialog(this, "Se ha alcanzado el numero maximo en la lista");
        }

    }

    public int devolverTamano() {
        return this.aLista.getTamano();
    }

}
