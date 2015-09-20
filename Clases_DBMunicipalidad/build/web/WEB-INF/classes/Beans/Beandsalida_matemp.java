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
 * @author user
 */
public class Beandsalida_matemp implements Serializable{
    
    private dsalida_matemp dsalidaemp_a= new dsalida_matemp();
    private ArrayList<dsalida_matemp> 
    arreglo = new ArrayList<dsalida_matemp>();
    private String parametro;
    private dsalida_matemp selecteddsalidaemp_a;
    private String mensaje;

    public ArrayList<dsalida_matemp> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<dsalida_matemp> arreglo) {
        this.arreglo = arreglo;
    }

    public dsalida_matemp getDsalidaemp_a() {
        return dsalidaemp_a;
    }

    public void setDsalidaemp_a(dsalida_matemp dsalidaemp_a) {
        this.dsalidaemp_a = dsalidaemp_a;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public dsalida_matemp getSelecteddsalidaemp_a() {
        return selecteddsalidaemp_a;
    }

    public void setSelecteddsalidaemp_a(dsalida_matemp selecteddsalidaemp_a) {
        this.selecteddsalidaemp_a = selecteddsalidaemp_a;
    }
    
    public boolean Registrar(){
       boolean a=false;
       Connection conexion=null;
       try{
       conexion=ControladorBD.darConexionBD();
       CallableStatement st =conexion.prepareCall("{call sp_registrar_dsalida_mateemp" + "(?,?,?,?)}");
       st.setInt(1,this.dsalidaemp_a.getCantidad_material());
       st.setString(2,this.dsalidaemp_a.getObj_em().getId_detalle_solicitud_empresa());
       st.setString(3,this.dsalidaemp_a.getObj_ar().getCod_articulo());
        
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
    
     public String doRegistrardsalida_matemp()
        {
        try
        {
            if (this.Registrar()){
                Mensaje.guardarMensajeExito2( this.mensaje);

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
    
     public ArrayList<dsalida_matemp> getListarDsalida_matemp(){
        if (arreglo.size()==0){
        dsalida_matemp obj = null;
        Connection conexion = null;
        ResultSet rs = null;

        try{
            conexion=ControladorBD.darConexionBD();
            CallableStatement st = null;
             st = conexion.prepareCall
            ("{call sp_listar_dsalida_mateemp()}");
            rs= st.executeQuery();
            if(rs.next()){
                this.arreglo= new ArrayList<dsalida_matemp>();
                do{
                    obj = new dsalida_matemp();
                    obj.setId_salida_mateemp(rs.getInt("id_salida_mateemp"));
                    obj.setCantidad_material(rs.getInt("cantidad_material"));
                    
                                    
                    detalle_solicitud_empresa em = new detalle_solicitud_empresa();
                    em.setId_detalle_solicitud_empresa(rs.getString("id_detalle_solicitud_empresa"));
                    obj.setObj_em(em);
                    
                    Empresa emp = new Empresa();
                    emp.setCod_empresa(rs.getString("cod_empresa"));
                    emp.setNombre_empresa(rs.getString("nombre_empresa"));
                    obj.setObj_emp(emp);
                    
                    
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
            CallableStatement st = conexion.prepareCall("{call sp_filtrararticuloxsolicitud2(?)}");            
            st.setString(1, this.dsalidaemp_a.getObj_em().getId_detalle_solicitud_empresa());
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
