/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

/**
 *
 * @author Ronal
 */
public class Operador extends ElementoAritmetico {

    private String simbolo;
    private String nombre;

    public Operador(String s) {
        simbolo = s;
        if (s.equals("+") ) {
            nombre = "Suma";
        }
        if (s.equals("-") ) {
            nombre = "Resta";
        }
        if (s.equals("*") ) {
            nombre = "Multiplicar";
        }
        if (s.equals("/") ) {
            nombre = "Dividir";
        }
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDatos() {
        return String.valueOf(this.simbolo);
    }
}
