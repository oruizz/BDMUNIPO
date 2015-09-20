/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Proveedor;

/**
 * @author ruiz zapata oscar
 * @author agramonte rey  Wilmer
 */
public class Prueba_Proveedor {
    public static void PruebaProveedor(){
        BeanProveedor zn1 = new BeanProveedor();
        Proveedor Prueba_Proveedor = new Proveedor();
        Prueba_Proveedor.setRuc_proveedor("32154872648");
        Prueba_Proveedor.setNombre_proveedor("Cementos Luna S.A");
        Prueba_Proveedor.setTelefono_proveedor("541254");
        Prueba_Proveedor.setDireccion_proveedor("AHH. Los Cocos 102 Lt 10");
        
        zn1.setProveedor_a(Prueba_Proveedor);
        if(zn1.Registrar()){
            System.out.print("Ok " + zn1.getProveedor_a().getId_proveedor());
        }
        else{
            System.out.print("NO PUDO");
        }
    }
    
    public static void main(String[] args){
        PruebaProveedor();
    }
      
    public static void prueba_arr_proveedor(){
        BeanProveedor zn1 = new BeanProveedor();
        System.out.print(zn1.getCargarProveedor().size());
    }
}
