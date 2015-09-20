/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Articulo;
import Modelo.Cargo;
import Modelo.ControladorBD;
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
public class BeanArticulo implements Serializable {

    private Articulo selectedArticulo;
    private Articulo articulo_a = new Articulo();
    private ArrayList<Articulo> arreglo = new ArrayList<Articulo>();
    private String parametro;
    private List<Articulo> arrayArticulo = new ArrayList<Articulo>();

    public BeanArticulo() {
    }

    public List<Articulo> getArrayArticulo() {
        return arrayArticulo;
    }

    public void setArrayArticulo(List<Articulo> arrayArticulo) {
        this.arrayArticulo = arrayArticulo;
    }

    public ArrayList<Articulo> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Articulo> arreglo) {
        this.arreglo = arreglo;
    }

    public Articulo getArticulo_a() {
        return articulo_a;
    }

    public void setArticulo_a(Articulo articulo_a) {
        this.articulo_a = articulo_a;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public Articulo getSelectedArticulo() {
        return selectedArticulo;
    }

    public void setSelectedArticulo(Articulo selectedArticulo) {
        this.selectedArticulo = selectedArticulo;
    }

    public boolean Registrar() {
        boolean a = false;
        Connection conexion = null;
        try {
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall("{call sp_registrar_articulo" + "(?,?,?,?,?,?,?)}");
            st.setString(1, articulo_a.getNombre_articulo());
            st.setString(2, articulo_a.getMarca_articulo());
            st.setString(3, articulo_a.getDescripcion_articulo());
            st.setInt(4, articulo_a.getCantidad_articulo());
            st.setString(5, articulo_a.getTipo_material());
            st.setDouble(6, articulo_a.getPrecio_articulo());

            st.registerOutParameter(7, java.sql.Types.VARCHAR);
            st.execute();
            articulo_a.setCod_articulo(st.getString(7));
            if (articulo_a.getCod_articulo() != null) {
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

    public ArrayList<Articulo> getCargarArticulo() {
        Articulo obj = null;
        Connection conexion = null;
        ResultSet rs = null;
        try {
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall("{call sp_listar_articulos()}");
            rs = st.executeQuery();
            if (rs.next()) {
                this.arreglo = new ArrayList<Articulo>();
                do {
                    obj = new Articulo();
                    obj.setCod_articulo(rs.getString("cod_articulo"));
                    obj.setNombre_articulo(rs.getString("nombre_articulo"));
                    obj.setMarca_articulo(rs.getString("marca_articulo"));
                    obj.setDescripcion_articulo(rs.getString("descripcion_articulo"));
                    obj.setCantidad_articulo(rs.getInt("cantidad_articulo"));
                    obj.setTipo_material(rs.getString("tipo_material"));
                    obj.setPrecio_articulo(rs.getDouble("precio_articulo"));
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

    public String doregistra_articulo() {
        try {
            if (this.Registrar()) {
                Mensaje.guardarMensajeExito("Registro Articulo: Codigo " + this.getArticulo_a().getCod_articulo());

            } else {
                Mensaje.manejarError("Registrando Articulo");
            }
        } catch (Exception e) {
            Mensaje.manejarError(e);
        }
        return null;
    }

    public List<Articulo> getCargarComboArt() {
        if (this.arrayArticulo.size() == 0) {
            Articulo obj = null;
            Connection conexion = null;
            ResultSet rs = null;
            try {
                conexion = ControladorBD.darConexionBD();
                CallableStatement st = conexion.prepareCall("{call sp_listar_articulos()}");
                rs = st.executeQuery();
                if (rs.next()) {

                    do {
                        obj = new Articulo();

                        obj.setCod_articulo(rs.getString("cod_articulo"));
                        obj.setNombre_articulo(rs.getString("nombre_articulo"));
                        obj.setMarca_articulo(rs.getString("marca_articulo"));
                        obj.setDescripcion_articulo(rs.getString("descripcion_articulo"));
                        obj.setCantidad_articulo(rs.getInt("cantidad_articulo"));
                        obj.setTipo_material(rs.getString("tipo_material"));
                        obj.setPrecio_articulo(rs.getDouble("precio_articulo"));

                        arrayArticulo.add(obj);
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
        return this.arrayArticulo;
    }

    public boolean Actualizar() {
        boolean a = false;
        Connection conexion = null;
        try {
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall("{call sp_ActualizarArticulo(?,?,?,?,?,?,?)}");

            st.setString(1, articulo_a.getCod_articulo());
            st.setString(2, articulo_a.getNombre_articulo());
            st.setString(3, articulo_a.getMarca_articulo());
            st.setString(4, articulo_a.getDescripcion_articulo());
            st.setInt(5, articulo_a.getCantidad_articulo());
            st.setString(6, articulo_a.getTipo_material());
            st.setDouble(7, articulo_a.getPrecio_articulo());


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
        final Articulo art = (Articulo) event.getObject();
        this.setArticulo_a(art);
        this.Actualizar();
    }

    public void onCancel(RowEditEvent event) {
    }

    public String doActualizarArticulo() {
        this.setArticulo_a(selectedArticulo);
        try {
            if (this.Actualizar()) {
                Mensaje.guardarMensajeExito("Acualizacion Articulo: Cod_articulo " + this.getArticulo_a().getCod_articulo());

            } else {
                Mensaje.manejarError("Actualizando Articulo");
            }
        } catch (Exception e) {
            Mensaje.manejarError(e);
        }
        return null;
    }
}
