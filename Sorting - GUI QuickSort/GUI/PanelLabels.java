/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareapro.GUI;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tareapro.MODELOS.Numero;

/**
 *
 * @author Ron
 */
public class PanelLabels extends JPanel implements PropertyChangeListener {
    
    private Numero[] listaNumeros;
    private JLabel lblDatos;
    private final static Logger log = LogManager.getRootLogger();
    
    public PanelLabels(Numero[] lista) {
        listaNumeros = lista;
        init();
        log.debug("Creados los labels de la parte inferior");
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        int numeros = listaNumeros.length;
        int mayor = 10;
        int menor = listaNumeros.length - 1;
        int promedio = 0;
        
        for (int i = 0; i < listaNumeros.length - 1; i++) {
            if (mayor < listaNumeros[i].getValor()) {
                mayor = listaNumeros[i].getValor();
            }
            if (menor > listaNumeros[i].getValor() && listaNumeros[i].getValor() != 0) {
                menor = listaNumeros[i].getValor();
                
            }
            
        }
        promedio = listaNumeros[(int) (listaNumeros.length / 2)].getValor();
        
        lblDatos.setText("Numeros: " + (1 + numeros) + "  Mayor: " + mayor + "  Menor: " + menor + "  Medio: " + promedio);
    }
    
    private void init() {
        lblDatos = new JLabel();
        this.setLayout(new BorderLayout());
        this.add(lblDatos, BorderLayout.CENTER);
    }
    
}
