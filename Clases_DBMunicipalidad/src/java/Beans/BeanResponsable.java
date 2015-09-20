/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Cargo;
import Modelo.ControladorBD;
import Modelo.Responsable;
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
public class BeanResponsable implements Serializable{
    
    private Responsable selectedResponsable;
    
     private Responsable responsable_a = new Responsable();
    private ArrayList<Responsable> arreglo =         new  ArrayList<Responsable>();    
    private List<Responsable> arrayResponsable   = new ArrayList<Responsable>();

    public List<Responsable> getArrayResponsable() {
        return arrayResponsable;
    }

    public void setArrayResponsable(List<Responsable> arrayResponsable) {
        this.arrayResponsable = arrayResponsable;
    }

    public ArrayList<Responsable> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Responsable> arreglo) {
        this.arreglo = arreglo;
    }

    public Responsable getResponsable_a() {
        return responsable_a;
    }

    public void setResponsable_a(Responsable responsable_a) {
        this.responsable_a = responsable_a;
    }

    public Responsable getSelectedResponsable() {
        return selectedResponsable;
    }

    public void setSelectedResponsable(Responsable selectedResponsable) {
        this.selectedResponsable = selectedResponsable;
    }
    
    
    
    public boolean Registrar(){
       boolean a=false;
       Connection conexion=null;
       try{
       conexion=ControladorBD.darConexionBD();
       CallableStatement st =conexion.prepareCall("{call sp_registrar_responsable" + "(?,?,?,?,?,?,?,?,?)}");
       st.setString(1,responsable_a.getNombre_responsable());
       st.setString(2,responsable_a.getApellido_responsable());
       st.setString(3,responsable_a.getSexo_responsable());
       st.setString(4,responsable_a.getEdad_responsable());
       st.setString(5,responsable_a.getCelular_responsable());
       st.setString(6,responsable_a.getDireccion_responsable());
       st.setInt(7,responsable_a.getResponsable_estado());
       st.setString(8,responsable_a.getObj_car().getId_cargo());
       st.registerOutParameter(9,java.sql.Types.VARCHAR);
       st.execute();
       responsable_a.setCod_responsable(st.getString(9));
       if(responsable_a.getCod_responsable()!=null){
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
    
    public ArrayList<Responsable>
    getCargarResponsable(){
        Responsable obj=null;
        Connection conexion =null;
        ResultSet rs=null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st=conexion.prepareCall( "{call sp_listar_responsable()}");
            rs = st.executeQuery();
            if (rs.next()){
             this.arreglo=new ArrayList<Responsable>();
             do{
                 obj=new Responsable();
                 obj.setCod_responsable(rs.getString("cod_responsable"));
                 obj.setNombre_responsable(rs.getString("nombre_responsable"));
                 obj.setApellido_responsable(rs.getString("apellido_responsable"));
                 obj.setSexo_responsable(rs.getString("sexo_responsable"));
                 obj.setEdad_responsable(rs.getString("edad_responsable"));
                 obj.setCelular_responsable(rs.getString("celular_responsable"));
                 obj.setDireccion_responsable(rs.getString("direccion_responsable"));
                 obj.setResponsable_estado(rs.getInt("responsable_estado"));
                 Cargo c1= new Cargo();
                 c1.setId_cargo(rs.getString("id_cargo"));
                 c1.setDescripcion_cargo(rs.getString("descripcion_cargo"));
                 obj.setObj_car(c1);
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
 public List<Responsable> getCargarComboRespo(){         
    if (this.arrayResponsable.size()==0){         
        Responsable obj=null;
    Connection conexion = null;
    ResultSet rs = null;
    try{
    conexion = ControladorBD.darConexionBD();
    CallableStatement st = conexion.prepareCall
  ( "{call sp_listar_responsable()}");    
    rs = st.executeQuery();        
    if (rs.next()){        
       
        do{
        obj =new Responsable();
                 obj.setCod_responsable(rs.getString("cod_responsable"));
                 obj.setNombre_responsable(rs.getString("nombre_responsable"));
                 obj.setApellido_responsable(rs.getString("apellido_responsable"));
                 obj.setSexo_responsable(rs.getString("sexo_responsable"));
                 obj.setEdad_responsable(rs.getString("edad_responsable"));
                 obj.setCelular_responsable(rs.getString("celular_responsable"));
                 obj.setDireccion_responsable(rs.getString("direccion_responsable"));
                 
                 obj.setResponsable_estado(rs.getInt("responsable_estado"));
                 Cargo c1= new Cargo();
                 c1.setId_cargo(rs.getString("id_cargo"));
                 c1.setDescripcion_cargo(rs.getString("descripcion_cargo"));
                 obj.setObj_car(c1);     
        arrayResponsable.add(obj);
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
    return this.arrayResponsable;
    }
 public String doregistra_responsable()
        {
            try
        {
            if (this.Registrar()){
                Mensaje.guardarMensajeExito( "Registro Responsable: Codigo " + this.getResponsable_a().getCod_responsable());

            }else {
                Mensaje.manejarError("Registrando Responsable");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
            return null ;
        }
  public List<Responsable> getCargarComboRespoxactivo(){         
    if (this.arrayResponsable.size()==0){         
        Responsable obj=null;
    Connection conexion = null;
    ResultSet rs = null;
    try{
    conexion = ControladorBD.darConexionBD();
    CallableStatement st = conexion.prepareCall
  ( "{call sp_listar_responsablexactivo()}");    
    rs = st.executeQuery();        
    if (rs.next()){        
       
        do{
        obj =new Responsable();
                 obj.setCod_responsable(rs.getString("cod_responsable"));
                 obj.setNombre_responsable(rs.getString("nombre_responsable"));
                 obj.setApellido_responsable(rs.getString("apellido_responsable"));
                 obj.setSexo_responsable(rs.getString("sexo_responsable"));
                 obj.setEdad_responsable(rs.getString("edad_responsable"));
                 obj.setCelular_responsable(rs.getString("celular_responsable"));
                 obj.setDireccion_responsable(rs.getString("direccion_responsable"));
                 
                 obj.setResponsable_estado(rs.getInt("responsable_estado"));
                 Cargo c1= new Cargo();
                 c1.setId_cargo(rs.getString("id_cargo"));
                 c1.setDescripcion_cargo(rs.getString("descripcion_cargo"));
                 obj.setObj_car(c1);     
        arrayResponsable.add(obj);
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
    return this.arrayResponsable;
    }
 
  
   public boolean Actualizar(){
   boolean a=false;
   Connection conexion=null;
   try{
      conexion=ControladorBD.darConexionBD();
      CallableStatement st=conexion.prepareCall("{call sp_ActualizarResponsable(?,?,?,?,?,?,?,?,?)}");
         
       st.setString(1,responsable_a.getCod_responsable());
       st.setString(2,responsable_a.getNombre_responsable());
       st.setString(3,responsable_a.getApellido_responsable());
       st.setString(4,responsable_a.getSexo_responsable());
       st.setString(5,responsable_a.getEdad_responsable());
       st.setString(6,responsable_a.getCelular_responsable());
       st.setString(7,responsable_a.getDireccion_responsable());
       st.setInt(8,responsable_a.getResponsable_estado());
       st.setString(9,responsable_a.getObj_car().getId_cargo());
    
      
      
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
    final Responsable resp=(Responsable) event.getObject();     
    this.setResponsable_a(resp);
    this.Actualizar();
    }  
      
    public void onCancel(RowEditEvent event) {  
        
    } 
    
    public String doActualizarResponsable()
        {
        this.setResponsable_a(selectedResponsable);
            try
        {
            if (this.Actualizar()){
                Mensaje.guardarMensajeExito( "Acualizacion Responsable: Codigo " + this.getResponsable_a().getCod_responsable());

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
