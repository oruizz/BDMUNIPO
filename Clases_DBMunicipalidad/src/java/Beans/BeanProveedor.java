/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.ControladorBD;
import Modelo.Proveedor;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.event.RowEditEvent;

/**
 * @author ruiz zapata oscar
 * @author agramonte rey Wilmer
 */
public class BeanProveedor implements Serializable {

    private Proveedor selectedProveedor;
    private Proveedor proveedor_a = new Proveedor();
    private ArrayList<Proveedor> arreglo = new ArrayList<Proveedor>();
    private List<Proveedor> arrayProveedor = new ArrayList<Proveedor>();
    private String parametro;

    public List<Proveedor> getArrayProveedor() {
        return arrayProveedor;
    }

    public void setArrayProveedor(List<Proveedor> arrayProveedor) {
        this.arrayProveedor = arrayProveedor;
    }

    public ArrayList<Proveedor> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Proveedor> arreglo) {
        this.arreglo = arreglo;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public Proveedor getProveedor_a() {
        return proveedor_a;
    }

    public void setProveedor_a(Proveedor proveedor_a) {
        this.proveedor_a = proveedor_a;
    }

    public Proveedor getSelectedProveedor() {
        return selectedProveedor;
    }

    public void setSelectedProveedor(Proveedor selectedProveedor) {
        this.selectedProveedor = selectedProveedor;
    }

    public ArrayList<Proveedor> getFiltrarProveedor() {
        if (arreglo.size() == 0) {
            ResultSet rs = null;
            Proveedor obj = null;
            Connection conexion = null;
            try {
                conexion = ControladorBD.darConexionBD();
                CallableStatement st = conexion.prepareCall("{call sp_FiltrarProveedor(?)}");
                st.setString(1, this.parametro);
                rs = st.executeQuery();
                if (rs.next()) {

                    do {
                        obj = new Proveedor();

                        obj.setId_proveedor(rs.getString("id_proveedor"));
                        obj.setRuc_proveedor(rs.getString("ruc_proveedor"));
                        obj.setNombre_proveedor(rs.getString("nombre_proveedor"));
                        obj.setTelefono_proveedor(rs.getString("telefono_proveedor"));
                        obj.setDireccion_proveedor(rs.getString("direccion_proveedor"));
                        obj.setCiudad_proveedor(rs.getString("ciudad_proveedor"));
                        obj.setServicio_proveedor(rs.getString("servicio_proveedor"));
                        obj.setFax_proveedor(rs.getString("fax_proveedor"));
                        obj.setEstado_proveedor(rs.getInt("estado_proveedor"));


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

    public boolean Registrar() {
        boolean a = false;
        Connection conexion = null;
        try {
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall("{call sp_registrar_proveedor" + "(?,?,?,?,?,?,?,?,?)}");
            st.setString(1, proveedor_a.getRuc_proveedor());
            st.setString(2, proveedor_a.getNombre_proveedor());
            st.setString(3, proveedor_a.getTelefono_proveedor());
            st.setString(4, proveedor_a.getDireccion_proveedor());
            st.setString(5, proveedor_a.getCiudad_proveedor());
            st.setString(6, proveedor_a.getServicio_proveedor());
            st.setString(7, proveedor_a.getFax_proveedor());
            st.setInt(8, proveedor_a.getEstado_proveedor());
            st.registerOutParameter(9, java.sql.Types.VARCHAR);
            st.execute();
            proveedor_a.setId_proveedor(st.getString(9));
            if (proveedor_a.getId_proveedor() != null) {
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

    public ArrayList<Proveedor> getCargarProveedor() {
        Proveedor obj = null;
        Connection conexion = null;
        ResultSet rs = null;
        try {
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall("{call sp_listar_proveedor()}");
            rs = st.executeQuery();
            if (rs.next()) {
                this.arreglo = new ArrayList<Proveedor>();
                do {
                    obj = new Proveedor();

                    obj.setId_proveedor(rs.getString("id_proveedor"));
                    obj.setRuc_proveedor(rs.getString("ruc_proveedor"));
                    obj.setNombre_proveedor(rs.getString("nombre_proveedor"));
                    obj.setTelefono_proveedor(rs.getString("telefono_proveedor"));
                    obj.setDireccion_proveedor(rs.getString("direccion_proveedor"));
                    obj.setCiudad_proveedor(rs.getString("ciudad_proveedor"));
                    obj.setServicio_proveedor(rs.getString("servicio_proveedor"));
                    obj.setFax_proveedor(rs.getString("fax_proveedor"));
                    obj.setEstado_proveedor(rs.getInt("estado_proveedor"));

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

    public String doregistra_proveedor() {
        try {
            if (this.Registrar()) {
                Mensaje.guardarMensajeExito("Registro Proveedor: Codigo " + this.getProveedor_a().getId_proveedor());

            } else {
                Mensaje.manejarError2("Ruc Existente");
            }
        } catch (Exception e) {
            Mensaje.manejarError(e);
        }
        return null;
    }

    public List<Proveedor> getCargarComboProveedor() {
        if (this.arrayProveedor.size() == 0) {
            Proveedor obj = null;
            Connection conexion = null;
            ResultSet rs = null;
            try {
                conexion = ControladorBD.darConexionBD();
                CallableStatement st = conexion.prepareCall("{call sp_listar_proveedor()}");
                rs = st.executeQuery();
                if (rs.next()) {

                    do {
                        obj = new Proveedor();
                        obj.setId_proveedor(rs.getString("id_proveedor"));
                        obj.setRuc_proveedor(rs.getString("ruc_proveedor"));
                        obj.setNombre_proveedor(rs.getString("nombre_proveedor"));
                        obj.setTelefono_proveedor(rs.getString("telefono_proveedor"));
                        obj.setDireccion_proveedor(rs.getString("direccion_proveedor"));
                        obj.setCiudad_proveedor(rs.getString("ciudad_proveedor"));
                        obj.setServicio_proveedor(rs.getString("servicio_proveedor"));
                        obj.setFax_proveedor(rs.getString("fax_proveedor"));
                        obj.setEstado_proveedor(rs.getInt("estado_proveedor"));
                        arrayProveedor.add(obj);
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
        return this.arrayProveedor;
    }

    public boolean Actualizar() {
        boolean a = false;
        Connection conexion = null;
        try {
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall("{call sp_ActualizarProveedor(?,?,?,?,?,?,?,?,?)}");

            st.setString(1, proveedor_a.getId_proveedor());
            st.setString(2, proveedor_a.getRuc_proveedor());
            st.setString(3, proveedor_a.getNombre_proveedor());
            st.setString(4, proveedor_a.getTelefono_proveedor());
            st.setString(5, proveedor_a.getDireccion_proveedor());
            st.setString(6, proveedor_a.getCiudad_proveedor());
            st.setString(7, proveedor_a.getServicio_proveedor());
            st.setString(8, proveedor_a.getFax_proveedor());
            st.setInt(9, proveedor_a.getEstado_proveedor());

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
        final Proveedor pro = (Proveedor) event.getObject();
        this.setProveedor_a(pro);
        this.Actualizar();
    }

    public void onCancel(RowEditEvent event) {
    }

    public String doActualizarProveedor() {
        this.setProveedor_a(selectedProveedor);
        try {
            if (this.Actualizar()) {
                Mensaje.guardarMensajeExito("Acualizacion Proveedor: Codigo " + this.getProveedor_a().getId_proveedor());

            } else {
                Mensaje.manejarError("Actualizando Proveedor");
            }
        } catch (Exception e) {
            Mensaje.manejarError(e);
        }
        return null;
    }

    public List<Proveedor> getCargarComboProveedorxactivo() {
        if (this.arrayProveedor.size() == 0) {
            Proveedor obj = null;
            Connection conexion = null;
            ResultSet rs = null;
            try {
                conexion = ControladorBD.darConexionBD();
                CallableStatement st = conexion.prepareCall("{call sp_listar_proveedorxactivo()}");
                rs = st.executeQuery();
                if (rs.next()) {

                    do {
                        obj = new Proveedor();
                        obj.setId_proveedor(rs.getString("id_proveedor"));
                        obj.setRuc_proveedor(rs.getString("ruc_proveedor"));
                        obj.setNombre_proveedor(rs.getString("nombre_proveedor"));
                        obj.setTelefono_proveedor(rs.getString("telefono_proveedor"));
                        obj.setDireccion_proveedor(rs.getString("direccion_proveedor"));
                        obj.setCiudad_proveedor(rs.getString("ciudad_proveedor"));
                        obj.setServicio_proveedor(rs.getString("servicio_proveedor"));
                        obj.setFax_proveedor(rs.getString("fax_proveedor"));
                        obj.setEstado_proveedor(rs.getInt("estado_proveedor"));
                        arrayProveedor.add(obj);
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
        return this.arrayProveedor;
    }
}
