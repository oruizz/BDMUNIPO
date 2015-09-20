/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Articulo;
import Modelo.ControladorBD;
import Modelo.Persona_Juridica;
import Modelo.Proyecto;
import Modelo.Responsable;
import Modelo.Solicitud;
import Modelo.detalle_solicitud_persona_juridica;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class Beansdetalle_solicitud_persona_juridica  implements Serializable{
     
     private detalle_solicitud_persona_juridica selectedsolipersona;
    
     private detalle_solicitud_persona_juridica detapersojuridica_a = new detalle_solicitud_persona_juridica();
    private ArrayList<detalle_solicitud_persona_juridica> arreglo =         new  ArrayList<detalle_solicitud_persona_juridica>();    
    private List<detalle_solicitud_persona_juridica> arraydetalle_solicitud_persona_juridica   = new ArrayList<detalle_solicitud_persona_juridica>();

    public Beansdetalle_solicitud_persona_juridica() {               
    }

    public List<detalle_solicitud_persona_juridica> getArraydetalle_solicitud_persona_juridica() {
        return arraydetalle_solicitud_persona_juridica;
    }

    public void setArraydetalle_solicitud_persona_juridica(List<detalle_solicitud_persona_juridica> arraydetalle_solicitud_persona_juridica) {
        this.arraydetalle_solicitud_persona_juridica = arraydetalle_solicitud_persona_juridica;
    }

    public ArrayList<detalle_solicitud_persona_juridica> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<detalle_solicitud_persona_juridica> arreglo) {
        this.arreglo = arreglo;
    }

    public detalle_solicitud_persona_juridica getDetapersojuridica_a() {
        return detapersojuridica_a;
    }

    public void setDetapersojuridica_a(detalle_solicitud_persona_juridica detapersojuridica_a) {
        this.detapersojuridica_a = detapersojuridica_a;
    }

    public detalle_solicitud_persona_juridica getSelectedsolipersona() {
        return selectedsolipersona;
    }

    public void setSelectedsolipersona(detalle_solicitud_persona_juridica selectedsolipersona) {
        this.selectedsolipersona = selectedsolipersona;
    }
    
    
    

    public boolean Registrar(){
       boolean a=false;
       Connection conexion=null;
       try{
       conexion=ControladorBD.darConexionBD();
       CallableStatement st =conexion.prepareCall("{call sp_registrar_solicitud_perso_juridica" + "(?,?,?,?,?,?,?,?)}");
       st.setString(1,detapersojuridica_a.getObj_pe().getCod_persona());
        st.setString(2,detapersojuridica_a.getNombre_solicitud());
       st.setString(3,detapersojuridica_a.getObj_pro().getId_proyecto());
       st.setString(4,detapersojuridica_a.getObj_ar().getCod_articulo());
       st.setString(5,detapersojuridica_a.getObj_re().getCod_responsable());
       if(detapersojuridica_a.getFecha_solicitud_persona()!= null)                 
                st.setDate(6,new java.sql.Date(detapersojuridica_a.getFecha_solicitud_persona().getTime()));                   
             else
                    st.setDate(6,null);   
       st.setInt(7,detapersojuridica_a.getEstado_solicitud_persona());
       st.registerOutParameter(8,java.sql.Types.VARCHAR);
       st.execute();
       detapersojuridica_a.setId_detalle_solicitud_persona_juridica(st.getString(8));
       if(detapersojuridica_a.getId_detalle_solicitud_persona_juridica()!=null){
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
    
    public ArrayList<detalle_solicitud_persona_juridica>
    getCargardetalle_solicitud_persona_juridica(){
        detalle_solicitud_persona_juridica obj=null;
        Connection conexion =null;
        ResultSet rs=null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st=conexion.prepareCall( "{call sp_listar_detalle_solicitud_persojuridica()}");
            rs = st.executeQuery();
            if (rs.next()){
             this.arreglo=new ArrayList<detalle_solicitud_persona_juridica>();
             do{
                  
                 obj=new detalle_solicitud_persona_juridica();
                 
                 obj.setId_detalle_solicitud_persona_juridica(rs.getString("id_detalle_solicitud_persona_juridica"));
                 Persona_Juridica e1=new Persona_Juridica();
                
                 e1.setCod_persona(rs.getString("cod_persona"));
                 e1.setNombre_persona(rs.getString("nombre_persona"));
                 e1.setApellido_persona(rs.getString("apellido_persona"));
                 obj.setObj_pe(e1);
                
                 obj.setNombre_solicitud(rs.getString("nombre_solicitud"));
               
                 Proyecto y1= new Proyecto();
                 y1.setId_proyecto(rs.getString("id_proyecto"));
                 y1.setNombre_proyecto(rs.getString("nombre_proyecto"));
                 obj.setObj_pro(y1);
                 Articulo a1= new Articulo();
                 a1.setCod_articulo(rs.getString("cod_articulo"));
                 a1.setNombre_articulo(rs.getString("nombre_articulo"));
                 obj.setObj_ar(a1);
                 Responsable re=new Responsable();
                 re.setCod_responsable(rs.getString("cod_responsable"));
                 re.setNombre_responsable(rs.getString("nombre_responsable"));
                 re.setApellido_responsable(rs.getString("apellido_responsable"));
                 obj.setObj_re(re);
                 obj.setFecha_solicitud_persona(rs.getDate("fecha_solicitud_persona"));
                 obj.setEstado_solicitud_persona(rs.getInt("estado_solicitud_persona"));
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
    public String doregistra_solipersona()
        {
            try
        {
            if (this.Registrar()){
                Mensaje.guardarMensajeExito( "Registro Solicitud Persona Juridica: Codigo " + this.getDetapersojuridica_a().getId_detalle_solicitud_persona_juridica());

            }else {
                Mensaje.manejarError("Registrando Solicitud Persona Juridica");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
            return null ;
        }
     
     public List<detalle_solicitud_persona_juridica> getCargarCombodesoliperso(){         
    if (this.arraydetalle_solicitud_persona_juridica.size()==0){         
        detalle_solicitud_persona_juridica obj=null;
    Connection conexion = null;
    ResultSet rs = null;
    try{
    conexion = ControladorBD.darConexionBD();
    CallableStatement st = conexion.prepareCall
  ( "{call sp_listar_detalle_solicitud_persojuridica()}");    
    rs = st.executeQuery();        
    if (rs.next()){        
       
        do{
        obj =new detalle_solicitud_persona_juridica();
                  obj.setId_detalle_solicitud_persona_juridica(rs.getString("id_detalle_solicitud_persona_juridica"));
                 Persona_Juridica e1=new Persona_Juridica();
                
                 e1.setCod_persona(rs.getString("cod_persona"));
                 e1.setNombre_persona(rs.getString("nombre_persona"));
                 e1.setApellido_persona(rs.getString("apellido_persona"));
                 obj.setObj_pe(e1);
                
                 obj.setNombre_solicitud(rs.getString("nombre_solicitud"));
             
                 Proyecto y1= new Proyecto();
                 y1.setId_proyecto(rs.getString("id_proyecto"));
                 y1.setNombre_proyecto(rs.getString("nombre_proyecto"));
                 obj.setObj_pro(y1);
                 Articulo a1= new Articulo();
                 a1.setCod_articulo(rs.getString("cod_articulo"));
                 a1.setNombre_articulo(rs.getString("nombre_articulo"));
                 obj.setObj_ar(a1);
                 Responsable re=new Responsable();
                 re.setCod_responsable(rs.getString("cod_responsable"));
                 re.setNombre_responsable(rs.getString("nombre_responsable"));
                 re.setApellido_responsable(rs.getString("apellido_responsable"));
                 obj.setObj_re(re);
                 obj.setFecha_solicitud_persona(rs.getDate("fecha_solicitud_persona"));
                 obj.setEstado_solicitud_persona(rs.getInt("estado_solicitud_persona"));
        
        
        
        arraydetalle_solicitud_persona_juridica.add(obj);
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
    return this.arraydetalle_solicitud_persona_juridica;
    }
    
    
   public List<detalle_solicitud_persona_juridica> getCargarCombodesolipersoxactivo(){         
    if (this.arraydetalle_solicitud_persona_juridica.size()==0){         
        detalle_solicitud_persona_juridica obj=null;
    Connection conexion = null;
    ResultSet rs = null;
    try{
    conexion = ControladorBD.darConexionBD();
    CallableStatement st = conexion.prepareCall
  ( "{call sp_listar_detalle_solicitud_persojuridicaxactivo()}");    
    rs = st.executeQuery();        
    if (rs.next()){        
       
        do{
        obj =new detalle_solicitud_persona_juridica();
                  obj.setId_detalle_solicitud_persona_juridica(rs.getString("id_detalle_solicitud_persona_juridica"));
                 Persona_Juridica e1=new Persona_Juridica();
                
                 e1.setCod_persona(rs.getString("cod_persona"));
                 e1.setNombre_persona(rs.getString("nombre_persona"));
                 e1.setApellido_persona(rs.getString("apellido_persona"));
                 obj.setObj_pe(e1);
                
                 obj.setNombre_solicitud(rs.getString("nombre_solicitud"));
             
                 Proyecto y1= new Proyecto();
                 y1.setId_proyecto(rs.getString("id_proyecto"));
                 y1.setNombre_proyecto(rs.getString("nombre_proyecto"));
                 obj.setObj_pro(y1);
                 Articulo a1= new Articulo();
                 a1.setCod_articulo(rs.getString("cod_articulo"));
                 a1.setNombre_articulo(rs.getString("nombre_articulo"));
                 obj.setObj_ar(a1);
                 Responsable re=new Responsable();
                 re.setCod_responsable(rs.getString("cod_responsable"));
                 re.setNombre_responsable(rs.getString("nombre_responsable"));
                 re.setApellido_responsable(rs.getString("apellido_responsable"));
                 obj.setObj_re(re);
                 obj.setFecha_solicitud_persona(rs.getDate("fecha_solicitud_persona"));
                 obj.setEstado_solicitud_persona(rs.getInt("estado_solicitud_persona"));
        
        
        
        arraydetalle_solicitud_persona_juridica.add(obj);
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
    return this.arraydetalle_solicitud_persona_juridica;
    }
     
   public boolean Actualizar(){
   boolean a=false;
   Connection conexion=null;
   try{
      conexion=ControladorBD.darConexionBD();
      CallableStatement st=conexion.prepareCall("{call sp_ActualizarSolpj(?,?,?,?,?,?,?,?)}");
         
       st.setString(1,detapersojuridica_a.getId_detalle_solicitud_persona_juridica());
       st.setString(2,detapersojuridica_a.getObj_pe().getCod_persona());
       st.setString(3,detapersojuridica_a.getNombre_solicitud());
       st.setString(4,detapersojuridica_a.getObj_pro().getId_proyecto());
       st.setString(5,detapersojuridica_a.getObj_ar().getCod_articulo());
       st.setString(6,detapersojuridica_a.getObj_re().getCod_responsable());
       if(detapersojuridica_a.getFecha_solicitud_persona() != null)                 
                st.setDate(7,new java.sql.Date(detapersojuridica_a.getFecha_solicitud_persona().getTime()));                   
             else
        st.setDate(7,null); 
       
       st.setInt(8,detapersojuridica_a.getEstado_solicitud_persona());
    
      
      
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
    final detalle_solicitud_persona_juridica dsp=(detalle_solicitud_persona_juridica) event.getObject();     
    this.setDetapersojuridica_a(dsp);
    this.Actualizar();
    }  
      
    public void onCancel(RowEditEvent event) {  
        
    } 
    
    public String doActualizarSolicitudPersonaJuridica()
        {
        this.setDetapersojuridica_a(selectedsolipersona);
            try
        {
            if (this.Actualizar()){
                Mensaje.guardarMensajeExito( "Acualizacion Detalle Persona: Codigo " + this.getDetapersojuridica_a().getId_detalle_solicitud_persona_juridica());

            }else {
                Mensaje.manejarError("Actualizando Detalle Solicitud Persona Juridica");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
           return null;
        } 
   
   
}



