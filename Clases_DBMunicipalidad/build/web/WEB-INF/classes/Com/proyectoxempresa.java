/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Com;

import Modelo.Empresa;
import Modelo.Proyecto;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class proyectoxempresa {
    private String id_detalle_solicitud_empresa;
    private Empresa obj_emp= new Empresa();
    private String nombre_solicitud;
    private Date fecha_solicitud;
    private int estado_solicitud;
    private Proyecto obj_pr= new Proyecto();

    public int getEstado_solicitud() {
        return estado_solicitud;
    }

    public void setEstado_solicitud(int estado_solicitud) {
        this.estado_solicitud = estado_solicitud;
    }

    public Date getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(Date fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
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

    public Empresa getObj_emp() {
        return obj_emp;
    }

    public void setObj_emp(Empresa obj_emp) {
        this.obj_emp = obj_emp;
    }

    public Proyecto getObj_pr() {
        return obj_pr;
    }

    public void setObj_pr(Proyecto obj_pr) {
        this.obj_pr = obj_pr;
    }
    
    
    
}
