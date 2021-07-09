package arboles;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import arboles.Arbol;
import arboles.Persona;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class FrameArbol extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ArbolAritmetico modelo;
    private JMenuBar men;
    private JMenu menu;
    private JMenu menu2;
    private JMenuItem imenu;
    private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getRootLogger();
    
    public FrameArbol() throws Exception {
        initModelo();
        init();
        log.debug("Iniciado el programa con exito");
    }
    Operador suma2 = new Operador("-");
    
    private void initModelo() throws Exception {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        modelo = new ArbolAritmetico();
        
    }
    
    private void init() {
        men = new JMenuBar();
        menu = new JMenu("Agregar");
        menu2 = new JMenu("Acerca de");
        imenu = new JMenuItem("Cómo usar");
        imenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                mySqlCon conexion = new mySqlCon();
                JOptionPane.showMessageDialog(men, "El programa tiene el proposito de construir un arbol binario a traves de una ecuacion.");
                JOptionPane.showMessageDialog(men, "La ecuacion puede ser de un tamaño considerable y es recomendable agrupar en parentesis.");
                JOptionPane.showMessageDialog(men, "si no se encuentra agrupada, lo hara automaticamente priorizando la ultima operacion.");
            }
        }
        );
        menu2.add(imenu);
        imenu = new JMenuItem("Nueva ecuacion");
        imenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    panelIngresarTexto pan = new panelIngresarTexto(modelo);
                    pan.setVisible(true);
                    
                } catch (Exception ex) {
                    Logger.getLogger(FrameArbol.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        menu2.add(imenu);
        imenu = new JMenuItem("Recuperar ecuacion");
        imenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    panelRecuperar pan = new panelRecuperar(modelo);
                    pan.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(FrameArbol.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        menu.add(imenu);
        men.add(menu);
        men.add(menu2);
        PanelArbol panel = new PanelArbol(modelo);
        modelo.addObserver(panel);
        
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.setJMenuBar(men);
        
        this.pack();
        log.debug("Todo listo, clase FrameArbol ");
    }
    
    public static void main(String[] args) throws Exception {
        FrameArbol frameArbol = new FrameArbol();
        frameArbol.setVisible(true);
    }
}
