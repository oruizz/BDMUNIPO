/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Com.*;
import Modelo.*;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Administrador
 */
public class BeansReportes implements Serializable{
     private PieChartModel pieModel;
     private CartesianChartModel categoryModel;
     private ArrayList<TotalArticulosSolixEmpresa> arregloTotalArticulosSolixEmpresa = new ArrayList<TotalArticulosSolixEmpresa>();
     private ArrayList<TotalSolicitudEmpresaxResponsable> arregloTotalSolicitudEmpresaxResponsable= new ArrayList<TotalSolicitudEmpresaxResponsable>();
     private ArrayList<ArticulosxSoliEmpresaxMonto> arregloArticulosxmonto = new ArrayList<ArticulosxSoliEmpresaxMonto>();
     private ArrayList<ultimasxsolicitudxpj> arregloultimasxsolicitudxpj =new ArrayList<ultimasxsolicitudxpj>();
     private ArrayList<activosxsolicitudxproveedor> arregloactivosxsolicitudxproveedor = new ArrayList<activosxsolicitudxproveedor>();
     private Persona_Juridica persona_p = new Persona_Juridica();
     private ArrayList<TotalArticulosxSolixPersonaJuridica> arregloTotalArticulosSolixPersona=new ArrayList<TotalArticulosxSolixPersonaJuridica>();
private ArrayList<proyectoxempresa> arregloproyectoxempresa = new ArrayList<proyectoxempresa>();
     private Empresa empresa_p = new Empresa();
     private detalle_solicitud_empresa dse_p=new detalle_solicitud_empresa();
     private detalle_solicitud_persona_juridica obj_dpj = new detalle_solicitud_persona_juridica();
     private detalle_solicitud_proveedor obj_ro = new detalle_solicitud_proveedor();
     private ArrayList<dsalida_matemp> arrsaliempresa = new ArrayList<dsalida_matemp>();

    
     private ArrayList<detalle_solicitud_empresa> arrsoliempresa = new ArrayList<detalle_solicitud_empresa>();
    
     private double precio_total;
     private Double importe;
     private Date fech_ini = new Date();
     private Date fech_fin = new Date();
     private int estado;
     
     private ArrayList<detalle_solicitud_persona_juridica> arrsolipersona = new ArrayList<detalle_solicitud_persona_juridica>();
      private ArrayList<detalle_solicitud_proveedor> arrsoliproveedor= new ArrayList<detalle_solicitud_proveedor>();
     
     
     private Proveedor ov = new Proveedor();
     private Proyecto pro = new Proyecto ();
     private Articulo ar = new Articulo();
     private Responsable res= new Responsable();

    public ArrayList<ArticulosxSoliEmpresaxMonto> getArregloArticulosxmonto() {
        return arregloArticulosxmonto;
    }

    public void setArregloArticulosxmonto(ArrayList<ArticulosxSoliEmpresaxMonto> arregloArticulosxmonto) {
        this.arregloArticulosxmonto = arregloArticulosxmonto;
    }

    public ArrayList<ultimasxsolicitudxpj> getArregloultimasxsolicitudxpj() {
        return arregloultimasxsolicitudxpj;
    }

    public void setArregloultimasxsolicitudxpj(ArrayList<ultimasxsolicitudxpj> arregloultimasxsolicitudxpj) {
        this.arregloultimasxsolicitudxpj = arregloultimasxsolicitudxpj;
    }

    public detalle_solicitud_proveedor getObj_ro() {
        return obj_ro;
    }

    public void setObj_ro(detalle_solicitud_proveedor obj_ro) {
        this.obj_ro = obj_ro;
    }
       
//-------------------------------------------------------------------------------------------------------

    public ArrayList<dsalida_matemp> getArrsaliempresa() {
        return arrsaliempresa;
    }

    public void setArrsaliempresa(ArrayList<dsalida_matemp> arrsaliempresa) {
        this.arrsaliempresa = arrsaliempresa;
    }

    
    public ArrayList<TotalArticulosxSolixPersonaJuridica> getArregloTotalArticulosSolixPersona() {
        return arregloTotalArticulosSolixPersona;
    }

