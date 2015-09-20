/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.ControladorBD;
import Modelo.Empresa;
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
public class BeanEmpresa implements Serializable{
    
    private Empresa selectedEmpresa;
    
    private Empresa empresa_a= new Empresa();
    private ArrayList<Empresa> 
    arreglo = new ArrayList<Empresa>();
    private List<Empresa> arrayEmpresa   = new ArrayList<Empresa>();
    private String parametro;

    public BeanEmpresa() {               
    }

    public List<Empresa> getArrayEmpresa() {
        return arrayEmpresa;
    }

    public void setArrayEmpresa(List<Empresa> arrayEmpresa) {
        this.arrayEmpresa = arrayEmpresa;
    }

    
    public Empresa getSelectedEmpresa() {
        return selectedEmpresa;
    }

    public void setSelectedEmpresa(Empresa selectedEmpresa) {
        this.selectedEmpresa = selectedEmpresa;
    }

    public Empresa getEmpresa_a() {
        return empresa_a;
    }

    public void setEmpresa_a(Empresa empresa_a) {
        this.empresa_a = empresa_a;
    }

    public ArrayList<Empresa> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Empresa> arreglo) {
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
       CallableStatement st =conexion.prepareCall("{call sp_registrar_empresa" + "(?,?,?,?,?,?)}");
       st.setString(1,empresa_a.getRuc_empresa());
       st.setString(2,empresa_a.getNombre_empresa());
       st.setString(3,empresa_a.getTelefono_empresa());
       st.setString(4,empresa_a.getDireccion_empresa());
       st.setInt(5,empresa_a.getEstado_empresa());
       st.registerOutParameter(6,java.sql.Types.VARCHAR);
       st.execute();
       empresa_a.setCod_empresa(st.getString(6));
       if(empresa_a.getCod_empresa()!=null){
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
    
  public ArrayList<Empresa>getCargarEmpresa(){
        Empresa obj=null;
        arreglo=null;
        Connection conexion =null;
        ResultSet rs=null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st=conexion.prepareCall( "{call sp_listar_empresas()}");
            rs = st.executeQuery();
            if (rs.next()){
             this.arreglo=new ArrayList<Empresa>();
             do{
                 obj=new Empresa();
                 obj.setCod_empresa(rs.getString("cod_empresa"));
                 obj.setRuc_empresa(rs.getString("ruc_empresa"));
                 obj.setNombre_empresa(rs.getString("nombre_empresa"));
                 obj.setTelefono_empresa(rs.getString("telefono_empresa"));
                 obj.setDireccion_empresa(rs.getString("direccion_empresa"));
                 obj.setEstado_empresa(rs.getInt("estado_empresa"));
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
   
    public String doregistra_empresa()
        {
            try
        {
            if (this.Registrar()){
                Mensaje.guardarMensajeExito( "Registro Empresa: Codigo " + this.getEmpresa_a().getCod_empresa());

            }else {
                Mensaje.manejarError2("Empresa Con Ruc Existente");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
            return null ;
        }
    
    public List<Empresa> getCargarComboEmp(){         
    if (this.arrayEmpresa.size()==0){         
        Empresa obj=null;
    Connection conexion = null;
    ResultSet rs = null;
    try{
    conexion = ControladorBD.darConexionBD();
    CallableStatement st = conexion.prepareCall
  ( "{call sp_listar_empresas()}");    
    rs = st.executeQuery();        
    if (rs.next()){        
       
        do{
        obj =new Empresa();
        
        obj.setCod_empresa(rs.getString("cod_empresa"));
       obj.setRuc_empresa(rs.getString("ruc_empresa"));
        obj.setNombre_empresa(rs.getString("nombre_empresa"));
        obj.setTelefono_empresa(rs.getString("telefono_empresa"));
        obj.setDireccion_empresa(rs.getString("direccion_empresa"));
        obj.setEstado_empresa(rs.getInt("estado_empresa"));
        arrayEmpresa.add(obj);
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
    return this.arrayEmpresa;
    }
    
    public ArrayList<Empresa> getFiltrarEmpresa(){
    if (arreglo.size()==0){            
    ResultSet rs=null;
        Empresa obj=null;
        Connection conexion = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall
            ( "{call sp_FiltrarEmpresas(?)}");
            st.setString(1, this.parametro);
            rs = st.executeQuery();
            if (rs.next()){
                
                do{
                obj =new Empresa();
                obj.setCod_empresa(rs.getString("cod_empresa"));
                 obj.setRuc_empresa(rs.getString("ruc_empresa"));
                obj.setNombre_empresa(rs.getString("nombre_empresa"));
               
                obj.setTelefono_empresa(rs.getString("telefono_empresa"));
                obj.setDireccion_empresa(rs.getString("direccion_empresa"));
                obj.setEstado_empresa(rs.getInt("estado_empresa"));
                arreglo.add(obj);
               } while (rs.next());
            }  
                 rs.close();
                 st.close();
                 conexion.close();


        }catch(Exception error){
                System.out.println("Error en el metodo por: " + error.getMessage());
                error.printStackTrace();
        }
    }   
    return arreglo;                
    }
    
    public boolean Actualizar(){
   boolean a=false;
   Connection conexion=null;
   try{
      conexion=ControladorBD.darConexionBD();
      CallableStatement st=conexion.prepareCall("{call sp_ActualizarEmpresa(?,?,?,?,?,?)}");
        
      st.setString(1,empresa_a.getRuc_empresa());
      st.setString(2,empresa_a.getNombre_empresa());
      st.setString(3,empresa_a.getTelefono_empresa());
      st.setString(4,empresa_a.getDireccion_empresa());
      st.setInt(5,empresa_a.getEstado_empresa());
      st.setString(6,empresa_a.getCod_empresa());
      
      
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
    final Empresa emp=(Empresa) event.getObject();     
    this.setEmpresa_a(emp);
    this.Actualizar();
    }  
      
    public void onCancel(RowEditEvent event) {  
        
    } 
    
    public String doActualizarEmpresa()
        {
        this.setEmpresa_a(selectedEmpresa);
            try
        {
            if (this.Actualizar()){
                Mensaje.guardarMensajeExito( "Acualizacion Empresa: Codigo " + this.getEmpresa_a().getCod_empresa());

            }else {
                Mensaje.manejarError("Actualizando Empresa");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
           return null;
        }
    
     public List<Empresa> getCargarComboEmpxActivo(){         
    if (this.arrayEmpresa.size()==0){         
        Empresa obj=null;
    Connection conexion = null;
    ResultSet rs = null;
    try{
    conexion = ControladorBD.darConexionBD();
    CallableStatement st = conexion.prepareCall
  ( "{call sp_listar_empresasxactivo()}");    
    rs = st.executeQuery();        
    if (rs.next()){        
       
        do{
        obj =new Empresa();
        
        obj.setCod_empresa(rs.getString("cod_empresa"));
       obj.setRuc_empresa(rs.getString("ruc_empresa"));
        obj.setNombre_empresa(rs.getString("nombre_empresa"));
        obj.setTelefono_empresa(rs.getString("telefono_empresa"));
        obj.setDireccion_empresa(rs.getString("direccion_empresa"));
        obj.setEstado_empresa(rs.getInt("estado_empresa"));
        arrayEmpresa.add(obj);
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
    return this.arrayEmpresa;
    }
}
