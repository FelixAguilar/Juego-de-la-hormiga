package Board;

import Images.Images; //Paquete que contiene las imagenes.

import java.awt.Image;
import java.io.IOException;

/**
 * Clase Casilla. En esta se define las propiedades de una casilla del tablero.
 * 
 * @author Felix Lluis Aguilar Ferrer.
 */
public class Square {
    
    private Image image; //Imagen de la casilla.
    private boolean modified; //Para saber si se ha modificado o no.

    /**
     * Constructor. Inicializa la casilla con la imagen de la hoja en todas y el
     * atributo filled en true ya que se utiliza par indicar si se ha 
     * modificado.
     * 
     * @throws IOException 
     */
    public Square() throws IOException {
        Images img = new Images();
        this.image = img.getImage(Images.LEAF);
        this.modified = true; //Para saber si se ha modificado o no.
    }

    /**
     * Metodo para obtenre la imagen.
     * 
     * @return 
     */
    public Image getImage(){
        return image;
    }

    /**
     * Metodo para imponer la imagen. Se modifica el modified a false.
     * 
     * @param img 
     */
    public void setImage(Image img){
        this.image = img;
        
        //Si se modifica del estado inicial no se puede revertir.
        this.modified = false;
    }
    
    /**
     * Metodo para obtener el boolean de modified.
     * 
     * @return 
     */
    public boolean isModified(){
        return modified;
    }
}
