/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro3tarea;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Ron
 */
public class PrimeraImagen extends Transformacion {

    public PrimeraImagen(Imagen img) {
        imagenBase = img;
    }

    @Override
    public void hacer() {
        try {
            File fila = new File("C:\\Users\\Ron\\Downloads\\amogus2.jpg");
            BufferedImage imgn = ImageIO.read(fila);
            for (int y = 0; y < imgn.getHeight(); y++) {
                for (int x = 0; x < imgn.getWidth(); x++) {
                    int pixel = imgn.getRGB(x, y);
                    imagenBase.setPixel(pixel, x, y);
                    
                }
            }
            imagenBase.cambioOk();
        } catch (IOException ex) {
            Logger.getLogger(PrimeraImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
