/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Almacen;
import Modelo.Articulo;
import Modelo.Inventario;
import Modelo.Proveedor;
import Modelo.Proyecto;
import Modelo.Responsable;
import Modelo.detalle_almacen;
import java.sql.Date;

/**
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class Prueba_detalle_almacen {
    public static void Pruebadetaalmacen(){
        Beandetalle_almacen zn1 = new Beandetalle_almacen();
        detalle_almacen Pruebadetaalmacen = new detalle_almacen();
        Responsable r1 = new Responsable();
        r1.setCod_responsable("RE000001");
        Pruebadetaalmacen.setObj_res(r1);
        Almacen l1=new Almacen();
        l1.setCod_almacen("AL000003");
        Pruebadetaalmacen.setObj_al(l1);
        Articulo t1 = new Articulo();
        t1.setCod_articulo("AR000002");
        Pruebadetaalmacen.setObj_ar(t1);
        Proyecto p1 = new Proyecto();
        p1.setId_proyecto("PR000001");
        Pruebadetaalmacen.setObj_pro(p1);
        Proveedor o1=new Proveedor();
        o1.setId_proveedor("PD000004");
        Pruebadetaalmacen.setObj_ve(o1);
        Inventario v1 =new Inventario();
        v1.setId_inventario("IN000003");
        Pruebadetaalmacen.setObj_in(v1);      
        Pruebadetaalmacen.setFecha_entrada(Date.valueOf("2012-01-01"));
        Pruebadetaalmacen.setFecha_salidad(Date.valueOf("2012-05-01"));
        zn1.setDetaalmacen_a(Pruebadetaalmacen);
        if(zn1.Registrar()){
            System.out.print("Ok " + zn1.getDetaalmacen_a().getId_detalle_almacen());
        }
        else{
            System.out.print("NO PUDO");
        }
    }
    
    public static void main(String[] args){
        Pruebadetaalmacen();
    }
      
    public static void prueba_arr_detalle_almacen(){
        Beandetalle_almacen zn1 = new Beandetalle_almacen();
        System.out.print(zn1.getCargardetalle_almacen().size());
    }
}
