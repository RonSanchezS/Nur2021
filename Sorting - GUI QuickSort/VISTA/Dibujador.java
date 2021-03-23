/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareapro.VISTA;

import tareapro.VISTA.iDibujo;
import java.awt.Graphics;
import tareapro.MODELOS.Numero;

/**
 *
 * @author Ron
 */
public class Dibujador implements iDibujo {

    private final Numero[] numeroLista;

    public Dibujador(Numero[] numeroLista) {
        this.numeroLista = numeroLista;
    }

    @Override
    public void dibujar(Graphics gs) {
        for (int i = 0; i < numeroLista.length - 1; i++) {
            if (numeroLista[i] != null) {

                gs.drawLine((i * 2), 380, (i * 2), 380-((int) (numeroLista[i].getValor()/1.2)));
            }
        }
    }
}
