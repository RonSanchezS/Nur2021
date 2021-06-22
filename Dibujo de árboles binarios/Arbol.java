/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dibujoarboles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.function.Consumer;

public class Arbol<T extends Identificable> {
	public static final int ESPACIO_VERTICAL = 80;
	public static final int ESPACIO_HORIZONTAL = 50;
    private Contenedor<T> raiz;

    public Contenedor<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(Contenedor<T> raiz) {
        this.raiz = raiz;
    }

    public void addHijo(T o, String padre) {
        if (padre == null) {
            raiz = new Contenedor<>(o);
            return;
        }
        Contenedor<T> hijo = new Contenedor<>(o);
        Contenedor<T> contenedorPadre = buscar(padre);
        contenedorPadre.getHijos().insertar(hijo);
        hijo.setPadre(contenedorPadre);
    }

    public Contenedor<T> buscar(String id) {
        if (raiz == null) {
            return null;
        }
        return raiz.buscar(id);

    }

    class Contenedor<T extends Identificable> {
	public static final int ESPACIO_VERTICAL = 80;
	public static final int ESPACIO_HORIZONTAL = 50;
        private T contenido;
        private Lista<Contenedor<T>> hijos;
        private Contenedor<T> padre;
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Contenedor(T o) {
            contenido = o;
            hijos = new Lista<>();
            padre = null;
        }

        public T getContenido() {
            return contenido;
        }

        public void setContenido(T contenido) {
            this.contenido = contenido;
        }

        public Lista<Contenedor<T>> getHijos() {
            return hijos;
        }

        public void setHijos(Lista<Contenedor<T>> hijos) {
            this.hijos = hijos;
        }

        public Contenedor<T> getPadre() {
            return padre;
        }

        public void setPadre(Contenedor<T> padre) {
            this.padre = padre;
        }

        public Contenedor<T> buscar(String id) {
            if (contenido.getId().equals(id)) {
                return this;
            }
            for (Contenedor<T> hijo : hijos) {
                Contenedor<T> posible = hijo.buscar(id);
                if (posible != null) {
                    return posible;
                }
            }
            return null;
        }

        public void pintar(Graphics g, int x, int y) {
            this.setX(x);
            this.setY(y);
            if (this.getPadre() != null) {
                g.drawLine(this.getPadre().getX(), this.getPadre().getY(), this.getX(), this.getY());
            }
            g.drawRect(x, y, 50, 50);
            g.drawString(this.toString(), x + 5, y + 30);
            y += 60;
            x -= 120;
            if (hijos.tamano > 0) {
                for (Contenedor<T> hijo : hijos) {

                    hijo.pintar(g, x, y);
                    x += 60;
                }
            }

        }

        public void pintar(Contenedor<Persona> contenedor, int x, int y, Graphics g) {

            int ancho = getAncho((Contenedor<Persona>) this);
            int xh = x;
            int yh = y + 10;
            int anchoHijo = 0;

            for (Contenedor<T> hijo : hijos) {
                anchoHijo = getAncho((Contenedor<Persona>) hijo);

              //  g.drawLine(x + ancho / 2, y + 40 / 2, xh + anchoHijo / 2, yh + 40 / 2);

                pintar((Contenedor<Persona>) hijo, xh, yh, g);

                xh += (anchoHijo + 10);

            }

            g.setColor(Color.white);

            g.fillArc(x
                    + ancho / 2 - 40 / 2, y, 40, 40, 0, 360);
            g.setColor(Color.black);

            g.drawArc(x
                    + ancho / 2 - 40 / 2, y, 40, 40, 0, 360);
            g.drawString(contenedor.getContenido().getId(), x + ancho / 2, y + 40 / 2);

        }

    private int getAncho(Contenedor<Persona> contenedor) {
        if (contenedor.getHijos().tamano == 0) {
            return 40;
        }

        int result = 0;
        int espacio = 0;

        for (Contenedor<Persona> hijo : contenedor.getHijos()) {
            result += espacio + getAncho(hijo);
            espacio = ESPACIO_HORIZONTAL;
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder respuesta = new StringBuilder();
        respuesta.append(this.getContenido().getId());
        if (hijos.tamano > 0) {
            respuesta.append("(");
            String separador = "";
            for (Contenedor<T> hijo : hijos) {
                respuesta.append(separador).append(hijo.toString());
            }
            respuesta.append(")");
        }
        return respuesta.toString();

    }
    }
}


