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
public class Proyecto {
    private String id_proyecto;
    private String nombre_proyecto;
    private String tipo_proyecto;
    private int estado_proyecto;

    
     public Proyecto() {        
    }

    public int getEstado_proyecto() {
        return estado_proyecto;
    }

    public void setEstado_proyecto(int estado_proyecto) {
        this.estado_proyecto = estado_proyecto;
    }

     
    public String getTipo_proyecto() {
        return tipo_proyecto;
    }

    public void setTipo_proyecto(String tipo_proyecto) {
        this.tipo_proyecto = tipo_proyecto;
    }
    
     
    public String getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(String id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }
    
}
