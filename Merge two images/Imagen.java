/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro3tarea;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Imagen {

    private int[][] pixeles;
    private int ancho;
    private int alto;

    private PropertyChangeSupport observed;

    public Imagen(int w, int h) {
        pixeles = new int[w][h];
        ancho = w;
        alto = h;
        observed = new PropertyChangeSupport(this);
        for (int i = 0; i < getAncho(); i++) {
            for (int j = 0; j < getAlto(); j++) {

                pixeles[i][j] = 255 << 16 | 255 << 8 | 255;
            }
        }
    }

    public void addObserver(PropertyChangeListener panel) {
        observed.addPropertyChangeListener(panel);
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setPixel(int c, int x, int y) {
        pixeles[x][y] = c;
        observed.firePropertyChange("Imagen", 1, 2);
    }

    public int getPixel(int x, int y) {
        return pixeles[x][y];
    }

    /*
     public void dibujar(Graphics g, int num) {
        BufferedImage rsm = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rsm.createGraphics();

        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                if (num == 1) {

                    g2d.setColor(new Color(pixeles[i][j]));
                    g2d.drawLine(i, j, i, j);
                } else {
                    g2d.setColor(new Color(pixeles[i][j]));
                    g2d.drawLine(i + 150, j, i + 150, j);

                }
            }
        }

        g.drawImage(rsm, 0, 0, null);
    }
     */
    public void hacer() {

        //int rojo = 16711680; // 0 255 0 0
    }

    public void cambioOk() {
        observed.firePropertyChange("Imagen", 1, 2);
    }
}
