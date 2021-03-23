/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareapro.GUI;

import tareapro.VISTA.iDibujo;
import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;

/**
 *
 * @author Ron
 */
public class PanelDibujo extends JPanel implements PropertyChangeListener {

    private iDibujo dibuj;

    public PanelDibujo(iDibujo dib) {
        dibuj =  dib;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (dibuj != null) {
            dibuj.dibujar(g);
        }
    }

}
