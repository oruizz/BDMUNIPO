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
public class dsalida_matepj {
    private int id_salida_matepj;
    private int cantidad_material;
    private detalle_solicitud_persona_juridica obj_pj= new detalle_solicitud_persona_juridica();
    private Articulo obj_ar=new Articulo();
    private Proyecto obj_pro=new Proyecto();
    private Persona_Juridica obj_per=new Persona_Juridica();
    private Date fecha_salida;
    
    public dsalida_matepj(){
    
     }

    public int getCantidad_material() {
        return cantidad_material;
    }

    public void setCantidad_material(int cantidad_material) {
        this.cantidad_material = cantidad_material;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public int getId_salida_matepj() {
        return id_salida_matepj;
    }

    public void setId_salida_matepj(int id_salida_matepj) {
        this.id_salida_matepj = id_salida_matepj;
    }

    public Articulo getObj_ar() {
        return obj_ar;
    }

    public void setObj_ar(Articulo obj_ar) {
        this.obj_ar = obj_ar;
    }

    public Persona_Juridica getObj_per() {
        return obj_per;
    }

    public void setObj_per(Persona_Juridica obj_per) {
        this.obj_per = obj_per;
    }

    public detalle_solicitud_persona_juridica getObj_pj() {
        return obj_pj;
    }

    public void setObj_pj(detalle_solicitud_persona_juridica obj_pj) {
        this.obj_pj = obj_pj;
    }

    public Proyecto getObj_pro() {
        return obj_pro;
    }

    public void setObj_pro(Proyecto obj_pro) {
        this.obj_pro = obj_pro;
    }

 
    
   
    
}