    public void setArregloTotalArticulosSolixPersona(ArrayList<TotalArticulosxSolixPersonaJuridica> arregloTotalArticulosSolixPersona) {
        this.arregloTotalArticulosSolixPersona = arregloTotalArticulosSolixPersona;
    }

    public ArrayList<proyectoxempresa> getArregloproyectoxempresa() {
        return arregloproyectoxempresa;
    }

    public void setArregloproyectoxempresa(ArrayList<proyectoxempresa> arregloproyectoxempresa) {
        this.arregloproyectoxempresa = arregloproyectoxempresa;
    }

    
    public Proveedor getOv() {
        return ov;
    }

    public void setOv(Proveedor ov) {
        this.ov = ov;
    }

    public ArrayList<detalle_solicitud_proveedor> getArrsoliproveedor() {
        return arrsoliproveedor;
    }

    public void setArrsoliproveedor(ArrayList<detalle_solicitud_proveedor> arrsoliproveedor) {
        this.arrsoliproveedor = arrsoliproveedor;
    }

    
    
    public detalle_solicitud_persona_juridica getObj_dpj() {
        return obj_dpj;
    }

    public void setObj_dpj(detalle_solicitud_persona_juridica obj_dpj) {
        this.obj_dpj = obj_dpj;
    }

    public ArrayList<activosxsolicitudxproveedor> getArregloactivosxsolicitudxproveedor() {
        return arregloactivosxsolicitudxproveedor;
    }

    public void setArregloactivosxsolicitudxproveedor(ArrayList<activosxsolicitudxproveedor> arregloactivosxsolicitudxproveedor) {
        this.arregloactivosxsolicitudxproveedor = arregloactivosxsolicitudxproveedor;
    }

    
    
    public ArrayList<detalle_solicitud_empresa> getArrsoliempresa() {
        return arrsoliempresa;
    }

    public void setArrsoliempresa(ArrayList<detalle_solicitud_empresa> arrsoliempresa) {
        this.arrsoliempresa = arrsoliempresa;
    }
    
    public ArrayList<TotalSolicitudEmpresaxResponsable> getArregloTotalSolicitudEmpresaxResponsable() {
        return arregloTotalSolicitudEmpresaxResponsable;
    }

    public void setArregloTotalSolicitudEmpresaxResponsable(ArrayList<TotalSolicitudEmpresaxResponsable> arregloTotalSolicitudEmpresaxResponsable) {
        this.arregloTotalSolicitudEmpresaxResponsable = arregloTotalSolicitudEmpresaxResponsable;
    }

    public detalle_solicitud_empresa getDse_p() {
        return dse_p;
    }

