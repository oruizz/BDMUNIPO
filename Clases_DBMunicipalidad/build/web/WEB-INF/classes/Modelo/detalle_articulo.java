/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class detalle_articulo {
    private String id_articulo;
    private Articulo obj_ar=new Articulo();
    private String marca_articulo;
    private String descripcion_articulo;
    private int cantidad_articulo;
    private String tipo_material;
    private double precio_articulo;
    
    public detalle_articulo(){
        
    }

    public int getCantidad_articulo() {
        return cantidad_articulo;
    }

    public void setCantidad_articulo(int cantidad_articulo) {
        this.cantidad_articulo = cantidad_articulo;
    }

    public String getDescripcion_articulo() {
        return descripcion_articulo;
    }

    public void setDescripcion_articulo(String descripcion_articulo) {
        this.descripcion_articulo = descripcion_articulo;
    }

    public String getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(String id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getMarca_articulo() {
        return marca_articulo;
    }

    public void setMarca_articulo(String marca_articulo) {
        this.marca_articulo = marca_articulo;
    }

    public Articulo getObj_ar() {
        return obj_ar;
    }

    public void setObj_ar(Articulo obj_ar) {
        this.obj_ar = obj_ar;
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
