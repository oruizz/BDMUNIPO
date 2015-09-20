/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Empresa;
import Modelo.Proyecto;
import Modelo.Solicitud;

/**
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class Prueba_Empresa {
     public static void PruebaEmpresa(){
        BeanEmpresa zn1 = new BeanEmpresa();
        Empresa Prueba_Empresa = new Empresa();
        Prueba_Empresa.setRuc_empresa("32546332715");
        Prueba_Empresa.setNombre_empresa("AlonFuker S.A");
        Prueba_Empresa.setTelefono_empresa("302514");
        Prueba_Empresa.setDireccion_empresa("Urb. Las Mercedes F-10 1008");
        zn1.setEmpresa_a(Prueba_Empresa);
        if(zn1.Registrar()){
            System.out.print("Ok " + zn1.getEmpresa_a().getCod_empresa());
        }
        else{
            System.out.print("NO PUDO");
        }
    }
    
    public static void main(String[] args){
        PruebaEmpresa();
    }
      
    public static void prueba_arr_empresa(){
        BeanEmpresa zn1 = new BeanEmpresa();
        System.out.print(zn1.getCargarEmpresa().size());
    }
}
