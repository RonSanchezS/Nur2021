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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

public class PanelImagen extends JPanel implements PropertyChangeListener {

    private static final long serialVersionUID = 1L;
    private Imagen imagen;
    private Imagen imagen2;

    public PanelImagen(Imagen img, Imagen img2) {
        imagen = img;
        imagen2 = img2;
        try {
            CargarImagenes();
        } catch (IOException ex) {
            Logger.getLogger(PanelImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        pintarImagenes(g);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }

    public void CargarImagenes() throws IOException {

        //Reading the image
        /*
        File file = new File("C:\\Users\\Ron\\Downloads\\amogus.jpg");
        BufferedImage img = ImageIO.read(file);
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                int pixel = img.getRGB(x, y);
                imagen.setPixel(pixel, x, y);

            }
        }
        
         */
        //Reading the image
        /*
        File fila = new File("C:\\Users\\Ron\\Downloads\\amogus2.jpg");
        BufferedImage imgn = ImageIO.read(fila);
        for (int y = 0; y < imgn.getHeight(); y++) {
            for (int x = 0; x < imgn.getWidth(); x++) {
                int pixel = imgn.getRGB(x, y);
                imagen2.setPixel(pixel, x, y);

            }
        }
        
         */
        
    }

    private void pintarImagenes(Graphics g) {

        if (imagen != null && imagen2 != null) {
            BufferedImage rsm = new BufferedImage(imagen.getAncho(), imagen.getAlto(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = rsm.createGraphics();
            /*
             for (int i = 0; i < imagen.getAncho(); i++) {
                for (int j = 0; j < imagen.getAlto(); j++) {
                    if (i < 200) {
                        g2d.setColor(new Color(imagen2.getPixel(j, j)));

                    } else if (i > 400) {
                        g2d.setColor(new Color(imagen.getPixel(j, j)));

                    } else if (i > 200 && i < 400) {
                        g2d.setColor(new Color(imagen.getPixel(j, j) + imagen2.getPixel(j, j)));

                    }

                    g2d.drawLine(i, j, i, j);

                }
            }

            g.drawImage(rsm, 0, 0, null);
             */
            for (int i = 0; i < imagen.getAncho(); i++) {
                for (int j = 0; j < imagen.getAlto(); j++) {
                    if (i < 133) {
                        g2d.setColor(new Color(imagen2.getPixel(i, j)));

                    } else if (i >= 133 && i < 266) {

                        g2d.setColor(new Color(((imagen2.getPixel(i, j)+imagen.getPixel(i, j)))/2));

                    } else {
                        g2d.setColor(new Color(imagen.getPixel(i, j)));
                        //                         g2d.setColor(new Color((imagen2.getPixel(i, j))));

                    }

                    g2d.drawLine(i, j, i, j);
                }
            }
            g.drawImage(rsm, 0, 0, null);
        }
    }

}