    public void setDse_p(detalle_solicitud_empresa dse_p) {
        this.dse_p = dse_p;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

       public Articulo getAr() {
        return ar;
    }

    public void setAr(Articulo ar) {
        this.ar = ar;
    }

    public Empresa getEmpresa_p() {
        return empresa_p;
    }

    public void setEmpresa_p(Empresa empresa_p) {
        this.empresa_p = empresa_p;
    }
    
    

    public ArrayList<TotalArticulosSolixEmpresa> getArregloTotalArticulosSolixEmpresa() {
        return arregloTotalArticulosSolixEmpresa;
    }

    public void setArregloTotalArticulosSolixEmpresa(ArrayList<TotalArticulosSolixEmpresa> arregloTotalArticulosSolixEmpresa) {
        this.arregloTotalArticulosSolixEmpresa = arregloTotalArticulosSolixEmpresa;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

  

    
    
    public ArrayList<detalle_solicitud_persona_juridica> getArrsolipersona() {
        return arrsolipersona;
    }

    public void setArrsolipersona(ArrayList<detalle_solicitud_persona_juridica> arrsolipersona) {
        this.arrsolipersona = arrsolipersona;
    }

    public CartesianChartModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CartesianChartModel categoryModel) {
        this.categoryModel = categoryModel;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFech_fin() {
        return fech_fin;
    }

    public void setFech_fin(Date fech_fin) {
        this.fech_fin = fech_fin;
    }

    public Date getFech_ini() {
        return fech_ini;
    }

    public void setFech_ini(Date fech_ini) {
        this.fech_ini = fech_ini;
    }

    public Persona_Juridica getPersona_p() {
        return persona_p;
    }

    public void setPersona_p(Persona_Juridica persona_p) {
        this.persona_p = persona_p;
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }


    public Proyecto getPro() {
        return pro;
    }

    public void setPro(Proyecto pro) {
        this.pro = pro;
    }

    public Responsable getRes() {
        return res;
    }

    public void setRes(Responsable res) {
        this.res = res;
    }
          
        public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }
        //====================================================================================
    public PieChartModel createPieModelTotalArticulosSolixEmpresa() {  
        if (arregloTotalArticulosSolixEmpresa.size()==0){       
              this.getreporteTotalArticulosSolixEmpresa();
         }
        pieModel = new PieChartModel();  
        try{        
            for(int i=0; i<arregloTotalArticulosSolixEmpresa.size();i++){                                       
                    pieModel.set(arregloTotalArticulosSolixEmpresa.get(i).getNombre(), arregloTotalArticulosSolixEmpresa.get(i).getPrecio_total());              
            }  
       }catch(Exception error){
        System.out.println("Error en el metodo por: " +
                   error.getMessage());         
        }    
     return this.pieModel;   
    }     
    //========================================================================================
    public CartesianChartModel createBarModelTotalArticuloSolixEmpresa() {  
        if (arregloTotalArticulosSolixEmpresa.size()==0){       
              this.getreporteTotalArticulosSolixEmpresa();
         }
        categoryModel = new CartesianChartModel();   
        ChartSeries montos = new ChartSeries();         
        Connection conexion = null;
        try{
            montos.setLabel("Montos"); 
            for(int i=0; i<arregloTotalArticulosSolixEmpresa.size();i++){                                       
                    montos.set(arregloTotalArticulosSolixEmpresa.get(i).getNombre(), arregloTotalArticulosSolixEmpresa.get(i).getPrecio_total());              
            }
        
     }catch(Exception error){
        System.out.println("Error en el metodo por: " +
                   error.getMessage());
                error.printStackTrace();
        } 
        categoryModel.addSeries(montos);
     return categoryModel;   
    } 
    //==================================================================================================
    public ArrayList<detalle_solicitud_persona_juridica> getBuscarSolicitudxPersonaJuridicaxFecha(){
        ArrayList<detalle_solicitud_persona_juridica> arr=null;       
       
        ResultSet rs=null;
        detalle_solicitud_persona_juridica obj=null;
        Connection conexion = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall
            ( "{call sp_buscarDetalleSolicitudxPersoJuridicaFecha(?,?,?)}");
            st.setDate(1,new java.sql.Date(fech_ini.getTime()));                   
            st.setDate(2,new java.sql.Date(fech_fin.getTime()));                              
            st.setString(3,this.getPersona_p().getCod_persona()); 
            rs = st.executeQuery();
            if (rs.next()){                              
                arr = new ArrayList<detalle_solicitud_persona_juridica>();
                do{
                    
                    obj =new detalle_solicitud_persona_juridica();
                    
                     obj.setId_detalle_solicitud_persona_juridica(rs.getString("id_detalle_solicitud_persona_juridica"));
                 Persona_Juridica e1=new Persona_Juridica();
                
                 e1.setCod_persona(rs.getString("cod_persona"));
                 e1.setNombre_persona(rs.getString("nombre_persona"));
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
                 obj.setObj_re(re);
                 obj.setFecha_solicitud_persona(rs.getDate("fecha_solicitud_persona"));
                 obj.setEstado_solicitud_persona(rs.getInt("estado_solicitud_persona"));
                    
                    
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
       
//==================================================================================================    
    public ArrayList<TotalArticulosSolixEmpresa> 
            getreporteTotalArticulosSolixEmpresa(){
    if (arregloTotalArticulosSolixEmpresa.size()==0){         
        TotalArticulosSolixEmpresa obj=null;
        Connection conexion = null;
        ResultSet rs = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall
            ( "{call sp_TotalArticulosxSolixEmpresa()}");    
            rs = st.executeQuery();        
            if (rs.next()){               
                do{
                obj =new TotalArticulosSolixEmpresa();
                obj.setNombre(rs.getString("nombre"));
                
                obj.setPrecio_total(rs.getDouble("precio_articulo"));
                obj.setCantidad(rs.getInt("cantidad"));                
                arregloTotalArticulosSolixEmpresa.add(obj);
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
        return this.arregloTotalArticulosSolixEmpresa;
    
    }
    
    //--------------------------------------------------------------------------------
    public ArrayList<detalle_solicitud_empresa> getBuscarSolicitudEmpresaxResponsable(){
        ArrayList<detalle_solicitud_empresa> arr=null;
        detalle_solicitud_empresa obj=null;
        Connection conexion = null;
        ResultSet rs = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall
            ( "{call sp_TotalSolicitudEmpresaxResponsable(?)}");  
            st.setString(1, res.getCod_responsable());            
            rs = st.executeQuery();        
            if (rs.next()){               
                arr= new ArrayList<detalle_solicitud_empresa>();
                do{
                obj =new detalle_solicitud_empresa();
                obj.setId_detalle_solicitud_empresa(rs.getString("id_detalle_solicitud_empresa"));
                obj.setNombre_solicitud(rs.getString("nombre_solicitud"));
                
                Articulo a1=new Articulo();
                a1.setNombre_articulo(rs.getString("nombre_articulo"));
                Proyecto p1=new Proyecto();
                p1.setNombre_proyecto(rs.getString("nombre_proyecto"));
                obj.setObj_ar(a1);
                obj.setObj_pro(p1);
                
                arr.add(obj);
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
               
        return arr;  
                     
    }
    //============================================================================
    public ArrayList<detalle_solicitud_persona_juridica> getBuscarultimasxsolicitudxpj(){
        ArrayList<detalle_solicitud_persona_juridica> arr=null;
        detalle_solicitud_persona_juridica obj=null;
        Connection conexion = null;
        ResultSet rs = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall
            ( "{call sp_ulimasxsolicitudxpj(?)}");  
            st.setString(1, persona_p.getCod_persona());            
            rs = st.executeQuery();        
            if (rs.next()){               
                arr= new ArrayList<detalle_solicitud_persona_juridica>();
                do{
                obj =new detalle_solicitud_persona_juridica();
                obj.setId_detalle_solicitud_persona_juridica(rs.getString("id_detalle_solicitud_persona_juridica"));
                obj.setNombre_solicitud(rs.getString("nombre_solicitud"));
                obj.setFecha_solicitud_persona(rs.getDate("fecha_solicitud_persona"));
                obj.setEstado_solicitud_persona(rs.getInt("estado_solicitud_persona"));
                
                Persona_Juridica a1=new Persona_Juridica();
                a1.setCod_persona(rs.getString("cod_persona"));
                a1.setNombre_persona(rs.getString("nombre_persona"));
                obj.setObj_pe(a1);
           
                
                arr.add(obj);
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
               
        return arr;  
                     
    }
    
    //======================================================================================================
    public ArrayList<detalle_solicitud_empresa> getBuscarArticulosxSoliEmpresaxMonto(){
        if (arrsoliempresa.size()==0){         
        detalle_solicitud_empresa obj=null;
        Connection conexion = null;
        ResultSet rs = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall
            ( "{call sp_ArticulosxSoliEmpresaxMonto(?,?)}");  
            st.setString(1, empresa_p.getCod_empresa());
            st.setDouble(2, importe);
            rs = st.executeQuery();        
            if (rs.next()){               
                do{
                obj =new detalle_solicitud_empresa();
                 
                 obj.setId_detalle_solicitud_empresa(rs.getString("id_detalle_solicitud_empresa"));
                 obj.setNombre_solicitud(rs.getString("nombre_solicitud"));
                 Articulo a1=new Articulo();
                 a1.setCod_articulo(rs.getString("cod_articulo"));
                 a1.setNombre_articulo(rs.getString("nombre_articulo"));
                 a1.setCantidad_articulo(rs.getInt("StockActual"));
                 obj.setObj_ar(a1);
                
                 
                arrsoliempresa.add(obj);
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
        return this.arrsoliempresa;  
                     
    }
   //===============================================================================
    public ArrayList<detalle_solicitud_empresa> getBuscarSolicitudxEmpresaxFecha(){
        ArrayList<detalle_solicitud_empresa> arr=null;       
       
        ResultSet rs=null;
        detalle_solicitud_empresa obj=null;
        Connection conexion = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall
            ( "{call sp_buscarDetalleSolicitudxEmpresaFecha(?,?,?)}");
            st.setDate(1,new java.sql.Date(fech_ini.getTime()));                   
            st.setDate(2,new java.sql.Date(fech_fin.getTime()));                              
            st.setString(3,this.getEmpresa_p().getCod_empresa()); 
            rs = st.executeQuery();
            if (rs.next()){                              
                arr = new ArrayList<detalle_solicitud_empresa>();
                do{
                    
                    obj =new detalle_solicitud_empresa();
                    
                     obj.setId_detalle_solicitud_empresa(rs.getString("id_detalle_solicitud_empresa"));
                 Empresa e1=new Empresa();
                
                 e1.setCod_empresa(rs.getString("cod_empresa"));
                 e1.setNombre_empresa(rs.getString("nombre_empresa"));
                 obj.setObj_em(e1);
                
                 obj.setNombre_solicitud(rs.getString("nombre_solicitud"));
                 Responsable re=new Responsable();
                 re.setCod_responsable(rs.getString("cod_responsable"));
                 re.setNombre_responsable(rs.getString("nombre_responsable"));
                 obj.setObj_re(re);
                 Proyecto y1= new Proyecto();
                 y1.setId_proyecto(rs.getString("id_proyecto"));
                 y1.setNombre_proyecto(rs.getString("nombre_proyecto"));
                 obj.setObj_pro(y1);
                 Articulo a1= new Articulo();
                 a1.setCod_articulo(rs.getString("cod_articulo"));
                 a1.setNombre_articulo(rs.getString("nombre_articulo"));
                 obj.setObj_ar(a1);
                 
                 obj.setFecha_solicitud_empresa(rs.getDate("fecha_solicitud_empresa"));
                 obj.setEstado_solicitud_empresa(rs.getInt("estado_solicitud_empresa"));
                    
                    
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
    
    //============================================================
     public ArrayList<detalle_solicitud_proveedor> getBuscaractivosxsolicitudxproveedor(){
        ArrayList<detalle_solicitud_proveedor> arr=null;
        detalle_solicitud_proveedor obj=null;
        Connection conexion = null;
        ResultSet rs = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall
            ( "{call sp_activosxsolicitudxproveedor(?)}");  
            st.setString(1, ov.getId_proveedor());            
            rs = st.executeQuery();        
            if (rs.next()){               
                arr= new ArrayList<detalle_solicitud_proveedor>();
                do{
                obj =new detalle_solicitud_proveedor();
                
                obj.setId_detalle_proveedor(rs.getString("id_detalle_proveedor"));
                
                
                
                Articulo a = new Articulo();
                a.setCod_articulo(rs.getString("cod_articulo"));
                a.setNombre_articulo(rs.getString("nombre_articulo"));
                obj.setObj_ar(a);
                
                Solicitud o = new Solicitud();
                o.setNombre_solicitud(rs.getString("nombre_solicitud"));
                obj.setObj_ds(o);
                
                obj.setFecha_solicitud_proveedor(rs.getDate("fecha_solicitud_proveedor"));
                obj.setEstado_solicitud_proveedor(rs.getInt("estado_solicitud_proveedor"));
               
           
                
                arr.add(obj);
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
               
        return arr;  
                     
    }
    
       ///=========================================================
     
     public ArrayList<TotalArticulosxSolixPersonaJuridica> 
            getreporteTotalArticulosSolixPersona(){
    if (arregloTotalArticulosSolixPersona.size()==0){         
        TotalArticulosxSolixPersonaJuridica obj=null;
        Connection conexion = null;
        ResultSet rs = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall
            ( "{call sp_TotalArticulosxSolixPersonaJuridica()}");    
            rs = st.executeQuery();        
            if (rs.next()){               
                do{
                obj =new TotalArticulosxSolixPersonaJuridica();
                obj.setNombre_persona(rs.getString("nombre"));
                
                obj.setPrecio_total(rs.getDouble("precio_articulo"));
                obj.setCantidad(rs.getInt("cantidad"));                
                arregloTotalArticulosSolixPersona.add(obj);
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
        return this.arregloTotalArticulosSolixPersona;
    
    }
          //=========================================================================
          public PieChartModel createPieModelTotalArticulosSolixPersona() {  
        if (arregloTotalArticulosSolixPersona.size()==0){       
              this.getreporteTotalArticulosSolixPersona();
         }
        pieModel = new PieChartModel();  
        try{        
            for(int i=0; i<arregloTotalArticulosSolixPersona.size();i++){                                       
                    pieModel.set(arregloTotalArticulosSolixPersona.get(i).getNombre_persona(), arregloTotalArticulosSolixPersona.get(i).getPrecio_total());              
            }  
       }catch(Exception error){
        System.out.println("Error en el metodo por: " +
                   error.getMessage());         
        }    
     return this.pieModel;   
    }     
    //========================================================================================
    public CartesianChartModel createBarModelTotalArticuloSolixPersona() {  
        if (arregloTotalArticulosSolixPersona.size()==0){       
              this.getreporteTotalArticulosSolixPersona();
         }
        categoryModel = new CartesianChartModel();   
        ChartSeries montos = new ChartSeries();         
        Connection conexion = null;
        try{
            montos.setLabel("Montos"); 
            for(int i=0; i<arregloTotalArticulosSolixPersona.size();i++){                                       
                    montos.set(arregloTotalArticulosSolixPersona.get(i).getNombre_persona(), arregloTotalArticulosSolixPersona.get(i).getPrecio_total());              
            }
        
     }catch(Exception error){
        System.out.println("Error en el metodo por: " +
                   error.getMessage());
                error.printStackTrace();
        } 
        categoryModel.addSeries(montos);
     return categoryModel;   
    } 
    
    
    
    //====================================================
    
    public ArrayList<detalle_solicitud_empresa> getBuscarproyectoxempresa(){
        ArrayList<detalle_solicitud_empresa> arr=null;
        detalle_solicitud_empresa obj=null;
        Connection conexion = null;
        ResultSet rs = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall
            ( "{call sp_proyectoxempresa(?)}");  
            st.setString(1, pro.getId_proyecto());            
            rs = st.executeQuery();        
            if (rs.next()){               
                arr= new ArrayList<detalle_solicitud_empresa>();
                do{
                obj =new detalle_solicitud_empresa();
                obj.setId_detalle_solicitud_empresa(rs.getString("id_detalle_solicitud_empresa"));
                
                Empresa e = new Empresa();
                e.setCod_empresa(rs.getString("cod_empresa"));
                e.setNombre_empresa(rs.getString("nombre_empresa"));
                obj.setObj_em(e);
                
                obj.setNombre_solicitud(rs.getString("nombre_solicitud"));
                
                
                Articulo or = new Articulo();
               or.setNombre_articulo(rs.getString("nombre_articulo"));
               obj.setObj_ar(or);
               
         
               
                obj.setFecha_solicitud_empresa(rs.getDate("fecha_solicitud_empresa"));
                obj.setEstado_solicitud_empresa(rs.getInt("estado_solicitud_empresa"));
                
                        
                
                arr.add(obj);
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
               
        return arr;  
                     
    }
    //===========================================================================
    public ArrayList<dsalida_matemp> getBuscarSalidaxEmpresaxFecha(){
        ArrayList<dsalida_matemp> arr=null;       
       
        ResultSet rs=null;
        dsalida_matemp obj=null;
        Connection conexion = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall
            ( "{call sp_buscarArticulosxDsalidaemp(?,?,?)}");
            st.setDate(1,new java.sql.Date(fech_ini.getTime()));                   
            st.setDate(2,new java.sql.Date(fech_fin.getTime()));                              
            st.setString(3,this.getEmpresa_p().getCod_empresa()); 
            rs = st.executeQuery();
            if (rs.next()){                              
                arr = new ArrayList<dsalida_matemp>();
                do{
                    
                    obj =new dsalida_matemp();
                    
                     obj.setId_salida_mateemp(rs.getInt("id_salida_mateemp"));
                     obj.setCantidad_material(rs.getInt("cantidad_material"));
                 Articulo e1=new Articulo();
                
                 e1.setCod_articulo(rs.getString("cod_articulo"));
                 e1.setNombre_articulo(rs.getString("nombre_articulo"));
                 obj.setObj_ar(e1);
                
                 
                    
                    
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
