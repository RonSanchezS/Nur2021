/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PanelArbol extends JPanel implements PropertyChangeListener, MouseListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ArbolAritmetico modelo;
    DibujoArbol dibujoArbol;

    public PanelArbol(ArbolAritmetico obj) {
        modelo = obj;
        this.addMouseListener(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (modelo != null) {
            dibujoArbol = new DibujoArbol(modelo);
            dibujoArbol.dibujar(g);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        this.repaint();

    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        try {
            dibujoArbol.registrarClick(me.getX(), me.getY());
            this.repaint();

        } catch (Exception ex) {
            Logger.getLogger(PanelArbol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
