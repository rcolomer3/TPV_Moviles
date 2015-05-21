/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPV_Moviles.Modulos.Login.Controlador_Login;

import TPV_Moviles.Modulos.GestionClientes.GestionCli.Controlador.Controlador_EF;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Modelo.Clases.Singletons;
import TPV_Moviles.Modulos.GestionClientes.GestionCli.Vista.AltaEF1;
import TPV_Moviles.Modulos.Login.BLL.LoginBLL;
import TPV_Moviles.Modulos.Login.Vista.CambiarPassword;
import TPV_Moviles.Modulos.Login.Vista.Login;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul
 */
public class Controlador_Login implements ActionListener, MouseListener {

    public enum Accion {

        //Ventana Login
        _TXT_USUARIO,
        _TXT_PASSWORD,
        _OLVIDAR,
        _BTN_ACCEDER,
        _REGISTER,
        //Ventana CambiarPassword
        _TXT_USUARIO_M,
        _TXT_PASSWORD_M,
        _TXT_EMAIL_M,
        _BTN_ACTUALIZAR,
    }

    public Controlador_Login(JFrame logeo, int i) {

        if (i == 0) {
            Singletons.log = (Login) logeo;
        }

        if (i == 1) {
            Singletons.cbpass = (CambiarPassword) logeo;
        }
    }

    public void iniciar(int i) {

        if (i == 0) {

            Singletons.log.setVisible(true);
            Singletons.log.setResizable(false);
            Singletons.log.setSize(380, 517); //ancho x alto
            Singletons.log.setTitle("Login Empleado Fijo");
            Singletons.log.setLocationRelativeTo(null);
            Image icono = Toolkit.getDefaultToolkit().getImage("src/TPV/Img/trabajador.jpg");
            Singletons.log.setIconImage(icono);

            Singletons.log.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicación");
                    System.exit(0);
                }
            });

            Singletons.log.txtPassword.setActionCommand("_TXT_USUARIO");
            Singletons.log.txtUsuario.addActionListener(this);

            Singletons.log.txtPassword.setActionCommand("_TXT_PASSWORD");
            Singletons.log.txtPassword.addActionListener(this);

            Singletons.log.Recordar.setName("_OLVIDAR");
            Singletons.log.Recordar.addMouseListener(this);

            Singletons.log.Registrar.setName("_REGISTER");
            Singletons.log.Registrar.addMouseListener(this);

            Singletons.log.btnAcceder.setActionCommand("_BTN_ACCEDER");
            Singletons.log.btnAcceder.addActionListener(this);

        }

        if (i == 1) {

            Singletons.cbpass.setVisible(true);
            Singletons.cbpass.setResizable(false);
            Singletons.cbpass.setSize(526, 389); //ancho x alto
            Singletons.cbpass.setTitle("Recuperar Password");
            Singletons.cbpass.setLocationRelativeTo(null);
            Image icono = Toolkit.getDefaultToolkit().getImage("src/TPV/Img/trabajador.jpg");
            Singletons.cbpass.setIconImage(icono);

            Singletons.cbpass.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicación");
                    System.exit(0);
                }
            });

            Singletons.cbpass.txtUsuarioReg.setActionCommand("_TXT_USUARIO_M");
            Singletons.cbpass.txtUsuarioReg.addActionListener(this);

            Singletons.cbpass.txtNuevaCont.setActionCommand("_TXT_PASSWORD_M");
            Singletons.cbpass.txtNuevaCont.addActionListener(this);
            
            Singletons.cbpass.txtEmailRecu.setName("_TXT_EMAIL_M");
            Singletons.cbpass.txtEmailRecu.setActionCommand("_TXT_EMAIL_M");
            Singletons.cbpass.txtEmailRecu.addActionListener(this);

            Singletons.cbpass.btnActualizar.setActionCommand("_BTN_ACTUALIZAR");
            Singletons.cbpass.btnActualizar.addActionListener(this);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (Accion.valueOf(e.getActionCommand())) {

            case _TXT_USUARIO:
                LoginBLL.Usuario();
                break;

            case _TXT_PASSWORD:
                LoginBLL.Password();
                break;

            case _BTN_ACCEDER:
                LoginBLL.AccesoLogeado();
                break;

                //Ventana CambiarPassword
            case _BTN_ACTUALIZAR:
                LoginBLL logi = new LoginBLL();
                logi.actualizarPasswordBLL();
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (Accion.valueOf(e.getComponent().getName())) {

            case _OLVIDAR:
                Singletons.log.dispose();
                new Controlador_Login(new CambiarPassword(), 1).iniciar(1);
                break;

            case _REGISTER:
                Singletons.log.dispose();
                new Controlador_EF(new AltaEF1(), 0).iniciar(0);
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {

            case _REGISTER:
                Singletons.log.Registrar.setForeground(Color.orange);
                break;

            case _OLVIDAR:
                Singletons.log.Recordar.setForeground(Color.orange);
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        switch (Accion.valueOf(me.getComponent().getName())) {
            case _REGISTER:
                Singletons.log.Registrar.setForeground(Color.white);
                break;

            case _OLVIDAR:
                Singletons.log.Recordar.setForeground(Color.white);
                break;
        }
    }
}
