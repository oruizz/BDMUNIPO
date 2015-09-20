/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.Almacen;
import Modelo.Articulo;
import Modelo.ControladorBD;
import Modelo.Inventario;
import Modelo.Proveedor;
import Modelo.Proyecto;
import Modelo.Responsable;
import Modelo.detalle_almacen;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author ruiz zapata oscar
 * @author agramonte rey wilmer
 */
public class Beandetalle_almacen {

    private detalle_almacen detaalmacen_a = new detalle_almacen();
    private ArrayList<detalle_almacen> arreglo = new ArrayList<detalle_almacen>();
    private String parametro;

    public detalle_almacen getDetaalmacen_a() {
        return detaalmacen_a;
    }

    public void setDetaalmacen_a(detalle_almacen detaalmacen_a) {
        this.detaalmacen_a = detaalmacen_a;
    }

    public ArrayList<detalle_almacen> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<detalle_almacen> arreglo) {
        this.arreglo = arreglo;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public boolean Registrar() {
        boolean a = false;
        Connection conexion = null;
        try {
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall("{call sp_registrar_detalle_almacen" + "(?,?,?,?,?,?,?,?,?)}");
            st.setString(1, detaalmacen_a.getObj_res().getCod_responsable());
            st.setString(2, detaalmacen_a.getObj_al().getCod_almacen());
            st.setString(3, detaalmacen_a.getObj_ar().getCod_articulo());
            st.setString(4, detaalmacen_a.getObj_pro().getId_proyecto());
            st.setString(5, detaalmacen_a.getObj_ve().getId_proveedor());
            st.setString(6, detaalmacen_a.getObj_in().getId_inventario());
            if (detaalmacen_a.getFecha_entrada() != null) {
                st.setDate(7, new java.sql.Date(detaalmacen_a.getFecha_entrada().getTime()));
            } else {
                st.setDate(8, null);
            }
            if (detaalmacen_a.getFecha_salidad() != null) {
                st.setDate(8, new java.sql.Date(detaalmacen_a.getFecha_salidad().getTime()));
            } else {
                st.setDate(8, null);
            }
            st.registerOutParameter(9, java.sql.Types.VARCHAR);
            st.execute();
            detaalmacen_a.setId_detalle_almacen(st.getString(9));
            if (detaalmacen_a.getId_detalle_almacen() != null) {
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

    public ArrayList<detalle_almacen> getCargardetalle_almacen() {
        detalle_almacen obj = null;
        Connection conexion = null;
        ResultSet rs = null;
        try {
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall("{call sp_listar_detalle_almacen()}");
            rs = st.executeQuery();
            if (rs.next()) {
                this.arreglo = new ArrayList<detalle_almacen>();
                do {
                    obj = new detalle_almacen();
                    Responsable r1 = new Responsable();
                    r1.setCod_responsable(rs.getString("cod_responsable"));
                    obj.setObj_res((r1));
                    Almacen l1 = new Almacen();
                    l1.setCod_almacen(rs.getString("cod_almacen"));
                    obj.setObj_al((l1));
                    Articulo a1 = new Articulo();
                    a1.setCod_articulo(rs.getString("cod_articulo"));
                    obj.setObj_ar((a1));
                    Proyecto p1 = new Proyecto();
                    p1.setId_proyecto(rs.getString("id_proyecto"));
                    obj.setObj_pro((p1));
                    Proveedor o1 = new Proveedor();
                    o1.setId_proveedor(rs.getString("id_proveedor"));
                    obj.setObj_ve((o1));
                    Inventario in = new Inventario();
                    in.setId_inventario(rs.getString("id_iventario"));
                    obj.setObj_in((in));
                    obj.setFecha_entrada(rs.getDate("fecha_entrada"));
                    obj.setFecha_salidad(rs.getDate("fecha_salida"));
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
}
