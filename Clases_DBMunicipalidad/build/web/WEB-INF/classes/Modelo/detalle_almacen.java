/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;



/**
 *
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class detalle_almacen {
    
    private String id_detalle_almacen;
    private Responsable obj_res=new Responsable();
    private Almacen obj_al=new Almacen();
    private Articulo obj_ar=new Articulo();
    private Proyecto obj_pro=new Proyecto();
    private Proveedor obj_ve=new Proveedor();
    private Inventario obj_in=new Inventario();
    private Date fecha_entrada;
    private Date fecha_salidad;

   
    public detalle_almacen(){
        
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public Date getFecha_salidad() {
        return fecha_salidad;
    }

    public void setFecha_salidad(Date fecha_salidad) {
        this.fecha_salidad = fecha_salidad;
    }

    public String getId_detalle_almacen() {
        return id_detalle_almacen;
    }

    public void setId_detalle_almacen(String id_detalle_almacen) {
        this.id_detalle_almacen = id_detalle_almacen;
    }

    public Almacen getObj_al() {
        return obj_al;
    }

    public void setObj_al(Almacen obj_al) {
        this.obj_al = obj_al;
    }

    public Articulo getObj_ar() {
        return obj_ar;
    }

    public void setObj_ar(Articulo obj_ar) {
        this.obj_ar = obj_ar;
    }

    public Inventario getObj_in() {
        return obj_in;
    }

    public void setObj_in(Inventario obj_in) {
        this.obj_in = obj_in;
    }

    public Proyecto getObj_pro() {
        return obj_pro;
    }

    public void setObj_pro(Proyecto obj_pro) {
        this.obj_pro = obj_pro;
    }

    public Responsable getObj_res() {
        return obj_res;
    }

    public void setObj_res(Responsable obj_res) {
        this.obj_res = obj_res;
    }

    public Proveedor getObj_ve() {
        return obj_ve;
    }

    public void setObj_ve(Proveedor obj_ve) {
        this.obj_ve = obj_ve;
    }

   
}
