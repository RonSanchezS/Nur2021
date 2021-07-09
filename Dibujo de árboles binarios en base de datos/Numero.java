/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

public class Numero extends ElementoAritmetico {

    private double valor;

    public Numero(double v) {
        valor = v;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String getDatos() {
        return String.valueOf(valor);
    }

}
