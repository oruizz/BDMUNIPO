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
public class detalle_solicitud_persona_juridica {
    private String id_detalle_solicitud_persona_juridica;
    private Persona_Juridica obj_pe=new Persona_Juridica();
    private String nombre_solicitud;
    private Proyecto obj_pro=new Proyecto();
    private Articulo obj_ar=new Articulo();
    private Responsable obj_re=new Responsable();
    private Date fecha_solicitud_persona;
    private int estado_solicitud_persona;
    
        public detalle_solicitud_persona_juridica(){
        
    }

    public int getEstado_solicitud_persona() {
        return estado_solicitud_persona;
    }

    public void setEstado_solicitud_persona(int estado_solicitud_persona) {
        this.estado_solicitud_persona = estado_solicitud_persona;
    }

    public Date getFecha_solicitud_persona() {
        return fecha_solicitud_persona;
    }

    public void setFecha_solicitud_persona(Date fecha_solicitud_persona) {
        this.fecha_solicitud_persona = fecha_solicitud_persona;
    }

    public String getId_detalle_solicitud_persona_juridica() {
        return id_detalle_solicitud_persona_juridica;
    }

    public void setId_detalle_solicitud_persona_juridica(String id_detalle_solicitud_persona_juridica) {
        this.id_detalle_solicitud_persona_juridica = id_detalle_solicitud_persona_juridica;
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

    public Persona_Juridica getObj_pe() {
        return obj_pe;
    }

    public void setObj_pe(Persona_Juridica obj_pe) {
        this.obj_pe = obj_pe;
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
