/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Empresa;

/**
 *
 * @author user
 */
public class prueba_actualizarempresa {
    public static void PruebaEmpresa(){
        BeanEmpresa zn1 = new BeanEmpresa();
        Empresa Prueba_Empresa = new Empresa();
        Prueba_Empresa.setCod_empresa("EM000001");
        Prueba_Empresa.setRuc_empresa("22222222222");
        Prueba_Empresa.setNombre_empresa("Alonr S.A");
        Prueba_Empresa.setTelefono_empresa("302344");
        Prueba_Empresa.setDireccion_empresa("Urb. Las Mercedes 1008");
        zn1.setEmpresa_a(Prueba_Empresa);
        if(zn1.Actualizar()){
            System.out.print("Ok " + zn1.getEmpresa_a().getCod_empresa());
        }
        else{
            System.out.print("NO PUDO");
        }
    }
    
    public static void main(String[] args){
        PruebaEmpresa();
    }
      
}
