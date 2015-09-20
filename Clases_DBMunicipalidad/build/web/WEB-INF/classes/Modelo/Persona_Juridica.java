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
public class Persona_Juridica {

    private String cod_persona;
    private String ruc_persona;
    private String nombre_persona;
    private String apellido_persona;
    private String direccion_persona;
    private String celular_persona;
    private String sexo_persona;
    private String edad_persona;
    private int estado_persona;

    public Persona_Juridica() {
    }

    public String getCelular_persona() {
        return celular_persona;
    }

    public void setCelular_persona(String celular_persona) {
        this.celular_persona = celular_persona;
    }

    public int getEstado_persona() {
        return estado_persona;
    }

    public void setEstado_persona(int estado_persona) {
        this.estado_persona = estado_persona;
    }

  

    public String getEdad_persona() {
        return edad_persona;
    }

    public void setEdad_persona(String edad_persona) {
        this.edad_persona = edad_persona;
    }

    public String getSexo_persona() {
        return sexo_persona;
    }

    public void setSexo_persona(String sexo_persona) {
        this.sexo_persona = sexo_persona;
    }

    public String getCod_persona() {
        return cod_persona;
    }

    public void setCod_persona(String cod_persona) {
        this.cod_persona = cod_persona;
    }

    public String getRuc_persona() {
        return ruc_persona;
    }

    public void setRuc_persona(String ruc_persona) {
        this.ruc_persona = ruc_persona;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
      
            this.nombre_persona = nombre_persona;
    }

    public String getApellido_persona() {
        return apellido_persona;
    }

    public void setApellido_persona(String apellido_persona) {
        this.apellido_persona = apellido_persona;
    }

    public String getDireccion_persona() {
        return direccion_persona;
    }

    public void setDireccion_persona(String direccion_persona) {
        this.direccion_persona = direccion_persona;
    }
}
