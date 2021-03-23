/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareapro.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tareapro.GUI.FrameVentana;

/**
 *
 * @author Ron
 */
public class TareaPro {
private final static Logger log = LogManager.getRootLogger();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FrameVentana p = new FrameVentana();
        log.debug("Se ha iniciado el programa");
        p.setVisible(true);

        
        
    }

}
