/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;


import Modelo.*;
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
public class Beandetalle_solicitud_empresa implements Serializable{
    
     private detalle_solicitud_empresa selectedSoliempresa;
     
    private detalle_solicitud_empresa detaempresa_a= new detalle_solicitud_empresa();
    private ArrayList<detalle_solicitud_empresa> 
    arreglo = new ArrayList<detalle_solicitud_empresa>();
        private List<detalle_solicitud_empresa> arraydetalle_solicitud_empresa   = new ArrayList<detalle_solicitud_empresa>();

    private String parametro;

    public List<detalle_solicitud_empresa> getArraydetalle_solicitud_empresa() {
        return arraydetalle_solicitud_empresa;
    }

    public void setArraydetalle_solicitud_empresa(List<detalle_solicitud_empresa> arraydetalle_solicitud_empresa) {
        this.arraydetalle_solicitud_empresa = arraydetalle_solicitud_empresa;
    }

    
    public Beandetalle_solicitud_empresa(){
        
    }
    
    public ArrayList<detalle_solicitud_empresa> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<detalle_solicitud_empresa> arreglo) {
        this.arreglo = arreglo;
    }

    public detalle_solicitud_empresa getDetaempresa_a() {
        return detaempresa_a;
    }

    public void setDetaempresa_a(detalle_solicitud_empresa detaempresa_a) {
        this.detaempresa_a = detaempresa_a;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public detalle_solicitud_empresa getSelectedSoliempresa() {
        return selectedSoliempresa;
    }

    public void setSelectedSoliempresa(detalle_solicitud_empresa selectedSoliempresa) {
        this.selectedSoliempresa = selectedSoliempresa;
    }

    
    public boolean Registrar(){
       boolean a=false;
       Connection conexion=null;
       try{
       conexion=ControladorBD.darConexionBD();
       CallableStatement st =conexion.prepareCall("{call sp_registrar_detalle_soli_empresa" + "(?,?,?,?,?,?,?,?)}");
       st.setString(1,detaempresa_a.getObj_em().getCod_empresa());
       st.setString(2,detaempresa_a.getNombre_solicitud());
       st.setString(3,detaempresa_a.getObj_re().getCod_responsable());
       st.setString(4,detaempresa_a.getObj_pro().getId_proyecto());
       st.setString(5,detaempresa_a.getObj_ar().getCod_articulo());
        if(detaempresa_a.getFecha_solicitud_empresa()!= null)                 
                st.setDate(6,new java.sql.Date(detaempresa_a.getFecha_solicitud_empresa().getTime()));                   
             else
                    st.setDate(6,null);   
       st.setInt(7,detaempresa_a.getEstado_solicitud_empresa());
       st.registerOutParameter(8,java.sql.Types.VARCHAR);
       st.execute();
       detaempresa_a.setId_detalle_solicitud_empresa(st.getString(8));
       if(detaempresa_a.getId_detalle_solicitud_empresa()!=null){
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
    
    public ArrayList<detalle_solicitud_empresa>
    getCargardetalle_solicitud_empresa(){
        if (arreglo.size()==0){ 
        detalle_solicitud_empresa obj=null;
        Connection conexion =null;
        ResultSet rs=null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st=conexion.prepareCall( "{call sp_listar_detalle_solicitud_empresas()}");
            rs = st.executeQuery();
            if (rs.next()){
             this.arreglo=new ArrayList<detalle_solicitud_empresa>();
             do{
              
                 obj=new detalle_solicitud_empresa();
                 obj.setId_detalle_solicitud_empresa(rs.getString("id_detalle_solicitud_empresa"));
                 Empresa e1 =new Empresa();
                 e1.setCod_empresa(rs.getString("cod_empresa"));
                 e1.setNombre_empresa(rs.getString("nombre_empresa"));
                 obj.setObj_em(e1);
                 
                 obj.setNombre_solicitud(rs.getString("nombre_solicitud"));
                
                 Responsable r1= new Responsable();
                 r1.setCod_responsable(rs.getString("cod_responsable"));
                 r1.setNombre_responsable(rs.getString("nombre_responsable"));
                 r1.setApellido_responsable(rs.getString("apellido_responsable"));
                 obj.setObj_re(r1);
                 Proyecto p1=new Proyecto();
                 p1.setId_proyecto(rs.getString("id_proyecto"));
                 p1.setNombre_proyecto(rs.getString("nombre_proyecto"));
                 obj.setObj_pro(p1);
                 Articulo t1=new Articulo();
                 t1.setCod_articulo(rs.getString("cod_articulo"));
                 t1.setNombre_articulo(rs.getString("nombre_articulo"));
                 obj.setObj_ar(t1);
                 obj.setFecha_solicitud_empresa(rs.getDate("fecha_solicitud_empresa"));
                 obj.setEstado_solicitud_empresa(rs.getInt("estado_solicitud_empresa"));
                 arreglo.add(obj);
             }while (rs.next());
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
        return this.arreglo;
    }
    
    public String doRegistrarsoliempresa()
        {
        try
        {
            if (this.Registrar()){
                Mensaje.guardarMensajeExito( "Agregando Detalle: Identificador " + this.getDetaempresa_a().getId_detalle_solicitud_empresa());

            }else {
                Mensaje.manejarError("Registrando Detalle De La Solicitud" );
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
            return null ;
        }

       public List<detalle_solicitud_empresa> getCargarCombodesoliempresaxactivo2(){         
    if (this.arraydetalle_solicitud_empresa.size()==0){         
        detalle_solicitud_empresa obj=null;
    Connection conexion = null;
    ResultSet rs = null;
    try{
    conexion = ControladorBD.darConexionBD();
    CallableStatement st = conexion.prepareCall
  ( "{call sp_listar_detalle_solicitud_empresasxactivo()}");    
    rs = st.executeQuery();        
    if (rs.next()){        
       
        do{
        obj =new detalle_solicitud_empresa();
                  obj.setId_detalle_solicitud_empresa(rs.getString("id_detalle_solicitud_empresa"));
                 Empresa e1=new Empresa();
                
                 e1.setCod_empresa(rs.getString("cod_empresa"));
                 e1.setNombre_empresa(rs.getString("nombre_empresa"));
                 obj.setObj_em(e1);
                
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
                 obj.setObj_re(re);
                 obj.setFecha_solicitud_empresa(rs.getDate("fecha_solicitud_empresa"));
                 obj.setEstado_solicitud_empresa(rs.getInt("estado_solicitud_empresa"));
        
        
        
        arraydetalle_solicitud_empresa.add(obj);
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
    return this.arraydetalle_solicitud_empresa;
    }
    
       
       public boolean Actualizar(){
   boolean a=false;
   Connection conexion=null;
   try{
      conexion=ControladorBD.darConexionBD();
      CallableStatement st=conexion.prepareCall("{call sp_ActualizarSolempresa(?,?,?,?,?,?,?,?)}");
         
       st.setString(1,detaempresa_a.getId_detalle_solicitud_empresa());
       st.setString(2,detaempresa_a.getObj_em().getCod_empresa());
       st.setString(3,detaempresa_a.getNombre_solicitud());
       st.setString(4,detaempresa_a.getObj_re().getCod_responsable());
       st.setString(5,detaempresa_a.getObj_pro().getId_proyecto());
       st.setString(6,detaempresa_a.getObj_ar().getCod_articulo());
       if(detaempresa_a.getFecha_solicitud_empresa() != null)                 
                st.setDate(7,new java.sql.Date(detaempresa_a.getFecha_solicitud_empresa().getTime()));                   
             else
        st.setDate(7,null); 
       
       st.setInt(8,detaempresa_a.getEstado_solicitud_empresa());
    
      
      
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
    final detalle_solicitud_empresa dse=(detalle_solicitud_empresa) event.getObject();     
    this.setDetaempresa_a(dse);
    this.Actualizar();
    }  
      
    public void onCancel(RowEditEvent event) {  
        
    } 
    
    public String doActualizarSolicitudEmpresa()
        {
        this.setDetaempresa_a(selectedSoliempresa);
            try
        {
            if (this.Actualizar()){
                Mensaje.guardarMensajeExito( "Acualizacion Responsable: Codigo " + this.getDetaempresa_a().getId_detalle_solicitud_empresa());

            }else {
                Mensaje.manejarError("Actualizando Reponsable");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
           return null;
        }
    
}
