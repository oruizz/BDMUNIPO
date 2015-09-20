/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Administrador
 */
public class ordenproveedor {
     private int id_dentrada_materpo;
    private int cantidad_material;
    private detalle_solicitud_proveedor obj_pr= new detalle_solicitud_proveedor();
    private Articulo obj_ar=new Articulo();
    private Proveedor obj_por=new Proveedor();
    private Date fecha_entrada;
    private double precio_articulo;
    
    public ordenproveedor(){
    
     }

    public double getPrecio_articulo() {
        return precio_articulo;
    }

    public void setPrecio_articulo(double precio_articulo) {
        this.precio_articulo = precio_articulo;
    }

    
    public int getCantidad_material() {
        return cantidad_material;
    }

    public void setCantidad_material(int cantidad_material) {
        this.cantidad_material = cantidad_material;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public int getId_dentrada_materpo() {
        return id_dentrada_materpo;
    }

    public void setId_dentrada_materpo(int id_dentrada_materpo) {
        this.id_dentrada_materpo = id_dentrada_materpo;
    }

   

  

    public Articulo getObj_ar() {
        return obj_ar;
    }

    public void setObj_ar(Articulo obj_ar) {
        this.obj_ar = obj_ar;
    }

    public Proveedor getObj_por() {
        return obj_por;
    }

    public void setObj_por(Proveedor obj_por) {
        this.obj_por = obj_por;
    }

    public detalle_solicitud_proveedor getObj_pr() {
        return obj_pr;
    }

    public void setObj_pr(detalle_solicitud_proveedor obj_pr) {
        this.obj_pr = obj_pr;
    }    
    
    
}
