/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareapro.MODELOS;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Ron
 */
public class Numero {

    private int valor;

    private PropertyChangeSupport cambio;

    public Numero(int valor) {
        this.valor = valor;
        
        cambio = new PropertyChangeSupport(this);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        try {
            int oldval = this.valor;
            this.valor = valor;
            cambio.firePropertyChange("Cambio", oldval, valor);

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void addObserver(PropertyChangeListener observador) {
        try {
            
            cambio.addPropertyChangeListener(observador);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "Numero{" + "valor=" + valor + '}';
    }

}
