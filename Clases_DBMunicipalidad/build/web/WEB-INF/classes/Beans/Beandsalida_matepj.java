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


/**
 *
 * @author Administrador
 */
public class Beandsalida_matepj implements Serializable{
    
    private dsalida_matepj dsalidapj_a= new dsalida_matepj();
    private ArrayList<dsalida_matepj> 
    arreglo = new ArrayList<dsalida_matepj>();
    private String parametro;
    private dsalida_matepj selecteddsalidapj_a;
    private String mensaje;

    public Beandsalida_matepj(){
        
    }
    
    public ArrayList<dsalida_matepj> getArreglo() {
        return arreglo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setArreglo(ArrayList<dsalida_matepj> arreglo) {
        this.arreglo = arreglo;
    }

    public dsalida_matepj getDsalidapj_a() {
        return dsalidapj_a;
    }

    public void setDsalidapj_a(dsalida_matepj dsalidapj_a) {
        this.dsalidapj_a = dsalidapj_a;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public dsalida_matepj getSelecteddsalidapj_a() {
        return selecteddsalidapj_a;
    }

    public void setSelecteddsalidapj_a(dsalida_matepj selecteddsalidapj_a) {
        this.selecteddsalidapj_a = selecteddsalidapj_a;
    }
 
      public boolean Registrar(){
       boolean a=false;
       Connection conexion=null;
       try{
       conexion=ControladorBD.darConexionBD();
       CallableStatement st =conexion.prepareCall("{call sp_registrar_dsalida_materialpj" + "(?,?,?,?)}");
       st.setInt(1,this.dsalidapj_a.getCantidad_material());
       st.setString(2,this.dsalidapj_a.getObj_pj().getId_detalle_solicitud_persona_juridica());
       st.setString(3,this.dsalidapj_a.getObj_ar().getCod_articulo());
        
       st.registerOutParameter(4,java.sql.Types.VARCHAR);
       st.execute();
       this.mensaje = st.getString(4);  
         if (this.mensaje!=null)
                a=true;
            st.close();
            conexion.close();            
        }catch(Exception error){
            System.out.println("Error en el "
                    + "metodo por: "+ error.getMessage());
            error.printStackTrace();                        
        }
         return a;
   }
    
      public String doRegistrardsalida_matepj()
        {
        try
        {
            if (this.Registrar()){
                                       
                    
                Mensaje.guardarMensajeExito2(this.mensaje);
            
            }else {
                Mensaje.manejarError("Registrando Salida De Material");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
            return null ;
        }
      
       public ArrayList<dsalida_matepj> getListarDsalida_matepj(){
        if (arreglo.size()==0){
        dsalida_matepj obj = null;
        Connection conexion = null;
        ResultSet rs = null;

        try{
            conexion=ControladorBD.darConexionBD();
            CallableStatement st = null;
             st = conexion.prepareCall
            ("{call sp_listar_dsalidamatepj()}");
            rs= st.executeQuery();
            if(rs.next()){
                this.arreglo= new ArrayList<dsalida_matepj>();
                do{
                    obj = new dsalida_matepj();
                    obj.setId_salida_matepj(rs.getInt("id_salida_matepj"));
                    obj.setCantidad_material(rs.getInt("cantidad_material"));
                    
                                    
                    detalle_solicitud_persona_juridica pj = new detalle_solicitud_persona_juridica();
                    pj.setId_detalle_solicitud_persona_juridica(rs.getString("id_detalle_solicitud_persona_juridica"));
                    obj.setObj_pj(pj);
                    
                    Persona_Juridica per = new Persona_Juridica();
                    per.setCod_persona(rs.getString("cod_persona"));
                    per.setNombre_persona(rs.getString("nombre_persona"));
                    obj.setObj_per(per);
                    
                    
                     Proyecto p=new Proyecto();
                    p.setId_proyecto(rs.getString("id_proyecto"));
                    p.setNombre_proyecto(rs.getString("nombre_proyecto"));
                    obj.setObj_pro(p);
                    
                    
                    Articulo a = new Articulo();
                    a.setCod_articulo(rs.getString("cod_articulo"));
                    a.setNombre_articulo(rs.getString("nombre_articulo"));
                    obj.setObj_ar(a);
                    
                   
                                      
                    obj.setFecha_salida(rs.getDate("fecha_salida"));
                    
                  
                    this.arreglo.add(obj);

                }while(rs.next());
                rs.close();
                st.close();
                conexion.close();
            }
         }catch(Exception error){
            System.out.println("Error en el "
                    + "metodo por: "+ error.getMessage());
            error.printStackTrace();
        }
        }
        return this.arreglo;
    }
       
       
        public List<Articulo> getCargarArticuloxSolicitud(){   
    List<Articulo> arr=null;            
    ResultSet rs=null;
        Articulo obj=null;
        Connection conexion = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall("{call sp_filtrararticuloxsolicitud(?)}");            
            st.setString(1, this.dsalidapj_a.getObj_pj().getId_detalle_solicitud_persona_juridica());
            rs = st.executeQuery();
            if (rs.next()){               
                arr= new ArrayList<Articulo>();
                do{
                    
                    obj =new Articulo();
                    obj.setCod_articulo(rs.getString("cod_articulo"));    
                    obj.setNombre_articulo(rs.getString("nombre_articulo"));
                                      
                    arr.add(obj);
               } while (rs.next());
            }  
                 rs.close();
                 st.close();
                 conexion.close();


        }catch(Exception error){
                System.out.println("Error en el metodo por: " + error.getMessage());
                error.printStackTrace();
        }
    
    return arr;                
    }        
     
       
      
}
