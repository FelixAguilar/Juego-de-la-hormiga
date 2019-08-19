package Images; //Paquete que contiene las imagenes.

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Clase Imagen. En esta se encuentran las direcciones a las diferentes imagenes
 * y el metodo para obtenerlas de los ficheros.
 * 
 * @author Felix Lluis Aguilar Ferrer.
 */
public class Images {
    
    //Tamaño lateral de las imagenes.
    public static final int SIZE = 40;
    
    //Conjunto de Imagenes que se pueden usar.
    public static final String ANTW = "Images/hormiga_o.png";
    public static final String ANTN = "Images/hormiga_n.png";
    public static final String ANTE = "Images/hormiga_e.png";
    public static final String ANTS = "Images/hormiga_s.png";
    public static final String LEAF = "Images/hoja.png";
    public static final String EMPTY = "Images/nada.png";
    
    /**
     * Metodo para obtener una imagen. Devuelve la imagen correspondiente al 
     * Path introducido por el parametro de entrada.
     * 
     * @param s
     * @return
     * @throws IOException 
     */
    public Image getImage(String s) throws IOException{
        return ImageIO.read(new File(s));
    }
   
}
