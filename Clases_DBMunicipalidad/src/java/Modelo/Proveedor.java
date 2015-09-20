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
public class Proveedor {
    private String id_proveedor;
    private String ruc_proveedor;
    private String nombre_proveedor;
    private String telefono_proveedor;
    private String direccion_proveedor;
    private String ciudad_proveedor;
    private String servicio_proveedor;
    private String fax_proveedor;
    private int estado_proveedor;
    
      public Proveedor() {        
    }

    public int getEstado_proveedor() {
        return estado_proveedor;
    }

    public void setEstado_proveedor(int estado_proveedor) {
        this.estado_proveedor = estado_proveedor;
    }

      
    public String getCiudad_proveedor() {
        return ciudad_proveedor;
    }

    public void setCiudad_proveedor(String ciudad_proveedor) {
        this.ciudad_proveedor = ciudad_proveedor;
    }

    public String getFax_proveedor() {
        return fax_proveedor;
    }

    public void setFax_proveedor(String fax_proveedor) {
        this.fax_proveedor = fax_proveedor;
    }

    public String getServicio_proveedor() {
        return servicio_proveedor;
    }

    public void setServicio_proveedor(String servicio_proveedor) {
        this.servicio_proveedor = servicio_proveedor;
    }


      
    public String getDireccion_proveedor() {
        return direccion_proveedor;
    }

    public void setDireccion_proveedor(String direccion_proveedor) {
        this.direccion_proveedor = direccion_proveedor;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getRuc_proveedor() {
        return ruc_proveedor;
    }

    public void setRuc_proveedor(String ruc_proveedor) {
        this.ruc_proveedor = ruc_proveedor;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }
   
    

    
}
