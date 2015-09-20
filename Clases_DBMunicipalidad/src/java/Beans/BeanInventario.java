/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.ControladorBD;
import Modelo.Inventario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class BeanInventario {
      
    private Inventario inventario_a= new Inventario();
    private ArrayList<Inventario> 
    arreglo = new ArrayList<Inventario>();
    private String parametro;
    private Inventario selectedInventario;

    public ArrayList<Inventario> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Inventario> arreglo) {
        this.arreglo = arreglo;
    }

    public Inventario getInventario_a() {
        return inventario_a;
    }

    public void setInventario_a(Inventario inventario_a) {
        this.inventario_a = inventario_a;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public Inventario getSelectedInventario() {
        return selectedInventario;
    }

    public void setSelectedInventario(Inventario selectedInventario) {
        this.selectedInventario = selectedInventario;
    }

      public boolean Registrar(){
       boolean a=false;
       Connection conexion=null;
       try{
       conexion=ControladorBD.darConexionBD();
       CallableStatement st =conexion.prepareCall("{call sp_registrar_inventario" + "(?,?)}");
       if(inventario_a.getFecha_inventario()!= null)                 
                st.setDate(1,new java.sql.Date(inventario_a.getFecha_inventario().getTime()));                   
             else
                    st.setDate(1,null);   
       st.registerOutParameter(2,java.sql.Types.VARCHAR);
       st.execute();
       inventario_a.setId_inventario(st.getString(2));
       if(inventario_a.getId_inventario()!=null){
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
    
    public ArrayList<Inventario>
    getCargarInventario(){
        Inventario obj=null;
        Connection conexion =null;
        ResultSet rs=null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st=conexion.prepareCall( "{call sp_listar_inventario()}");
            rs = st.executeQuery();
            if (rs.next()){
             this.arreglo=new ArrayList<Inventario>();
             do{
                 obj=new Inventario();
                 obj.setId_inventario(rs.getString("id_inventario"));
                 obj.setFecha_inventario(rs.getDate("fecha_inventario"));
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
    
    public String doRegistraInventario()
        {
            try
        {
            if (this.Registrar()){
                Mensaje.guardarMensajeExito( "Registro Inventario: Codigo " + this.getInventario_a().getId_inventario());

            }else {
                Mensaje.manejarError("Registrando Inventario");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
            return null ;
        }
    
}
