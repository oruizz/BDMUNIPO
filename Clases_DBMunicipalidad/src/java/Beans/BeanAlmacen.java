/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Almacen;

import Modelo.ControladorBD;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class BeanAlmacen implements Serializable{
    
    
    private Almacen selectedAlmacen;
    
     private Almacen almacen_a= new Almacen();
    private ArrayList<Almacen> 
    arreglo = new ArrayList<Almacen>();
    private String parametro;
 
    
    public BeanAlmacen() {               
    }

    
    public Almacen getAlmacen_a() {
        return almacen_a;
    }

    public void setAlmacen_a(Almacen almacen_a) {
        this.almacen_a = almacen_a;
    }

    public ArrayList<Almacen> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Almacen> arreglo) {
        this.arreglo = arreglo;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public Almacen getSelectedAlmacen() {
        return selectedAlmacen;
    }

    public void setSelectedAlmacen(Almacen selectedAlmacen) {
        this.selectedAlmacen = selectedAlmacen;
    }

   
    
    public boolean Registrar(){
       boolean a=false;
       Connection conexion=null;
       try{
       conexion=ControladorBD.darConexionBD();
       CallableStatement st =conexion.prepareCall("{call sp_registrar_almacen" + "(?,?,?,?,?,?)}");
       st.setString(1,almacen_a.getNombre());
       st.setString(2,almacen_a.getTelefono_almacen());
       st.setString(3,almacen_a.getDireccion_almacen());
       st.setString(4,almacen_a.getFax_almacen());
       st.setInt(5,almacen_a.getEstado_almacen());
       st.registerOutParameter(6,java.sql.Types.VARCHAR);
       st.execute();
       almacen_a.setCod_almacen(st.getString(6));
       if(almacen_a.getCod_almacen()!=null){
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
    
    public ArrayList<Almacen>
    getCargarAlmacen(){
        Almacen obj=null;
        Connection conexion =null;
        ResultSet rs=null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st=conexion.prepareCall( "{call sp_listar_almacen()}");
            rs = st.executeQuery();
            if (rs.next()){
             this.arreglo=new ArrayList<Almacen>();
             do{
                 obj=new Almacen();
                 obj.setCod_almacen(rs.getString("cod_almacen"));
                 obj.setNombre(rs.getString("nombre"));
                 obj.setTelefono_almacen(rs.getString("telefono_almacen"));
                 obj.setDireccion_almacen(rs.getString("direccion_almacen"));
                 obj.setFax_almacen(rs.getString("fax_almacen"));
                 obj.setEstado_almacen(rs.getInt("estado_almacen"));
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
    
     public String doregistra_almacen()
        {
            try
        {
            if (this.Registrar()){
                Mensaje.guardarMensajeExito( "Registro Almacen: Codigo " + this.getAlmacen_a().getCod_almacen());

            }else {
                Mensaje.manejarError("Registrando Almacen");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
            return null ;
        }
     
     public boolean Actualizar(){
   boolean a=false;
   Connection conexion=null;
   try{
      conexion=ControladorBD.darConexionBD();
      CallableStatement st=conexion.prepareCall("{call sp_ActualizarAlmacen(?,?,?,?,?,?)}");
        
      st.setString(1,almacen_a.getCod_almacen());
      st.setString(2,almacen_a.getNombre());
      st.setString(3,almacen_a.getTelefono_almacen());
      st.setString(4,almacen_a.getDireccion_almacen());
      st.setString(5,almacen_a.getFax_almacen());
      st.setInt(6,almacen_a.getEstado_almacen());
      
      
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
    final Almacen alm=(Almacen) event.getObject();     
    this.setAlmacen_a(alm);
    this.Actualizar();
    }  
      
    public void onCancel(RowEditEvent event) {  
        
    }
    
    public String doActualizarAlmacen()
        {
        this.setAlmacen_a(selectedAlmacen);
            try
        {
            if (this.Actualizar()){
                Mensaje.guardarMensajeExito( "Acualizacion Almacen: Cod_almacen " + this.getAlmacen_a().getCod_almacen());

            }else {
                Mensaje.manejarError("Actualizando Almacen");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
           return null;
        }
     
         public ArrayList<Almacen>
    getCargarAlmacenxactivo(){
        Almacen obj=null;
        Connection conexion =null;
        ResultSet rs=null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st=conexion.prepareCall( "{call sp_listar_almacenxactivo()}");
            rs = st.executeQuery();
            if (rs.next()){
             this.arreglo=new ArrayList<Almacen>();
             do{
                 obj=new Almacen();
                 obj.setCod_almacen(rs.getString("cod_almacen"));
                 obj.setNombre(rs.getString("nombre"));
                 obj.setTelefono_almacen(rs.getString("telefono_almacen"));
                 obj.setDireccion_almacen(rs.getString("direccion_almacen"));
                 obj.setFax_almacen(rs.getString("fax_almacen"));
                 obj.setEstado_almacen(rs.getInt("estado_almacen"));
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
}
