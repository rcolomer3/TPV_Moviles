/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.Login.DAO;

import TPV_Moviles.Librerias.Encrypt;
import TPV_Moviles.Librerias.Validate;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.BLL.BLLBD;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Singletons;
import TPV_Moviles.Modulos.Inicio.ControladorInicio.Controlador_Inicio;
import TPV_Moviles.Modulos.Inicio.Vista.Ventana_Inicio;
import TPV_Moviles.Modulos.Login.BLL.LoginBLL;
import TPV_Moviles.Modulos.Login.Vista.Login;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class LoginDAO {

    public static void pideUsuario() {

        if (Login.txtUsuario.getText().isEmpty()) {
            Login.txtUsuario.setForeground(Color.red);
            Login.txtUsuario.setText("Introduzca usuario");
            Login.txtUsuario.requestFocus();
            return;
        }

        if (Validate.validaDNI(Login.txtUsuario.getText()) == false) {
            Login.txtUsuario.setForeground(Color.red);
            Login.txtUsuario.setText("Usuario inválido");
            Login.txtUsuario.requestFocus();
            return;
        }
        Login.txtPassword.requestFocus();
    }

    public static void PidePassword() {

        if (Login.txtPassword.getText().isEmpty()) {
            Login.txtPassword.setForeground(Color.red);
            Login.txtPassword.setText("Introduzca password");
            Login.txtPassword.requestFocus();
            return;
        }
        Login.btnAcceder.requestFocus();
    }

    public static void AccesoLogeado() {
        String usuario = Singletons.log.txtUsuario.getText();
        String password = Singletons.log.txtPassword.getText();

        boolean login;

        LoginBLL _login = new LoginBLL();
        login = _login.loginUsuarioBLL(usuario, password);

        if (login != true) {

            Login.txtUsuario.setForeground(Color.red);
            Login.txtUsuario.setText("Usuario incorrecto");
            Login.txtUsuario.requestFocus();
            Login.txtPassword.setForeground(Color.red);
            Login.txtPassword.setText("Error");

        } else {
            Singletons.conectado = "si";
            BLLBD cli = new BLLBD();
            cli.listarClienteBLL();
            Singletons.log.dispose();
            new Controlador_Inicio(new Ventana_Inicio(), 0).iniciar(0);
        }

    }

    public boolean loginUsuarioDAO(Connection con, String dni, String Password) {

        boolean resultado = false;
        ResultSet rs = null;
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM movilesbbdd.clientes WHERE DNI=? AND Password=?");

            stmt.setString(1, dni);
            stmt.setString(2, Password);
            stmt.setString(2, Encrypt.encriptarTokenMD5(Password));

            rs = stmt.executeQuery();

            while (rs.next()) {

                dni = rs.getString("DNI");
                Password = rs.getString("Password");

                resultado = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Logger");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error Logger");
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error Logger");
                }
            }
        }
        return resultado;
    }

    public int actualizarPasswordDAO(Connection con, String dni, String password) {

        PreparedStatement stmt = null;
        int correcto = 0;

        try {
            stmt = con.prepareStatement("UPDATE movilesbbdd.clientes SET Password=? WHERE DNI=?");

            stmt.setString(1, password);
            stmt.setString(2, dni);

            correcto = stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al actualizar la contraseña!");
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

    public String TipoUsuarioDAO(Connection con, String dni) {

        String tipo = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("SELECT tipo FROM movilesbbdd.clientes WHERE DNI=?");

            stmt.setString(1, dni);

            rs = stmt.executeQuery();

            while (rs.next()) {

                tipo = rs.getString("Tipo");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Logger");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error Logger");
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error Logger");
                }
            }
        }
        return tipo;
    }
}
