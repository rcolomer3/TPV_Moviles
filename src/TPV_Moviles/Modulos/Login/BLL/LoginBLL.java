/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.Login.BLL;

import TPV_Moviles.Clases.ConexionBD;
import TPV_Moviles.Clases.JavaMail;
import TPV_Moviles.Librerias.Encrypt;
import TPV_Moviles.Librerias.Funciones;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Singletons;
import TPV_Moviles.Modulos.Login.Controlador_Login.Controlador_Login;
import TPV_Moviles.Modulos.Login.DAO.LoginDAO;
import TPV_Moviles.Modulos.Login.Vista.CambiarPassword;
import TPV_Moviles.Modulos.Login.Vista.Login;
import java.awt.Color;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class LoginBLL {

    public static String dni;
    public static String password;

    public static void Usuario() {
        LoginDAO.pideUsuario();
    }

    public static void Password() {
        LoginDAO.PidePassword();
    }

    public static void AccesoLogeado() {
        LoginDAO.AccesoLogeado();
    }

    public int actualizarPasswordBLL() {

        Connection _con = null;
        int correcto;

        String dni, password, passwordEn, subject, mensaje, email;

        dni = Singletons.cbpass.txtUsuarioReg.getText();
        password = Funciones.getCadenaAleatoria(7);
        passwordEn = Encrypt.encriptarTokenMD5(password);
        subject = "La nueva contraseña es:  ";
        mensaje = "Nueva password de registro";
        email = Singletons.cbpass.txtEmailRecu.getText();

        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();

        LoginDAO _clienteDAO = new LoginDAO();

        correcto = _clienteDAO.actualizarPasswordDAO(_con, dni, passwordEn);

        _conexion_DB.CerrarConexion(_con);

        if (correcto == 1) {

            CambiarPassword.txtUsuarioReg.setBackground(Color.green);
            JOptionPane.showMessageDialog(null, "Usuario correcto, procesando envio!");

            //creamos el objeto Mail
            JavaMail mail = new JavaMail(email, password, subject, mensaje);
            //enviamos el mensaje
            
            //JOptionPane.showMessageDialog(null, mail.toString(), "Envio Email OK", JOptionPane.INFORMATION_MESSAGE);
            
            String error = mail.send();
            if (error.equals("")) {
                JOptionPane.showMessageDialog(null, "Envio Correcto", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error de envio:\n" + error, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no coincide");
            CambiarPassword.txtUsuarioReg.setBackground(Color.red);
        }

        Singletons.cbpass.dispose();
        new Controlador_Login(new Login(), 0).iniciar(0);

        return correcto;
    }

    public boolean loginUsuarioBLL(String dni, String password) {

        Connection _con;
        boolean correcto;
        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();

        LoginDAO _loginDAO = new LoginDAO();

        correcto = _loginDAO.loginUsuarioDAO(_con, dni, password);

        _conexion_DB.CerrarConexion(_con);

        return correcto;
    }

    /**
     * ver si el usuario que nos pasan es de tipo administrador o normal
     *
     * @param dni
     * @return String tipo (Administrador o user)
     */
    public String TipoUsuarioBLL(String dni) {

        Connection _con;
        String tipo;
        ConexionBD _conexion_DB = new ConexionBD();

        _con = _conexion_DB.AbrirConexion();

        LoginDAO _loginDAO = new LoginDAO();

        tipo = _loginDAO.TipoUsuarioDAO(_con, dni);

        _conexion_DB.CerrarConexion(_con);

        return tipo;

    }
}
