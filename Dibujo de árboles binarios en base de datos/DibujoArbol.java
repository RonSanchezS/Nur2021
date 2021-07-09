package arboles;

import arboles.Arbol.Contenedor;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DibujoArbol extends JFrame implements IDibujo {

    public static final int ANCHO_CONTENEDOR = 40;
    public static final int ESPACIO_VERTICAL = 80;
    public static final int ESPACIO_HORIZONTAL = 50;
    ArbolAritmetico.Contenedor raiz;
    private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getRootLogger();

    public ArbolAritmetico modelo;
    private int ubiX;
    private int ubiY;

    public DibujoArbol(ArbolAritmetico obj) {
        modelo = obj;
    }

    @Override
    public void dibujar(Graphics g) {
        raiz = modelo.getRaiz();

        dibujarContenedor(raiz, 10, 10, g);

    }

    public void dibujarContenedor(ArbolAritmetico.Contenedor<ElementoAritmetico> contenedor, int x, int y, Graphics g) {
        try {
            int ancho = getAncho(contenedor);
            int xh = x;
            int yh = y + ESPACIO_VERTICAL;
            int anchoHijo = 0;

            for (Arbol.Contenedor<ElementoAritmetico> hijo : contenedor.getHijos()) {
                anchoHijo = getAncho(hijo);

                g.drawLine(x + ancho / 2, y + ANCHO_CONTENEDOR / 2, xh + anchoHijo / 2, yh + ANCHO_CONTENEDOR / 2);

                dibujarContenedor(hijo, xh, yh, g);

                xh += (anchoHijo + ESPACIO_HORIZONTAL);
            }

            g.setColor(Color.white);
            g.fillArc(x + ancho / 2 - ANCHO_CONTENEDOR / 2, y, ANCHO_CONTENEDOR, ANCHO_CONTENEDOR, 0, 360);
            g.setColor(Color.black);
            g.drawArc(x + ancho / 2 - ANCHO_CONTENEDOR / 2, y, ANCHO_CONTENEDOR, ANCHO_CONTENEDOR, 0, 360);
            if (contenedor.getContenido().getClass() == Numero.class) {
                g.drawString("" + contenedor.getContenido().getDatos(), x + ancho / 2, y + ANCHO_CONTENEDOR / 2);

            } else {
                g.drawString("" + contenedor.getContenido().getDatos(), x + ancho / 2, y + ANCHO_CONTENEDOR / 2);

            }

            contenedor.setCoordenadas(x + ancho / 2 - ANCHO_CONTENEDOR / 2, y);

        } catch (Exception e) {
        }
    }

    private int getAncho(Contenedor<ElementoAritmetico> contenedor) {
        int result = 0;
        int espacio = 0;
        try {
            if (contenedor.getHijos().tamano() == 0) {
                return ANCHO_CONTENEDOR;
            }

            for (Contenedor<ElementoAritmetico> hijo : contenedor.getHijos()) {
                result += espacio + getAncho(hijo);
                espacio = ESPACIO_HORIZONTAL;
            }

        } catch (Exception e) {
        }

        return result;
    }

    void registrarClick(int x, int y) {

        revisar(raiz, x, y);

    }

    private void revisar(ArbolAritmetico.Contenedor<ElementoAritmetico> contenedor, int x, int y) {
        if (contenedor != null) {

            if (x > contenedor.getX()) {
                if (x < contenedor.getX() + 50) {
                    if (y > contenedor.getY()) {
                        if (y < contenedor.getY() + 50) {
                            if (contenedor.getContenido().getClass() != Numero.class) {
                                JOptionPane.showMessageDialog(this, "El resultado de dicha operacion es: "+modelo.evaluarContenedor(contenedor));
                                log.debug("Se ha hecho click en "+contenedor.toString());
                            } else {
                            }

                        }
                    }
                }
            }
            try {

                for (Arbol.Contenedor<ElementoAritmetico> hijo : contenedor.getHijos()) {
                    revisar(hijo, x, y);

                }

            } catch (Exception e) {
            }
        }
    }
}
