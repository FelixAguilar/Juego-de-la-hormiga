package Board;

import Images.Images; //Paquete que contiene las imagenes.

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import javax.swing.JPanel;

/**
 * Clase Tablero. Contiene el PaintComponent para el tablero.
 * 
 * @author Felix Lluis Aguilar Ferrer.
 */
public class Board extends JPanel{
    
    //Tamaño del tablero de lateral.
    public static final int DIMENSION = 20;
    
    //Matriz de casillas para el trablero.
    private Square square[][] = new Square[DIMENSION][DIMENSION];
    
    /**
     * Constructor. Implementa las casillas que tendra el tablero.
     * 
     * @throws IOException 
     */
    public Board() throws IOException{
            for (int i = 0; i < DIMENSION; i++) {
                for (int j = 0; j < DIMENSION; j++) {
                    square[i][j] = new Square();
                }
            }
    }

    /**
     * Metodo para imponer una nueva imagen a la casilla. Mediante la posicion
     * introducida por parametro y la imagen que se quiere imponer introducida
     * de igual manera se modifica una casilla. (Al modificarla tambien se 
     * modifica el filled de casilla).
     * 
     * @param img
     * @param pos
     * @throws IOException 
     */
    public void setBox(Image img, int[] pos) throws IOException {
        this.square[pos[0]][pos[1]].setImage(img);
    }
    
    /**
     * Se devuele el valor de filled. Devuele el valor actual del aributo filled
     * de la casilla indicada por la posicion introducida por parametro.
     * 
     * @param pos
     * @return 
     */
    public boolean isModified(int[] pos){
        return square[pos[0]][pos[1]].isModified(); 
    }
    
    /**
     * Metodo para Pintar el tablero. No se necesita utilizar, este se 
     * autoejecuta cada vez que hay un cambio en la clase. Este dibuja cada 
     * casilla rodeada de un rectangulo y el dibuja la imagen encima indicada en
     * los atributos de la casilla.
     * 
     * @param g 
     */
     @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                Rectangle2D rectangle = new Rectangle2D.Double(Images.SIZE * i,
                        Images.SIZE * j, Images.SIZE, Images.SIZE);
                Graphics2D g2d = (Graphics2D) g; 
                g2d.drawImage(square[i][j].getImage(), Images.SIZE * i, 
                        Images.SIZE * j, null);
                g2d.draw(rectangle);
            }
        }
        repaint();
    }
}
    
    

