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
public class Cargo {
    private String id_cargo;
    private String descripcion_cargo;

    
         public Cargo() {        
    }
    public String getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(String id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getDescripcion_cargo() {
        return descripcion_cargo;
    }

    public void setDescripcion_cargo(String descripcion_cargo) {
        this.descripcion_cargo = descripcion_cargo;
    }

   
}
