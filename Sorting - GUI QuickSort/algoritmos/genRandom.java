/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareapro.algoritmos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tareapro.MODELOS.Numero;
import tareapro.MODELOS.Numero;

/**
 *
 * @author Ron
 */
public class genRandom {

    private Logger log = LogManager.getRootLogger();

    public void randomizar(int[] listaEnteros, Numero[] listaNumero, int random, int milis) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < listaNumero.length - 1; i++) {
                    listaNumero[i].setValor(20);
                }
                log.debug("Vector seteado en 20 para su analisis en panel labels");
                try {

                    for (int i = 0; i < listaNumero.length - 1; i++) {
                        int val = (int) (Math.random() * random);
                        Numero aux = new Numero(val);
                        if (listaNumero[i] == null) {
                            listaNumero[i].setValor(aux.getValor());
                            listaEnteros[i] = (aux.getValor());

                        } else {

                            listaNumero[i].setValor(val);
                            listaEnteros[i] = (val);
                        }
                        Thread.sleep(milis / 5);

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        thread.start();
        log.debug("Se han creado " + (1 + listaNumero.length) + " numeros con el método randomizar de la clase genRandom, numero maximo probable = " + random);
    }
}
