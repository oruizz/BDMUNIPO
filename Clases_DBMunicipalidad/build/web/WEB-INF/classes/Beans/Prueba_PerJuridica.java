/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Persona_Juridica;
import Modelo.Proyecto;
import Modelo.Solicitud;

/**
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class Prueba_PerJuridica {
    public static void PruebaPersona_Juridica(){
        BeanPersona_Juridica zn1 = new BeanPersona_Juridica();
        Persona_Juridica Prueba_PerJuridica = new Persona_Juridica();
        Prueba_PerJuridica.setRuc_persona("65482167812");
        Prueba_PerJuridica.setNombre_persona("Julian");
        Prueba_PerJuridica.setApellido_persona("Huerto Ruiz");
        Prueba_PerJuridica.setDireccion_persona("Av. Grau 1801");
        zn1.setJuridica_a(Prueba_PerJuridica);
        
        if(zn1.Registrar()){
            System.out.print("Ok " + zn1.getJuridica_a().getCod_persona());
        }
        else{
            System.out.print("NO PUDO");
        }
    }
    
    public static void main(String[] args){
        PruebaPersona_Juridica();
    }
      
    public static void prueba_arr_Persona_Juridica(){
        BeanPersona_Juridica zn1 = new BeanPersona_Juridica();
        System.out.print(zn1.getCargarPersona_Juridica().size());
    }
}
