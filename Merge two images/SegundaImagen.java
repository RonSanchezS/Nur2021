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

/**
 *
 * @author Ron
 */
public class SegundaImagen extends Transformacion {

    public SegundaImagen(Imagen img) {
        imagenBase = img;
    }

    @Override
    public void hacer() {
        try {

            File file = new File("C:\\Users\\Ron\\Downloads\\amogus.jpg");
            BufferedImage img;
            img = ImageIO.read(file);
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
