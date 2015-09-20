/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class Beanordenproveedor {
    
    private ordenproveedor dordenproveedor_a = new ordenproveedor();
    private ArrayList<ordenproveedor> arreglo = new ArrayList<ordenproveedor>();
    private String parametro;
    private ordenproveedor selecteddordenproveedor;
    private String mensaje;
    
    public Beanordenproveedor() {
        
    }
    
    public ArrayList<ordenproveedor> getArreglo() {
        return arreglo;
    }
    
    public void setArreglo(ArrayList<ordenproveedor> arreglo) {
        this.arreglo = arreglo;
    }
    
    public ordenproveedor getDordenproveedor_a() {
        return dordenproveedor_a;
    }
    
    public void setDordenproveedor_a(ordenproveedor dordenproveedor_a) {
        this.dordenproveedor_a = dordenproveedor_a;
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
    
    public ordenproveedor getSelecteddordenproveedor() {
        return selecteddordenproveedor;
    }
    
    public void setSelecteddordenproveedor(ordenproveedor selecteddordenproveedor) {
        this.selecteddordenproveedor = selecteddordenproveedor;
    }
    
    public boolean Registrar() {
        boolean a = false;
        Connection conexion = null;
        try {
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall("{call sp_registrar_dentradamaterial" + "(?,?,?,?,?,?)}");
            st.setInt(1, this.dordenproveedor_a.getCantidad_material());
            st.setString(2, this.dordenproveedor_a.getObj_pr().getId_detalle_proveedor());
            st.setString(3, this.dordenproveedor_a.getObj_ar().getCod_articulo());
            if (this.dordenproveedor_a.getFecha_entrada() != null) {
                st.setDate(4, new java.sql.Date(this.dordenproveedor_a.getFecha_entrada().getTime()));
            } else {
                st.setDate(4, null);
            }
            
            st.setDouble(5, this.dordenproveedor_a.getPrecio_articulo());
            st.registerOutParameter(6, java.sql.Types.VARCHAR);
            st.execute();
            this.mensaje = st.getString(6);            
            if (this.mensaje != null) {
                a = true;
            }
            st.close();
            conexion.close();            
        } catch (Exception error) {
            System.out.println("Error en el "
                    + "metodo por: " + error.getMessage());
            error.printStackTrace();            
        }
        return a;
    }
    
    public String doRegistrardordenproveedor() {
        try {
            if (this.Registrar()) {
                
                
               Mensaje.guardarMensajeExito2("Mensaje: " + this.mensaje);
                
            } else {
                Mensaje.manejarError("Registrando Salida De Material");
            }
        } catch (Exception e) {
            Mensaje.manejarError(e);
        }
        return null;
    }
    
    public ArrayList<ordenproveedor> getListarordenproveedor() {
        if (arreglo.size() == 0) {
            ordenproveedor obj = null;
            Connection conexion = null;
            ResultSet rs = null;
            
            try {
                conexion = ControladorBD.darConexionBD();
                CallableStatement st = null;
                st = conexion.prepareCall("{call sp_listar_dentreadamatepro()}");
                rs = st.executeQuery();
                if (rs.next()) {
                    this.arreglo = new ArrayList<ordenproveedor>();
                    do {
                        obj = new ordenproveedor();
                        
                        obj.setId_dentrada_materpo(rs.getInt("id_dentrada_materpo"));
                        obj.setCantidad_material(rs.getInt("cantidad_material"));
                        
                        
                        detalle_solicitud_proveedor por = new detalle_solicitud_proveedor();
                        por.setId_detalle_proveedor(rs.getString("id_detalle_proveedor"));
                        obj.setObj_pr(por);
                        
                        Proveedor per = new Proveedor();
                        per.setId_proveedor(rs.getString("id_proveedor"));
                        per.setNombre_proveedor(rs.getString("nombre_proveedor"));
                        obj.setObj_por(per);
                                            
                        
                        Articulo a = new Articulo();
                        a.setCod_articulo(rs.getString("cod_articulo"));
                        a.setNombre_articulo(rs.getString("nombre_articulo"));
                        obj.setObj_ar(a);
                        
                        
                        
                        obj.setFecha_entrada(rs.getDate("fecha_entrada"));
                        obj.setPrecio_articulo(rs.getDouble("precio_articulo"));
                        
                        this.arreglo.add(obj);
                        
                    } while (rs.next());
                    rs.close();
                    st.close();
                    conexion.close();
                }
            } catch (Exception error) {
                System.out.println("Error en el "
                        + "metodo por: " + error.getMessage());
                error.printStackTrace();
            }
        }
        return this.arreglo;
    }
    
     public List<Articulo> getCargarArticuloxSolicitudPro(){   
    List<Articulo> arr=null;            
    ResultSet rs=null;
        Articulo obj=null;
        Connection conexion = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall("{call sp_filtrar_articuloxsoliprovedor(?)}");            
            st.setString(1, this.dordenproveedor_a.getObj_pr().getId_detalle_proveedor());
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
