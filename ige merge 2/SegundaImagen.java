/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro3tarea;

import java.io.File;
import java.io.FileWriter;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Ron
 */
public class SegundaImagen extends Transformacion {
JFileChooser jf;
    public SegundaImagen(Imagen img) {
        imagenBase = img;
    }

    @Override
    public void hacer() {
        try {
            jf = new JFileChooser();
            jf.showOpenDialog(jf);
            File archivo = jf.getSelectedFile();
           
        //    File file = new File("C:\\Users\\Ron\\Downloads\\amogus.jpg");
            BufferedImage img;
            img = ImageIO.read(archivo);
            imagenBase.setAlto(img.getHeight());
            imagenBase.setAncho(img.getWidth());
            for (int y = 0; y < imagenBase.getAncho(); y++) {
                for (int x = 0; x < imagenBase.getAncho(); x++) {
                    int pixel = img.getRGB(x, y);
                    imagenBase.setPixel(pixel, x, y);

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SegundaImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
