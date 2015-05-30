/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.GestionProductos.Modelo.BLL;

import TPV_Moviles.Clases.ConexionBD;
import TPV_Moviles.Modulos.GestionProductos.Modelo.DAO.DAOProBD;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class BLLProBD {

    public static int nuevoProductoBLL() {

        int correcto;
        Connection _con = null;

        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();

        correcto = DAOProBD.nuevoProductoDAO(_con);

        _conexion_DB.CerrarConexion(_con);

        return correcto;
    }
    // * obtener un arraylist con todos los productos disponibles

    public void listarProductosBLL() {

        Connection _con = null;
        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();
        DAOProBD _productoDAO = new DAOProBD();

        try {
            _productoDAO.listarProductoDAO(_con);//Recuperamos los productos 

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al listar productos en BLLBD!");
        }
        _conexion_DB.CerrarConexion(_con);

    }

    // modificar un producto existente en la BD
    public static void modificarProductoBLL() {

        Connection _con;

        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();
        DAOProBD _productoDAO = new DAOProBD();

        _productoDAO.modificarProductoDAO(_con);
        _conexion_DB.CerrarConexion(_con);

    }

    // eliminar un empleado de la BD
    public static boolean borrarProductoBLL() {

        Connection _con;
        boolean correcto;

        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();
        DAOProBD _productoDAO = new DAOProBD();

        correcto = _productoDAO.borrarProductoDAO(_con);
        _conexion_DB.CerrarConexion(_con);

        return correcto;
    }

    //* buscar en la BD un producto por su referencia
    public static boolean buscarPorReferenciaBLL() {

        Connection _con;
        boolean correcto;

        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();
        DAOProBD _productoDAO = new DAOProBD();

        correcto = _productoDAO.buscarPorRefenciaDAO(_con);
        _conexion_DB.CerrarConexion(_con);

        return correcto;
    }

    // Sacar empleado joven y mayor
    public void productoBaratoCaroBLL() {

        Connection _con = null;
        ConexionBD _conexion_DB = new ConexionBD();
        _con = _conexion_DB.AbrirConexion();

        DAOProBD _productoDAO = new DAOProBD();
        _productoDAO.productoBaratoCaroDAO(_con);
        _conexion_DB.CerrarConexion(_con);
    }

    // Sacar edad media de los empleados
    public void PrecioMedioBLL() {

        Connection _con = null;
        ConexionBD _conexion_DB = new ConexionBD();
        _con = _conexion_DB.AbrirConexion();

        DAOProBD _productoDAO = new DAOProBD();
        _productoDAO.PrecioMedioDAO(_con);
        _conexion_DB.CerrarConexion(_con);
    }
}
