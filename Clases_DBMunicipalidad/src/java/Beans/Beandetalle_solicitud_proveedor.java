/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Articulo;
import Modelo.ControladorBD;
import Modelo.Proveedor;
import Modelo.Proyecto;
import Modelo.Solicitud;
import Modelo.detalle_solicitud_proveedor;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Logger;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;

/**
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class Beandetalle_solicitud_proveedor implements Serializable{
    private detalle_solicitud_proveedor detaproveedor_a= new detalle_solicitud_proveedor();
    private ArrayList<detalle_solicitud_proveedor> 
    arreglo = new ArrayList<detalle_solicitud_proveedor>();
    private String parametro;
    private static final Logger logger = Logger.getLogger(Beandetalle_solicitud_proveedor.class.getName());
    private detalle_solicitud_proveedor selecteddetalle_solicitud_proveedor;
    public static Logger getLogger() {
        return logger;
    }

    public detalle_solicitud_proveedor getSelecteddetalle_solicitud_proveedor() {
        return selecteddetalle_solicitud_proveedor;
    }

    public void setSelecteddetalle_solicitud_proveedor(detalle_solicitud_proveedor selecteddetalle_solicitud_proveedor) {
        this.selecteddetalle_solicitud_proveedor = selecteddetalle_solicitud_proveedor;
    }

    public detalle_solicitud_proveedor getDetaproveedor_a() {
        return detaproveedor_a;
    }

    public void setDetaproveedor_a(detalle_solicitud_proveedor detaproveedor_a) {
        this.detaproveedor_a = detaproveedor_a;
    }

    public ArrayList<detalle_solicitud_proveedor> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<detalle_solicitud_proveedor> arreglo) {
        this.arreglo = arreglo;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }
    
    public boolean Registrar(){
       boolean a=false;
       Connection conexion=null;
       try{
       conexion=ControladorBD.darConexionBD();
       CallableStatement st =conexion.prepareCall("{call sp_registrar_detalle_soli_proveedor" + "(?,?,?,?,?,?)}");
       st.setString(1,detaproveedor_a.getObj_ve().getId_proveedor());
    
       st.setString(2,detaproveedor_a.getObj_ar().getCod_articulo());
       st.setString(3,detaproveedor_a.getObj_ds().getCod_solicitud());
       if(detaproveedor_a.getFecha_solicitud_proveedor()!= null)                 
                st.setDate(4,new java.sql.Date(detaproveedor_a.getFecha_solicitud_proveedor().getTime()));                   
             else
                    st.setDate(4,null);   
       st.setInt(5,detaproveedor_a.getEstado_solicitud_proveedor());
       st.registerOutParameter(6,java.sql.Types.VARCHAR);
       st.execute();
       detaproveedor_a.setId_detalle_proveedor(st.getString(6));
       if(detaproveedor_a.getId_detalle_proveedor()!=null){
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
    
    public ArrayList<detalle_solicitud_proveedor>
    getCargardetalle_solicitud_proveedor(){
        detalle_solicitud_proveedor obj=null;
        Connection conexion =null;
        ResultSet rs=null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st=conexion.prepareCall( "{call sp_listar_detalle_soli_proveedor()}");
            rs = st.executeQuery();
            if (rs.next()){
             this.arreglo=new ArrayList<detalle_solicitud_proveedor>();
             do{
                 
                 obj=new detalle_solicitud_proveedor();
                 obj.setId_detalle_proveedor(rs.getString("id_detalle_proveedor"));
                 Proveedor p1= new Proveedor();
                 p1.setId_proveedor(rs.getString("id_proveedor"));
                 p1.setNombre_proveedor(rs.getString("nombre_proveedor"));
                 obj.setObj_ve((p1));
               
                 Articulo a1= new Articulo();
                 a1.setCod_articulo(rs.getString("cod_articulo"));
                 a1.setNombre_articulo(rs.getString("nombre_articulo"));
                 obj.setObj_ar((a1));
                
                 Solicitud ds =new Solicitud();
                 ds.setCod_solicitud(rs.getString("cod_solicitud"));
                 ds.setNombre_solicitud(rs.getString("nombre_solicitud"));
                 obj.setObj_ds(ds);
          
                 
                 obj.setFecha_solicitud_proveedor(rs.getDate("fecha_solicitud_proveedor"));
                 obj.setEstado_solicitud_proveedor(rs.getInt("estado_solicitud_proveedor"));
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
public String onFlowProcess(FlowEvent event) {  
        logger.info("Paso Actual..:" + event.getOldStep());  
        logger.info("Siguiente ..:" + event.getNewStep());                  
            return event.getNewStep();
    }
    
    public String doRegistrardetalle_solicitud_proveedor()
        {
        try
        {
            if (this.Registrar()){
                Mensaje.guardarMensajeExito( "Agregado Detalle: Codigo " + this.getDetaproveedor_a().getId_detalle_proveedor());

            }else {
                Mensaje.manejarError("Registrando Detalle  " );
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
            return null ;
        }    

     public ArrayList<detalle_solicitud_proveedor>
    getCargardetalle_solicitud_proveedorxactivo(){
        detalle_solicitud_proveedor obj=null;
        Connection conexion =null;
        ResultSet rs=null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st=conexion.prepareCall( "{call sp_listar_detalle_soli_proveedorxactivo()}");
            rs = st.executeQuery();
            if (rs.next()){
             this.arreglo=new ArrayList<detalle_solicitud_proveedor>();
             do{
                 
                 obj=new detalle_solicitud_proveedor();
                 
                 obj.setId_detalle_proveedor(rs.getString("id_detalle_proveedor"));
                 Proveedor p1= new Proveedor();
                 p1.setId_proveedor(rs.getString("id_proveedor"));
                 p1.setNombre_proveedor(rs.getString("nombre_proveedor"));
                 obj.setObj_ve((p1));
             
                 Articulo a1= new Articulo();
                 a1.setCod_articulo(rs.getString("cod_articulo"));
                 a1.setNombre_articulo(rs.getString("nombre_articulo"));
                 obj.setObj_ar((a1));
                 
               
           
                Solicitud ds =new Solicitud();
                 ds.setCod_solicitud(rs.getString("cod_solicitud"));
                 ds.setNombre_solicitud(rs.getString("nombre_solicitud"));
               
                 
                 obj.setFecha_solicitud_proveedor(rs.getDate("fecha_solicitud_proveedor"));
                 obj.setEstado_solicitud_proveedor(rs.getInt("estado_solicitud_proveedor"));
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
     
     public boolean Actualizar(){
   boolean a=false;
   Connection conexion=null;
   try{
      conexion=ControladorBD.darConexionBD();
      CallableStatement st=conexion.prepareCall("{call sp_ActualizarSolpro(?,?,?,?,?,?)}");
         
       st.setString(1,detaproveedor_a.getId_detalle_proveedor());
       st.setString(2,detaproveedor_a.getObj_ve().getId_proveedor());
     
       
       st.setString(3,detaproveedor_a.getObj_ar().getCod_articulo());
       st.setString(4,detaproveedor_a.getObj_ds().getCod_solicitud());
       if(detaproveedor_a.getFecha_solicitud_proveedor() != null)                 
                st.setDate(5,new java.sql.Date(detaproveedor_a.getFecha_solicitud_proveedor().getTime()));                   
             else
        st.setDate(5,null); 
       
       st.setInt(6,detaproveedor_a.getEstado_solicitud_proveedor());
    
      
      
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
    final detalle_solicitud_proveedor dspr=(detalle_solicitud_proveedor) event.getObject();     
    this.setDetaproveedor_a(dspr);
    this.Actualizar();
    }  
      
    public void onCancel(RowEditEvent event) {  
        
    } 
    
    public String doActualizarSolicitudProveedor()
        {
        this.setDetaproveedor_a(selecteddetalle_solicitud_proveedor);
            try
        {
            if (this.Actualizar()){
                Mensaje.guardarMensajeExito( "Acualizacion Detalle Proveedor: Codigo " + this.getDetaproveedor_a().getId_detalle_proveedor());

            }else {
                Mensaje.manejarError("Actualizando Detalle Proveedor");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
           return null;
        }
    
}

