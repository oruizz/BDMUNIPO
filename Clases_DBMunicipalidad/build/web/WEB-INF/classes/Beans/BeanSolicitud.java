/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Cargo;
import Modelo.ControladorBD;
import Modelo.Solicitud;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.event.RowEditEvent;

/**
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class BeanSolicitud implements Serializable{
    
    private Solicitud selectedSolicitud;
    
     private Solicitud solicitud_a = new Solicitud();
    private ArrayList<Solicitud> arreglo =         new  ArrayList<Solicitud>();    
    private List<Solicitud> arraySolicitud   = new ArrayList<Solicitud>();

    public List<Solicitud> getArraySolicitud() {
        return arraySolicitud;
    }

    public void setArraySolicitud(List<Solicitud> arraySolicitud) {
        this.arraySolicitud = arraySolicitud;
    }

    public ArrayList<Solicitud> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Solicitud> arreglo) {
        this.arreglo = arreglo;
    }

    public Solicitud getSelectedSolicitud() {
        return selectedSolicitud;
    }

    public void setSelectedSolicitud(Solicitud selectedSolicitud) {
        this.selectedSolicitud = selectedSolicitud;
    }

    public Solicitud getSolicitud_a() {
        return solicitud_a;
    }

    public void setSolicitud_a(Solicitud solicitud_a) {
        this.solicitud_a = solicitud_a;
    }

    
  
  
    
    public boolean Registrar(){
       boolean a=false;
       Connection conexion=null;
       try{
       conexion=ControladorBD.darConexionBD();
       CallableStatement st =conexion.prepareCall("{call sp_registrar_solicitud" + "(?,?)}");
       st.setString(1,solicitud_a.getNombre_solicitud());
       st.registerOutParameter(2,java.sql.Types.VARCHAR);
       st.execute();
       solicitud_a.setCod_solicitud(st.getString(2));
       if(solicitud_a.getCod_solicitud()!=null){
           a=true;
       }
       st.close();
       conexion.close();
       }catch(Exception error){
        System.out.println("error en el metodo por: " +error.getMessage());
        error.printStackTrace();
       }
    return a;
   }
    
    public ArrayList<Solicitud>
    getCargarSolicitud(){
        Solicitud obj=null;
        Connection conexion =null;
        ResultSet rs=null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st=conexion.prepareCall( "{call sp_listar_solicitud()}");
            rs = st.executeQuery();
            if (rs.next()){
             this.arreglo=new ArrayList<Solicitud>();
             do{
                 obj=new Solicitud();
                 obj.setCod_solicitud(rs.getString("cod_solicitud"));
                 obj.setNombre_solicitud(rs.getString("nombre_solicitud"));
                 arreglo.add(obj);
             }while (rs.next());
        }
               rs.close();
               st.close();
               conexion.close();
        }catch(Exception error){
            
        }
        return this.arreglo;
    }
    
    public String doRegistraSolicitud()
        {
            try
        {
            if (this.Registrar()){
                Mensaje.guardarMensajeExito( "Registro Solicitud: Codigo " + this.getSolicitud_a().getCod_solicitud());

            }else {
                Mensaje.manejarError("Registrando Solicitud");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
            return null ;
        }
    
    public List<Solicitud> getCargarComboSoli(){         
    if (this.arraySolicitud.size()==0){         
        Solicitud obj=null;
    Connection conexion = null;
    ResultSet rs = null;
    try{
    conexion = ControladorBD.darConexionBD();
    CallableStatement st = conexion.prepareCall
  ( "{call sp_listar_solicitud()}");    
    rs = st.executeQuery();        
    if (rs.next()){        
       
        do{
        obj =new Solicitud();
        obj.setCod_solicitud(rs.getString("cod_solicitud"));
        obj.setNombre_solicitud(rs.getString("nombre_solicitud"));        
        arraySolicitud.add(obj);
       } while (rs.next());
    }  
         rs.close();
         st.close();
         conexion.close();

     }catch(Exception error){
        System.out.println("Error en el metodo por: " +
                   error.getMessage());
                error.printStackTrace();
        }    
      }  
    return this.arraySolicitud;
    }
    
    public boolean Actualizar(){
   boolean a=false;
   Connection conexion=null;
   try{
      conexion=ControladorBD.darConexionBD();
      CallableStatement st=conexion.prepareCall("{call sp_ActualizarSolicitud(?,?)}");
        
      st.setString(1,solicitud_a.getCod_solicitud());
      st.setString(2,solicitud_a.getNombre_solicitud());
      
      
      st.execute();          
      a= true;
                st.close();
                conexion.close();
            }catch(Exception error){
                    System.out.println("Error en el metodo por: " + error.getMessage());
                    error.printStackTrace();
            }
            
            return a;
    }
        
        public void onEdit(RowEditEvent event) {  
    final Solicitud sol=(Solicitud) event.getObject();     
    this.setSolicitud_a(sol);
    this.Actualizar();
    }  
      
    public void onCancel(RowEditEvent event) {  
        
    }
    
    public String doActualizarSolicitud()
        {
        this.setSolicitud_a(selectedSolicitud);
            try
        {
            if (this.Actualizar()){
                Mensaje.guardarMensajeExito( "Acualizacion Solicitud: Cod_solicitud " + this.getSolicitud_a().getCod_solicitud());

            }else {
                Mensaje.manejarError("Actualizando Solicitud");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
           return null;
        }
    
}
