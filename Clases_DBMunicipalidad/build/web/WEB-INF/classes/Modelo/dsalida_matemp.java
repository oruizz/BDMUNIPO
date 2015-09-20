/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author user
 */
public class dsalida_matemp {
    private int id_salida_mateemp;
    private int cantidad_material;
    private detalle_solicitud_empresa obj_em= new detalle_solicitud_empresa();
    private Articulo obj_ar=new Articulo();
    private Proyecto obj_pro=new Proyecto();
    private Empresa obj_emp=new Empresa();
    private Date fecha_salida;

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

    public int getId_salida_mateemp() {
        return id_salida_mateemp;
    }

    public void setId_salida_mateemp(int id_salida_mateemp) {
        this.id_salida_mateemp = id_salida_mateemp;
    }

    public Articulo getObj_ar() {
        return obj_ar;
    }

    public void setObj_ar(Articulo obj_ar) {
        this.obj_ar = obj_ar;
    }

    public detalle_solicitud_empresa getObj_em() {
        return obj_em;
    }

    public void setObj_em(detalle_solicitud_empresa obj_em) {
        this.obj_em = obj_em;
    }

    public Empresa getObj_emp() {
        return obj_emp;
    }

    public void setObj_emp(Empresa obj_emp) {
        this.obj_emp = obj_emp;
    }

    public Proyecto getObj_pro() {
        return obj_pro;
    }

    public void setObj_pro(Proyecto obj_pro) {
        this.obj_pro = obj_pro;
    }
    
}
