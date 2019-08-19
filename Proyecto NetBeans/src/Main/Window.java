package Main;

import Ant.Ant; //Paquete que contiene hormiga.
import Board.Board; //Paquete que contiene las Tablero.
import Images.Images; //Paquete que contiene las imagenes.

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Programa Principal. Contiene la ventana y sus metodos relacionados.
 * 
 * @author Felix Lluis Aguilar Ferrer.
 */
public class Window extends JFrame{
    
    
    static public Window w;
    public Board board;
    public Ant ant;
    
    public Dimension size = new Dimension((Board.DIMENSION * Images.SIZE) + 17,
            (Board.DIMENSION * Images.SIZE) + 40);
    public String title = "El juego de la hormiga";
    
    public int count = 1; //Se inicia a 1 por la posicion de la hormiga.
    
    /**
     * Constructor de la ventana.
     * 
     * @throws IOException 
     */
    public Window() throws IOException{
        this.setTitle(title);
        this.setSize(size);
        this.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
        this.initContents();
        KeyListeners keylisteners = new KeyListeners();
        this.addKeyListener(keylisteners);
        this.setFocusable(true);
    }
    
    /**
     * Componentes relacionados con la ventana.
     * 
     * @throws IOException 
     */
    private void initContents() throws IOException{ 
        
        //Creación del Layout principal.
        JPanel window = (JPanel) getContentPane();
        
        //Inicializacion de tablero y hormiga.
        board = new Board();
        ant = new Ant();
        
        //Se añade el tablero a la ventana.
        window.add(board);
        
        //Se añade la hormiga al tablero.
        board.setBox(ant.getImage(), ant.getPos());
    }
    
    /**
     * Inicio del programa. Da visibilidad a la ventana.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        try {
            w = new Window();
            w.setVisible(true);
        } catch (IOException ex) {
            System.out.println(ex.getMessage()); //Imprimir el error.
        }
    }
    
    /**
     * Clase escuchador de teclado. Implementa todas las acciones a realizar
     * al producirse un evento de teclado.
     * 
     * @author Felix Lluis Aguilar Ferrer.
     */
    public class KeyListeners implements KeyListener{
        
        /**
         * Si se produce una presion de tecla. Es donde se realizarán las
         * acciones pertinentes del programa.
         * 
         * @param e 
         */
        @Override
        public void keyPressed(KeyEvent e) {
            
            try {
                int key = e.getKeyCode(); //Se obtiene el valor de la tecla.
                switch(key){
                    
                    //Si se ha pulsado la barra espaciadora se avanza.
                    case KeyEvent.VK_SPACE:
                        
                        Images img = new Images();
                        
                        //Se impone la imagen vacia en la posicion de la hormiga.
                        board.setBox(img.getImage(Images.EMPTY), ant.getPos());
                        
                        //Se realiza el movimiento de la hormiga.
                        ant.move();
                        
                        //Si habua una hoja se suma uno a la cuenta.
                        if(board.isModified(ant.getPos())){
                            count++;
                        }
                        
                        //Se impone la imagen de la hormiga en la posicion nueva.
                        board.setBox(ant.getImage(), ant.getPos());     
                    break;
                    default:
                        
                        //Se rota la hormiga a hacia la direccion indicada.
                        ant.rotate(key);
                        
                        //Se actualiza la imagen de la hormiga en el tablero.
                        board.setBox(ant.getImage(), ant.getPos());
                    break;
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            
            /* Si se han limpiado todas las hojas aparece el popup siguiente. y 
            se cierra el programa. */
            if(count == (Board.DIMENSION * Board.DIMENSION)){
                JOptionPane.showMessageDialog(w, "ENHORABUENA \n ¡¡¡has "
                        + "completado el juego!!! \n LA HORMIGA SE HA COMIDO "
                        + "TODAS LAS HOJAS");
                w.dispatchEvent(new WindowEvent(w, WindowEvent.WINDOW_CLOSING));
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            //No se realiza ninguna accion.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //No se realiza ninguna accion.
        }  
    }
}
