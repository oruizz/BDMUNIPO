/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;



/**
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class Empresa {
    
    private String cod_empresa;
    private String ruc_empresa;
    private String nombre_empresa;
    private String telefono_empresa;
    private String direccion_empresa;
    private int estado_empresa;
    
    public Empresa() {        
    }

    public int getEstado_empresa() {
        return estado_empresa;
    }

    public void setEstado_empresa(int estado_empresa) {
        this.estado_empresa = estado_empresa;
    }

    
    public String getCod_empresa() {
        return cod_empresa;
    }

    public void setCod_empresa(String cod_empresa) {
        this.cod_empresa = cod_empresa;
    }

    public String getDireccion_empresa() {
        return direccion_empresa;
    }

    public void setDireccion_empresa(String direccion_empresa) {
        this.direccion_empresa = direccion_empresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getRuc_empresa() {
        return ruc_empresa;
    }

    public void setRuc_empresa(String ruc_empresa) {
        this.ruc_empresa = ruc_empresa;
    }

    public String getTelefono_empresa() {
        return telefono_empresa;
    }

    public void setTelefono_empresa(String telefono_empresa) {
        this.telefono_empresa = telefono_empresa;
    }

    
    
}
