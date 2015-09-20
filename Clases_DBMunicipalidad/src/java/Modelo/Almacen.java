/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class Almacen {
    private String cod_almacen;
    private String nombre;
    private String telefono_almacen;
    private String direccion_almacen;
    private String fax_almacen;
    private int estado_almacen;

     public Almacen() {        
    }

    public String getDireccion_almacen() {
        return direccion_almacen;
    }

    public void setDireccion_almacen(String direccion_almacen) {
        this.direccion_almacen = direccion_almacen;
    }

    public String getFax_almacen() {
        return fax_almacen;
    }

    public void setFax_almacen(String fax_almacen) {
        this.fax_almacen = fax_almacen;
    }

    public String getTelefono_almacen() {
        return telefono_almacen;
    }

    public void setTelefono_almacen(String telefono_almacen) {
        this.telefono_almacen = telefono_almacen;
    }

     
    public String getCod_almacen() {
        return cod_almacen;
    }

    public void setCod_almacen(String cod_almacen) {
        this.cod_almacen = cod_almacen;
    }

    public int getEstado_almacen() {
        return estado_almacen;
    }

    public void setEstado_almacen(int estado_almacen) {
        this.estado_almacen = estado_almacen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

  
    
    
}
