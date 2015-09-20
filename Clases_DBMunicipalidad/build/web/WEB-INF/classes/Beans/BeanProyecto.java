/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.ControladorBD;
import Modelo.Proyecto;
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
public class BeanProyecto implements Serializable {

    private Proyecto selectedProyecto;
    private Proyecto proyecto_a = new Proyecto();
    private ArrayList<Proyecto> arreglo = new ArrayList<Proyecto>();
    private List<Proyecto> arrayProyecto = new ArrayList<Proyecto>();

    public BeanProyecto() {
    }

    public List<Proyecto> getArrayProyecto() {
        return arrayProyecto;
    }

    public void setArrayProyecto(List<Proyecto> arrayProyecto) {
        this.arrayProyecto = arrayProyecto;
    }

    public ArrayList<Proyecto> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Proyecto> arreglo) {
        this.arreglo = arreglo;
    }

    public Proyecto getProyecto_a() {
        return proyecto_a;
    }

    public void setProyecto_a(Proyecto proyecto_a) {
        this.proyecto_a = proyecto_a;
    }

    public Proyecto getSelectedProyecto() {
        return selectedProyecto;
    }

    public void setSelectedProyecto(Proyecto selectedProyecto) {
        this.selectedProyecto = selectedProyecto;
    }

    public boolean Registrar() {
        boolean a = false;
        Connection conexion = null;
        try {
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall("{call sp_registrar_proyecto" + "(?,?,?,?)}");
            st.setString(1, proyecto_a.getNombre_proyecto());
            st.setString(2, proyecto_a.getTipo_proyecto());
            st.setInt(3, proyecto_a.getEstado_proyecto());
            st.registerOutParameter(4, java.sql.Types.VARCHAR);
            st.execute();
            proyecto_a.setId_proyecto(st.getString(4));
            if (proyecto_a.getId_proyecto() != null) {
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

    public ArrayList<Proyecto> getCargarProyecto() {
        Proyecto obj = null;
        Connection conexion = null;
        ResultSet rs = null;
        try {
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall("{call sp_listar_proyecto()}");
            rs = st.executeQuery();
            if (rs.next()) {
                this.arreglo = new ArrayList<Proyecto>();
                do {
                    obj = new Proyecto();
                    obj.setId_proyecto(rs.getString("id_proyecto"));
                    obj.setNombre_proyecto(rs.getString("nombre_proyecto"));
                    obj.setTipo_proyecto(rs.getString("tipo_proyecto"));
                    obj.setEstado_proyecto(rs.getInt("estado_proyecto"));
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

    public String doregistra_proyecto() {
        try {
            if (this.Registrar()) {
                Mensaje.guardarMensajeExito("Registro Proyecto: Codigo " + this.getProyecto_a().getId_proyecto());

            } else {
                Mensaje.manejarError("Registrando Proyecto");
            }
        } catch (Exception e) {
            Mensaje.manejarError(e);
        }
        return null;
    }

    public List<Proyecto> getCargarComboPro() {
        if (this.arrayProyecto.size() == 0) {
            Proyecto obj = null;
            Connection conexion = null;
            ResultSet rs = null;
            try {
                conexion = ControladorBD.darConexionBD();
                CallableStatement st = conexion.prepareCall("{call sp_listar_proyectoxactivo()}");
                rs = st.executeQuery();
                if (rs.next()) {

                    do {
                        obj = new Proyecto();
                        obj.setId_proyecto(rs.getString("id_proyecto"));
                        obj.setNombre_proyecto(rs.getString("nombre_proyecto"));
                        obj.setTipo_proyecto(rs.getString("tipo_proyecto"));
                        obj.setEstado_proyecto(rs.getInt("estado_proyecto"));
                        arrayProyecto.add(obj);
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
        return this.arrayProyecto;
    }

    public boolean Actualizar() {
        boolean a = false;
        Connection conexion = null;
        try {
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall("{call sp_ActualizarProyecto(?,?,?,?)}");

            st.setString(1, proyecto_a.getId_proyecto());
            st.setString(2, proyecto_a.getNombre_proyecto());
            st.setString(3, proyecto_a.getTipo_proyecto());
            st.setInt(4, proyecto_a.getEstado_proyecto());

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
        final Proyecto proy = (Proyecto) event.getObject();
        this.setProyecto_a(proy);
        this.Actualizar();
    }

    public void onCancel(RowEditEvent event) {
    }

    public String doActualizarProyecto() {
        this.setProyecto_a(selectedProyecto);
        try {
            if (this.Actualizar()) {
                Mensaje.guardarMensajeExito("Acualizacion Proyectos: ID_proyecto " + this.getProyecto_a().getId_proyecto());

            } else {
                Mensaje.manejarError("Actualizando Proyectos");
            }
        } catch (Exception e) {
            Mensaje.manejarError(e);
        }
        return null;
    }
}
