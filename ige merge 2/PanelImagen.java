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
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import org.apache.logging.log4j.LogManager;

public class PanelImagen extends JPanel implements PropertyChangeListener {

    private static final long serialVersionUID = 1L;
    private Imagen imagen;
    private Imagen imagen2;
    private boolean fusion;
    private boolean primeraVez;
    private final static org.apache.logging.log4j.Logger log = LogManager.getRootLogger();

    public PanelImagen(Imagen img, Imagen img2) {
        imagen = img;
        imagen2 = img2;
        try {
            CargarImagenes();
        } catch (IOException ex) {
            log.error(ex);
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
          
             
            for (int i = 0; i < imagen.getAncho(); i++) {
                for (int j = 0; j < imagen.getAlto(); j++) {
                    if (i < imagen.getAncho() / 3) {
                        g2d.setColor(new Color(imagen2.getPixel(i, j)));

                    } else if (i >= imagen.getAncho() / 3 && i < (imagen.getAncho() / 3) * 2) {
                        if (fusion) {
                            if (imagen.getAncho() != imagen2.getAncho() || imagen.getAlto() != imagen2.getAlto()) {
                                JOptionPane.showMessageDialog(this, "Las imagenes no coinciden, saliedno del programa");
                                System.exit(1);
                            }
                            int pixel = imagen2.getPixel(i, j);
                            Color color = new Color(pixel, true);
                            int red = color.getRed();
                            int green = color.getGreen();
                            int blue = color.getBlue();
                            int pixel2 = imagen.getPixel(i, j);
                            Color color2 = new Color(pixel2, true);
                            int red2 = color2.getRed();
                            int green2 = color2.getGreen();
                            int blue2 = color2.getBlue();
                            red2 = red2 + ((red - red2) / 2);

                            green2 = green2 + ((green - green2) / 2);

                            blue2 = blue2 + ((blue - blue2) / 2);

                            Color x = new Color((red2 << 16 | green2 << 8 | blue2));
                            g2d.setColor(x);
                            imagen.cambioOk();
                        }

                    } else {
                        g2d.setColor(new Color(imagen.getPixel(i, j)));

                    }

                    g2d.drawLine(i, j, i, j);
                }
            }
            g.drawImage(rsm, 0, 0, null);
        }
        log.debug("Imagen creada");
    }

    void merge() {
        this.fusion = !fusion;

    }

    void MostrarImg() {
        //     PrimeraImagen f = new PrimeraImagen(imagen);
        //   f.hacer();
        hacer();
        if (primeraVez) {
            if (imagen.getAlto() != imagen2.getAlto() || imagen2.getAncho() != imagen2.getAncho()) {
                System.exit(1);
            }
        }

        primeraVez = false;
    }

    void MostrarImg2() {
        //   SegundaImagen f = new SegundaImagen(imagen2);
        // f.hacer();
        hacer2();
        if (primeraVez) {
            if (imagen.getAlto() != imagen2.getAlto() || imagen2.getAncho() != imagen2.getAncho()) {
                System.exit(1);
            }
        }

        primeraVez = false;
    }

    public void hacer() {
        try {
            JFileChooser jf;
            jf = new JFileChooser();
            jf.showOpenDialog(jf);
            File archivo = jf.getSelectedFile();
            //   File fila = new File("C:\\Users\\Ron\\Downloads\\amogus2.jpg");
            BufferedImage img = ImageIO.read(archivo);
            log.debug(archivo + " " + img.getHeight() + "x" + img.getWidth());
            if (img.getHeight() != 400 || img.getWidth() != 400) {
                JOptionPane.showMessageDialog(jf, "Las dimensiones deben ser 400x400");
                System.exit(1);

            }
            imagen2.setAlto(img.getHeight());
            imagen2.setAncho(img.getWidth());
            for (int y = 0; y < img.getHeight(); y++) {
                for (int x = 0; x < img.getWidth(); x++) {
                    int pixel = img.getRGB(x, y);
                    imagen2.setPixel(pixel, x, y);

                }
            }
            imagen2.cambioOk();
        } catch (IOException ex) {
            Logger.getLogger(PrimeraImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hacer2() {
        try {
            JFileChooser jf;
            jf = new JFileChooser();
            jf.showOpenDialog(jf);
            File archivo = jf.getSelectedFile();
            //   File fila = new File("C:\\Users\\Ron\\Downloads\\amogus2.jpg");
           
            BufferedImage imgn = ImageIO.read(archivo);
            log.debug(archivo + " " + imgn.getHeight() + "x" + imgn.getWidth());
            if (imgn.getHeight() != 400 || imgn.getWidth() != 400) {
                JOptionPane.showMessageDialog(jf, "Las dimensiones deben ser 400x400");
                System.exit(1);

            }
            imagen.setAlto(imgn.getHeight());
            imagen.setAncho(imgn.getWidth());
            for (int y = 0; y < imgn.getHeight(); y++) {
                for (int x = 0; x < imgn.getWidth(); x++) {
                    int pixel = imgn.getRGB(x, y);
                    imagen.setPixel(pixel, x, y);

                }
            }
            imagen.cambioOk();
        } catch (IOException ex) {
            Logger.getLogger(PrimeraImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
