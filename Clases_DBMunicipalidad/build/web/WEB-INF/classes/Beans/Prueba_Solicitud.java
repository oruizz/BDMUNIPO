/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Responsable;
import Modelo.Solicitud;

/**
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class Prueba_Solicitud {
     public static void PruebaSolicitud(){
        BeanSolicitud zn1 = new BeanSolicitud();
        Solicitud Prueba_Solicitud = new Solicitud();
        Prueba_Solicitud.setNombre_solicitud("Madagascar");
        zn1.setSolicitud_a(Prueba_Solicitud);
        if(zn1.Registrar()){
            System.out.print("Ok " + zn1.getSolicitud_a().getCod_solicitud());
        }
        else{
            System.out.print("NO PUDO");
        }
    }
    
    public static void main(String[] args){
        PruebaSolicitud();
    }
    
     public static void prueba_arr_solicitud(){
        BeanSolicitud rn1 = new BeanSolicitud();
        System.out.print(rn1.getCargarSolicitud().size());
    }
    
}
