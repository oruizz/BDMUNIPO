/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Com;

import Modelo.Persona_Juridica;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class ultimasxsolicitudxpj {
    private String id_detalle_solicitud_persona_juridica;
    private String nombre_solicitud;
    private Date fecha_solicitud_persona;
    private int estado_solicitud_persona;
    private Persona_Juridica obj_pj=new Persona_Juridica();

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

    public Persona_Juridica getObj_pj() {
        return obj_pj;
    }

    public void setObj_pj(Persona_Juridica obj_pj) {
        this.obj_pj = obj_pj;
    }
    
    
    
}
