/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.GestionProductos.Modelo.DAO;

import TPV_Moviles.Clases.Config;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.DAOCliente;
import TPV_Moviles.Modulos.GestionProductos.Modelo.Clases.Productos;
import TPV_Moviles.Modulos.GestionProductos.Modelo.Clases.SingletonsPro;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class DAOProBD {

    //Dar de alta a un producto
    public static int nuevoProductoDAO(Connection con) {

        PreparedStatement stmt = null;
        int correcto = 0;

        try {

            stmt = con.prepareStatement("INSERT INTO movilesbbdd.productos"
                    + "(Referencia, Modelo, Marca, Descrip, FechaMercado, Antiguedad, Precio, "
                    + "Stock, Tipo, Avatar) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, SingletonsPro.p.getReferencia());
            stmt.setString(2, SingletonsPro.p.getModelo());
            stmt.setString(3, SingletonsPro.p.getMarca());
            stmt.setString(4, SingletonsPro.p.getDescripcion());
            stmt.setString(5, SingletonsPro.p.getFechaMercado().toStringFecha());
            stmt.setInt(6, SingletonsPro.p.getAntiguedad());
            stmt.setFloat(7, SingletonsPro.p.getPrecio());
            stmt.setInt(8, SingletonsPro.p.getStock());
            stmt.setString(9, SingletonsPro.p.getTipo());
            stmt.setString(10, SingletonsPro.p.getAvatar());

            correcto = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "El producto ha sido añadido correctamente!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al insertar un nuevo producto!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
        return correcto;
    }

    //Listamos todos los productos y los metemos en su array
    public void listarProductoDAO(Connection con) {

        ResultSet rs = null;
        PreparedStatement stmt = null;

        SingletonsPro.pro.clear();
        try {
            stmt = con.prepareStatement("SELECT * FROM movilesbbdd.productos");
            rs = stmt.executeQuery();

            Productos _pro = null;

            while (rs.next()) {

                _pro = new Productos();
                _pro.setReferencia(rs.getString("Referencia"));
                _pro.setModelo(rs.getString("Modelo"));
                _pro.setMarca(rs.getString("Marca"));
                _pro.setDescripcion(rs.getString("Descrip"));
                _pro.setFechaMercado(DAOCliente.sacaFecha(rs.getString("FechaMercado")));
                _pro.setAntiguedad(rs.getInt("Antiguedad"));
                _pro.setPrecio(rs.getFloat("Precio"));
                _pro.setStock(rs.getInt("Stock"));
                _pro.setTipo(rs.getString("Tipo"));
                _pro.setAvatar(rs.getString("Avatar"));

                SingletonsPro.pro.add(_pro);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al obtener los productos!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
    }

    //Modificamos un producto
    public static int modificarProductoDAO(Connection con) {
        PreparedStatement stmt = null;
        int correcto = 0;

        try {
            stmt = con.prepareStatement("UPDATE movilesbbdd.productos SET Referencia=?, "
                    + "Modelo=?, Marca=?, Descrip=?, FechaMercado=?, Antiguedad=?,"
                    + "Precio=?, Stock=?, Tipo=?, Avatar=? WHERE Referencia=?");

            stmt.setString(1, SingletonsPro.p.getReferencia());
            stmt.setString(2, SingletonsPro.p.getModelo());
            stmt.setString(3, SingletonsPro.p.getMarca());
            stmt.setString(4, SingletonsPro.p.getDescripcion());
            stmt.setString(5, SingletonsPro.p.getFechaMercado().toStringFecha());
            stmt.setInt(6, SingletonsPro.p.getAntiguedad());
            stmt.setFloat(7, SingletonsPro.p.getPrecio());
            stmt.setInt(8, SingletonsPro.p.getStock());
            stmt.setString(9, SingletonsPro.p.getTipo());
            stmt.setString(10, SingletonsPro.p.getAvatar());

            stmt.setString(11, SingletonsPro.p.getReferencia());
            correcto = stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "El producto ha sido modificado correctamente!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al actualizar el producto!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
        return correcto;
    }

    //Borramos un producto
    public boolean borrarProductoDAO(Connection con) {

        PreparedStatement stmt = null;
        boolean correcto = false;

        try {
            stmt = con.prepareStatement("DELETE FROM movilesbbdd.productos WHERE Referencia=?");
            stmt.setString(1, SingletonsPro.p.getReferencia());
            stmt.executeUpdate();
            correcto = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al eliminar el producto!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger!");
                }
            }
        }
        return correcto;
    }

    //Buscamos por referencia un producto
    public boolean buscarPorRefenciaDAO(Connection con) {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        boolean correcto = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM movilesbbdd.productos WHERE Referencia=?");
            stmt.setString(1, SingletonsPro.p.getReferencia());
            rs = stmt.executeQuery();
            while (rs.next()) {

                obtenProductoFila(rs);
            }
            correcto = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al buscar el producto por referencia");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger");
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger");
                }
            }
        }
        return correcto;
    }

    public boolean obtenProductoFila(ResultSet rs) {

        boolean correcto = false;

        try {

            SingletonsPro.p.setReferencia(rs.getString("Referencia"));
            SingletonsPro.p.setModelo(rs.getString("Modelo"));
            SingletonsPro.p.setMarca(rs.getString("Marca"));
            SingletonsPro.p.setDescripcion(rs.getString("Descrip"));
            SingletonsPro.p.setFechaMercado(DAOCliente.sacaFecha(rs.getString("FechaMercado")));
            SingletonsPro.p.setAntiguedad(rs.getInt("Antiguedad"));
            SingletonsPro.p.setPrecio(rs.getFloat("Precio"));
            SingletonsPro.p.setStock(rs.getInt("Stock"));
            SingletonsPro.p.setTipo(rs.getString("Tipo"));
            SingletonsPro.p.setAvatar(rs.getString("Avatar"));

            correcto = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el Logger");
        }

        return correcto;
    }

    public void productoBaratoCaroDAO(Connection con) {

        com.mysql.jdbc.CallableStatement cstmt = null;
        String cadena = "";

        try {
            cstmt = (com.mysql.jdbc.CallableStatement) con.prepareCall("{call proce_precio(?,?)}");
            cstmt.registerOutParameter(1, java.sql.Types.FLOAT);
            cstmt.registerOutParameter(2, java.sql.Types.FLOAT);
            cstmt.execute();
            cadena = cadena + "Producto barato: " + cstmt.getFloat(1) + Config.getMoneda() + "\n";
            cadena = cadena + "Producto caro: " + cstmt.getFloat(2) + Config.getMoneda();
            JOptionPane.showMessageDialog(null, cadena, "Producto barato/caro", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Logger!");
        }
    }

    public void PrecioMedioDAO(Connection con) {

        CallableStatement cstmt = null;
        String cadena = "";
        try {
            cstmt = (CallableStatement) con.prepareCall("{call procedure_precio_medio(?)}");
            cstmt.registerOutParameter(1, java.sql.Types.DOUBLE);
            cstmt.execute();
            cadena = cadena + "Precio medio: " + (int) cstmt.getDouble(1) + Config.getMoneda();
            JOptionPane.showMessageDialog(null, cadena, "Precio medio", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Logger!");
        }
    }
}
