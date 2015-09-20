/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.*;
import java.sql.Date;


/**
 *
 * @author user
 */
public class pruebadsali {
      public static void Pruebadsali(){
        Beandsalida_matepj zn1 = new Beandsalida_matepj();
         dsalida_matepj Prueba_Sa = new dsalida_matepj();
         
        Prueba_Sa.setCantidad_material(20);
        
        detalle_solicitud_persona_juridica p1 = new detalle_solicitud_persona_juridica();
        p1.setId_detalle_solicitud_persona_juridica("SP000002");
        Prueba_Sa.setObj_pj(p1);
        
        Articulo a = new Articulo();
        a.setCod_articulo("AR000002");
        Prueba_Sa.setObj_ar(a);
        
        Prueba_Sa.setFecha_salida(Date.valueOf("28/06/12"));

        zn1.setDsalidapj_a(Prueba_Sa);
        
        if(zn1.Registrar()){
            System.out.print("Ok " + zn1.getDsalidapj_a().getId_salida_matepj());
        }
        else{
            System.out.print("NO PUDO");
        }
    }
      
          public static void main(String[] args){
        Pruebadsali();
    }
}
