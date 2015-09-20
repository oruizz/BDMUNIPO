/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;



/**
 *
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class Inventario {
    private String id_inventario;
    private Date fecha_inventario;

    public Date getFecha_inventario() {
        return fecha_inventario;
    }

    public void setFecha_inventario(Date fecha_inventario) {
        this.fecha_inventario = fecha_inventario;
    }

    

    public String getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(String id_inventario) {
        this.id_inventario = id_inventario;
    }

    
    
}
