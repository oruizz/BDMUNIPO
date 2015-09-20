/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author L3_PROFESOR
 */
public class GalleriaBean {
     private List<ImagenGall> imagenes;

    public GalleriaBean() {
    imagenes = new ArrayList<ImagenGall>();  
  
       imagenes.add(new ImagenGall("muni-morropon1.jpg", "LOCALIZACION"));  
        imagenes.add(new ImagenGall("muni-morropon2.JPG", "PLAZA DE ARMAS"));  
        imagenes.add(new ImagenGall("muni-morropon3.JPG", "OBRAS DE LA MUNICIPALIDAD"));  
        imagenes.add(new ImagenGall("muni-morropon4.jpg", "INCENTIVANDO LA CULTURA"));  
        imagenes.add(new ImagenGall("muni-morropon5.jpg", "INCENTIVO AL EMPLEO"));  
  
    }

    public List<ImagenGall> getImagenes() {
        return imagenes;
    }
   
}
