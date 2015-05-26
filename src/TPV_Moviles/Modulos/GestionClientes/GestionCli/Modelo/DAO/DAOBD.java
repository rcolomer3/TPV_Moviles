/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.DAO;

import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Clientes;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.DAOCliente;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Singletons;
import com.mysql.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class DAOBD {

    //Dar de alta a un empleado
    public static int nuevoClienteDAO(Connection con) {

        PreparedStatement stmt = null;
        int correcto = 0;
         JOptionPane.showMessageDialog(null, "EEE!");
        try {

            stmt = con.prepareStatement("INSERT INTO movilesbbdd.clientes"
                    + "(Nombre, Apellidos, DNI, Edad, Telefono, fechaNacimiento, fechaAlta, "
                    + "Usuario, Password, Email, Estado, Tipo, Avatar, Antiguedad, Saldo) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, Singletons.e.getNombre());
            stmt.setString(2, Singletons.e.getApellidos());
            stmt.setString(3, Singletons.e.getDni());
            stmt.setInt(4, Singletons.e.getEdad());
            stmt.setString(5, Singletons.e.getTelefono());
            stmt.setString(6, Singletons.e.getFechaNacimiento().toStringFecha());
            stmt.setString(7, Singletons.e.getFechaAlta().toStringFecha());
            stmt.setString(8, Singletons.e.getUsuario());
            stmt.setString(9, Singletons.e.getPassword());
            stmt.setString(10, Singletons.e.getEmail());
            stmt.setInt(11, Singletons.e.getEstado());
            stmt.setString(12, Singletons.e.getTipo());
            stmt.setString(13, Singletons.e.getAvatar());
            stmt.setInt(14, Singletons.e.getAntiguedad());
            stmt.setFloat(15, Singletons.e.getSaldo());
JOptionPane.showMessageDialog(null, Singletons.e.getTelefono());
            correcto = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "El usuario ha sido dado de alta correctamente!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al insertar un nuevo usuario!");
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

    //Listamos todos los empleados y los metemos en su array
    public void listarClienteDAO(Connection con) {

        ResultSet rs = null;
        PreparedStatement stmt = null;

        Singletons.efi.clear();
        try {
            stmt = con.prepareStatement("SELECT * FROM movilesbbdd.clientes");
            rs = stmt.executeQuery();

            Clientes _cli = null;

            while (rs.next()) {

                _cli = new Clientes();
                _cli.setNombre(rs.getString("Nombre"));
                _cli.setApellidos(rs.getString("Apellidos"));
                _cli.setDni(rs.getString("DNI"));
                _cli.setEdad(rs.getInt("Edad"));
                _cli.setTelefono(rs.getString("Telefono"));
                _cli.setFechaNacimiento(DAOCliente.sacaFecha(rs.getString("fechaNacimiento")));
                _cli.setFechaAlta(DAOCliente.sacaFecha(rs.getString("fechaAlta")));
                _cli.setUsuario(rs.getString("Usuario"));
                _cli.setPassword(rs.getString("Password"));
                _cli.setEmail(rs.getString("Email"));
                _cli.setEstado(rs.getInt("Estado"));
                _cli.setTipo(rs.getString("Tipo"));
                _cli.setAvatar(rs.getString("Avatar"));
                _cli.setAntiguedad(rs.getInt("Antiguedad"));
                _cli.setSaldo(rs.getFloat("Saldo"));
                Singletons.efi.add(_cli);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al obtener los usuarios!");
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

    //Modificamos un empleado
    public static int modificarClienteDAO(Connection con) {
        PreparedStatement stmt = null;
        int correcto = 0;

        try {
            stmt = con.prepareStatement("UPDATE movilesbbdd.clientes SET Nombre=?, "
                    + "Apellidos=?, DNI=?, Edad=?, Telefono=?, fechaNacimiento=?, fechaAlta=?, Usuario=?, Password=?,"
                    + "Email=?, Estado=?, Tipo=?, Avatar=?, "
                    + "Antiguedad=?, Saldo=? WHERE DNI=?");

            stmt.setString(1, Singletons.e.getNombre());
            stmt.setString(2, Singletons.e.getApellidos());
            stmt.setString(3, Singletons.e.getDni());
            stmt.setInt(4, Singletons.e.getEdad());
            stmt.setString(5, Singletons.e.getTelefono());
            stmt.setString(6, Singletons.e.getFechaNacimiento().toStringFecha());
            stmt.setString(7, Singletons.e.getFechaAlta().toStringFecha());
            stmt.setString(8, Singletons.e.getUsuario());
            stmt.setString(9, Singletons.e.getPassword());
            stmt.setString(10, Singletons.e.getEmail());
            stmt.setInt(11, Singletons.e.getEstado());
            stmt.setString(12, Singletons.e.getTipo());
            stmt.setString(13, Singletons.e.getAvatar());
            stmt.setInt(14, Singletons.e.getAntiguedad());
            stmt.setFloat(15, Singletons.e.getSaldo());
            
            stmt.setString(16, Singletons.e.getDni());
            correcto = stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "El usuario ha sido modificado correctamente!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al actualizar el usuario!");
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

    //Borramos un empleado
    public boolean borrarClienteDAO(Connection con) {

        PreparedStatement stmt = null;
        boolean correcto = false;

        try {
            stmt = con.prepareStatement("DELETE FROM movilesbbdd.clientes WHERE DNI=?");
            stmt.setString(1, Singletons.e.getDni());
            stmt.executeUpdate();
            correcto = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al eliminar el usuario!");
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

    //Buscamos por dni un empleado
    public boolean buscarPorDniDAO(Connection con) {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        boolean correcto = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM movilesbbdd.clientes WHERE DNI=?");
            stmt.setString(1, Singletons.e.getDni());
            rs = stmt.executeQuery();
            while (rs.next()) {

                obtenClienteFila(rs);
            }
            correcto = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al buscar el usuario por DNI");
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

    public boolean obtenClienteFila(ResultSet rs) {

        boolean correcto = false;

        try {

            Singletons.e.setNombre(rs.getString("Nombre"));
            Singletons.e.setApellidos(rs.getString("Apellidos"));
            Singletons.e.setDni(rs.getString("DNI"));
            Singletons.e.setEdad(rs.getInt("Edad"));
            Singletons.e.setTelefono(rs.getString("Telefono"));
            Singletons.e.setFechaNacimiento(DAOCliente.sacaFecha(rs.getString("fechaNacimiento")));
            Singletons.e.setFechaAlta(DAOCliente.sacaFecha(rs.getString("fechaAlta")));
            Singletons.e.setUsuario(rs.getString("Usuario"));
            Singletons.e.setPassword(rs.getString("Password"));
            Singletons.e.setEmail(rs.getString("Email"));
            Singletons.e.setEstado(rs.getInt("Estado"));
            Singletons.e.setTipo(rs.getString("Tipo"));
            Singletons.e.setAvatar(rs.getString("Avatar"));
            Singletons.e.setAntiguedad(rs.getInt("Antiguedad"));
            Singletons.e.setSaldo(rs.getFloat("Saldo"));
            
            correcto = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el Logger");
        }

        return correcto;
    }

    public void clienteMenorMayorDAO(Connection con) {

        com.mysql.jdbc.CallableStatement cstmt = null;
        String cadena = "";
        
        try {
            cstmt = (com.mysql.jdbc.CallableStatement) con.prepareCall("{call proce_edad(?,?)}");
            cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
            cstmt.execute();
            cadena = cadena + "Cliente joven: " + cstmt.getInt(1) + " años" + "\n";
            cadena = cadena + "Cliente mayor: " + cstmt.getInt(2) + " años";
            JOptionPane.showMessageDialog(null, cadena, "Cliente joven/mayor", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Logger!");
        }
    }

    public void EdadMediaDAO(Connection con) {

        CallableStatement cstmt = null;
        String cadena = "";
        try {
            cstmt = (CallableStatement) con.prepareCall("{call procedure_media_edad(?)}");
            cstmt.registerOutParameter(1, java.sql.Types.DOUBLE);
            cstmt.execute();
            cadena = cadena + "Edad media: " + (int) cstmt.getDouble(1) + " años";
            JOptionPane.showMessageDialog(null, cadena, "Edad media", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Logger!");
        }
    }
}
