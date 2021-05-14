/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2.Ventanas;

import javaapplication2.Comparadores.ComparatorGenero;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Comparator;

/**
 *
 * @author Ronal
 */
public class Persona implements Comparable<Persona> {

    private int tamano;
    private int edad;
    private String nombre;
    private char genero;
    private Comparator<Persona> comparador;

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public Comparator<Persona> getComparador() {
        return comparador;
    }

    public void setComparador(Comparator<Persona> comparador) {
        this.comparador = comparador;
    }

    public Persona(int tamano, int edad, String nombre, char genero) {
        this.tamano = tamano;
        this.edad = edad;
        this.nombre = nombre;
        this.genero = genero;
        this.comparador = new ComparatorGenero();
    }

    @Override
    public String toString() {
        return "Persona{" + "tamano=" + tamano + ", edad=" + edad + ", nombre=" + nombre + '}';
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    void dibujar(int c, int i, Graphics g, int fin) {
        Color color;
        g.setColor(Color.BLACK);
        g.drawString("" + edad, c, 20);
        g.drawString("" + tamano, c, 40);
        g.drawString("" + nombre, c, 60);
        if (genero == 'F' || genero == 'f') {
            g.drawString("" + "Mujer", c, 80);

        } else {
            g.drawString("" + "Hombre", c, 80);

        }
        if (edad > 110) {
            color = new Color(255 << 16 | 255 << 8 | 5);

        } else {
            color = new Color((int) (edad * 2.35) << 16 | 145 + edad << 8 | 5);

        }
        g.setColor(color);

        //cabeza
        g.fillOval(c, 350 - tamano, (int) (tamano * 0.25), (int) (tamano * 0.25));

        //brazos
        g.drawLine(c, 350 - (int) (tamano * 0.65), c + (int) (tamano * 0.25), 350 - (int) (tamano * 0.65));

        //Torso
        g.drawLine(c + (int) (tamano * 0.25) / 2, 350 - tamano + (int) (tamano * 0.25), c + ((int) (tamano * 0.25) / 2), 350 - tamano + (int) (tamano * 0.35) + ((int) (tamano * 0.25)));

        //Piernas
        g.drawLine(c + (int) (tamano * 0.25), 350, c + ((int) (tamano * 0.25) / 2), 350 - tamano + (int) (tamano * 0.35) + ((int) (tamano * 0.25)));
        g.drawLine(c, 350, c + ((int) (tamano * 0.25) / 2), 350 - tamano + (int) (tamano * 0.35) + ((int) (tamano * 0.25)));

        if (genero == 'F') {
            int[] x = {c+((int) (tamano * 0.25) / 2), c+(int) (tamano * 0.25), c};
            int[] y = { 350 - tamano + (int) (tamano * 0.35) + ((int) (tamano * 0.25)), 370 - tamano + (int) (tamano * 0.35) + ((int) (tamano * 0.25)), 370- tamano + (int) (tamano * 0.35) + ((int) (tamano * 0.25))};
            g.drawPolygon(x, y, 3);
        }
        //Manos
        // g.drawLine(c + (int) (tamano * 0.25), (int) (tamano * 0.75) * 2, c + (int) (tamano * 0.25), (int) (tamano * 0.75) * 2);
    }

    @Override
    public int compareTo(Persona t) {

        return comparador.compare(this, t);

    }

}
