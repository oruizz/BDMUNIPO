/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Proyecto;

/**
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class Prueba_Proyecto {
     public static void PruebaProyecto(){
        BeanProyecto zn1 = new BeanProyecto();
        Proyecto Prueba_Proyecto = new Proyecto();
        Prueba_Proyecto.setNombre_proyecto("Mantenimiento De Plazas");
        zn1.setProyecto_a(Prueba_Proyecto);
        if(zn1.Registrar()){
            System.out.print("Ok " + zn1.getProyecto_a().getId_proyecto());
        }
        else{
            System.out.print("NO PUDO");
        }
    }
    
    public static void main(String[] args){
        PruebaProyecto();
    }
    
    public static void prueba_arr_proyecto(){
        BeanProyecto zn1 = new BeanProyecto();
        System.out.print(zn1.getCargarProyecto().size());
    }
}
