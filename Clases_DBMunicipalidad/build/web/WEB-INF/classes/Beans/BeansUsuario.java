/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.ControladorBD;

import Modelo.Usuario;
import Utils.Constantes;
import Utils.encriptaCadenas;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class BeansUsuario {
  private Usuario usuario_l = new Usuario();
   private boolean usuarioLogeado;
   private boolean flgPassIguales;
   private String nom_user;
   private String clave_user;

    public String getClave_user() {
        return clave_user;
    }

    public void setClave_user(String clave_user) {
        this.clave_user = clave_user;
    }

    public boolean isFlgPassIguales() {
        return flgPassIguales;
    }

    public void setFlgPassIguales(boolean flgPassIguales) {
        this.flgPassIguales = flgPassIguales;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public boolean isUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(boolean usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }

    public Usuario getUsuario_l() {
        return usuario_l;
    }

    public void setUsuario_l(Usuario usuario_l) {
        this.usuario_l = usuario_l;
    }
   
     
 public String loginUsuario(){
        String outcome = null;       
        flgPassIguales=false;
        try{            
        FacesContext contex = FacesContext.getCurrentInstance();                                        
            if(usuario_l!=null){
                usuario_l=this.validar(this.nom_user, encriptaCadenas.getStringMessageDigest(this.clave_user,encriptaCadenas.MD5));                
                if(usuario_l != null){          //  
                   Mensaje.addMensajeInfo("Usuario logeado correctamente");
                    usuarioLogeado = true; 
                    contex.getExternalContext().getSessionMap().put("usuario",usuario_l);                       
                  contex.getExternalContext().getSessionMap().put("isSesionAlive", usuarioLogeado);                                                                                         
                    outcome=Constantes.PAGE_INGRESO_JSF;                    
               }
               else{
                   Mensaje.addMensajeError("Usuario o Password Incorrectos");
                    outcome=Constantes.PAGE_LOGIN_JSF;  
                    
               }  
            }
            else{
                Mensaje.addMensajeError("Usuario o Password Incorrectos");
                outcome=Constantes.PAGE_LOGIN_JSF;  
                
            }
                
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }        
    return outcome+"?faces-redirect=true";         
    }
 
  public  Usuario validar(String us, String pass){
System.out.print("Esta es la clave: " + pass);
     ResultSet rs=null; 
     Connection conexion = null;
     Usuario user=null;       
        try{               
           conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall
            ( "{call sp_validar_usuarios(?,?)}");
            st.setString(1,us);                   
            st.setString(2,pass);             
            rs = st.executeQuery();
            if(rs.next()){
                user = new Usuario();
                user.setUser(us);
                
                user.setId_cargo(rs.getString("id_cargo"));
                user.setDescripion_cargo(rs.getString("descripcion_cargo"));
                
                rs.close();                
                conexion.close();                
            }
       
        }catch(Exception error){
            System.out.println("Error en el metodo por: " + error.getMessage());
                error.printStackTrace();
        }
        return user;
 }
 
   public void salirSistema(){
        FacesContext contex = FacesContext.getCurrentInstance();  
        this.nom_user="";
        this.clave_user="";
        String outcome =Constantes.PAGE_LOGIN_JSF;
        contex.getExternalContext().getSessionMap().clear();
        contex.getExternalContext().getSessionMap().put("isSesionAlive", false);
        contex.getExternalContext().invalidateSession();
        try {
            contex.getExternalContext().redirect(outcome);
        } catch (IOException ex) {
        }

    }
   
   public void validarSesion() {        
        FacesContext contex = FacesContext.getCurrentInstance();
        try {
            if (contex.getExternalContext().getSessionMap().get("isSesionAlive") == null
                    | contex.getExternalContext().getSessionMap().get("isSesionAlive").
                    toString().trim().equals("false")) {
                contex.getExternalContext().redirect("login.jsf");
                contex.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Autenticacion", "El usuario No existe !!"));

            }
        } catch (Exception e) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.jsf");
            } catch (Exception ex) {
                
            }
        }
        
    }

  
 
}
