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
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class BeanPersona_Juridica implements Serializable {

    private Persona_Juridica selectedpersojuridica;
    private Persona_Juridica juridica_a = new Persona_Juridica();
    private ArrayList<Persona_Juridica> arreglo = new ArrayList<Persona_Juridica>();
    private List<Persona_Juridica> arraypersona_juridica = new ArrayList<Persona_Juridica>();
    private String parametro;

    public BeanPersona_Juridica() {
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public List<Persona_Juridica> getArraypersona_juridica() {
        return arraypersona_juridica;
    }

    public void setArraypersona_juridica(List<Persona_Juridica> arraypersona_juridica) {
        this.arraypersona_juridica = arraypersona_juridica;
    }

    public ArrayList<Persona_Juridica> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Persona_Juridica> arreglo) {
        this.arreglo = arreglo;
    }

    public Persona_Juridica getJuridica_a() {
        return juridica_a;
    }

    public void setJuridica_a(Persona_Juridica juridica_a) {
        this.juridica_a = juridica_a;
    }

    public Persona_Juridica getSelectedpersojuridica() {
        return selectedpersojuridica;
    }

    public void setSelectedpersojuridica(Persona_Juridica selectedpersojuridica) {
        this.selectedpersojuridica = selectedpersojuridica;
    }

    public boolean Registrar() {
        boolean a = false;
        Connection conexion = null;
        try {
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall("{call sp_registrar_persona_juridica" + "(?,?,?,?,?,?,?,?,?)}");
            st.setString(1, juridica_a.getRuc_persona());
            st.setString(2, juridica_a.getNombre_persona());
            st.setString(3, juridica_a.getApellido_persona());
            st.setString(4, juridica_a.getDireccion_persona());
            st.setString(5, juridica_a.getCelular_persona());
            st.setString(6, juridica_a.getSexo_persona());
            st.setString(7, juridica_a.getEdad_persona());
            st.setInt(8, juridica_a.getEstado_persona());
            st.registerOutParameter(9, java.sql.Types.VARCHAR);
            st.execute();
            juridica_a.setCod_persona(st.getString(9));
            if (juridica_a.getCod_persona() != null) {
                a = true;
            }
            st.close();
            conexion.close();
        } catch (Exception error) {
            System.out.println("error en el metodo por: " + error.getMessage());
            error.printStackTrace();
        }
        return a;
    }

    public ArrayList<Persona_Juridica> getCargarPersona_Juridica() {

        Persona_Juridica obj = null;
        Connection conexion = null;
        ResultSet rs = null;
        try {
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall("{call sp_listar_personasjuridicas()}");
            rs = st.executeQuery();
            if (rs.next()) {
                this.arreglo = new ArrayList<Persona_Juridica>();
                do {
                    obj = new Persona_Juridica();
                    obj.setCod_persona(rs.getString("cod_persona"));
                    obj.setRuc_persona(rs.getString("ruc_persona"));
                    obj.setNombre_persona(rs.getString("nombre_persona"));
                    obj.setApellido_persona(rs.getString("apellido_persona"));
                    obj.setDireccion_persona(rs.getString("direccion_persona"));
                    obj.setCelular_persona(rs.getString("celular_persona"));
                    obj.setSexo_persona(rs.getString("sexo_persona"));
                    obj.setEdad_persona(rs.getString("edad_persona"));
                    obj.setEstado_persona(rs.getInt("estado_persona"));
                    arreglo.add(obj);
                } while (rs.next());
            }
            rs.close();
            st.close();
            conexion.close();
        } catch (Exception error) {
        }
        return this.arreglo;
    }

    public String doregistra_persona_juridica() {
        try {
            if (this.Registrar()) {
                Mensaje.guardarMensajeExito("Registra Persona Juridica: Codigo " + this.getJuridica_a().getCod_persona());

            } else {
                Mensaje.manejarError2("Ruc Existente Persona Juridica No Valida");
            }
        } catch (Exception e) {
            Mensaje.manejarError(e);
        }
        return null;

    }

    public List<Persona_Juridica> getCargarCombona() {
        if (this.arraypersona_juridica.size() == 0) {
            Persona_Juridica obj = null;
            Connection conexion = null;
            ResultSet rs = null;
            try {
                conexion = ControladorBD.darConexionBD();
                CallableStatement st = conexion.prepareCall("{call sp_listar_personasjuridicas()}");
                rs = st.executeQuery();
                if (rs.next()) {

                    do {

                        obj = new Persona_Juridica();
                        obj.setCod_persona(rs.getString("cod_persona"));
                        obj.setRuc_persona(rs.getString("ruc_persona"));
                        obj.setNombre_persona(rs.getString("nombre_persona"));
                        obj.setApellido_persona(rs.getString("apellido_persona"));
                        obj.setDireccion_persona(rs.getString("direccion_persona"));
                        obj.setCelular_persona(rs.getString("celular_persona"));
                        obj.setSexo_persona(rs.getString("sexo_persona"));
                        obj.setEdad_persona(rs.getString("edad_persona"));
                        obj.setEstado_persona(rs.getInt("estado_persona"));

                        arraypersona_juridica.add(obj);
                    } while (rs.next());
                }
                rs.close();
                st.close();
                conexion.close();

            } catch (Exception error) {
                System.out.println("Error en el metodo por: "
                        + error.getMessage());
                error.printStackTrace();
            }
        }
        return this.arraypersona_juridica;
    }

    public boolean Actualizar() {
        boolean a = false;
        Connection conexion = null;
        try {
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall("{call sp_ActualizarPersonaJuridica(?,?,?,?,?,?,?,?,?)}");

            st.setString(1, juridica_a.getCod_persona());
            st.setString(2, juridica_a.getRuc_persona());
            st.setString(3, juridica_a.getNombre_persona());
            st.setString(4, juridica_a.getApellido_persona());
            st.setString(5, juridica_a.getDireccion_persona());
            st.setString(6, juridica_a.getCelular_persona());
            st.setString(7, juridica_a.getSexo_persona());
            st.setString(8, juridica_a.getEdad_persona());
            st.setInt(9, juridica_a.getEstado_persona());

            st.execute();
            a = true;
            st.close();
            conexion.close();
        } catch (Exception error) {
            System.out.println("Error en el metodo por: " + error.getMessage());
            error.printStackTrace();
        }

        return a;
    }

    public void onEdit(RowEditEvent event) {
        final Persona_Juridica pj = (Persona_Juridica) event.getObject();
        this.setJuridica_a(pj);
        this.Actualizar();
    }

    public void onCancel(RowEditEvent event) {
    }

    public String doActualizarPersonaJuridica() {
        this.setJuridica_a(selectedpersojuridica);
        try {
            if (this.Actualizar()) {
                Mensaje.guardarMensajeExito("Acualizacion Persona Juridica: Codigo " + this.getJuridica_a().getCod_persona());

            } else {
                Mensaje.manejarError("Actualizando Persona Juridica");
            }
        } catch (Exception e) {
            Mensaje.manejarError(e);
        }
        return null;
    }

    public ArrayList<Persona_Juridica> getFiltrarPersona_Juridica() {
        if (arreglo.size() == 0) {
            ResultSet rs = null;
            Persona_Juridica obj = null;
            Connection conexion = null;
            try {
                conexion = ControladorBD.darConexionBD();
                CallableStatement st = conexion.prepareCall("{call sp_FiltrarPersonaJuridica(?)}");
                st.setString(1, this.parametro);
                rs = st.executeQuery();
                if (rs.next()) {

                    do {
                        obj = new Persona_Juridica();
                        obj.setCod_persona(rs.getString("cod_persona"));
                        obj.setRuc_persona(rs.getString("ruc_persona"));
                        obj.setNombre_persona(rs.getString("nombre_persona"));
                        obj.setApellido_persona(rs.getString("apellido_persona"));
                        obj.setDireccion_persona(rs.getString("direccion_persona"));
                        obj.setCelular_persona(rs.getString("celular_persona"));
                        obj.setSexo_persona(rs.getString("sexo_persona"));
                        obj.setEdad_persona(rs.getString("edad_persona"));
                        obj.setEstado_persona(rs.getInt("estado_persona"));
                        arreglo.add(obj);
                    } while (rs.next());
                }
                rs.close();
                st.close();
                conexion.close();


            } catch (Exception error) {
                System.out.println("Error en el metodo por: " + error.getMessage());
                error.printStackTrace();
            }
        }
        return arreglo;
    }
    
    
    public List<Persona_Juridica> getCargarCombonaxactivo() {
        if (this.arraypersona_juridica.size() == 0) {
            Persona_Juridica obj = null;
            Connection conexion = null;
            ResultSet rs = null;
            try {
                conexion = ControladorBD.darConexionBD();
                CallableStatement st = conexion.prepareCall("{call sp_listar_personasjuridicasxactivo()}");
                rs = st.executeQuery();
                if (rs.next()) {

                    do {

                        obj = new Persona_Juridica();
                        obj.setCod_persona(rs.getString("cod_persona"));
                        obj.setRuc_persona(rs.getString("ruc_persona"));
                        obj.setNombre_persona(rs.getString("nombre_persona"));
                        obj.setApellido_persona(rs.getString("apellido_persona"));
                        obj.setDireccion_persona(rs.getString("direccion_persona"));
                        obj.setCelular_persona(rs.getString("celular_persona"));
                        obj.setSexo_persona(rs.getString("sexo_persona"));
                        obj.setEdad_persona(rs.getString("edad_persona"));
                        obj.setEstado_persona(rs.getInt("estado_persona"));

                        arraypersona_juridica.add(obj);
                    } while (rs.next());
                }
                rs.close();
                st.close();
                conexion.close();

            } catch (Exception error) {
                System.out.println("Error en el metodo por: "
                        + error.getMessage());
                error.printStackTrace();
            }
        }
        return this.arraypersona_juridica;
    }


   
}
