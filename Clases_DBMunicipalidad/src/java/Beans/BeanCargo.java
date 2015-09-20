/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Cargo;
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
 *
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class BeanCargo implements Serializable{
    
    private Cargo selectedCargo;
    private Cargo cargo_a= new Cargo();
    private ArrayList<Cargo> 
    arreglo = new ArrayList<Cargo>();
    private List<Cargo> arrayCargo   = new ArrayList<Cargo>();
    private String parametro;

    public List<Cargo> getArrayCargo() {
        return arrayCargo;
    }

    public void setArrayCargo(List<Cargo> arrayCargo) {
        this.arrayCargo = arrayCargo;
    }

    public ArrayList<Cargo> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Cargo> arreglo) {
        this.arreglo = arreglo;
    }

    public Cargo getCargo_a() {
        return cargo_a;
    }

    public void setCargo_a(Cargo cargo_a) {
        this.cargo_a = cargo_a;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public Cargo getSelectedCargo() {
        return selectedCargo;
    }

    public void setSelectedCargo(Cargo selectedCargo) {
        this.selectedCargo = selectedCargo;
    }

    
 
    
    public boolean Registrar(){
       boolean a=false;
       Connection conexion=null;
       try{
       conexion=ControladorBD.darConexionBD();
       CallableStatement st =conexion.prepareCall("{call sp_registrar_cargo" + "(?,?)}");
       st.setString(1,cargo_a.getDescripcion_cargo());
       st.registerOutParameter(2,java.sql.Types.VARCHAR);
       st.execute();
       cargo_a.setId_cargo(st.getString(2));
       if(cargo_a.getId_cargo()!=null){
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
    public ArrayList<Cargo>
    getCargarCargo(){
        Cargo obj=null;
        Connection conexion =null;
        ResultSet rs=null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st=conexion.prepareCall( "{call sp_listar_cargos()}");
            rs = st.executeQuery();
            if (rs.next()){
             this.arreglo=new ArrayList<Cargo>();
             do{
                 obj=new Cargo();
                 obj.setId_cargo(rs.getString("id_cargo"));
                 obj.setDescripcion_cargo(rs.getString("descripcion_cargo"));
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
    
    
    
     public List<Cargo> getCargarComboCargo(){         
    if (this.arrayCargo.size()==0){         
        Cargo obj=null;
    Connection conexion = null;
    ResultSet rs = null;
    try{
    conexion = ControladorBD.darConexionBD();
    CallableStatement st = conexion.prepareCall
  ( "{call sp_listar_cargos()}");    
    rs = st.executeQuery();        
    if (rs.next()){        
       
        do{
        obj =new Cargo();
        obj.setId_cargo(rs.getString("id_cargo"));
        obj.setDescripcion_cargo(rs.getString("descripcion_cargo"));        
        arrayCargo.add(obj);
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
    return this.arrayCargo;
    }
     
        public String doRegistraCargo()
        {
            try
        {
            if (this.Registrar()){
                Mensaje.guardarMensajeExito( "Registro Cargo: id " + this.getCargo_a().getId_cargo());

            }else {
                Mensaje.manejarError("Registrando Cargo");
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
      CallableStatement st=conexion.prepareCall("{call sp_ActualizarCargo(?,?)}");
        
      st.setString(1,cargo_a.getId_cargo());
      st.setString(2,cargo_a.getDescripcion_cargo());
      
      
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
    final Cargo car=(Cargo) event.getObject();     
    this.setCargo_a(car);
    this.Actualizar();
    }  
      
    public void onCancel(RowEditEvent event) {  
        
    }
    
    public String doActualizarCargo()
        {
        this.setCargo_a(selectedCargo);
            try
        {
            if (this.Actualizar()){
                Mensaje.guardarMensajeExito( "Acualizacion Cargo: ID_cargo " + this.getCargo_a().getId_cargo());

            }else {
                Mensaje.manejarError("Actualizando Cargo");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
           return null;
        }
    
}
