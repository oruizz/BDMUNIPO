/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Com;

/**
 *
 * @author user
 */
public class TotalArticulosxSolixPersonaJuridica {
    private String nombre_persona;
    private double precio_total;
    private int cantidad;
    
    
    //===========================================================================

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }
    
}
