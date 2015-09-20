/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Com;

import Modelo.Articulo;
import Modelo.Proveedor;
import Modelo.Proyecto;
import Modelo.Solicitud;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class activosxsolicitudxproveedor {
    private String id_detalle_proveedor;
    private Proyecto obj_p=new Proyecto();
    private Articulo obj_a= new Articulo();
    private Solicitud obj_so= new Solicitud();
    private Proveedor obj_pro= new Proveedor();
    private Date fecha_solicitud_proveedor;
    private int estado_solicitud_proveedor;

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

    public Articulo getObj_a() {
        return obj_a;
    }

    public void setObj_a(Articulo obj_a) {
        this.obj_a = obj_a;
    }

    public Proyecto getObj_p() {
        return obj_p;
    }

    public void setObj_p(Proyecto obj_p) {
        this.obj_p = obj_p;
    }

    public Proveedor getObj_pro() {
        return obj_pro;
    }

    public void setObj_pro(Proveedor obj_pro) {
        this.obj_pro = obj_pro;
    }

    public Solicitud getObj_so() {
        return obj_so;
    }

    public void setObj_so(Solicitud obj_so) {
        this.obj_so = obj_so;
    }
    
    
    
}
