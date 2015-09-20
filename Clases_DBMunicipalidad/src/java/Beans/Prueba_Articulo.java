/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Articulo;

/**
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class Prueba_Articulo {
     public static void PruebaArticulo(){
        BeanArticulo zn1 = new BeanArticulo();
        Articulo Prueba_Articulo = new Articulo();
        Prueba_Articulo.setNombre_articulo("Vidrios");
        zn1.setArticulo_a(Prueba_Articulo);
        if(zn1.Registrar()){
            System.out.print("Ok " + zn1.getArticulo_a().getCod_articulo());
        }
        else{
            System.out.print("NO PUDO");
        }
    }
    
    public static void main(String[] args){
        PruebaArticulo();
    }
    
    public static void prueba_arr_articulo(){
        BeanArticulo zn1 = new BeanArticulo();
        System.out.print(zn1.getCargarArticulo().size());
    }
}
