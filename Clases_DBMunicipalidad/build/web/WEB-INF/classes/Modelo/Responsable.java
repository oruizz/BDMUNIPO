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
public class Responsable {
    private String cod_responsable;
    private String nombre_responsable;
    private String apellido_responsable;
    private String sexo_responsable;
    private String edad_responsable;
    private String celular_responsable;
    private String direccion_responsable;
    private int responsable_estado;
    private Cargo obj_car=new Cargo();

    /*CONSTRUCTOR*/
    public Responsable() {
    }

    public String getApellido_responsable() {
        return apellido_responsable;
    }

    public void setApellido_responsable(String apellido_responsable) {
        this.apellido_responsable = apellido_responsable;
    }

    public String getCelular_responsable() {
        return celular_responsable;
    }

    public void setCelular_responsable(String celular_responsable) {
        this.celular_responsable = celular_responsable;
    }

    public String getCod_responsable() {
        return cod_responsable;
    }

    public void setCod_responsable(String cod_responsable) {
        this.cod_responsable = cod_responsable;
    }

    public String getDireccion_responsable() {
        return direccion_responsable;
    }

    public void setDireccion_responsable(String direccion_responsable) {
        this.direccion_responsable = direccion_responsable;
    }

    public String getEdad_responsable() {
        return edad_responsable;
    }

    public void setEdad_responsable(String edad_responsable) {
        this.edad_responsable = edad_responsable;
    }

    public String getNombre_responsable() {
        return nombre_responsable;
    }

    public void setNombre_responsable(String nombre_responsable) {
        this.nombre_responsable = nombre_responsable;
    }

    public Cargo getObj_car() {
        return obj_car;
    }

    public void setObj_car(Cargo obj_car) {
        this.obj_car = obj_car;
    }

    public int getResponsable_estado() {
        return responsable_estado;
    }

    public void setResponsable_estado(int responsable_estado) {
        this.responsable_estado = responsable_estado;
    }

    public String getSexo_responsable() {
        return sexo_responsable;
    }

    public void setSexo_responsable(String sexo_responsable) {
        this.sexo_responsable = sexo_responsable;
    }

   
  
    /*********************/
    
    

    
    


}
