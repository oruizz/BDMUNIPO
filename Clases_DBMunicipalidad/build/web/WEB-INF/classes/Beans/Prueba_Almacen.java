/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Almacen;

/**
 *
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class Prueba_Almacen {
    public static void PruebaAlmacen(){
        BeanAlmacen zn1 = new BeanAlmacen();
        Almacen Prueba_Almacen = new Almacen();
        Prueba_Almacen.setNombre("NAVARRETE");
        Prueba_Almacen.setEstado_almacen(0);
        zn1.setAlmacen_a(Prueba_Almacen);
        if(zn1.Registrar()){
            System.out.print("Ok " + zn1.getAlmacen_a().getCod_almacen());
        }
        else{
            System.out.print("NO PUDO");
        }
    }
    
    public static void main(String[] args){
        PruebaAlmacen();
    }
      
    public static void prueba_arr_almacen(){
        BeanAlmacen zn1 = new BeanAlmacen();
        System.out.print(zn1.getCargarAlmacen().size());
    }
}
