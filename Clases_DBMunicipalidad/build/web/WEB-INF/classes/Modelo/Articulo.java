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
public class Articulo {
    private String cod_articulo;
    private String nombre_articulo;
    private String marca_articulo;
    private String descripcion_articulo;
    private int cantidad_articulo;
    private String tipo_material;
    private double precio_articulo;

    
        public Articulo() {        
    }

    public int getCantidad_articulo() {
        return cantidad_articulo;
    }

    public void setCantidad_articulo(int cantidad_articulo) {
        this.cantidad_articulo = cantidad_articulo;
    }

    public String getCod_articulo() {
        return cod_articulo;
    }

    public void setCod_articulo(String cod_articulo) {
        this.cod_articulo = cod_articulo;
    }

    public String getDescripcion_articulo() {
        return descripcion_articulo;
    }

    public void setDescripcion_articulo(String descripcion_articulo) {
        this.descripcion_articulo = descripcion_articulo;
    }

    public String getMarca_articulo() {
        return marca_articulo;
    }

    public void setMarca_articulo(String marca_articulo) {
        this.marca_articulo = marca_articulo;
    }

    public String getNombre_articulo() {
        return nombre_articulo;
    }

    public void setNombre_articulo(String nombre_articulo) {
        this.nombre_articulo = nombre_articulo;
    }

    public double getPrecio_articulo() {
        return precio_articulo;
    }

    public void setPrecio_articulo(double precio_articulo) {
        this.precio_articulo = precio_articulo;
    }

    public String getTipo_material() {
        return tipo_material;
    }

    public void setTipo_material(String tipo_material) {
        this.tipo_material = tipo_material;
    }

 
   
}
