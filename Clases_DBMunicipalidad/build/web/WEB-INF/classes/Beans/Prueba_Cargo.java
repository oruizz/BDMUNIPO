/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Cargo;

/**
 *
 * @author Administrador
 */
public class Prueba_Cargo {
    public static void PruebaCargo(){
        BeanCargo Cn1 = new BeanCargo();
        Cargo Prueba_Cargo = new Cargo(); 
        Prueba_Cargo.setDescripcion_cargo("Jefe Area");
        Cn1.setCargo_a(Prueba_Cargo);
        if(Cn1.Registrar()){
            System.out.print("Ok " + Cn1.getCargo_a().getId_cargo());
        }
        else{
            System.out.print("NO PUDO");
        }
    }
    public static void main(String[] args){
        PruebaCargo();
    }
}
