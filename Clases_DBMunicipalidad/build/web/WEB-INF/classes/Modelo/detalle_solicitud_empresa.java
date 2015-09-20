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
public class detalle_solicitud_empresa {
    private String id_detalle_solicitud_empresa;
    private Empresa obj_em=new Empresa();
    private String nombre_solicitud;
    private Responsable obj_re=new Responsable();
    private Proyecto obj_pro=new Proyecto();
    private Articulo obj_ar=new Articulo();
    private Date fecha_solicitud_empresa;
    private int estado_solicitud_empresa;
    
    public detalle_solicitud_empresa(){
        
    }

    public int getEstado_solicitud_empresa() {
        return estado_solicitud_empresa;
    }

    public void setEstado_solicitud_empresa(int estado_solicitud_empresa) {
        this.estado_solicitud_empresa = estado_solicitud_empresa;
    }

    public Date getFecha_solicitud_empresa() {
        return fecha_solicitud_empresa;
    }

    public void setFecha_solicitud_empresa(Date fecha_solicitud_empresa) {
        this.fecha_solicitud_empresa = fecha_solicitud_empresa;
    }

    public String getId_detalle_solicitud_empresa() {
        return id_detalle_solicitud_empresa;
    }

    public void setId_detalle_solicitud_empresa(String id_detalle_solicitud_empresa) {
        this.id_detalle_solicitud_empresa = id_detalle_solicitud_empresa;
    }

    public String getNombre_solicitud() {
        return nombre_solicitud;
    }

    public void setNombre_solicitud(String nombre_solicitud) {
        this.nombre_solicitud = nombre_solicitud;
    }

    public Articulo getObj_ar() {
        return obj_ar;
    }

    public void setObj_ar(Articulo obj_ar) {
        this.obj_ar = obj_ar;
    }

    public Empresa getObj_em() {
        return obj_em;
    }

    public void setObj_em(Empresa obj_em) {
        this.obj_em = obj_em;
    }

    public Proyecto getObj_pro() {
        return obj_pro;
    }

    public void setObj_pro(Proyecto obj_pro) {
        this.obj_pro = obj_pro;
    }

    public Responsable getObj_re() {
        return obj_re;
    }

    public void setObj_re(Responsable obj_re) {
        this.obj_re = obj_re;
    }

    
   

   
    
    
}
