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
public class detalle_solicitud_proveedor {
    private String id_detalle_proveedor;
    private Proveedor obj_ve=new Proveedor();
    private Articulo obj_ar=new Articulo();
    private Solicitud obj_ds= new Solicitud();
    private Date fecha_solicitud_proveedor;
    private int estado_solicitud_proveedor;

    
    public detalle_solicitud_proveedor(){
        
    }
    

    public int getEstado_solicitud_proveedor() {
        return estado_solicitud_proveedor;
    }

    public void setEstado_solicitud_proveedor(int estado_solicitud_proveedor) {
        this.estado_solicitud_proveedor = estado_solicitud_proveedor;
    }

    public Date getFecha_solicitud_proveedor() {
        return fecha_solicitud_proveedor;
    }

    public void setFecha_solicitud_proveedor(Date fecha_solicitud_proveedor) {
        this.fecha_solicitud_proveedor = fecha_solicitud_proveedor;
    }

    public String getId_detalle_proveedor() {
        return id_detalle_proveedor;
    }

    public void setId_detalle_proveedor(String id_detalle_proveedor) {
        this.id_detalle_proveedor = id_detalle_proveedor;
    }

    public Articulo getObj_ar() {
        return obj_ar;
    }

    public void setObj_ar(Articulo obj_ar) {
        this.obj_ar = obj_ar;
    }



    public Solicitud getObj_ds() {
        return obj_ds;
    }

    public void setObj_ds(Solicitud obj_ds) {
        this.obj_ds = obj_ds;
    }

   
  

    public Proveedor getObj_ve() {
        return obj_ve;
    }

    public void setObj_ve(Proveedor obj_ve) {
        this.obj_ve = obj_ve;
    }

    

   

       
}
