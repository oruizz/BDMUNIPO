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
public class Usuario {
    private int id_login;
    private String clave;
    private String user;
    private String id_cargo;
    private String descripion_cargo;
    private int usuestado;
    
    public Usuario(){
        
    }

   
    public String getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(String id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getDescripion_cargo() {
        return descripion_cargo;
    }

    public void setDescripion_cargo(String descripion_cargo) {
        this.descripion_cargo = descripion_cargo;
    }

    
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

  

   
    public int getUsuestado() {
        return usuestado;
    }

    public void setUsuestado(int usuestado) {
        this.usuestado = usuestado;
    }


    
}
