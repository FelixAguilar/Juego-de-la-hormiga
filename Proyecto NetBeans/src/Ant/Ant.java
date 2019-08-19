package Ant;

import Board.Board; //Paquete que contiene las Tablero. 
import Images.Images; //Paquete que contiene las imagenes.

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

/**
 * Clase hormiga. En esta estan todos los atributos relacionados con hormiga y
 * los metodos que permiten a esta moverse por el tablero.
 * 
 * @author Felix Lluis Aguilar Ferrer.
 */
public class Ant {
    private int[] pos = new int[2]; //Vector posicion.
    private Direction direction; //Hacia donde mira la hormiga.
    private Image image; //Imagen de la hormiga.

    /**
     * Constructor. Pone la hormiga en una posicion al azar dentro de los
     * limites del tablero. Ademas se le asigna una imagen inicial y su 
     * respectiva direccion.
     * 
     * @throws IOException 
     */
    public Ant() throws IOException {
        Random rand = new Random();
        Images img = new Images();
        
        this.pos[0] = rand.nextInt(Board.DIMENSION);
        this.pos[1] = rand.nextInt(Board.DIMENSION);
        this.image =  img.getImage(Images.ANTN);
        this.direction = Direction.NORTH;
    }
    
    /**
     * Metodo para obtener la posicion.
     * 
     * @return 
     */
    public int[] getPos() {
        return pos;
    }

    /**
     * Metodo para inponer una posicion.
     * 
     * @param pos 
     */
    public void setPos(int[] pos) {
        this.pos = pos;
    }
    
    /**
     * Metodo para inponer una imagen.
     * 
     * @param image 
     */
    public void setImage(Image image){
        this.image = image;
    }
    
    /**
     * Metodo para obtener la imagen.
     * 
     * @return 
     */
    public Image getImage(){
        return image;
    }
    
    /**
     * Metodo para el movimiento de la hormiga. Realiza el movimiento en una 
     * posicion de la hormiga hacia la direccion a la que apunta. En el caso de
     * llegar al final del tablero, esta se desplaza a la posicion opuesta de
     * este.
     * 
     */
    public void move(){
        
        //Movimiento segun la direccion.
        switch (this.direction) {
            case NORTH:
                pos[1]--;
                break;
            case SOUTH:
                pos[1]++;
                break;
            case WEST:
                pos[0]--;
                break;
            case EAST:
                pos[0]++;
                break;
        }
        
        //Se comprueba que la posicion no indique una casilla fuera del tablero.
        if (pos[0] >= Board.DIMENSION){
            pos[0] = 0;
        }else if(pos[1] >= Board.DIMENSION){
            pos[1] = 0;
        }else if(pos[0] < 0){
            pos[0] = Board.DIMENSION-1;
        }else if(pos[1] < 0){
            pos[1] = Board.DIMENSION-1;
        }
    }
    
    /**
     * Metodo para rotar a la hormiga. Realiza la rotacion de la hormiga segun
     * la tecla pulsada por el usuario, cambiando la direccion a la indicada y 
     * se actualiza la imagen de la hormiga por la correspondiente a la
     * direccion.
     * 
     * @param key
     * @throws IOException 
     */
    public void rotate(int key) throws IOException{
        
        Images img = new Images(); //Se instancia la clase imagenes.
        
        /* Se comprueba que tecla se ha presionado y si coincide entonces se 
        realiza el cambio en la direccion pertinente. */
        switch (key) {
            case KeyEvent.VK_UP:
                this.image = img.getImage(Images.ANTN);
                this.direction = Direction.NORTH;
            break;
            case KeyEvent.VK_DOWN:
                this.image = img.getImage(Images.ANTS);
                this.direction = Direction.SOUTH;
            break;
            case KeyEvent.VK_LEFT:
                this.image = img.getImage(Images.ANTW);
                this.direction = Direction.WEST;
            break;
            case KeyEvent.VK_RIGHT:
                this.image = img.getImage(Images.ANTE);
                this.direction = Direction.EAST;
            break;
        }
    }
}
