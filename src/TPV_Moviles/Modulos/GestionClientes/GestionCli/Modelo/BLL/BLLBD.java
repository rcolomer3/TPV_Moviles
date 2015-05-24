/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.BLL;

import TPV_Moviles.Clases.ConexionBD;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.DAO.DAOBD;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class BLLBD {

    public static int nuevoClienteBLL() {

        int correcto;
        Connection _con = null;

        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();

        correcto = DAOBD.nuevoClienteDAO(_con);

        _conexion_DB.CerrarConexion(_con);

        return correcto;
    }
    // * obtener un arraylist con todos los empleados disponibles

    public void listarClienteBLL() {

        Connection _con = null;
        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();
        DAOBD _clienteDAO = new DAOBD();

        try {
            _clienteDAO.listarClienteDAO(_con);//Recuperamos los empleados 

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error Logger2!");
        }
        _conexion_DB.CerrarConexion(_con);

    }

    // modificar un empleado existente en la BD
    public static void modificarClienteBLL() {

        Connection _con;

        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();
        DAOBD _clienteDAO = new DAOBD();

        _clienteDAO.modificarClienteDAO(_con);
        _conexion_DB.CerrarConexion(_con);

    }

    // eliminar un empleado de la BD
    public static boolean borrarClienteBLL() {

        Connection _con;
        boolean correcto;

        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();
        DAOBD _clienteDAO = new DAOBD();

        correcto = _clienteDAO.borrarClienteDAO(_con);
        _conexion_DB.CerrarConexion(_con);

        return correcto;
    }

    //* buscar en la BD un empleado por su DNI
    public static boolean buscarPorDniBLL() {

        Connection _con;
        boolean correcto;

        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();
        DAOBD _clienteDAO = new DAOBD();

        correcto = _clienteDAO.buscarPorDniDAO(_con);
        _conexion_DB.CerrarConexion(_con);

        return correcto;
    }

    // Sacar empleado joven y mayor
    public void clienteMenorMayorBLL() {

        Connection _con = null;
        ConexionBD _conexion_DB = new ConexionBD();
        _con = _conexion_DB.AbrirConexion();

        DAOBD _clienteDAO = new DAOBD();
        _clienteDAO.clienteMenorMayorDAO(_con);
        _conexion_DB.CerrarConexion(_con);
    }

    // Sacar edad media de los empleados
    public void EdadMediaBLL() {

        Connection _con = null;
        ConexionBD _conexion_DB = new ConexionBD();
        _con = _conexion_DB.AbrirConexion();

        DAOBD _clienteDAO = new DAOBD();
        _clienteDAO.EdadMediaDAO(_con);
        _conexion_DB.CerrarConexion(_con);
    }
}
