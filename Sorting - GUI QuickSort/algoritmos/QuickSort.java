/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareapro.algoritmos;

import tareapro.MODELOS.Numero;
import java.util.Random;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Ron
 */
public class QuickSort {

    private Logger log = LogManager.getRootLogger();

    public void quickSort(int[] A, Numero[] listanum, char orden) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                quickSort(A, 0, A.length - 1, listanum, orden);
            }
        });
        t.start();
        if (orden == '+') {
            log.debug("Se ha efectuado un quickSort");

        } else {
            log.debug("Se ha efectuado un quickSort invertido");

        }
    }

    private void quickSort(int[] A, int low, int high, Numero[] listanum, char orden) {
        if (low < high) {
            int p = partition(A, low, high, listanum, orden);
            quickSort(A, low, p - 1, listanum, orden);
            quickSort(A, p + 1, high, listanum, orden);
        }
    }

    private void swap(int[] A, int index1, int index2, Numero[] listanum) {
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
        if (listanum[index1] != null) {
            listanum[index1].setValor(A[index1]);
        }
        if (listanum[index2] != null) {
            listanum[index2].setValor(A[index2]);

        }
        try {
            Thread.sleep(8);
        } catch (InterruptedException ex) {
            log.error("Se ha encontrado un error en la clase QuickSort");
        }
    }

    // returns random pivot index between low and high inclusive.
    private int getPivot(int low, int high) {
        Random rand = new Random();
        return rand.nextInt((high - low) + 1) + low;
    }

    private int partition(int[] A, int low, int high, Numero[] listanNum, char orden) {
        swap(A, low, getPivot(low, high), listanNum);
        int border = low + 1;
        for (int i = border; i <= high; i++) {
            if (orden == '+') {
                if (A[i] > A[low]) {
                    swap(A, i, border++, listanNum);

                }

            } else {
                if (A[i] < A[low]) {
                    swap(A, i, border++, listanNum);
                }
            }
        }
        swap(A, low, border - 1, listanNum);

        //Corre más rápido, no sé por qué no da error
        //no usar
        //swap(A, border -1, low, listanNum);
        return border - 1;
    }

}
