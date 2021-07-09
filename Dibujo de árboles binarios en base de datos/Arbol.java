package arboles;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Arbol<T extends Identificable> {

    Contenedor<T> raiz;
    private static int alpha = 5;
    private PropertyChangeSupport ps = new PropertyChangeSupport(this);

    public Contenedor<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(Contenedor<T> raiz) {
        this.raiz = raiz;
    }

    public void addObserver(PropertyChangeListener panel) {
        ps.addPropertyChangeListener(panel);
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
        ps.firePropertyChange("Cambio", 0, 1);
    }

    public Contenedor<T> buscar(String id) {
        if (raiz == null) {
            return null;
        }

        return raiz.buscar(id);
    }

    @Override
    public String toString() {
        if (raiz == null) {
            return "VACIO";
        }
        return raiz.toString();
    }

    public static class Contenedor<T extends Identificable> {

        private T contenido;
        private Lista<Contenedor> hijos;
        private Contenedor<T> padre;
        private int x;
        private int y;

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

        public Lista<Contenedor> getHijos() {
            return hijos;
        }

        public void setHijos(Lista<Contenedor> hijos) {
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

        @Override
        public String toString() {
            StringBuilder respuesta = new StringBuilder();
            respuesta.append(this.getContenido().getId());
            if (hijos.tamano() > 0) {
                respuesta.append("(");
                String separador = "";
                for (Contenedor<T> hijo : hijos) {
                    respuesta.append(separador).append(hijo.toString());
                    separador = ",";
                }
                respuesta.append(")");
            }

            return respuesta.toString();
        }

        void setCoordenadas(int x, int y) {
            this.x = x;
            this.y = y;
        }

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

       
    }

}
