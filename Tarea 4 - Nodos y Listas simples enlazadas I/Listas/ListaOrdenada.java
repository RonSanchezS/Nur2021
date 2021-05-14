/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.Listas;

import javaapplication2.Listas.Lista;

/**
 *
 * @author Ronal
 * @param <T>
 */
public class ListaOrdenada<T extends Comparable<T>> extends Lista<T> {

    public ListaOrdenada() {
        super();
    }

    @Override
    public void insertar(T o) {

        if (raiz == null) {
            super.insertar(o);
            return;
        }

        Comparable<T> comparable = (Comparable) o;
        if (comparable.compareTo(raiz.getContenido()) <= 0) {
            super.insertar(o);
            int oldval = tamano;
            super.ps.firePropertyChange("Cambio", oldval, tamano);
            return;
        }

        Contenedor<T> nuevo = new Contenedor<T>(o);
        Contenedor<T> actual = raiz;

        while (actual.getSiguiente() != null
                && comparable.compareTo(actual.getSiguiente().getContenido()) > 0) {
            actual = actual.getSiguiente();
            int oldval = tamano;
                    super.ps.firePropertyChange("Cambio", oldval, tamano);

        }

        // Aqui actual es el nodo anterior al lugar donde debe ir o (nuevo)
        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo);
        int oldval = tamano;
        tamano++;
        super.ps.firePropertyChange("Cambio", oldval, tamano);
    }
}
